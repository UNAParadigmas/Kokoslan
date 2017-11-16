package kokoslan.ast

import kokoslan.kotlin.ast.*
import java.io.PrintStream

data class KoKoListPat(var pattern: KoKoAst, var patt_ctx : KoKoContext = KoKoContext(null)) : KoKoAst {

	override fun genCode(out: PrintStream){
		out.print("\\")
		this.pattern.genCode(out)
		out.print(". ")
		this.expr.genCode(out)
	}

	override fun eval(ctx : KoKoContext) : KoKoValue {
		this.lambda_ctx = KoKoContext(ctx)
		this.lambda_ctx.assoc(KoKoId("#KoKo"), KoKoNullValue(pattern.toString()))
		return KoKoLambdaValue(this)
		val variable = this.lambda_ctx.find(KoKoId("#KoKo")) as KoKoNullValue
		this.lambda_ctx.assoc(KoKoId(variable.value ?: ""), (valor[0].eval(lambda_ctx) as KoKoListValue).list[0])
		if(valor.size>1){
			val lamda_Hija = this.expr.eval(lambda_ctx) as KoKoLambdaValue
			val lamda = lamda_Hija.value as KoKoListPat
			if(valor.size==1)
				return lamda.expr.eval(lambda_ctx)
			valor.removeAt(0)
			if(valor.size==0)
				return this.expr.eval(lambda_ctx)
			return lamda.eval(valor)
		}
		return this.expr.eval(lambda_ctx)
	}
}