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

class KoKoList(val list : List<KoKoAst> = ArrayList<KoKoAst>()) : ArrayList<KoKoAst>(list), KoKoAst {
	
	override fun genCode (out: PrintStream){
		if(this.size == 0) return;
		this[0].genCode(out)
		this.stream().skip(1)
			.forEach{
					out.print(", ")
					it.genCode(out)			
			};
	}
	
	override fun eval(ctx: KoKoContext) : KoKoValue {
		var res = KoKoListValue()
		this.stream().forEach{ res.add(it.eval(ctx)) }
		return res
	}
	
	fun eval () = this.eval(KoKoContext())
	
}