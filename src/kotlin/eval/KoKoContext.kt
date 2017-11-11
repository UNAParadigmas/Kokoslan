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
		try{
			val value = this.[id.value]
			value?.let{ return value }
		}catch(e: Excepcion) {
			if (parent == null) throw KoKoNotFoundId(id)
			return parent.find(id);
		}
	}
	public void assoc(KoKoId id, KoKoValue val){
		put(id.getValue(), val);
	}
	public KoKoContext push(){
		return KoKoContext(this);
	}
	public KoKoContext pop(){
		if ( parent == null ) throw KoKoStackUnderflow();
		return parent;
	}
	
}