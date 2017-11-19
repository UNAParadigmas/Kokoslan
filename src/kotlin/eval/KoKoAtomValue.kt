/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/
package kokoslan.kotlin.ast;
import java.io.*;

open class KoKoAtomValue<T>(val value:T):KoKoValue {
	override fun toString() = this.value.toString()
}