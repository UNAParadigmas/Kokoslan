package kokoslan.ast;

class KoKoNum (val value: Double): KoKoAtom<Double>(value) {
    override fun eval (ctx: KoKoContext) : KoKoValue{
	   return  KoKoNumValue(value);	   
    }   
}