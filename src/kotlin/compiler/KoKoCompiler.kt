package kokoslan.kotlin.compile;

import kokoslan.kotlin.ast.*;
import kokoslan.parser.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.stream.*;
import java.io.*;

class KoKoCompiler(val outputFile:String? = null):KoKoslanBaseVisitor<KoKoAst>(), KoKoEmiter {
	var program:KoKoAst? = null 
	var statements:MutableList<KoKoAst> = mutableListOf()
	
	fun getProgram() = PROGRAM(this.statements)
	
	fun genCode() {
		try{
			genCode(if (outputFile == null) System.out else PrintStream(outputFile))
		}
		catch (e:Exception) {
			throw RuntimeException(e.message)
		}
	}
	
	fun genCode(out:PrintStream) {
		this.statements.forEach{
			it.genCode(out)
		}
	}
	
	fun eval() = getProgram().eval()
	
	fun compile(tree:ParseTree) = visit(tree)
	
	override fun visitProgram(ctx:KoKoslanParser.ProgramContext):KoKoAst? {
		println("VISITPROGRAM")
		ctx.definition().map( {f -> visit(f)} )
							.forEach{ this.statements.add(it) }
		this.program = PROGRAM(this.statements)
		val expr = visit(ctx.expression())
		this.statements.add(expr)
		return this.program
	}
	
	override fun visitDefinition(ctx:KoKoslanParser.DefinitionContext):KoKoAst {
		println("VISITDEFINITION")
		val id = visit(ctx.id())
		val expr = visit(ctx.expression())
		return LET(id, expr)
	}
	
	/* override fun visitParentesis_expr(ctx : KoKoslanParser.Parentesis_exprContext) : KoKoAst {
		println("PARENTESIS "+ ctx)
		return OPERATOR("+")
	} */
	
	override fun visitAdd_oper(ctx:KoKoslanParser.Add_operContext) = OPERATOR(ctx.oper.getText())
	
	override fun visitId(ctx:KoKoslanParser.IdContext) = ID(ctx.ID().getText())
	
	override fun visitNumber(ctx:KoKoslanParser.NumberContext) = NUM(java.lang.Double.valueOf(ctx.NUMBER().getText()))
	
	override fun visitBool(ctx:KoKoslanParser.BoolContext) = if ((ctx.TRUE() != null)) KoKoEmiter.TRUE else KoKoEmiter.FALSE
	
	override fun visitMult_oper(ctx:KoKoslanParser.Mult_operContext) = OPERATOR(ctx.oper.getText())
	
	override fun visitAdd_expr(ctx:KoKoslanParser.Add_exprContext):KoKoAst {
    // Check if only one operand. Then just visit down
		println("VISIT_ADD_EXPRESSION")
		if (ctx.add_oper() == null)
			return visit(ctx.mult_expr(0))
	
		val operators = ctx.add_oper().map{ visit(it) }
		val operands = ctx.mult_expr().map{ visit(it) }
		println("Operand Final = ${operands[operands.size -1]}")
		val r = arrayOf<KoKoAst>(operands[0])
		( 1 until operands.size ).forEach{
			r[0] = BI_OPERATION(operators[it - 1], r[0], operands[it] )
		}
		return r[0]
	}
  
	override fun visitMult_expr(ctx:KoKoslanParser.Mult_exprContext):KoKoAst {
		if (ctx.mult_oper() == null){
			println("CTX = $ctx")
			return visit(ctx.value_expr(0))
		}
		println("CTX = $ctx")
		val operators = ctx.mult_oper().map{ visit(it) }
		println("Mi Contexto = ${ctx.value_expr()}")
		ctx.value_expr().forEach{ println(it) }
		val operands = ctx.value_expr().map{ visit(it) }
		println("OPERANDS = $operands")
		
		if(operands[0]==null){
			println("CTX2 = $ctx")
			println(ctx.value_expr(0))
			return visit(ctx.value_expr(0));
			}
		else{ 
			val r = mutableListOf<KoKoAst>(operands[0])
			( 1 until operands.size ).forEach{ r[0] = BI_OPERATION(operators[it - 1], r[0], operands[it]) }
			return r[0]
		}
	}
  
	override fun visitCallValueExpr(ctx:KoKoslanParser.CallValueExprContext):KoKoAst {
		println("SOY CALL_VALUE EXPRESION")
		val head = visit(ctx.value_expr())
		val args = visit(ctx.call_args()) as KoKoList
		return CALL(head, args)
	}
	
	override fun visitCall_args(ctx:KoKoslanParser.Call_argsContext):KoKoAst {
		println("SOY CALL_ARGS")
		return if (ctx.list_expr() != null) visit(ctx.list_expr()) else LIST()
	}
  
	override fun visitList_expr(ctx:KoKoslanParser.List_exprContext):KoKoAst {
		val exprs = ctx.expression().map{ visit(it) }
		return LIST(exprs)
	}
	
	override fun visitLambda_expr( ctx:KoKoslanParser.Lambda_exprContext) : KoKoAst{ 
		println("SOY LAMBDA")
		val pattern = visit(ctx.pattern())
		val expression = visit(ctx.expression())
		return LAMBDA(pattern, expression)
	}
}