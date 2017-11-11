package kokoslan.ast

class KoKoNotFoundId (val id: KoKoId) : 
	RuntimeException ( String.format("*** Id '%s' is not defined! ***", id.getValue()) )
