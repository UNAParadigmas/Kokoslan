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

class KoKoNEQ(operator : KoKoAst, left : KoKoAst, right : KoKoAst) : KoKoOperation(operator, Arrays.asList(left, right)) {
	
	override fun eval(ctx : KoKoContext): KoKoBoolValue{
	   try {
           val lv = operands[0].eval(ctx) as KoKoAtomValue<*>
           val rv = operands[1].eval(ctx) as KoKoAtomValue<*>
		   return KoKoBoolValue(lv.value != rv.value)
	   } catch ( e : Exception ) {
			throw KoKoEvalException("${e.message}")
	   }
    }
}

