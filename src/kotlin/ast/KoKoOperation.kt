package kokoslan.ast;
import java.util.*;
import java.io.*;


open class KoKoOperation (val _operator: KoKoAst, val operands: List<KoKoAst> = ArrayList<KoKoAst>) : KoKoAst {
   
    fun addOperand( x: KoKoAst ) = this.operands.add(x)

    override fun genCode(out: PrintStream){
	    this.operands.first().genCode(out)
        this.operands
            .skip(1)
            .forEach{
                this.operator.genCode(out)
				t.genCode(out)
			}
    }

    override fun eval ( ctx: KoKoContext ) : KoKoValue{
	    throw KoKoEvalException("KoKoOperation: eval not implemented")   
    }   
}