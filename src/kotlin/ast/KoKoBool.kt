/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast;

import  kokoslan.eval.KoKoBoolValue
import  kokoslan.eval.KoKoContext
import  kokoslan.eval.KoKoValue

class KoKoBool (value: Boolean): KoKoAtom<Boolean> (value){
    fun eval(ctx:KoKoContext) = KoKoBoolValue(value)
}