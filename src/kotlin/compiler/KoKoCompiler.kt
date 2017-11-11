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

class KoKoCompiler @JVMoverload (protected var outputFile: String? = null) : KoKoslanBaseVisitor<KoKoAst>, KoKoEmiter{
	
   protected var program
   protected var statements = ArrayList<KoKoAst>()

   fun getProgram() = PROGRAM(this.statements)

   override fun genCode(){
	   try {
	    genCode(if(outputFile == null) System.out else PrintStream(outputFile))
	   } catch (Exception e){
		   throw RuntimeException(e.getMessage())
	   }
   }
   override fun genCode(out: PrintStream) = this.statements.forEach{it.genCode(out)}
   
   fun eval() = getProgram().eval() 
   
   fun compile(tree: ParseTree) = visit(tree)
   
   override fun visitProgram(ctx: KoKoslanParser.ProgramContext): KoKoAst{
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
   
   override fun visitNumber(ctx: KoKoslanParser.NumberContext) = NUM(Double.valueOf(ctx.NUMBER().getText()))
   
   override fun visitBool(ctx: KoKoslanParser.BoolContext) = if( ctx.TRUE() != null ) TRUE else FALSE
   
   override fun visitMult_oper(ctx: KoKoslanParser.Mult_operContext) = OPERATOR(ctx.oper.getText())
   
   override fun visitAdd_expr(ctx KoKoslanParser.Add_exprContext): KoKoAst{
	  // Check if only one operand. Then just visit down
	  if ( ctx.add_oper() == null ){
		  return visit(ctx.mult_expr(0))
	  }
	  List<KoKoAst> operators = ctx.add_oper()
	                               .map{ visit(it) }
								   .collect{Collectors.toList()}						   
	  List<KoKoAst> operands =  ctx.mult_expr()
	                               .map{ visit(it) }
								   .collect{Collectors.toList()}
      var r = {operands.get(0)}
      java.util.stream.IntStream
	                  .range(1, operands.size())
	                  .forEach( {i -> r[0] = BI_OPERATION(operators.get(i - 1), r[0], operands.get(i))})	  
      return r[0]
   
   }
   
   override fun visitMult_expr(KoKoslanParser.Mult_exprContext ctx):KoKoAst{
	   if(ctx.mult_oper() == null){
		   return visit(ctx.value_expr(0))
	   }
	   List<KoKoAst> operators = ctx.mult_oper()
	                               .stream()
	                               .map( e -> visit(e) )
								   .collect(Collectors.toList())						   
	  List<KoKoAst> operands =  ctx.value_expr()
	                               .stream()
	                               .map( e -> visit(e) )
								   .collect(Collectors.toList())
      KoKoAst[] r = {operands.get(0)}
      java.util.stream.IntStream
	                  .range(1, operands.size())
	                  .forEach( i -> r[0] = BI_OPERATION(operators.get(i - 1), r[0], operands.get(i)))	  
      return r[0]
	}
   
   override fun visitCallValueExpr(KoKoslanParser.CallValueExprContext ctx): KoKoAst{
	   KoKoAst head = visit(ctx.value_expr())
	   KoKoList args = (KoKoList)visit(ctx.call_args())
	   return CALL(head,args)
   }
   
   override fun visitCall_args(KoKoslanParser.Call_argsContext ctx): KoKoAst{
		if(ctx.list_expr() != null)
			visit(ctx.list_expr())
		else LIST()
   }
   
   override fun visitList_expr(KoKoslanParser.List_exprContext ctx): KoKoAst{
	   List<KoKoAst> exprs = ctx.expression()
									.stream()
									.map( e -> visit(e) )
									.collect(Collectors.toList())
		return LIST(exprs)
   }
   
}