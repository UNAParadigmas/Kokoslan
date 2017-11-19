/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast

import java.io.*
import kokoslan.kotlin.eval.*


class KoKoNOT(var expr: KoKoAst) : KoKoAst {

	override fun genCode(out:PrintStream){
		out.print("!")	
        expr.genCode(out)
    }

	override fun eval(ctx : KoKoContext): KoKoBoolValue =  KoKoBoolValue(!(expr.eval(ctx) as KoKoBoolValue).value)
}
