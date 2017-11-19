/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/

package kokoslan.kotlin.ast

import java.util.*
import java.io.*
import kokoslan.kotlin.ast.*
import kokoslan.kotlin.compiler.*

class KoKoNegative(var expr: KoKoAst) : KoKoAst, KoKoEmiter{

	override fun genCode(out:PrintStream){
		out.print("-")	
        expr.genCode(out)
    }

	override fun eval(ctx : KoKoContext): KoKoValue{
        var l = ((expr as KoKoOperation).operands[0].eval(ctx)) as KoKoNumValue
        println("l evaluado en negative es: ${l.value * -1}")
        if(l is KoKoNumValue){
            return KoKoNumValue(l.value * -1)
        }
        return KoKoNumValue((expr.eval(ctx) as KoKoNumValue).value)
    }
}
