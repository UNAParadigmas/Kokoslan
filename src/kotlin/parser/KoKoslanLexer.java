// Generated from grammar/KoKoslan.g4 by ANTLR 4.7
package kokoslan.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KoKoslanLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUMBER=6, STRING=7, DOT=8, BACK_SLASH=9, 
		COMMA=10, COLON=11, QUESTION_MARK=12, LEFT_PAR=13, RIGHT_PAR=14, LEFT_CURLY=15, 
		RIGHT_CURLY=16, LEFT_BRACKET=17, RIGHT_BRACKET=18, LET=19, NOT=20, EQ=21, 
		EQS=22, NEQ=23, LEQ=24, GEQ=25, LS=26, GS=27, OR=28, AND=29, TRUE=30, 
		FALSE=31, MUL=32, DIV=33, ADD=34, SUB=35, ID=36, PRINT=37, SLC=38, MLC=39, 
		WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "NUMBER", "INTEGER", "STRING", 
		"DOT", "BACK_SLASH", "COMMA", "COLON", "QUESTION_MARK", "LEFT_PAR", "RIGHT_PAR", 
		"LEFT_CURLY", "RIGHT_CURLY", "LEFT_BRACKET", "RIGHT_BRACKET", "LET", "NOT", 
		"EQ", "EQS", "NEQ", "LEQ", "GEQ", "LS", "GS", "OR", "AND", "TRUE", "FALSE", 
		"MUL", "DIV", "ADD", "SUB", "ID", "PRINT", "SLC", "MLC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'print('", "'fail()'", "'first('", "'rest('", "'|'", null, null, 
		"'.'", "'\\'", "','", "':'", "'?'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "'let'", "'!'", "'='", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
		"'||'", "'&&'", "'true'", "'false'", "'*'", "'/'", "'+'", "'-'", null, 
		"'print'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "NUMBER", "STRING", "DOT", "BACK_SLASH", 
		"COMMA", "COLON", "QUESTION_MARK", "LEFT_PAR", "RIGHT_PAR", "LEFT_CURLY", 
		"RIGHT_CURLY", "LEFT_BRACKET", "RIGHT_BRACKET", "LET", "NOT", "EQ", "EQS", 
		"NEQ", "LEQ", "GEQ", "LS", "GS", "OR", "AND", "TRUE", "FALSE", "MUL", 
		"DIV", "ADD", "SUB", "ID", "PRINT", "SLC", "MLC", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public KoKoslanLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KoKoslan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0101\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\5\7t\n\7\3\7\3\7\3\7\5\7y\n"+
		"\7\3\b\6\b|\n\b\r\b\16\b}\3\t\3\t\7\t\u0082\n\t\f\t\16\t\u0085\13\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\7&\u00d2\n&\f&\16&\u00d5"+
		"\13&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00e1\n(\f(\16(\u00e4\13("+
		"\3(\3(\3(\3(\3(\3)\3)\3)\3)\7)\u00ef\n)\f)\16)\u00f2\13)\3)\5)\u00f5\n"+
		")\3)\3)\3)\3)\3*\6*\u00fc\n*\r*\16*\u00fd\3*\3*\4\u00e2\u00f0\2+\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\2\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!"+
		"\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37?"+
		" A!C\"E#G$I%K&M\'O(Q)S*\3\2\7\3\2\62;\3\2$$\4\2C\\c|\6\2\62;C\\aac|\5"+
		"\2\13\f\17\17\"\"\2\u0108\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\3U\3\2\2\2\5\\\3\2\2\2\7c\3\2\2\2\tj\3\2\2\2\13p\3\2\2\2\rs"+
		"\3\2\2\2\17{\3\2\2\2\21\177\3\2\2\2\23\u0088\3\2\2\2\25\u008a\3\2\2\2"+
		"\27\u008c\3\2\2\2\31\u008e\3\2\2\2\33\u0090\3\2\2\2\35\u0092\3\2\2\2\37"+
		"\u0094\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2%\u009a\3\2\2\2\'\u009c\3"+
		"\2\2\2)\u009e\3\2\2\2+\u00a2\3\2\2\2-\u00a4\3\2\2\2/\u00a6\3\2\2\2\61"+
		"\u00a9\3\2\2\2\63\u00ac\3\2\2\2\65\u00af\3\2\2\2\67\u00b2\3\2\2\29\u00b4"+
		"\3\2\2\2;\u00b6\3\2\2\2=\u00b9\3\2\2\2?\u00bc\3\2\2\2A\u00c1\3\2\2\2C"+
		"\u00c7\3\2\2\2E\u00c9\3\2\2\2G\u00cb\3\2\2\2I\u00cd\3\2\2\2K\u00cf\3\2"+
		"\2\2M\u00d6\3\2\2\2O\u00dc\3\2\2\2Q\u00ea\3\2\2\2S\u00fb\3\2\2\2UV\7r"+
		"\2\2VW\7t\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z[\7*\2\2[\4\3\2\2\2\\]\7h\2\2"+
		"]^\7c\2\2^_\7k\2\2_`\7n\2\2`a\7*\2\2ab\7+\2\2b\6\3\2\2\2cd\7h\2\2de\7"+
		"k\2\2ef\7t\2\2fg\7u\2\2gh\7v\2\2hi\7*\2\2i\b\3\2\2\2jk\7t\2\2kl\7g\2\2"+
		"lm\7u\2\2mn\7v\2\2no\7*\2\2o\n\3\2\2\2pq\7~\2\2q\f\3\2\2\2rt\7/\2\2sr"+
		"\3\2\2\2st\3\2\2\2tu\3\2\2\2ux\5\17\b\2vw\7\60\2\2wy\5\17\b\2xv\3\2\2"+
		"\2xy\3\2\2\2y\16\3\2\2\2z|\t\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\20\3\2\2\2\177\u0083\7$\2\2\u0080\u0082\n\3\2\2\u0081\u0080\3\2"+
		"\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7$\2\2\u0087\22\3\2\2\2"+
		"\u0088\u0089\7\60\2\2\u0089\24\3\2\2\2\u008a\u008b\7^\2\2\u008b\26\3\2"+
		"\2\2\u008c\u008d\7.\2\2\u008d\30\3\2\2\2\u008e\u008f\7<\2\2\u008f\32\3"+
		"\2\2\2\u0090\u0091\7A\2\2\u0091\34\3\2\2\2\u0092\u0093\7*\2\2\u0093\36"+
		"\3\2\2\2\u0094\u0095\7+\2\2\u0095 \3\2\2\2\u0096\u0097\7}\2\2\u0097\""+
		"\3\2\2\2\u0098\u0099\7\177\2\2\u0099$\3\2\2\2\u009a\u009b\7]\2\2\u009b"+
		"&\3\2\2\2\u009c\u009d\7_\2\2\u009d(\3\2\2\2\u009e\u009f\7n\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7v\2\2\u00a1*\3\2\2\2\u00a2\u00a3\7#\2\2\u00a3,\3"+
		"\2\2\2\u00a4\u00a5\7?\2\2\u00a5.\3\2\2\2\u00a6\u00a7\7?\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7?\2\2\u00ab\62"+
		"\3\2\2\2\u00ac\u00ad\7>\2\2\u00ad\u00ae\7?\2\2\u00ae\64\3\2\2\2\u00af"+
		"\u00b0\7@\2\2\u00b0\u00b1\7?\2\2\u00b1\66\3\2\2\2\u00b2\u00b3\7>\2\2\u00b3"+
		"8\3\2\2\2\u00b4\u00b5\7@\2\2\u00b5:\3\2\2\2\u00b6\u00b7\7~\2\2\u00b7\u00b8"+
		"\7~\2\2\u00b8<\3\2\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\7(\2\2\u00bb>\3"+
		"\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7w\2\2\u00bf"+
		"\u00c0\7g\2\2\u00c0@\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7c\2\2\u00c3"+
		"\u00c4\7n\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7g\2\2\u00c6B\3\2\2\2\u00c7"+
		"\u00c8\7,\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7\61\2\2\u00caF\3\2\2\2\u00cb"+
		"\u00cc\7-\2\2\u00ccH\3\2\2\2\u00cd\u00ce\7/\2\2\u00ceJ\3\2\2\2\u00cf\u00d3"+
		"\t\4\2\2\u00d0\u00d2\t\5\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4L\3\2\2\2\u00d5\u00d3\3\2\2\2"+
		"\u00d6\u00d7\7r\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da"+
		"\7p\2\2\u00da\u00db\7v\2\2\u00dbN\3\2\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00de"+
		"\7,\2\2\u00de\u00e2\3\2\2\2\u00df\u00e1\13\2\2\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\u00e4\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e5\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6\u00e7\7\61\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\b(\2\2\u00e9P\3\2\2\2\u00ea\u00eb\7\61\2\2"+
		"\u00eb\u00ec\7\61\2\2\u00ec\u00f0\3\2\2\2\u00ed\u00ef\13\2\2\2\u00ee\u00ed"+
		"\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\7\17\2\2\u00f4\u00f3\3"+
		"\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\f\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f9\b)\2\2\u00f9R\3\2\2\2\u00fa\u00fc\t\6\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b*\2\2\u0100T\3\2\2\2\f\2sx}\u0083"+
		"\u00d3\u00e2\u00f0\u00f4\u00fd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}