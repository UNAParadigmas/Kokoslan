/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast;
import java.io.*;

class KoKoAtomValue<T>(val value: T): KoKoValue{
   fun toString(): String{
      return this.value.toString();
   }
}