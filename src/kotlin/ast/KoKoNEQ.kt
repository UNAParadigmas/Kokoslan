/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import java.util.*;
import java.io.*;


class KoKoNEQ(operator : KoKoAst, left : KoKoAst, right : KoKoAst) : KoKoBiOperation(operator, left, right) {
	
	override fun eval(ctx : KoKoContext): KoKoBoolValue{
	   try {
		    val lv = left().eval(ctx)
			val rv = right().eval(ctx)
	        if(lv is KoKoNumValue)
     			return KoKoBoolValue((lv as KoKoNumValue).value != (rv as KoKoNumValue).value)
     		return KoKoBoolValue((lv as KoKoBoolValue).value != (rv as KoKoBoolValue).value)
    		
	   } catch ( e : Exception ) {
			throw KoKoEvalException("${e.message}")
	   }
    }
}

