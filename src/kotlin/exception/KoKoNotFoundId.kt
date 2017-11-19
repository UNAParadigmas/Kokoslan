/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.exception

import kokoslan.kotlin.ast.KoKoId

class KoKoNotFoundId(val id:KoKoId) : RuntimeException("*** Id '' $id.value not defined! ***"){}