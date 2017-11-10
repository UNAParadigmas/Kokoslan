/**
 @author loriacarlos@gmail.com
 
*/
package kokoslan.ast;


public class KoKoId : KoKoAtom<String> ( value: String ): super(value){
	
   override 
   fun eval(KoKoContext ctx): KoKoValue{
	   return ctx.find(this);
   }
   
}