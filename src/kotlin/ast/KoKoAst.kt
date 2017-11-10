package kokoslan.ast;
import java.io.*;

interface KoKoAst{
   fun genCode(){
      genCode(System.out);
   }
   fun genCode( out: PrintStream ){
   }
   fun eval(KoKoContext ctx): KoKoValue;
}