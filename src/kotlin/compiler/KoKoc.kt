/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/

package kokoslan.compile

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

import java.io.FileInputStream
import java.io.InputStream

import kokoslan.parser.*

const val VERSION = "KoKoC v0.0 CR EIF400.II-2017.kotlin"
const val PROMPT = ">";
fun main(args : Array<String>){
    println("\n...............................................")
	println(">>> $VERSION <<<");
	println("...............................................\n")
	
	var inputFile : String? = null
	var outputFile : String? = null
	
	if (args.size > 0) 
		  inputFile = args[0]
	  
	var  inStream : InputStream = System.`in`
	
	if (inputFile != null){
	   inStream = FileInputStream(inputFile);
	   System.err.println("KoKoC Reading from $inputFile");
	} else {
	   System.err.println("KoKoC Reading from console (enter CTRL-Z+ENTER to finish");
	}
	 // Setup Lexer/Parser
	val input = CharStreams.fromStream(inStream);
	val lexer = KoKoslanLexer(input);
	val tokens = CommonTokenStream(lexer);
	val parser = KoKoslanParser(tokens);
	
	// Parse, Compile and Generate code
	// Starting point is rule (context) a (See grammar KoKo.g4)
	val tree = parser.program(); 
	
	// Compile
	if (args.size > 1) 
	  outputFile = args[1];
	val compiler = KoKoCompiler(outputFile);
	compiler.compile(tree);
	// Write code
	System.err.println("KoKoC Writing to $outputFile");
	compiler.genCode();
    // Eval code
	System.err.println(">>> KoKoc starts evaluating to console <<<");
	println( "${PROMPT} ${PROMPT}${compiler.eval()}");
	println("...............................................\n");
		
}