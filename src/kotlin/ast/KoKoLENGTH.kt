package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*

class KoKoLength(val operands: MutableList<KoKoAst>) : KoKoAst {
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
    override fun eval(ctx: KoKoContext): KoKoValue = KoKoNumValue((operands[0].eval(ctx) as KoKoListValue).size * 1.0)
    
}