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

class KoKoMULT(operator : KoKoAst, left : KoKoAst, right : KoKoAst ) : KoKoOperation(operator, Arrays.asList(left, right)) {
	
    override fun eval(ctx : KoKoContext ) : KoKoValue{
	   try {
		     val lv = (operands[0].eval(ctx)) as KoKoNumValue
			 val rv = (operands[1].eval(ctx)) as KoKoNumValue
			 println("L en MULT es: ${lv.value}")
			 println("R en MULT es: ${rv.value}")
	         return KoKoNumValue(lv.value * rv.value)
	   } catch ( e: Exception ) {
			throw  KoKoEvalException("${e.message}")
	   }
	}
}