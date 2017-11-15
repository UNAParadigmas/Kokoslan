package kokoslan.kotlin.ast;

import java.io.*;

class KoKoPrint(val expr : KoKoAst ) : KoKoAst{
 
   override fun genCode(out : PrintStream){
        this.expr.genCode(out)
	    out.println()
   }
   
   override fun eval(ctx:KoKoContext) = expr.eval(ctx)   
}