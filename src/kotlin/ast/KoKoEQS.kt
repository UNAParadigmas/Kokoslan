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
		    val lv = left().eval(ctx)
			val rv = right().eval(ctx)
			if(lv is KoKoNumValue && rv is KoKoNumValue)
                return KoKoBoolValue(lv.value == rv.value)
            if(lv is KoKoBoolValue && rv is KoKoBoolValue)
     			return KoKoBoolValue(lv.value == rv .value)
            if(lv is KoKoListValue && rv is KoKoListValue)
                return KoKoBoolValue(lv == rv)
			throw KoKoEvalException("Unhandled comparision.")
	   } catch ( e : Exception ) {
			throw KoKoEvalException("${e.message}")
	   }
    }
}