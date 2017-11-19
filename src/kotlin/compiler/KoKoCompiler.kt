package kokoslan.kotlin.compile;

import kokoslan.kotlin.ast.*
import kokoslan.kotlin.parser.*

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

    /* Base Visitor Override Functions */

    override fun visitProgram(ctx:KoKoslanParser.ProgramContext):KoKoAst? {
        ctx.definition().map( {f -> visit(f)} )
                .forEach{ this.statements.add(it) }
        this.program = PROGRAM(this.statements)
        val expr = visit(ctx.expression())
        if(expr!=null)
            this.statements.add(expr)
        return this.program
    }

    override fun visitDefinition(ctx:KoKoslanParser.DefinitionContext):KoKoAst {
        val id = visit(ctx.id())
        val expr = visit(ctx.expression())
        return LET(id, expr)
    }

    override fun visitLambda_expr( ctx:KoKoslanParser.Lambda_exprContext) : KoKoAst{
        val pattern = visit(ctx.pattern())
        val expression = visit(ctx.expression())
        if(ctx.ARROW()!=null)
            return LAMBDAWHEN(pattern, expression)
        return LAMBDA(pattern, expression)
    }

    override fun visitAdd_expr(ctx:KoKoslanParser.Add_exprContext):KoKoAst {
        if (ctx.add_oper() == null)
            return visit(ctx.mult_expr(0))

        val operators = ctx.add_oper().map{ visit(it) }
        val operands = ctx.mult_expr().map{ visit(it) }
        val r = arrayOf<KoKoAst>(operands[0])
        ( 1 until operands.size ).forEach{
            r[0] = BI_OPERATION(operators[it - 1], r[0], operands[it] )
        }
        return r[0]
    }

    override fun visitAdd_oper(ctx:KoKoslanParser.Add_operContext) = OPERATOR(ctx.oper.getText())

    override fun visitBool_expr(ctx: KoKoslanParser.Bool_exprContext) :KoKoAst {
        if(ctx.bool_oper() == null){
            return visit(ctx.bool_Not_expr(0))
        }
        val operators = ctx.bool_oper().map{ visit(it) }
        val operands = ctx.bool_Not_expr().map{ visit(it) }
        val r = arrayOf<KoKoAst>(operands[0])
        ( 1 until operands.size ).forEach{
            r[0] = BI_OPERATION(operators[it - 1], r[0], operands[it] )
        }
        return r[0]
    }

    override fun visitBool_Not_expr(ctx: KoKoslanParser.Bool_Not_exprContext): KoKoAst {
			val x = visit(ctx.value_expr())
			val y = KoKoNOT(visit(ctx.value_expr()))
			val r = if(ctx.NOT() != null && ctx.NOT().size % 2 == 0) x else y
            return r

    }
    override fun visitBool_oper(ctx:KoKoslanParser.Bool_operContext) = OPERATOR(ctx.oper.getText())

    override fun visitParentValueExpr(ctx : KoKoslanParser.ParentValueExprContext) : KoKoAst {
        val expr = visit(ctx.expression())
        return PARENTESIS(expr)
    }

    override fun visitNegative(ctx: KoKoslanParser.NegativeContext) = NEGATIVE(visit(ctx.expression()))


    override fun visitEvaluable_expr(ctx: KoKoslanParser.Evaluable_exprContext): KoKoAst {
		if(ctx.bool_expr()!=null) {
        	val oper = visit(ctx.bool_expr())
			if(ctx.test_expr()!= null) {
                val operands = ctx.test_expr().expression().map { visit(it) }
                return ELVIS(oper, operands as MutableList<KoKoAst>)
            }
            return oper
        }
		return visit(ctx.add_expr())
    }
    override fun visitId(ctx:KoKoslanParser.IdContext) = ID(ctx.ID().getText())

    override fun visitNumber(ctx:KoKoslanParser.NumberContext) = NUM(java.lang.Double.valueOf(ctx.NUMBER().getText()))

    override fun visitBool(ctx:KoKoslanParser.BoolContext): KoKoAst{
        if(ctx.NOT().size % 2 == 0){
            return if(ctx.TRUE() != null) KoKoEmiter.TRUE else KoKoEmiter.FALSE
        }
        return if(ctx.TRUE() != null) KoKoEmiter.FALSE else KoKoEmiter.TRUE
    }

    override fun visitMult_oper(ctx:KoKoslanParser.Mult_operContext) = OPERATOR(ctx.oper.getText())

    override fun visitMult_expr(ctx:KoKoslanParser.Mult_exprContext):KoKoAst {
        if (ctx.mult_oper() == null){
            return visit(ctx.value_expr(0))
        }
        val operators = ctx.mult_oper().map{ visit(it) }
        val operands = ctx.value_expr().map{ visit(it) }

        if(operands[0]==null){
            return visit(ctx.value_expr(0));
        }
        else{
            val r = mutableListOf<KoKoAst>(operands[0])
            ( 1 until operands.size ).forEach{ r[0] = BI_OPERATION(operators[it - 1], r[0], operands[it]) }
            return r[0]
        }
    }

    override fun visitCallValueExpr(ctx:KoKoslanParser.CallValueExprContext):KoKoAst {
        val head = visit(ctx.value_expr())
        val args = visit(ctx.call_args()) as KoKoList
        return CALL(head, args)
    }

    override fun visitPrintValue(ctx: KoKoslanParser.PrintValueContext) = PRINT(visit(ctx.expression()))

    override fun visitCall_args(ctx:KoKoslanParser.Call_argsContext):KoKoAst {
        if (ctx.list_expr() != null){
            var args = ctx.list_expr().map{i -> visit(i)}
            return LIST(args)
        }else
            return LIST()
    }

    override fun visitList_expr(ctx:KoKoslanParser.List_exprContext):KoKoAst {
        val exprs = ctx.expression().map{ visit(it) }
        return LIST(exprs)
    }

    override fun visitListValueExpr(ctx: KoKoslanParser.ListValueExprContext):KoKoAst {
            return visit(ctx.list_value())
    }

    override fun visitList_value(ctx: KoKoslanParser.List_valueContext):KoKoAst {
        if(ctx.list_expr()!= null && ctx.list_expr().expression()!= null && ctx.list_expr().expression().get(0).part_expr()!= null){
            val expressions = ctx.list_expr().expression().get(0).part_expr().map{ visit(it) }
            return LISTExp(expressions, false)
        }
        return LISTExp()
    }

    override fun visitFailValue(ctx: KoKoslanParser.FailValueContext?): KoKoAst {
        return FAIL()
    }

    /*override fun  visitCons(ctx: KoKoslanParser.ConsContext) :KoKoAst {
        var a = mutableListOf<KoKoAst>()
        ctx.expression().forEach{ it.part_expr().map{ visit(it) }.forEach{a.add(it)} }
        return KoKoCons(a)
    }
  
    override fun visitList_pat(ctx: KoKoslanParser.List_patContext): KoKoAst {
        if(ctx.list_body_pat()!=null) {
            val expressions = visit(ctx.list_body_pat()) ?: return LISTExp()
            if (!(expressions as MutableList<KoKoAst>).isEmpty())
                return expressions
        }
        return LISTExp()
	}

    override fun visitListPattern(ctx: KoKoslanParser.ListPatternContext): KoKoAst {
        return visit(ctx.list_pat())
    }

    override fun visitList_body_pat(ctx: KoKoslanParser.List_body_patContext): KoKoAst {
        var p = false
        var l = mutableListOf<KoKoAst>()
        ctx.pattern().forEach { l.add(visit(it)) }
        if(ctx.rest_body_pat()!=null) {
            l.add(visit(ctx.rest_body_pat()))
            p = true
        }
        return LISTExp(l, p)
	}

	override fun visitRest_body_pat(ctx: KoKoslanParser.Rest_body_patContext): KoKoAst{
        return if(ctx.id()!=null)
            LISTREST(listOf(visit(ctx.id())))
        else 
            visit(ctx.list_pat())
    }

    /*override fun visitListFirst(ctx: KoKoslanParser.ListFirstContext):KoKoAst {
        throw Exception("first")
    }

    override fun visitRest(ctx: KoKoslanParser.RestContext) : KoKoAst {
        var a = mutableListOf<KoKoAst>()
        ctx.expression().part_expr().map{ visit(it) }.forEach{a.add(it)}
        return KoKoRest(a)
    }

    override fun visitFirst(ctx: KoKoslanParser.FirstContext) : KoKoAst { 
        var a = mutableListOf<KoKoAst>()
        ctx.expression().part_expr().map{ visit(it) }.forEach{a.add(it)}
        return KoKoFirst(a)
    }

    override fun visitLength(ctx: KoKoslanParser.LengthContext) : KoKoAst {
        var a = mutableListOf<KoKoAst>()
        ctx.expression().part_expr().map{ visit(it) }.forEach{a.add(it)}
        return KoKoLength(a) 
    }*/*/

}