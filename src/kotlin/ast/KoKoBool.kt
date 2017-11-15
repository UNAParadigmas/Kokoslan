package kokoslan.kotlin.ast;

class KoKoBool( value : Boolean ) : KoKoAtom<Boolean>( value ) {
    override fun eval(ctx : KoKoContext) = KoKoBoolValue(value)
}