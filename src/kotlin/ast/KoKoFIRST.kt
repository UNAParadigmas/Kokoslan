package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*

class KoKoFirst(val operands: MutableList<KoKoAst>) : KoKoAst {
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
         return (vec as KoKoListValue)[0]
    }
}