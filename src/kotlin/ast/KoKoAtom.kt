/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;
import java.io.*;

open class KoKoAtom<T>(val value: T) : KoKoAst{
   
   override fun genCode(out : PrintStream){
      out.print("${this.value} ")
   }
   
   override fun eval(ctx : KoKoContext) : KoKoValue{
	   throw KoKoEvalException("KoKoAtom: eval not implemented")
   }
   
   override fun toString() =  value.toString()
}