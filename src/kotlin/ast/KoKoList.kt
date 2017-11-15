package kokoslan.kotlin.ast;

import java.util.*;
import java.io.*;

class KoKoList:ArrayList<KoKoAst>, KoKoAst {
  constructor(list:List<KoKoAst>) : super(list) {}
  constructor() : super() {}
	
	override fun genCode(out : PrintStream){
		if( this.size == 0 ) return
		
		this[0].genCode(out)
		(1 until this.size).forEach{
			out.print(", ")
			this[it].genCode(out)
		}
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue {
		val res = KoKoListValue()
		println("Entre aquí")
		this.forEach{
			res.list.add(it.eval(ctx))
		}
		return res
	}
	
	fun eval() = eval(KoKoContext(KoKoContext()))
}