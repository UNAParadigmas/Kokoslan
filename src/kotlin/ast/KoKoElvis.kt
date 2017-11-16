package kokoslan.ast

import kokoslan.kotlin.ast.*

class KoKoElvis(val operator : KoKoAst, val operands: MutableList<KoKoAst> = mutableListOf()) : KoKoAst {
    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            val oper = operator.eval(ctx) as KoKoBoolValue
            val operan = operands.map { it.eval(ctx) }
            return if (oper.value) operan[1] else operan[0]
        }
        catch (e: Exception){
            throw Exception("ocurrió un error en KoKoElvis")
        }
    }

}