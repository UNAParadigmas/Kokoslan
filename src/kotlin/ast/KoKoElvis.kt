package kokoslan.ast

import kokoslan.exception.KoKoFailException
import kokoslan.kotlin.ast.*

class KoKoElvis(val operator : KoKoAst, val operands: MutableList<KoKoAst> = mutableListOf()) : KoKoAst {
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