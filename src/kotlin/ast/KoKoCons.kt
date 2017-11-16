package kokoslan.kotlin.ast

import kokoslan.exception.KoKoFailException
import kokoslan.kotlin.ast.*

class KoKoCons(val operands: MutableList<KoKoAst>) : KoKoAst {
    /*override fun genCode(out : PrintStream){
        out.print("first(")
	    operands[0].genCode(out)
        operands.forEach{ e ->
            out.print(",")
            e.genCode(out)
        }
	    out.print(")")
   }
*/
    override fun eval(ctx: KoKoContext): KoKoValue {
        var vec  = (operands[0].eval(ctx) as KoKoListValue)
        var vec2 = (operands[1].eval(ctx) as KoKoListValue)
        vec2.forEach{vec.add(it)}
        return vec
    }
}