package  kokoslan.ast

import  kokoslan.ast.KoKoAtom
import  kokoslan.eval.KoKoContext
import  kokoslan.eval.KoKoValue

open class KoKoId (value: String ): KoKoAtom<String>(value){
   fun eval(ctx: KoKoContext) = ctx.find(this)
}