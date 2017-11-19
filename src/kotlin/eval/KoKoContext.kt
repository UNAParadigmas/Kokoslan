/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import java.util.*;

class KoKoContext(var parent: KoKoContext? = null) : HashMap<String, KoKoValue>(){
 
	fun find(id : KoKoId): KoKoValue{
		val valor = get(id.value)
		if (valor != null) return valor
		if (parent == null) throw KoKoNotFoundId(id)
		return (parent as KoKoContext).find(id)
	}
	
	fun assoc(id : KoKoId, valor : KoKoValue){
		put(id.value, valor)
	}
	
	fun push() = KoKoContext(this)
	
	fun pop() : KoKoContext?{
		if ( parent == null ) throw  KoKoStackUnderflow()
		return parent;
	}
	
}