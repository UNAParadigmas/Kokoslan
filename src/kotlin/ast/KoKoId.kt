/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package  kokoslan.ast

import  kokoslan.ast.KoKoAtom
import  kokoslan.eval.KoKoContext
import  kokoslan.eval.KoKoValue

class KoKoId (value: String ): KoKoAtom<String>(value){
   override fun eval(ctx: KoKoContext) = ctx.find(this)
}