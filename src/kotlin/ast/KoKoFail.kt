package kokoslan.kotlin.ast;

import java.io.*;

class KoKoFail() : KoKoAst{
 
   override fun genCode(out : PrintStream){
	    out.println("Fail()")
   }
   
   override fun eval(ctx:KoKoContext): KoKoValue{
       throw KoKoEvalException("Fail exception")
    }
}