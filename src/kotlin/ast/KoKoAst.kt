/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast;
import java.io.*;

interface KoKoAst{
   fun genCode(){
      genCode(System.out)
   }
   fun genCode( out: PrintStream ){
   }
   fun eval(ctx: KoKoContext): KoKoValue
}