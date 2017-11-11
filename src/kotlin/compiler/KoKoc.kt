/**
 * Foo controller of compilation
 * Purpose is to start a compilation
 * Demo ANTLR
 @author loriacarlos@gmail.com 
 @version EIF400.II-2017
 @since 0.0
*/
/**
 * Kokoslan toy controller
 * Demo ANTLR (suing visitors)
 @author loriacarlos@gmail.com 
 @version EIF400.II-2017
 @since 0.0
*/

package kokoslan.compile

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

import java.io.FileInputStream
import java.io.InputStream

import kokoslan.parser.*

class KoKoc {
	companion object{
		val VERSION: String = "KoKoc v0.0 CR EIF400.II-2017"
		val PROMPT: String = ">"
		
		@Throws(Exception::class) 
		@JvmStatic fun main(args : Array<String>){
			println("\n...............................................")
			println(">>> " + VERSION + " <<<")
			println("...............................................\n")
			// Get parameters
			var inputFile: String? = null 
			var outputFile: String? = null 
			if (args.length > 0) 
			  inputFile = args[0]
		  
			var is = System.in
			
			if (inputFile != null){
			   is = FileInputStream(inputFile)
			   println(">>> KoKoc Reading from " + inputFile + " <<<")
			   outputFile = inputFile + "out.kl"
			} else{
			   println(">>> KoKoc Reading from console (enter CTRL-Z+ENTER to finish <<<")
			}
			 // Setup Lexer/Parser
			//ANTLRInputStream input = new ANTLRInputStream(is);
			val input = CharStreams.fromStream(is)
			val lexer = KoKoslanLexer(input)
			val tokens = CommonTokenStream(lexer)
			val parser = KoKoslanParser(tokens)
			
			// Parse, Compile and Generate code
			// Starting point is rule (context) 'program' (See grammar KoKoslan.g4)
			val tree = parser.program()
			
			// Compile tree
			if (args.length > 1) 
			  outputFile = args[1]
			val compiler = KoKoCompiler(outputFile)
			compiler.compile(tree)
			
			// Write code
			System.err.println(">>> KoKoc is writing to " + outputFile + " <<<")
			compiler.genCode()
			 // Eval code
			System.err.println(">>> KoKoc starts evaluating to console <<<")
			println( "${PROMPT} ${PROMPT}${compiler.eval()}" )
			println("...............................................\n")
			
		}
	}
}
