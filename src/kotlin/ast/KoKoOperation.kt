/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast
import java.util.*
import java.io.*

open class KoKoOperation (val _operator: KoKoAst, val operands: MutableList<KoKoAst> = mutableListOf<KoKoAst>()) : KoKoAst {
    
    fun addOperand( x: KoKoAst ) = this.operands.add(x)

    override fun genCode(out: PrintStream){
	    this.operands.first().genCode(out)
        this.operands
            .drop(1)
            .forEach{
                this._operator.genCode(out)
				it.genCode(out)
			}
    }

    override fun eval ( ctx: KoKoContext ) : KoKoValue{
	    throw KoKoEvalException("KoKoOperation: eval not implemented")   
    }   
}