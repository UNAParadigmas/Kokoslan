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


class KoKoBiOperation(val oper: KoKoAst, val left: KoKoAst = this.operands[0], val right: KoKoAst = this.operands[1]): KoKoOperation(oper, Arrays.asList(left, right)) {
	
	override fun eval(ctx: KoKoContext): KoKoValue{
	   try {
	        val operId: KoKoId = oper as KoKoId
			val lv: KoKoNumValue = left().eval(ctx) as KoKoNumValue
			val rv: KoKoNumValue  = right().eval(ctx) as KoKoNumValue

			when(operId.value()){
				"+" -> return KoKoNumValue(lv.value() + rv.value())
				"-" -> return KoKoNumValue(lv.value() - rv.value())
				"*" -> return KoKoNumValue(lv.value() * rv.value())
				else -> throw KoKoEvalException("KoKoBiOperation unimpemented operator")
			}
			
	   }catch (e: Exception) {
			throw KoKoEvalException(e.message());
	    }
	   
   }
	
}