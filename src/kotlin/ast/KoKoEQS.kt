/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException


class KoKoEQS(operator : KoKoAst, left : KoKoAst, right : KoKoAst) : KoKoBiOperation(operator, left, right) {
	
	override fun eval(ctx : KoKoContext): KoKoValue{
	    try {
		    val lv = left().eval(ctx) as KoKoAtom<*>
			val rv = right().eval(ctx) as KoKoAtom<*>
     		return KoKoBoolValue(lv.value == rv.value)
	   } catch ( e : Exception ) {
			throw KoKoEvalException("${e.message}")
	   }
    }
}