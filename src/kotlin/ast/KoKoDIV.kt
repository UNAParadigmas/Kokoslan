/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.ast
import java.util.*
import java.io.*
import kokoslan.eval.*
import kokoslan.exception.*

class KoKoDIV (oper: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation (oper, left, right) {
	
	override fun eval( ctx: KoKoContext ) : KoKoValue {
	   	try {
		    val lv = left.eval(ctx) as KoKoNumValue
			val rv = right.eval(ctx) as KoKoNumValue
	        return	KoKoNumValue(lv.value / rv.value)
	   	} catch (e: Exception) {
			throw KoKoEvalException(e.message)
	  	}
	   
   	}
}