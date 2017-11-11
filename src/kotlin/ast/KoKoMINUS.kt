package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoMINUS (oper: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation (oper, left, right) {
	
	override fun eval( ctx: KoKoContext ) : KoKoValue {
	   	try {
		    val lv = left().eval(ctx) as KoKoNumValue
			val rv = right().eval(ctx) as KoKoNumValue
	        return	KoKoNumValue(lv.getValue() - rv.getValue())
	   	} catch (Exception e) {
			throw new KoKoEvalException(e.getMessage());
	  	}	   
   	}
}