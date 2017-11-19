package kokoslan.ast

import kokoslan.kotlin.ast.*
import java.io.PrintStream
import java.util.ArrayList

class KoKoListRest : ArrayList<KoKoAst>, KoKoAst {
  constructor(list:List<KoKoAst>) : super(list) {}
  constructor() : super() {}

	override fun genCode(out : PrintStream){
		if( this.size == 0 ) return

		this[0].genCode(out)
	}

	override fun eval(ctx : KoKoContext) : KoKoValue {
		val res = KoKoListValue()
		this.forEach{
			res.list.add(it.eval(ctx))
		}
		return res
	}

	fun eval() = eval(KoKoContext(KoKoContext()))
}