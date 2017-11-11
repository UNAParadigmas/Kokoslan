/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast
import java.util.*
import java.io.*

class KoKoProgram (private val statements: List<KoKoAst>) : KoKoAst {
    
    override fun genCode (out: PrintStream) = this.statements.forEach{ it.genCode(out) }

    override fun eval (ctx: KoKoContext) : KoKoValue {
		this.statements.subList(0, statements.size -2).forEach{ it.eval(ctx) }
        return this.statements[this.statements.size -1].eval(ctx)
	}

	fun eval () = eval( KoKoContext() )
}