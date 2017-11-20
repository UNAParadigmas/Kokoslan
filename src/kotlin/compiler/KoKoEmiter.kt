/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.compiler

import kokoslan.kotlin.ast.*
import kokoslan.kotlin.eval.*
import java.util.*

interface KoKoEmiter {
	
	fun PROGRAM(stmts:MutableList<KoKoAst>) = KoKoProgram(stmts)
	
	fun LET(id:KoKoAst, expr:KoKoAst) = KoKoLet(id, expr)

	fun OPERATOR(operator:String) = KoKoId(operator)
	
	fun OPERATION(operator:KoKoAst, operands: MutableList<KoKoAst>) = KoKoOperation(operator, operands)
	
	fun BI_OPERATION(operator:KoKoAst, left:KoKoAst, right:KoKoAst):KoKoAst {
		val id = operator as KoKoId
		return when (id.value) {
			"+"  -> KoKoPLUS(operator, left, right)
			"-"  -> KoKoMINUS(operator, left, right)
			"*"  -> KoKoMULT(operator, left, right)
			"/"  -> KoKoDIV	(operator, left, right)
			"<"  -> KoKoLS	(operator, left, right)
			">"  -> KoKoGS	(operator, left, right)
			"<=" -> KoKoLEQ	(operator, left, right)
			">=" -> KoKoGEQ	(operator, left, right)
			"&&" -> KoKoAND	(operator, left, right)
			"||" -> KoKoOR	(operator, left, right)
			"==" -> KoKoEQS	(operator, left, right)
			"!=" -> KoKoNEQ	(operator, left, right)
			else -> throw Exception("Error => Unknown operator = ${operator}")
		}
	}
  
	fun NUM(value:Double) = KoKoNum(value)
  
	fun ID(value:String) = KoKoId(value)
  
	fun LIST(expressions:List<KoKoAst>) = KoKoList(expressions)
  
	fun LIST():KoKoList = KoKoList()

	fun LISTREST(valor:List<KoKoAst>):KoKoListPat= KoKoListPat(valor as MutableList<KoKoAst>, true)

	fun IS_PRIMITIVE(head: KoKoAst) : Boolean{
		return when(head.toString()){
            "first","rest","cons","length","fail" ->  true
             else -> false
		}
	}

	fun CALL(head:KoKoAst, args:KoKoList) = KoKoCall(head, args)

	fun CALL_PRIMITIVE(head:KoKoAst, args:MutableList<KoKoAst>): KoKoAst {
		return when (head.toString()) {
            "first" -> KoKoFirst(args)
        	"rest"  -> KoKoRest(args)
        	"length"-> return KoKoLength(args)
            "cons"  -> throw Exception("Cons must have 2 arguments")
			else -> throw Exception("Unexpected Exception")
        }
    }

    fun CALL_PRIMITIVE(head:KoKoAst, args:MutableList<KoKoAst>, args2:MutableList<KoKoAst>) = KoKoCons(args, args2)

    fun LISTExp(expressions:List<KoKoAst>, pipe: Boolean) = KoKoArrayList(expressions, pipe)

    fun LISTExp(): KoKoArrayList = KoKoArrayList()

    fun ELVIS(operator: KoKoAst, operands: MutableList<KoKoAst>) = KoKoElvis(operator, operands)

    fun LAMBDA(pattern : KoKoAst, expression : KoKoAst) = KoKoLambda(pattern, expression)

	fun PARENTESIS(expression : KoKoAst) = KoKoParentesis(expression)

	fun NEGATIVE(expression: KoKoAst) = KoKoNegative(expression)

	companion object {
		val TRUE = KoKoBool(true)
		val FALSE = KoKoBool(false)
		val PLUS:KoKoAst = KoKoId("+")
		val MINUS:KoKoAst = KoKoId("-")
		val MULT:KoKoAst = KoKoId("*")
		val ERROR:KoKoAst = KoKoId("??")
		val AND:KoKoAst = KoKoId("&&")
	}
}