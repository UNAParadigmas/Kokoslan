package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoList : ArrayList<KoKoAst>, KoKoAst {
	
	constructor(list :List<KoKoAst>) : super(list)
	cunstructor() : super()
		
	override fun genCode(out: PrintStream){
		if(this.size() == 0) return;
		this.first().genCode(out);
		this.stream()
			.skip(1)
			.forEach{
					out.print(", ")
					it.genCode(out);				
			};
	}
	
	override fun eval: KoKoValue (ctx: KoKoContext){
		var res : KoKoListValue = KoKoListValue();
		this.stream().forEach{ res.add(it.eval(ctx)) }
		return res;
	}
	
	fun eval: KoKoValue (){
		return this.eval(KoKoContext());
	}
	
}