/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/

package kokoslan.kotlin.ast

import java.io.*
import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException

class KoKoNegative(var expr: KoKoAst) : KoKoAst{

	override fun genCode(out:PrintStream){
		out.print("-")	
        expr.genCode(out)
    }

	override fun eval(ctx : KoKoContext): KoKoValue{
        if(expr is KoKoOperation){
            var l = (expr as KoKoOperation).operands[0].eval(ctx)
            var r = (expr as KoKoOperation).operands[1]
            var o = (expr as KoKoOperation).operator

            return KoKoBiOperation(o, KoKoNum((l as KoKoNumValue).value * -1), r).eval(ctx)
        }

        try{
            var valor = (expr.eval(ctx)) as KoKoNumValue
            return KoKoNumValue(valor.value * -1)
        }
        catch(e: Exception){
            throw KoKoEvalException("expression can't have a negative")
        }
    }
    
}
