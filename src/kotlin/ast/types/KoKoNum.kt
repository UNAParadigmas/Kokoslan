/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;

class KoKoNum(value : Double) : KoKoAtom<Double>(value){
   override fun eval(ctx : KoKoContext) = KoKoNumValue(value)
   
   
}