package kokoslan.exception

import kokoslan.ast.KoKoId

class KoKoNotFoundId (val id: KoKoId) : RuntimeException("*** Id ${id.value} is not defined! ***")