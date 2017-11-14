/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.ast
import java.util.*
import java.io.*
import kokoslan.eval.*

class KoKoProgram (private val statements: List<KoKoAst>) : KoKoAst {
    
    override fun genCode (out: PrintStream) = this.statements.forEach{ it.genCode(out) }

    override fun eval (ctx: KoKoContext) : KoKoValue {
		this.statements.subList(0, statements.size -2).forEach{ it.eval(ctx) }
        return this.statements[this.statements.size -1].eval(ctx)
	  }

	  fun eval (): KoKoValue{
        return eval(KoKoContext())
    } 
}