/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast
class KoKoStackUnderflow() : RuntimeException("Pop of an empty context"){}