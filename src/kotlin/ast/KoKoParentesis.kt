/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/

package kokoslan.kotlin.ast

import java.util.*
import java.io.*
import kokoslan.kotlin.ast.*

class KoKoParentesis(var expr: KoKoAst) : KoKoAst {

	override fun genCode(out:PrintStream){
		out.print("(")	
        expr.genCode(out)
        out.print(")")	
    }

	override fun eval(ctx : KoKoContext) = expr.eval(ctx)
}
