
package kokoslan.ast;
import java.util.*;
import java.io.*;


class KoKoBiOperation: KoKoOperation {
	
    constructor KoKoBiOperation(val oper: KoKoAst, val left: KoKoAst = this.operands.first, val right: KoKoAst = this.operands.get(1)): super(oper, Arrays.asList(left, right))

	
	override fun KoKoValue eval(ctx: KoKoContext){
	   try {
	        operId: KoKoId = perator as KoKoId
			lv: KoKoNumValue = left().eval(ctx) as KoKoNumValue
			rv: KoKoNumValue  = right().eval(ctx) as KoKoNumValue

			when(operId.getValue()){
				"+" -> return KoKoNumValue(lv.getValue() + rv.getValue())
				"-" -> return KoKoNumValue(lv.getValue() - rv.getValue())
				"*" -> return KoKoNumValue(lv.getValue() * rv.getValue())
				else -> throw KoKoEvalException("KoKoBiOperation unimpemented operator")
			}
			
	   }catch (e: Exception) {
			throw KoKoEvalException(e.getMessage());
	    }
	   
   }
	
}