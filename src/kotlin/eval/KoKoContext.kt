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
	
	fun find(id: KoKoId): KoKoValue{
		val value: KoKoValue = get(id.value)
		value?.let{

		} return value
		if (parent == null) throw KoKoNotFoundId(id)
		return parent.find(id);
	}
	public void assoc(KoKoId id, KoKoValue val){
		put(id.getValue(), val);
	}
	public KoKoContext push(){
		return new KoKoContext(this);
	}
	public KoKoContext pop(){
		if ( parent == null ) throw new KoKoStackUnderflow();
		return parent;
	}
	
}