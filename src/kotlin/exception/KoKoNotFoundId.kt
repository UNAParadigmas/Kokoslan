package kokoslan.ast

class KoKoNotFoundId (val id: KoKoId) : RuntimeException("*** Id ${id.value} is not defined! ***")