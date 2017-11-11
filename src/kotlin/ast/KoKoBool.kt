package kokoslan.ast;

import  kokoslan.eval.KoKoBoolValue
import  kokoslan.eval.KoKoContext
import  kokoslan.eval.KoKoValue

class KoKoBool (value: Boolean): KoKoAtom<Boolean> (value){
    override fun eval(ctx:KoKoContext):KoKoValue {
        return KoKoBoolValue(value)
    }
}