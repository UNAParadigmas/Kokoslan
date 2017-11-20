package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException

class KoKoCons(val arg1: MutableList<KoKoAst>,val arg2: MutableList<KoKoAst>) : KoKoAst {
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
        var list  = arg1[0].eval(ctx) as KoKoListValue
        var list2 = arg2[0].eval(ctx) as KoKoListValue
        list2.forEach{list.add(it)}
        return list
    }
}