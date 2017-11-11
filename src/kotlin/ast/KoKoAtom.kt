
package kokoslan.ast
import java.io.PrintStream


class KoKoAtom<T> (val value: T): KoKoAst { 
   override fun genCode (out: PrintStream) = out.print("${this.value} ")

   override fun eval(ctx: KoKoContext): KoKoValue{
	   throw KoKoEvalException("KoKoAtom: eval not implemented")
   }
   
   override fun toString(): String{
	   return value.toString()
   }
}