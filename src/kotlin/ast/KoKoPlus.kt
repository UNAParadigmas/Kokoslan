/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast;
import java.util.*;
import java.io.*;


open class KoKoPLUS (oper: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation (oper, left, right) {
	
	override fun eval( ctx: KoKoContext ) : KoKoValue{
	   try {
		     val lv = left.eval(ctx) as KoKoNumValue
			 val rv = right.eval(ctx) as KoKoNumValue
	         return	KoKoNumValue(lv.value + rv.value)
	   } catch (e: Exception) {
			throw KoKoEvalException(e.message)
	  	}	
	   
   }
	
}