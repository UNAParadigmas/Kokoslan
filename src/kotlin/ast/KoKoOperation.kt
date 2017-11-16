/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import java.util.*;
import java.io.*;


open class KoKoOperation(val operator : KoKoAst, val operands: MutableList<KoKoAst> = mutableListOf()) : KoKoAst{

   fun addOperand( x : KoKoAst ){
	   this.operands.add(x)
   }
   
   override fun genCode(out:PrintStream){
		this.operands[0].genCode(out)
		( 1 until this.operands.size ).forEach{
			this.operator.genCode(out)
			this.operands[it].genCode(out)
		}
   }
   
   override fun eval(ctx:KoKoContext) : KoKoValue {
	   throw KoKoEvalException("KoKoOperation: eval no implementado") 
   }
}