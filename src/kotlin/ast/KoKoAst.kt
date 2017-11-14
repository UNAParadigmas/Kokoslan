/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.ast
import kokoslan.eval.*
import java.io.*

interface KoKoAst{
   fun genCode(){
      genCode(System.out)
   }
   fun genCode( out: PrintStream )
   fun eval(ctx: KoKoContext): KoKoValue
   //fun eval(): KoKoValue = eval(KoKoContext())
}