
package kokoslan.ast;
import java.io.*;


class KoKoAtom<T> : KoKoAst (val value: T){ 
   fun genCode (out: PrintStream){
      out.print(this.value + " ")
   }

   fun eval: KoKoValue(ctx: KoKoContext){
	   throw KoKoEvalException("KoKoAtom: eval not implemented");	   
   }
   
   fun toString: String(){
	   return value.toString();
   }
}