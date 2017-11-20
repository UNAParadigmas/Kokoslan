/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast

import java.io.*
import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException

class KoKoPRINT(val arg : KoKoAst ) : KoKoAst{

   override fun genCode(out : PrintStream){
        out.print("print( ")
        this.arg.genCode(out)
        out.println(" )")
   }
   
   override fun eval(ctx:KoKoContext) = arg.eval(ctx)
}