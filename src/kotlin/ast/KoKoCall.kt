package kokoslan.kotlin.ast;

import java.util.*;
import java.io.*;
import java.util.stream.*;

class KoKoCall(var head:KoKoAst, var args:KoKoList = KoKoList(Arrays.asList())) : KoKoAst{
	
	override fun genCode(out: PrintStream){
		this.head.genCode(out)
		out.print("(")
		this.args.genCode(out)
		out.print(")")
	}
	
	override fun eval(ctx : KoKoContext) : KoKoValue{
		args.forEach{println("ARG "+it)}
		val lambda_ast = ctx.find(KoKoId(head.toString())) as KoKoLambdaValue
		val lambda = lambda_ast.value as KoKoLambda
		val evaluacion = lambda.eval(args)
		return evaluacion
	}
}