package kokoslan.ast;
import java.util.*;
import java.io.*;


class KoKoMULT: KoKoBiOperation (KoKoAst operator, KoKoAst left, KoKoAst right): super(operator, left, right){

	override
	fun eval( ctx: KoKoContext ): KoKoValue{
	   try {
		     val lv: KoKoNumValue = left().eval(ctx) as KoKoNumValue
			 val rv: KoKoNumValue = right().eval(ctx) as KoKoNumValue
	         return KoKoNumValue(lv.getValue() - rv.getValue())
	   } catch (Exception e) {
			throw new KoKoEvalException(e.getMessage())
	   }
   }
	
}