/**
 * Foo Emiter
 * Helps at compiling
 * Demo ANTLR
 @author loriacarlos@gmail.com 
 @version EIF400.II-2017
 @since 0.0
 
*/
package kokoslan.compile;

import kokoslan.ast.*;
import java.util.*;

public interface KoKoEmiter{
	
   val TRUE = KoKoBool(true)
   val FALSE = KoKoBool(false)
   
   val PLUS = KoKoId("+")
   val MINUS = KoKoId("-")
   val MULT = KoKoId("*")
   val ERROR = KoKoId("??")
   
   fun PROGRAM(stmts: List<KoKoAst>): KoKoProgram{ 
       return KoKoProgram(stmts)
   }
   
   fun LET(id: KoKoAst, expr: KoKoAst): KoKoAst{
	   return KoKoLet(id, expr)
   }
   fun OPERATOR(operator: String): KoKoAst{
	   return KoKoId(operator)
   }
   fun OPERATION(operator: KoKoAst, operands: List<KoKoAst>): KoKoAst{ 
       return KoKoOperation(operator, operands)
   }
   
   fun BI_OPERATION(operator: KoKoAst, left: KoKoAst, right: KoKoAst): KoKoAst{ 
       val id = operator as KoKoId
	   println("Operator = " + id.getValue())
	   when( id.getValue() ){
		   "+" -> return KoKoPLUS(operator, left, right)
		   "-" -> return KoKoMINUS(operator, left, right)
		   "*" -> return KoKoMULT(operator, left, right);
		   else  -> return KoKoBiOperation(operator, left, right);
	   }
   }
   
   fun NUM(value: Double): KoKoNum{ 
       return KoKoNum(value);
   }
   
   fun ID(String value): KoKoId{ 
       return KoKoId(value);
   }
   
   
   fun LIST @JVMoverload (expressions: List<KoKoAst>? = null): KoKoList{
	   expressions?.let{
		 return KoKoList(expressions)
	   }
	   return KoKoList()
   }
   
   fun CALL(head: KoKoAst, args: KoKoList): KoKoAst{
	   return KoKoCall(head, args);
   }
   
   
}