/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast
import java.io.*
import kokoslan.kotlin.eval.*

interface KoKoAst{
	fun genCode(){
      genCode(System.out)
	}
	
	fun genCode(out : PrintStream){}
   
	fun eval(ctx : KoKoContext = KoKoContext()) : KoKoValue
}