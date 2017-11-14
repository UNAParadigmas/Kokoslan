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
import kokoslan.exception.*

class KoKoCall ( val head: KoKoAst, val args: KoKoList = KoKoList() ) : KoKoAst {		
	override fun genCode(out: PrintStream){
		this.head.genCode(out)
		out.print("(")
		this.args.genCode(out)
		out.print(")")
	}

	override fun eval ( ctx: KoKoContext ) : KoKoValue{
		throw KoKoEvalException("KoKoCall: eval not implemented")
	}
}