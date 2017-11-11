package kokoslan.ast;
import java.io.*;


class KoKoLet (val id: KoKoAst, val expr: KoKoAst ): KoKoAst {

   fun genCode( out: PrintStream ){
      out.print("let ");
	  this.id.genCode(out);
	  out.print(" = ");
	  this.expr.genCode(out);
	  out.println();
   }
   fun eval(KoKoContext ctx): KoKoValue {
	   var value = expr.eval(ctx);
	   ctx.assoc(id as KoKoId, value);
	   return value;
   }
   
}