/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

class KoKoId( value : String) : KoKoAtom<String>( value ){
	override fun eval(ctx : KoKoContext) = ctx.find(this)
}