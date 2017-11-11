/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.eval
import java.util.*
import java.io.*

class KoKoListValue : ArrayList<KoKoValue>, KoKoValue {
  	constructor(list:List<KoKoValue>) : super(list)
  	constructor() : super()
}