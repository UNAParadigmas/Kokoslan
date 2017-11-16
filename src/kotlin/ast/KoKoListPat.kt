package kokoslan.ast

import kokoslan.kotlin.ast.*
import java.io.PrintStream

class KoKoListPat(var pattern: MutableList<KoKoAst>) : KoKoAst {

    override fun genCode(out : PrintStream){
        if( this.pattern.size == 0 ) return

        this.pattern[0].genCode(out)
        (1 until this.pattern.size).forEach{
            out.print(", ")
            this.pattern[it].genCode(out)
        }
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

	fun eval(ctx : KoKoContext, valor: KoKoListValue, last: Boolean):KoKoContext {
		val ids = pattern.filter { it is KoKoId }
        if(last && pattern.size==1){
            ctx.assoc(ids[0] as KoKoId, valor)
            return ctx
        }
        if(ids.size>1)
		    (1..ids.size).forEach{ctx.assoc(ids[it] as KoKoId, valor[it])}
        else
            ctx.assoc(ids[0] as KoKoId, valor[0])
		val rest = pattern.filter { it is KoKoListPat }[0] as KoKoListPat
		val next = valor.subList(ids.size, valor.size)
        if(next.size==0)
            return ctx
		return rest.eval(ctx, KoKoListValue(next), true)
	}
}