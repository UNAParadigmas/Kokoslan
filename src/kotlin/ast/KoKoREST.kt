package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*
import java.io.*
import kokoslan.kotlin.exception.KoKoEvalException

class KoKoRest(val operands: MutableList<KoKoAst>) : KoKoAst {
    override fun genCode(out : PrintStream){
        out.print("rest(")
	    operands[0].genCode(out)
        out.print(")")
   }

    override fun eval(ctx: KoKoContext): KoKoValue {
        if(operands.size > 1) throw KoKoEvalException("First can only receive one argument")
        val vec = (operands[0].eval(ctx) as KoKoListValue)
        if(vec.size == 0)  return vec
        return KoKoListValue(vec.subList(1,vec.size))
    }
}