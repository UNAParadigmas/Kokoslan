package kokoslan.ast;
import java.util.*;
import java.io.*;

class KoKoListValue : ArrayList<KoKoValue>, KoKoValue {
  	constructor(list:List<KoKoValue>) : super(list) 
  	constructor() : super() 
}