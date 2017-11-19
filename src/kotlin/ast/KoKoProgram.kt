package kokoslan.kotlin.ast

import java.util.*
import java.io.*

class KoKoProgram(val statements: MutableList<KoKoAst>) : KoKoAst{
   
	override fun genCode(out:PrintStream){
		( 0 until statements.size ).forEach{
			this.statements[it].genCode(out)
		}
	}
   
    override fun eval(ctx : KoKoContext ) : KoKoValue {
		var res : KoKoValue? = null
		this.statements.forEach{
			res = it.eval(ctx)
		}
		return res ?: this.statements[this.statements.size - 1].eval(ctx)
	}
	
	fun eval() = eval(KoKoContext(KoKoContext()))
	
}