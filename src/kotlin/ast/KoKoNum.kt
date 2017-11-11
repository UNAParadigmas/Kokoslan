/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
          Manuel Masis Segura
  @since 2017
*/
package kokoslan.ast

class KoKoNum (value: Double): KoKoAtom<Double>(value) {

    override fun eval (ctx: KoKoContext) = KoKoNumValue(value)
    
}