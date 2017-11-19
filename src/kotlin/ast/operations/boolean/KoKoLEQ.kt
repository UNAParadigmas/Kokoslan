/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast.operations.boolean

import java.util.*
import java.io.*
import kokoslan.kotlin.ast.*

class KoKoLEQ(operator : KoKoAst, left : KoKoAst, right : KoKoAst) : KoKoOperation(operator, Arrays.asList(left, right)) {
	
	override fun eval(ctx : KoKoContext): KoKoBoolValue{
	    try {
            val lv = operands[0].eval(ctx) as KoKoNumValue
            val rv = operands[1].eval(ctx) as KoKoNumValue
     		return KoKoBoolValue(lv.value <= rv.value)
	   } catch ( e : Exception ) {
			throw KoKoEvalException("${e.message}")
	   }
    }
}