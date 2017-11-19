/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

import java.util.*;
import java.io.*;

class KoKoCall(var head:KoKoAst, var args:KoKoList = KoKoList(Arrays.asList())) : KoKoAst{
	
	override fun genCode(out: PrintStream){
		this.head.genCode(out)
		out.print("(")
		this.args.genCode(out)
		out.print(")")
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue {
        val lambda_ast = ctx.find(KoKoId(head.toString())) as KoKoLambdaValue
        val lambda = lambda_ast.value as KoKoLambda
        if (args.size == 1){
        	val t = ((args[0] as KoKoList)[0].eval(ctx) as KoKoNumValue).value
        	return lambda.eval(KoKoList(mutableListOf(KoKoNum(t))))
    	}
		return lambda.eval(args)
	}
}