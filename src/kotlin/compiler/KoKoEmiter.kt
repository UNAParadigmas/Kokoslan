/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.compiler;

import kokoslan.kotlin.ast.*

interface KoKoEmiter {
	
	fun PROGRAM(stmts:MutableList<KoKoAst>) = KoKoProgram(stmts)
	
	fun LET(id:KoKoAst, expr:KoKoAst) = KoKoLet(id, expr)

    fun PRINT(expr: KoKoAst) = KoKoPrint(expr)

	fun FAIL() = KoKoFail()
  
	fun OPERATOR(operator:String) = KoKoId(operator)
	
	fun OPERATION(operator:KoKoAst, operands: MutableList<KoKoAst>) = KoKoOperation(operator, operands)
	
	fun BI_OPERATION(operator:KoKoAst, left:KoKoAst, right:KoKoAst):KoKoAst {
		val id = operator as KoKoId
		when (id.value) {
			"+"  -> return KoKoPLUS	(operator, left, right)
			"-"  -> return KoKoMINUS(operator, left, right)
			"*"  -> return KoKoMULT	(operator, left, right)
			"/"  -> return KoKoDIV	(operator, left, right)
			"<"  -> return KoKoLS	(operator, left, right)
			">"  -> return KoKoGS	(operator, left, right)
			"<=" -> return KoKoLEQ	(operator, left, right)
			">=" -> return KoKoGEQ	(operator, left, right)
			"&&" -> return KoKoAND	(operator, left, right)
			"||" -> return KoKoOR	(operator, left, right)
			"==" -> return KoKoEQS	(operator, left, right)
			"!=" -> return KoKoNEQ	(operator, left, right)
			else -> throw Exception("Error => Unknown operator = ${operator}")
		}
	}
  
	fun NUM(value:Double) = KoKoNum(value)
  
	fun ID(value:String) = KoKoId(value)
  
	fun LIST(expressions:List<KoKoAst>) = KoKoList(expressions)
  
	fun LIST():KoKoList = KoKoList()

	fun LISTREST(valor:List<KoKoAst>):KoKoListPat= KoKoListPat(valor as MutableList<KoKoAst>, true)
  
	fun CALL(head:KoKoAst, args:KoKoList) = KoKoCall(head, args)

    fun LISTExp(expressions:List<KoKoAst>, pipe: Boolean) = KoKoArrayList(expressions, pipe)

    fun LISTExp(): KoKoArrayList = KoKoArrayList()

    fun ELVIS(operator: KoKoAst, operands: MutableList<KoKoAst>) = KoKoElvis(operator, operands)

    fun LAMBDA(pattern : KoKoAst, expression : KoKoAst) = KoKoLambda(pattern, expression)

	fun LAMBDAWHEN(pattern : KoKoAst, expression : KoKoAst) = KoKoLambdaWhen(pattern, expression)

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