package kokoslan.ast;
import java.io.*;


class KoKoLet : KoKoAst constructor(val id: KoKoAst, val expr: KoKoAst ){

   fun genCode( out: PrintStream ){
      out.print("let ");
	  this.id.genCode(out);
	  out.print(" = ");
	  this.expr.genCode(out);
	  out.println();
   }
   fun eval(KoKoContext ctx): KoKoValue {
	   var value: KoKoValue = expr.eval(ctx);
	   ctx.assoc((KoKoId)id, value);
	   return value;
   }
   
}