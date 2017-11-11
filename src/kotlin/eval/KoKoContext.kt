/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast;

import java.util.*;

class KoKoContext @JvmOverloads (private val parent: KoKoContext? = null) : HashMap<String, KoKoValue>{
	
	fun find(id: KoKoId): KoKoValue {
		val value = this.[id.value]
		value ?: parent.find(id) ?: throw KoKoNotFoundId(id)
	}

	fun assoc(id: KoKoId, value: KoKoValue) = put(id.value, value)

	fun push() = KoKoContext(this)

	fun pop() = parent ?: throw KoKoStackUnderflow()
	
}