package kokoslan.kotlin.ast

import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoFailException
import java.io.PrintStream

class KoKoElvis(val operator : KoKoAst, val operands: MutableList<KoKoAst> = mutableListOf()) : KoKoAst {

    override fun genCode(out : PrintStream){
        operator.genCode(out)
        out.print("? ")
        operands[0].genCode(out)
        out.print(": ")
        operands[1].genCode(out)
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            val oper = operator.eval(ctx) as KoKoBoolValue
            return if (oper.value) operands[0].eval(ctx) else operands[1].eval(ctx)
        }
        catch(e: KoKoFailException) {
            throw e
        }
        catch (e: Exception){
            throw Exception("Error en KoKoElvis")
        }
    }

}