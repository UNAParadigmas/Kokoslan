/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast
import java.io.PrintStream


open class KoKoAtom<T> (val value: T): KoKoAst { 
   override open fun genCode (out: PrintStream) = out.print("${this.value} ")

   override open fun eval(ctx: KoKoContext): KoKoValue{
	   throw KoKoEvalException("KoKoAtom: eval not implemented")
   }
   
   override open fun toString(): String{
	   return value.toString()
   }
}