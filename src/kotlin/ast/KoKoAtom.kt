
package kokoslan.ast;
import java.io.*;


class KoKoAtom<T> : KoKoAst (val value: T){ 
   override fun genCode (out: PrintStream){
      out.print(this.value + " ")
   }

   override fun eval: KoKoValue(ctx: KoKoContext){
	   throw KoKoEvalException("KoKoAtom: eval not implemented");	   
   }
   
   fun toString: String(){
	   return value.toString();
   }
}