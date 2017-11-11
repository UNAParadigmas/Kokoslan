package  kokoslan.ast

import  kokoslan.ast.KoKoAtom
import  kokoslan.eval.KoKoContext
import  kokoslan.eval.KoKoValue

class KoKoId (val value: String ): KoKoAtom<String>(value){
   override fun eval(KoKoContext ctx) = return ctx.find(this)
}