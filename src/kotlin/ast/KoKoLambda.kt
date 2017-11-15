package kokoslan.kotlin.ast;

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
		this.lambda_ctx.assoc(KoKoId("#KoKo"), KoKoNullValue(pattern.toString()))
		return KoKoLambdaValue(this)
	}
	
	fun eval(valor : KoKoList): KoKoValue{
		println("tamano de args = "+valor.size)
		println("valor de arg es ${valor[0]}")
		val variable = this.lambda_ctx.find( KoKoId("#KoKo") ) as KoKoNullValue
		this.lambda_ctx.assoc(KoKoId(variable.value?:""), (valor[0].eval(lambda_ctx) as KoKoListValue).list[0])
		if(valor.size>1){
			println(lambda_ctx)
			val lamda_Hija = this.expr.eval(lambda_ctx) as KoKoLambdaValue
			val lamda = lamda_Hija.value as KoKoLambda
			println("salgo de eval")
			if(valor.size==1)
				return lamda.expr.eval(lambda_ctx)
			valor.removeAt(0)
			if(valor.size==0)
				return this.expr.eval(lambda_ctx)
			return lamda.eval(valor)
		}
		println(lambda_ctx)
		return this.expr.eval(lambda_ctx)
	}
}