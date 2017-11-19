/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

class KoKoBool( value : Boolean ) : KoKoAtom<Boolean>( value ) {
    override fun eval(ctx : KoKoContext) = KoKoBoolValue(value)
}