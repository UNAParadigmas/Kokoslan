package kokoslan.ast;

class KoKoNum (val value: Double): KoKoAtom<Double>(value) {
   constructor(val value: Double) : super(value);
   
    override fun eval (ctx: KoKoContext) : KoKoValue{
	   return  KoKoNumValue(value);	   
   }   
}