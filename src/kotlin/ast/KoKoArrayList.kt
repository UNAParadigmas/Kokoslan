/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast

import java.util.*
import java.io.*
import kokoslan.kotlin.eval.*

class KoKoArrayList:ArrayList<KoKoAst>, KoKoAst {
	var pipe: Boolean = false
  constructor(list:List<KoKoAst>, pipe: Boolean) : super(list) {this.pipe= pipe}
  constructor() : super() {}
	
	override fun genCode(out : PrintStream){
		if( this.size == 0 ) return

		out.print("[ ")
        this[0].genCode(out)
        (1 until this.size).forEach{
            if(this.size-1 == it && this.pipe)
                out.print("| ")
            else
                out.print(", ")
            this[it].genCode(out)
        }
        out.print("]")
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue {
		val res = KoKoListValue()
		this.forEach{
			res.add(it.eval(ctx))
		}

		if(res[1] is KoKoListValue){
			val list = mutableListOf(res[0])
			(res[1] as KoKoListValue).forEach{list.add(it)}
			return KoKoListValue(list)
        }
		return res
	}
	
	fun eval() = eval(KoKoContext(KoKoContext()))
}