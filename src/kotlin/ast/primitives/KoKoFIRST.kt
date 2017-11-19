/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast.primitives

import kokoslan.kotlin.ast.*
import java.io.*

class KoKoFirst(val operands: MutableList<KoKoAst>) : KoKoAst {
    
    override fun genCode(out : PrintStream){
       /* out.print("first( ")
	     operands[0].forEach {
            it.forEach{
               it.genCode(out)
            }
        }
        out.print(" )")
        */
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        var vec = operands[0].eval(ctx)
        return (vec as KoKoListValue)[0]
    }
}