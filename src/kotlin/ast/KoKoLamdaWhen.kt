/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast
import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException
import java.io.*

data class KoKoLambdaWhen(var pattern:KoKoAst, var expr:KoKoAst, var lambda_ctx : KoKoContext = KoKoContext(null)) : KoKoAst{
	
	override fun genCode(out: PrintStream){
		this.pattern.genCode(out)
		out.print(" -> ")
		this.expr.genCode(out)
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue{
        throw KoKoEvalException("KoKoLambdaWhen: eval not implemented")
	}

}