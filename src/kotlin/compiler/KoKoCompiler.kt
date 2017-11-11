/**
 * Kokoslan toy compiler
 * Demo ANTLR (suing visitors)
 @author loriacarlos@gmail.com 
 @version EIF400.II-2017
 @since 0.0
*/
package kokoslan.compile


import kokoslan.ast.*
import kokoslan.parser.*

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

import java.util.*
import java.util.stream.*
import java.io.*

class KoKoCompiler (outputFile: String? = null) : KoKoslanBaseVisitor<KoKoAst>(), KoKoEmiter{
   protected var outputFile: String?
   protected var program: KoKoAst? = null
   protected var statements = ArrayList<KoKoAst>()
   
   init {
		this.outputFile = outputFile
   }

   fun getProgram() = PROGRAM(this.statements)

   fun genCode(){
	   try {
	    genCode(if(outputFile == null) System.out else PrintStream(outputFile))
	   } catch (e: Exception){
		   throw RuntimeException(e.message)
	   }
   }
   fun genCode(out: PrintStream) = this.statements.forEach{it.genCode(out)}
   
   fun eval() = getProgram().eval() 
   
   fun compile(tree: ParseTree) = visit(tree)
   
   override fun visitProgram(ctx: KoKoslanParser.ProgramContext): KoKoAst?{
	   ctx.definition().map{visit(it)}
					   .forEach{ this.statements.add(it) }
	   this.program = PROGRAM(this.statements) 
	   val expr = visit(ctx.expression())
	   this.statements.add(expr)
	   return this.program
   }

   override fun visitDefinition(ctx: KoKoslanParser.DefinitionContext): KoKoAst{
	  val id = visit(ctx.id())
      val expr = visit(ctx.expression())  
	  return LET(id, expr)
   }
   
   override fun visitAdd_oper(ctx: KoKoslanParser.Add_operContext) = OPERATOR(ctx.oper.getText())

   override fun visitId(ctx: KoKoslanParser.IdContext) = ID(ctx.ID().getText())
   
   override fun visitNumber(ctx: KoKoslanParser.NumberContext) = NUM(ctx.NUMBER().getText().toDouble())
   
   override fun visitBool(ctx: KoKoslanParser.BoolContext): KoKoAst { return if( ctx.TRUE() != null ) TRUE else FALSE}
   
   override fun visitMult_oper(ctx: KoKoslanParser.Mult_operContext) = OPERATOR(ctx.oper.getText())
   
   override fun visitAdd_expr(ctx: KoKoslanParser.Add_exprContext): KoKoAst{
	  // Check if only one operand. Then just visit down
	  if ( ctx.add_oper() == null ){
		  return visit(ctx.mult_expr(0))
	  }
	  var operators = ctx.add_oper()
								   .stream()
	                               .map{ visit(it) }					   
	  var operands =  ctx.mult_expr()
								   .stream()
	                               .map{ visit(it) }
      var r = {operands.get(0)}
      java.util.stream.IntStream
	                  .range(1, operands.size())
	                  .forEach( {i -> r[0] = BI_OPERATION(operators.get(i - 1), r[0], operands.get(i))})	  
      return r[0]
   
   }
   
   override fun visitMult_expr(ctx: KoKoslanParser.Mult_exprContext):KoKoAst{
	   if(ctx.mult_oper() == null){
		   return visit(ctx.value_expr(0))
	   }
	   var operators = ctx.mult_oper()
	                               .stream()
	                               .map{ visit(it) }					   
	  var operands =  ctx.value_expr()
	                               .stream()
	                               .map{ visit(e) }
      var r = {operands[0]}
      java.util.stream.IntStream.range(1, operands.size()).forEach( {i -> r[0] = BI_OPERATION(operators.get(i - 1), r[0], operands.get(i))})	  
      return r[0]
	}
   
   override fun visitCallValueExpr(ctx: KoKoslanParser.CallValueExprContext): KoKoAst{
	   val head = visit(ctx.value_expr())
	   val args = (KoKoList)visit(ctx.call_args())
	   return CALL(head,args)
   }
   
   override fun visitCall_args(ctx: KoKoslanParser.Call_argsContext): KoKoAst{
		if(ctx.list_expr() != null)
			visit(ctx.list_expr())
		else LIST()
   }
   
   override fun visitList_expr(ctx: KoKoslanParser.List_exprContext): KoKoAst{
	   val exprs = ctx.expression()
					  .stream()
					  .map{ visit(it) }
					  .collect(Collectors.toList())
		return LIST(exprs)
   }
   
}