package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoProgram : KoKoAst (val statements: List<KoKoAst>){
    override fun genCode(out: PrintStream){
       this.statements.forEach{ it.genCode(out)}
   }

    override fun eval: KoKoValue(ctx: KoKoContext){
		this.statements.subList(0, statements.size -1).forEach{ it.eval(ctx) }
        return this.statements.last().eval(ctx)
	}

	override fun KoKoValue eval(){
		return  eval( KoKoContext() );
	}
}