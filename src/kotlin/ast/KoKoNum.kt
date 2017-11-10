package kokoslan.ast;

class KoKoNum : KoKoAtom<Double>{
   constructor(val value: Double) : super(value);
   
    override fun eval: KoKoValue(ctx: KoKoContext){
	   return  KoKoNumValue(value);	   
   }   
}