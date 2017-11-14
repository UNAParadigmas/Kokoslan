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
	
	fun eval(valor : KoKoNum): KoKoValue{
		val variable = this.lambda_ctx.find( KoKoId("#KoKo") ) as KoKoNullValue
		this.lambda_ctx.assoc(KoKoId(variable.value?:""), valor.eval(lambda_ctx))
		return this.expr.eval(lambda_ctx)
		
	}
}