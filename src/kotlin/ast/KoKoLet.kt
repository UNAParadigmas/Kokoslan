package kokoslan.ast;
import java.io.*;


class KoKoLet (val id: KoKoAst, val expr: KoKoAst ): KoKoAst {

   override fun genCode( out: PrintStream ){
      out.print("let ")
	  this.id.genCode(out)
	  out.print(" = ")
	  this.expr.genCode(out)
	  out.println()
   }
   override fun eval(ctx: KoKoContext): KoKoValue {
	   var value = expr.eval(ctx)
	   ctx.assoc(id as KoKoId, value)
	   return value
   }
   
}