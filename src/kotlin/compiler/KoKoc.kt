package kokoslan.kotlin.compile;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import kokoslan.kotlin.compile.*;
import java.io.FileInputStream;
import java.io.InputStream;
import kokoslan.parser.*;
const val VERSION = "KoKoc v0.0 CR EIF400.II-2017 KOTLIN"
const val PROMPT = ">"

fun main(args:Array<String>) {
		println("\n...............................................")
		println(">>> $VERSION  <<<")
		println("...............................................\n")
	// Get parameters
		var inputFile:String? = "C:\\Users\\Walter\\Dropbox\\Proyecto-K\\Proyecto-K\\cases\\cases_xor.kl"
		var outputFile:String? = null
		
		if (args.size > 0)
			inputFile = args[0]
		
		var inStream : InputStream = System.`in` 
		
		if (inputFile != null){
			inStream = FileInputStream(inputFile)
			System.err.println(">>> KoKoc Reading from $inputFile <<<")
		} else{
			System.err.println(">>> KoKoc Reading from console (enter CTRL-Z+ENTER to finish <<<")
		}
	// Setup Lexer/Parser
    //ANTLRInputStream input = new ANTLRInputStream(is);
		val input = CharStreams.fromStream(inStream)
		val lexer = KoKoslanLexer(input)
		val tokens = CommonTokenStream(lexer)
		val parser = KoKoslanParser(tokens)
    
	// Parse, Compile and Generate code
    // Starting point is rule (context) 'program' (See grammar KoKoslan.g4)
		val tree = parser.program()
    
	// Compile tree
		if (args.size > 1)
			outputFile = args[1]
		val compiler = KoKoCompiler(outputFile)
		compiler.compile(tree)
    
	// Write code
		System.err.println(">>> KoKoc is writing to ${outputFile} <<<")
		compiler.genCode()
    
	// Eval code
		System.err.println(">>> KoKoc starts evaluating to console <<<")
		System.out.format("$PROMPT ${compiler.eval()} \n")
		println("...............................................\n")
}