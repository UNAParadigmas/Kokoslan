package kokoslan.kotlin.compile;

import kokoslan.kotlin.ast.*;
import java.util.*;

interface KoKoEmiter {
	
	fun PROGRAM(stmts:MutableList<KoKoAst>) = KoKoProgram(stmts)
	
	fun LET(id:KoKoAst, expr:KoKoAst) = KoKoLet(id, expr)
  
	fun OPERATOR(operator:String) = KoKoId(operator)
	
	fun OPERATION(operator:KoKoAst, operands:MutableList<KoKoAst>) = KoKoOperation(operator, operands)
	
	fun BI_OPERATION(operator:KoKoAst, left:KoKoAst, right:KoKoAst):KoKoAst {
		val id = operator as KoKoId
		when (id.value) {
			"+" -> return KoKoPLUS(operator, left, right)
			"-" -> return KoKoMINUS(operator, left, right)
			"*" -> return KoKoMULT(operator, left, right)
			else -> return KoKoBiOperation(operator, left, right)
		}
	}
  
	fun NUM(value:Double) = KoKoNum(value)
  
	fun ID(value:String) = KoKoId(value)
  
	fun LIST(expressions:List<KoKoAst>) = KoKoList(expressions)
  
	fun LIST():KoKoList = KoKoList()
  
	fun CALL(head:KoKoAst, args:KoKoList) = KoKoCall(head, args)
	
	fun LAMBDA(pattern : KoKoAst, expression : KoKoAst) = KoKoLambda(pattern, expression)
  
	companion object {
		val TRUE = KoKoBool(true)
		val FALSE = KoKoBool(false)
		val PLUS:KoKoAst = KoKoId("+")
		val MINUS:KoKoAst = KoKoId("-")
		val MULT:KoKoAst = KoKoId("*")
		val ERROR:KoKoAst = KoKoId("??")
	}
}