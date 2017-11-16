package kokoslan.kotlin.ast;

import kokoslan.exception.KoKoFailException
import java.io.*;

class KoKoFail() : KoKoAst{
 
   override fun genCode(out : PrintStream){
	    out.print("Fail()")
   }
   
   override fun eval(ctx:KoKoContext): KoKoValue{
       throw KoKoFailException("Fail exception")
    }
}