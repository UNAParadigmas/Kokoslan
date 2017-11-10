package kokoslan.ast;
import java.util.*;
import java.io.*;
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/
class KoKoCall @JvmOverloads ( val head: KoKoAst, val args: KoKoList = KoKoList() ) : KoKoAst {		
	override fun genCode(out: PrintStream){
		this.head.genCode(out);
		out.print("(");
		this.args.genCode(out);
		out.print(")");
	}

	override fun eval ( ctx: KoKoContext ) : KoKoValue{
		throw KoKoEvalException("KoKoCall: eval not implemented");
	}
}