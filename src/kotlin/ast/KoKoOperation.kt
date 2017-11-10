package kokoslan.ast;
import java.util.*;
import java.io.*;


class KoKoOperation : KoKoAst (val _operator: KoKoAst, val operands: List<KoKoAst>){
   
    constructor(val _operator: KoKoAst) : this(_operator, new ArrayList<KoKoAst>	())
	
    fun addOperand( x: KoKoAst ){
	   this.operands.add(x);
   }

   override fun genCode(out: PrintStream){
	    this.operands.first().genCode(out)
        this.operands
            .skip(1)
            .forEach{
                this.operator.genCode(out);
				t.genCode(out)
			}
   }

   override fun eval: KoKoValue( ctx: KoKoContext ){
	   throw KoKoEvalException("KoKoOperation: eval not implemented");	   
   
   
}