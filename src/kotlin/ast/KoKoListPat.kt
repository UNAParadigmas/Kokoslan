package kokoslan.kotlin.ast

import java.io.PrintStream
import kokoslan.kotlin.eval.*
import kokoslan.kotlin.exception.KoKoEvalException

class KoKoListPat(var pattern: MutableList<KoKoAst>, var pipe: Boolean) : KoKoAst {

    override fun genCode(out : PrintStream){
        if( this.pattern.size == 0 ) return

       // out.print("[")
        this.pattern[0].genCode(out)
        (1 until this.pattern.size).forEach{
            println("$it ${this.pattern.size}")
            if(pattern.size == it && pipe)
                out.print("| ")
            else
                out.print(", ")
            this.pattern[it].genCode(out)
        }
       // out.print("]")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        return this.pattern[0].eval(ctx)
    }

	fun eval(ctx : KoKoContext, valor: KoKoListValue, last: Boolean):KoKoContext {
		val ids = pattern.filter { it is KoKoId }
        if(last && pattern.size==1){
            if(pipe == true)
                ctx.assoc(ids[0] as KoKoId, valor)
            else
                ctx.assoc(ids[0] as KoKoId, valor[0])
            return ctx
        }
        if(ids.size>1) {
            if(ids.size > valor.size)
                throw KoKoEvalException("Pattern missMatch: the given List does not match with parameters, pattern > list given")
            (0 until ids.size).forEach { ctx.assoc(ids[it] as KoKoId, valor[it]) }
        }
        else {
            if(valor.size == 0)
                throw KoKoEvalException("Pattern missMatch: the given List does not match with parameters, a list is not given")
            ctx.assoc(ids[0] as KoKoId, valor[0])
        }
		var rest = pattern.filter { it is KoKoListPat }
        val arr = pattern.filter{it is KoKoArrayList}
        if(arr.isNotEmpty()) {
            rest = listOf(KoKoListPat(arr[0] as KoKoArrayList, true))
        }
        if (rest.isNotEmpty()) {
            var next = valor.subList(ids.size, valor.size)
            if (next.size == 0 && pipe)
                    return (rest[0] as KoKoListPat).eval(ctx, KoKoListValue(mutableListOf()), true)
            if(next.size==1 && next[0] is KoKoListValue)
                next = next[0] as MutableList<KoKoValue>
            return (rest[0] as KoKoListPat).eval(ctx, KoKoListValue(next), true)
        }
        return ctx
	}
}