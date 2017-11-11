/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.eval

import java.util.*
import kokoslan.ast.KoKoId
import kokoslan.exception.* 

class KoKoContext (private val parent: KoKoContext? = null) : HashMap<String, KoKoValue>(){
	
	fun find(id: KoKoId): KoKoValue {
		val hashVal: KoKoValue? = this[id.value]
		if(hashVal != null)	return hashVal
		if(parent == null) throw KoKoNotFoundId(id)
		return parent.find(id)
	}

	fun assoc(id: KoKoId, value: KoKoValue) = put(id.value, value)

	fun push() = KoKoContext(this)

	fun pop() = parent ?: throw KoKoStackUnderflow()
	
}