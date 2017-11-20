package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException
import java.io.*

class KoKoFirst(val operands: MutableList<KoKoAst>) : KoKoAst {
    override fun genCode(out : PrintStream){
        out.print("first(")
	    operands[0].genCode(out)
         out.println(")")
   }

    override fun eval(ctx: KoKoContext): KoKoValue {
        if(operands.size > 1) throw KoKoEvalException("First can only receive one argument")
        val vec = operands[0].eval(ctx) as KoKoListValue
        val vec2 = KoKoListValue()
        vec2.add(vec[0])
        return vec2
    }
}