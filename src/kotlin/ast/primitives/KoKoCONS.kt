/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast.primitives

import kokoslan.exception.KoKoFailException
import java.io.*
import kokoslan.kotlin.ast.*

class KoKoCons(val operands: MutableList<KoKoAst>) : KoKoAst {
    override fun genCode(out : PrintStream){
        out.print("cons( ")
	    /*operands[0].forEach {
            it.forEach{
               it.genCode(out)
            }
        }
        operands
            .skip(1)
            .forEach {
                out.print(" ,")
                it.forEach{
                    it.genCode(out)
                }
            }
            */
	    out.print(" )")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        try{
            operands.forEach{ println(it.eval(ctx)) }
            var vec  = (operands[0].eval(ctx) as KoKoListValue)
            println(vec)
            operands
                .drop(1)
                .map{ it.eval(ctx) as KoKoListValue }
                .forEach{ vec.add(it) }
            println(vec)
            return vec
        } catch( e : Exception ){
            throw  KoKoEvalException("${e.message}")
        }
    }
}