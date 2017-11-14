/**
 @author loriacarlos@gmail.com
 
*/
package kokoslan.kotlin.ast;

class KoKoNotFoundId(val id:KoKoId) : RuntimeException("*** Id '' $id.value not defined! ***"){}