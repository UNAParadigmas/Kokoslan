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

open class KoKoId (value: String ): KoKoAtom<String>(value){
   fun eval(ctx: KoKoContext) = ctx.find(this)
}