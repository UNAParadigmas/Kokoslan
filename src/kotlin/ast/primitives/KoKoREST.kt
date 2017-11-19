/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast.primitives

import java.io.*
import kokoslan.kotlin.ast.*

class KoKoRest(val operands: MutableList<KoKoAst>) : KoKoAst {
    override fun genCode(out : PrintStream){
        out.print("rest( ")
	    /*operands
            .skip(1)
            .forEach {
                out.print(", ")
                it.forEach{
                    it.genCode(out)
                }
            }*/
	    out.print(" )")
   }

    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            return  (operands[0].eval(ctx) as KoKoListValue).removeAt(0)
        }catch (e : Exception){
            throw  KoKoEvalException("${e.message}")
        }
    }
}