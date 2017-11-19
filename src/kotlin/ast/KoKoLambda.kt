/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import kokoslan.ast.KoKoListPat
import java.util.*;
import java.io.*;

data class KoKoLambda(var pattern:KoKoAst, var expr:KoKoAst, var lambda_ctx : KoKoContext = KoKoContext(null)) : KoKoAst{
	
	override fun genCode(out: PrintStream){
		out.print("\\")
		this.pattern.genCode(out)
		out.print(". ")
		this.expr.genCode(out)
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue{
		this.lambda_ctx = KoKoContext(ctx)
		this.lambda_ctx.assoc(KoKoId("#KoKo"), KoKoNullValue(KoKoId(pattern.toString())))
		return KoKoLambdaValue(this)
	}
	
	fun eval(valor : KoKoList): KoKoValue{
		val variable = this.lambda_ctx.find( KoKoId("#KoKo") ) as KoKoNullValue
		if(pattern is KoKoArrayList){
            val matched_List = (lambda_ctx.parent ?: lambda_ctx).find((valor[0] as MutableList<KoKoAst>)[0] as KoKoId)
			this.lambda_ctx = KoKoListPat(pattern as MutableList<KoKoAst>, valor.size!= (pattern as KoKoArrayList).size).eval(lambda_ctx , matched_List as KoKoListValue, matched_List.size==1)
        }
		else {
			if(valor[0] is KoKoNum)
                this.lambda_ctx.assoc((variable.value as KoKoId ?: KoKoId("")), KoKoNumValue((valor[0] as KoKoNum).value))
			else
            	this.lambda_ctx.assoc((variable.value as KoKoId ?: KoKoId("")), (valor[0].eval(lambda_ctx) as KoKoListValue).list[0])
            if (valor.size > 1) {
                val lamda_Hija = this.expr.eval(lambda_ctx) as KoKoLambdaValue
                val lamda = lamda_Hija.value as KoKoLambda
                if (valor.size == 1)
                    return lamda.expr.eval(lambda_ctx)
                valor.removeAt(0)
                if (valor.size == 0)
                    return this.expr.eval(lambda_ctx)
                return lamda.eval(valor)
            }
        }
		return this.expr.eval(lambda_ctx)
	}
}