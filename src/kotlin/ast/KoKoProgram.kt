package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoProgram (private val statements: List<KoKoAst>) : KoKoAst {
    
    override fun genCode (out: PrintStream) = this.statements.forEach{ it.genCode(out) }

    override fun eval (ctx: KoKoContext) : KoKoValue {
		this.statements.subList(0, statements.size -2).forEach{ it.eval(ctx) }
        return this.statements[this.statements.size -1].eval(ctx)
	}

	override fun eval () = eval( KoKoContext() )
}