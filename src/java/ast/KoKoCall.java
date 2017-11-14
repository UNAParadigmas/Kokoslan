package kokoslan.ast;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class KoKoCall implements KoKoAst{
	protected KoKoList args;
	protected KoKoAst head;
	
	public KoKoCall(KoKoAst head, KoKoList args){
		this.args = args;
		this.head = head;
	}
	public KoKoCall(KoKoAst head){
		this(head, new KoKoList());
	}
	
	public void genCode(PrintStream out){
		this.head.genCode(out);
		out.print("(");
		this.args.genCode(out);
		out.print(")");
	}
	public KoKoValue eval(KoKoContext ctx){
		KoKoValue res = null;
		// for(int i = 0; i < args.size() -1 ; i++){
			// res = args.get(i).eval(ctx);
		// }
		res = args.get(args.size() -1).eval(ctx);
		return res;
	}
}