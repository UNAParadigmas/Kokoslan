package kokoslan.kotlin.ast;
import java.io.*;

interface KoKoAst{
	fun genCode(){
      genCode(System.out)
	}
	
	fun genCode(out : PrintStream){}
   
	fun eval(ctx : KoKoContext = KoKoContext()) : KoKoValue
}