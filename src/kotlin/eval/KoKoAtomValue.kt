/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.eval
import java.io.*

open class KoKoAtomValue<T>(val value: T) : KoKoValue {
   override fun toString(): String{
      return this.value.toString()
   }
}