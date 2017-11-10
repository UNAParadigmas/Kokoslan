package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoCall : KoKoAst (val head: KoKoAst, val args: KoKoList){		
	
	constructor(head: KoKoAst): this(head, new KoKoList())
	
	fun genCode(out: PrintStream){
		this.head.genCode(out);
		out.print("(");
		this.args.genCode(out);
		out.print(")");
	}

	fun eval: KoKoValue(ctx: KoKoContext){
		throw KoKoEvalException("KoKoCall: eval not implemented");
	}
}