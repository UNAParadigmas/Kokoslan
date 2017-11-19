/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast

import kokoslan.kotlin.ast.*
import java.io.*

class KoKoLength(val operands: MutableList<KoKoAst>) : KoKoAst {
    override fun genCode(out : PrintStream){
        /*out.print("length( ")
	    operands[0].forEach {
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
        out.print(" )")*/
   }

    override fun eval(ctx: KoKoContext): KoKoValue {
        try{
            return KoKoNumValue((operands[0].eval(ctx) as KoKoListValue).size * 1.0)
        }catch(e : Exception){
            throw  KoKoEvalException("${e.message}")
        }
    }
    
}