/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast
import java.util.*
import java.io.*

class KoKoListValue(var list:MutableList<KoKoValue> = mutableListOf()):ArrayList<KoKoValue>(list), KoKoValue {
}