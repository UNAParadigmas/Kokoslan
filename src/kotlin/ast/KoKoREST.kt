package kokoslan.kotlin.ast

import kokoslan.exception.KoKoFailException
import kokoslan.kotlin.ast.*

class KoKoRest(val operands: MutableList<KoKoAst>) : KoKoAst {
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
        var vec = operands[0].eval(ctx)
        (vec as KoKoListValue).removeAt(0)
        return vec
    }
}