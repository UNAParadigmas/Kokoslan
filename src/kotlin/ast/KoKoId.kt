package kokoslan.kotlin.ast;

class KoKoId( value : String) : KoKoAtom<String>( value ){
	override fun eval(ctx : KoKoContext) = ctx.find(this)
}