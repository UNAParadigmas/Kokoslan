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


open class KoKoBiOperation(val oper: KoKoAst, val left: KoKoAst, val right: KoKoAst): KoKoOperation(oper, mutableListOf(left, right)) {
	
	fun left() = this.operands[0]

  	fun right() = this.operands[1]

	override fun eval(ctx: KoKoContext): KoKoValue{
	   try {
	        val operId = oper as KoKoId
			val lv = this.left().eval(ctx) as KoKoNumValue
			val rv = this.right().eval(ctx) as KoKoNumValue

			when(operId.value){
				"+" -> return KoKoNumValue(lv.value + rv.value)
				"-" -> return KoKoNumValue(lv.value - rv.value)
				"*" -> return KoKoNumValue(lv.value * rv.value)
				"/" -> return KoKoNumValue(lv.value / rv.value)
				else -> throw KoKoEvalException("KoKoBiOperation unimpemented operator")
			}
			
	   }catch (e: Exception) {
			throw KoKoEvalException(e.message)
	    }
	   
   }
	
}