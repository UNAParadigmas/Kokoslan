// Generated from grammar/KoKoslan.g4 by ANTLR 4.7
package kokoslan.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KoKoslanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMBER=8, STRING=9, 
		DOT=10, BACK_SLASH=11, COMMA=12, COLON=13, QUESTION_MARK=14, LEFT_PAR=15, 
		RIGHT_PAR=16, LEFT_CURLY=17, RIGHT_CURLY=18, LEFT_BRACKET=19, RIGHT_BRACKET=20, 
		LET=21, NOT=22, EQ=23, EQS=24, NEQ=25, LEQ=26, GEQ=27, LS=28, GS=29, OR=30, 
		AND=31, TRUE=32, FALSE=33, MUL=34, DIV=35, ADD=36, SUB=37, ID=38, PRINT=39, 
		SLC=40, MLC=41, WS=42;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_expression = 2, RULE_part_expr = 3, 
		RULE_lambda_expr = 4, RULE_evaluable_expr = 5, RULE_add_expr = 6, RULE_add_oper = 7, 
		RULE_bool_expr = 8, RULE_bool_Not_expr = 9, RULE_bool_oper = 10, RULE_mult_expr = 11, 
		RULE_mult_oper = 12, RULE_test_expr = 13, RULE_value_expr = 14, RULE_primitive = 15, 
		RULE_cons = 16, RULE_rest = 17, RULE_first = 18, RULE_call_args = 19, 
		RULE_atomic_value = 20, RULE_list_value = 21, RULE_list_expr = 22, RULE_case_value = 23, 
		RULE_case_expr = 24, RULE_pattern = 25, RULE_atomic_pat = 26, RULE_list_pat = 27, 
		RULE_list_body_pat = 28, RULE_rest_body_pat = 29, RULE_id = 30, RULE_number = 31, 
		RULE_bool = 32;
	public static final String[] ruleNames = {
		"program", "definition", "expression", "part_expr", "lambda_expr", "evaluable_expr", 
		"add_expr", "add_oper", "bool_expr", "bool_Not_expr", "bool_oper", "mult_expr", 
		"mult_oper", "test_expr", "value_expr", "primitive", "cons", "rest", "first", 
		"call_args", "atomic_value", "list_value", "list_expr", "case_value", 
		"case_expr", "pattern", "atomic_pat", "list_pat", "list_body_pat", "rest_body_pat", 
		"id", "number", "bool"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'print('", "'fail()'", "'cons('", "')('", "'rest('", "'first('", 
		"'|'", null, null, "'.'", "'\\'", "','", "':'", "'?'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'let'", "'!'", "'='", "'=='", "'!='", "'<='", "'>='", 
		"'<'", "'>'", "'||'", "'&&'", "'true'", "'false'", "'*'", "'/'", "'+'", 
		"'-'", null, "'print'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMBER", "STRING", "DOT", 
		"BACK_SLASH", "COMMA", "COLON", "QUESTION_MARK", "LEFT_PAR", "RIGHT_PAR", 
		"LEFT_CURLY", "RIGHT_CURLY", "LEFT_BRACKET", "RIGHT_BRACKET", "LET", "NOT", 
		"EQ", "EQS", "NEQ", "LEQ", "GEQ", "LS", "GS", "OR", "AND", "TRUE", "FALSE", 
		"MUL", "DIV", "ADD", "SUB", "ID", "PRINT", "SLC", "MLC", "WS"
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

	@Override
	public String getGrammarFileName() { return "KoKoslan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KoKoslanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET) {
				{
				{
				setState(66);
				definition();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LET);
			setState(75);
			id();
			setState(76);
			match(EQ);
			setState(77);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<Part_exprContext> part_expr() {
			return getRuleContexts(Part_exprContext.class);
		}
		public Part_exprContext part_expr(int i) {
			return getRuleContext(Part_exprContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			part_expr();
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					match(COMMA);
					setState(81);
					part_expr();
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Part_exprContext extends ParserRuleContext {
		public Lambda_exprContext lambda_expr() {
			return getRuleContext(Lambda_exprContext.class,0);
		}
		public Evaluable_exprContext evaluable_expr() {
			return getRuleContext(Evaluable_exprContext.class,0);
		}
		public Part_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitPart_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Part_exprContext part_expr() throws RecognitionException {
		Part_exprContext _localctx = new Part_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_part_expr);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BACK_SLASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				lambda_expr();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__4:
			case T__5:
			case NUMBER:
			case LEFT_PAR:
			case LEFT_CURLY:
			case LEFT_BRACKET:
			case NOT:
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				evaluable_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_exprContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Lambda_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitLambda_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_exprContext lambda_expr() throws RecognitionException {
		Lambda_exprContext _localctx = new Lambda_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lambda_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(BACK_SLASH);
			setState(92);
			pattern();
			setState(93);
			match(DOT);
			setState(94);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Evaluable_exprContext extends ParserRuleContext {
		public Add_exprContext add_expr() {
			return getRuleContext(Add_exprContext.class,0);
		}
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public Test_exprContext test_expr() {
			return getRuleContext(Test_exprContext.class,0);
		}
		public Evaluable_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluable_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitEvaluable_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Evaluable_exprContext evaluable_expr() throws RecognitionException {
		Evaluable_exprContext _localctx = new Evaluable_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_evaluable_expr);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				add_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(97);
				bool_expr();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION_MARK) {
					{
					setState(98);
					test_expr();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_exprContext extends ParserRuleContext {
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public List<Add_operContext> add_oper() {
			return getRuleContexts(Add_operContext.class);
		}
		public Add_operContext add_oper(int i) {
			return getRuleContext(Add_operContext.class,i);
		}
		public Add_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitAdd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_exprContext add_expr() throws RecognitionException {
		Add_exprContext _localctx = new Add_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_add_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			mult_expr();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(104);
				add_oper();
				setState(105);
				mult_expr();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_operContext extends ParserRuleContext {
		public Token oper;
		public Add_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitAdd_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_operContext add_oper() throws RecognitionException {
		Add_operContext _localctx = new Add_operContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_add_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			((Add_operContext)_localctx).oper = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
				((Add_operContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_exprContext extends ParserRuleContext {
		public List<Bool_Not_exprContext> bool_Not_expr() {
			return getRuleContexts(Bool_Not_exprContext.class);
		}
		public Bool_Not_exprContext bool_Not_expr(int i) {
			return getRuleContext(Bool_Not_exprContext.class,i);
		}
		public List<Bool_operContext> bool_oper() {
			return getRuleContexts(Bool_operContext.class);
		}
		public Bool_operContext bool_oper(int i) {
			return getRuleContext(Bool_operContext.class,i);
		}
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			bool_Not_expr();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQS) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LS) | (1L << GS) | (1L << OR) | (1L << AND))) != 0)) {
				{
				{
				setState(115);
				bool_oper();
				setState(116);
				bool_Not_expr();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_Not_exprContext extends ParserRuleContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public List<TerminalNode> NOT() { return getTokens(KoKoslanParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(KoKoslanParser.NOT, i);
		}
		public Bool_Not_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_Not_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitBool_Not_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_Not_exprContext bool_Not_expr() throws RecognitionException {
		Bool_Not_exprContext _localctx = new Bool_Not_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bool_Not_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(NOT);
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(129);
			value_expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_operContext extends ParserRuleContext {
		public Token oper;
		public TerminalNode OR() { return getToken(KoKoslanParser.OR, 0); }
		public TerminalNode AND() { return getToken(KoKoslanParser.AND, 0); }
		public TerminalNode EQS() { return getToken(KoKoslanParser.EQS, 0); }
		public TerminalNode NEQ() { return getToken(KoKoslanParser.NEQ, 0); }
		public TerminalNode LEQ() { return getToken(KoKoslanParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(KoKoslanParser.GEQ, 0); }
		public TerminalNode LS() { return getToken(KoKoslanParser.LS, 0); }
		public TerminalNode GS() { return getToken(KoKoslanParser.GS, 0); }
		public Bool_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitBool_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_operContext bool_oper() throws RecognitionException {
		Bool_operContext _localctx = new Bool_operContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bool_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			((Bool_operContext)_localctx).oper = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQS) | (1L << NEQ) | (1L << LEQ) | (1L << GEQ) | (1L << LS) | (1L << GS) | (1L << OR) | (1L << AND))) != 0)) ) {
				((Bool_operContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_exprContext extends ParserRuleContext {
		public List<Value_exprContext> value_expr() {
			return getRuleContexts(Value_exprContext.class);
		}
		public Value_exprContext value_expr(int i) {
			return getRuleContext(Value_exprContext.class,i);
		}
		public List<Mult_operContext> mult_oper() {
			return getRuleContexts(Mult_operContext.class);
		}
		public Mult_operContext mult_oper(int i) {
			return getRuleContext(Mult_operContext.class,i);
		}
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitMult_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mult_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			value_expr(0);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(134);
				mult_oper();
				setState(135);
				value_expr(0);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_operContext extends ParserRuleContext {
		public Token oper;
		public Mult_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitMult_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_operContext mult_oper() throws RecognitionException {
		Mult_operContext _localctx = new Mult_operContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mult_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((Mult_operContext)_localctx).oper = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
				((Mult_operContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Test_exprContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Test_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitTest_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_exprContext test_expr() throws RecognitionException {
		Test_exprContext _localctx = new Test_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_test_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(QUESTION_MARK);
			setState(145);
			expression();
			setState(146);
			match(COLON);
			setState(147);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_exprContext extends ParserRuleContext {
		public Value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expr; }
	 
		public Value_exprContext() { }
		public void copyFrom(Value_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParentValueExprContext extends Value_exprContext {
		public TerminalNode LEFT_PAR() { return getToken(KoKoslanParser.LEFT_PAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAR() { return getToken(KoKoslanParser.RIGHT_PAR, 0); }
		public ParentValueExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitParentValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallValueExprContext extends Value_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public CallValueExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCallValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintValueContext extends Value_exprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintValueContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitPrintValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListValueExprContext extends Value_exprContext {
		public List_valueContext list_value() {
			return getRuleContext(List_valueContext.class,0);
		}
		public ListValueExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitListValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FailValueContext extends Value_exprContext {
		public FailValueContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitFailValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveExprContext extends Value_exprContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public PrimitiveExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitPrimitiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseValueExprContext extends Value_exprContext {
		public Case_valueContext case_value() {
			return getRuleContext(Case_valueContext.class,0);
		}
		public CaseValueExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCaseValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicValueExprContext extends Value_exprContext {
		public Atomic_valueContext atomic_value() {
			return getRuleContext(Atomic_valueContext.class,0);
		}
		public AtomicValueExprContext(Value_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitAtomicValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_exprContext value_expr() throws RecognitionException {
		return value_expr(0);
	}

	private Value_exprContext value_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Value_exprContext _localctx = new Value_exprContext(_ctx, _parentState);
		Value_exprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_value_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAR:
				{
				_localctx = new ParentValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(150);
				match(LEFT_PAR);
				setState(151);
				expression();
				setState(152);
				match(RIGHT_PAR);
				}
				break;
			case T__0:
				{
				_localctx = new PrintValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__0);
				setState(155);
				expression();
				setState(156);
				match(RIGHT_PAR);
				}
				break;
			case NUMBER:
			case NOT:
			case TRUE:
			case FALSE:
			case ID:
				{
				_localctx = new AtomicValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				atomic_value();
				}
				break;
			case LEFT_BRACKET:
				{
				_localctx = new ListValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				list_value();
				}
				break;
			case LEFT_CURLY:
				{
				_localctx = new CaseValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				case_value();
				}
				break;
			case T__1:
				{
				_localctx = new FailValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(T__1);
				}
				break;
			case T__2:
			case T__4:
			case T__5:
				{
				_localctx = new PrimitiveExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CallValueExprContext(new Value_exprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_value_expr);
					setState(165);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(166);
					call_args();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimitiveContext extends ParserRuleContext {
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public FirstContext first() {
			return getRuleContext(FirstContext.class,0);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primitive);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				cons();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				rest();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				first();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cons; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cons);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__2);
			setState(178);
			expression();
			setState(179);
			match(T__3);
			setState(180);
			expression();
			setState(181);
			match(RIGHT_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__4);
			setState(184);
			expression();
			setState(185);
			match(RIGHT_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FirstContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FirstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitFirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstContext first() throws RecognitionException {
		FirstContext _localctx = new FirstContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_first);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__5);
			setState(188);
			expression();
			setState(189);
			match(RIGHT_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_argsContext extends ParserRuleContext {
		public List<List_exprContext> list_expr() {
			return getRuleContexts(List_exprContext.class);
		}
		public List_exprContext list_expr(int i) {
			return getRuleContext(List_exprContext.class,i);
		}
		public Call_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCall_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_argsContext call_args() throws RecognitionException {
		Call_argsContext _localctx = new Call_argsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_call_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LEFT_PAR);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << NUMBER) | (1L << BACK_SLASH) | (1L << LEFT_PAR) | (1L << LEFT_CURLY) | (1L << LEFT_BRACKET) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID))) != 0)) {
				{
				setState(192);
				list_expr();
				}
			}

			setState(195);
			match(RIGHT_PAR);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					match(LEFT_PAR);
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << NUMBER) | (1L << BACK_SLASH) | (1L << LEFT_PAR) | (1L << LEFT_CURLY) | (1L << LEFT_BRACKET) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID))) != 0)) {
						{
						setState(197);
						list_expr();
						}
					}

					setState(200);
					match(RIGHT_PAR);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Atomic_valueContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public Atomic_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitAtomic_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atomic_valueContext atomic_value() throws RecognitionException {
		Atomic_valueContext _localctx = new Atomic_valueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atomic_value);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				id();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				number();
				}
				break;
			case NOT:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_valueContext extends ParserRuleContext {
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public List_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitList_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_valueContext list_value() throws RecognitionException {
		List_valueContext _localctx = new List_valueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(LEFT_BRACKET);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << NUMBER) | (1L << BACK_SLASH) | (1L << LEFT_PAR) | (1L << LEFT_CURLY) | (1L << LEFT_BRACKET) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID))) != 0)) {
				{
				setState(212);
				list_expr();
				}
			}

			setState(215);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_exprContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitList_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_exprContext list_expr() throws RecognitionException {
		List_exprContext _localctx = new List_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_list_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			expression();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(218);
				match(COMMA);
				setState(219);
				expression();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_valueContext extends ParserRuleContext {
		public Case_exprContext case_expr() {
			return getRuleContext(Case_exprContext.class,0);
		}
		public Case_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCase_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_valueContext case_value() throws RecognitionException {
		Case_valueContext _localctx = new Case_valueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_case_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LEFT_CURLY);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BACK_SLASH) {
				{
				setState(226);
				case_expr();
				}
			}

			setState(229);
			match(RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_exprContext extends ParserRuleContext {
		public List<Lambda_exprContext> lambda_expr() {
			return getRuleContexts(Lambda_exprContext.class);
		}
		public Lambda_exprContext lambda_expr(int i) {
			return getRuleContext(Lambda_exprContext.class,i);
		}
		public Case_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitCase_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_exprContext case_expr() throws RecognitionException {
		Case_exprContext _localctx = new Case_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_case_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			lambda_expr();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(232);
				match(COMMA);
				setState(233);
				lambda_expr();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public Atomic_patContext atomic_pat() {
			return getRuleContext(Atomic_patContext.class,0);
		}
		public List_patContext list_pat() {
			return getRuleContext(List_patContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pattern);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case NOT:
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				atomic_pat();
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				list_pat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Atomic_patContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public Atomic_patContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_pat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitAtomic_pat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atomic_patContext atomic_pat() throws RecognitionException {
		Atomic_patContext _localctx = new Atomic_patContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_atomic_pat);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				id();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				number();
				}
				break;
			case NOT:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_patContext extends ParserRuleContext {
		public List_body_patContext list_body_pat() {
			return getRuleContext(List_body_patContext.class,0);
		}
		public List_patContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_pat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitList_pat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_patContext list_pat() throws RecognitionException {
		List_patContext _localctx = new List_patContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_list_pat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(LEFT_BRACKET);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << LEFT_BRACKET) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID))) != 0)) {
				{
				setState(249);
				list_body_pat();
				}
			}

			setState(252);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_body_patContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public Rest_body_patContext rest_body_pat() {
			return getRuleContext(Rest_body_patContext.class,0);
		}
		public List_body_patContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_body_pat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitList_body_pat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_body_patContext list_body_pat() throws RecognitionException {
		List_body_patContext _localctx = new List_body_patContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_list_body_pat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			pattern();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(255);
				match(COMMA);
				setState(256);
				pattern();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(262);
				rest_body_pat();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rest_body_patContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List_patContext list_pat() {
			return getRuleContext(List_patContext.class,0);
		}
		public Rest_body_patContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest_body_pat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitRest_body_pat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rest_body_patContext rest_body_pat() throws RecognitionException {
		Rest_body_patContext _localctx = new Rest_body_patContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_rest_body_pat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__6);
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(266);
				id();
				}
				break;
			case LEFT_BRACKET:
				{
				setState(267);
				list_pat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KoKoslanParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(KoKoslanParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(KoKoslanParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(KoKoslanParser.FALSE, 0); }
		public List<TerminalNode> NOT() { return getTokens(KoKoslanParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(KoKoslanParser.NOT, i);
		}
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KoKoslanVisitor ) return ((KoKoslanVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOT) {
				{
				{
				setState(274);
				match(NOT);
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return value_expr_sempred((Value_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_expr_sempred(Value_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u011d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\5\3\5\5\5\\\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\5\7f\n\7\5\7h\n\7\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\13\7\13\177\n\13"+
		"\f\13\16\13\u0082\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u008c\n"+
		"\r\f\r\16\r\u008f\13\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a6"+
		"\n\20\3\20\3\20\7\20\u00aa\n\20\f\20\16\20\u00ad\13\20\3\21\3\21\3\21"+
		"\5\21\u00b2\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\5\25\u00c4\n\25\3\25\3\25\3\25\5\25\u00c9\n"+
		"\25\3\25\7\25\u00cc\n\25\f\25\16\25\u00cf\13\25\3\26\3\26\3\26\5\26\u00d4"+
		"\n\26\3\27\3\27\5\27\u00d8\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u00df\n"+
		"\30\f\30\16\30\u00e2\13\30\3\31\3\31\5\31\u00e6\n\31\3\31\3\31\3\32\3"+
		"\32\3\32\7\32\u00ed\n\32\f\32\16\32\u00f0\13\32\3\33\3\33\5\33\u00f4\n"+
		"\33\3\34\3\34\3\34\5\34\u00f9\n\34\3\35\3\35\5\35\u00fd\n\35\3\35\3\35"+
		"\3\36\3\36\3\36\7\36\u0104\n\36\f\36\16\36\u0107\13\36\3\36\5\36\u010a"+
		"\n\36\3\37\3\37\3\37\5\37\u010f\n\37\3 \3 \3!\3!\3\"\7\"\u0116\n\"\f\""+
		"\16\"\u0119\13\"\3\"\3\"\3\"\2\3\36#\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@B\2\6\3\2&\'\3\2\32!\3\2$%\3\2\"#\2\u011e"+
		"\2G\3\2\2\2\4L\3\2\2\2\6Q\3\2\2\2\b[\3\2\2\2\n]\3\2\2\2\fg\3\2\2\2\16"+
		"i\3\2\2\2\20r\3\2\2\2\22t\3\2\2\2\24\u0080\3\2\2\2\26\u0085\3\2\2\2\30"+
		"\u0087\3\2\2\2\32\u0090\3\2\2\2\34\u0092\3\2\2\2\36\u00a5\3\2\2\2 \u00b1"+
		"\3\2\2\2\"\u00b3\3\2\2\2$\u00b9\3\2\2\2&\u00bd\3\2\2\2(\u00c1\3\2\2\2"+
		"*\u00d3\3\2\2\2,\u00d5\3\2\2\2.\u00db\3\2\2\2\60\u00e3\3\2\2\2\62\u00e9"+
		"\3\2\2\2\64\u00f3\3\2\2\2\66\u00f8\3\2\2\28\u00fa\3\2\2\2:\u0100\3\2\2"+
		"\2<\u010b\3\2\2\2>\u0110\3\2\2\2@\u0112\3\2\2\2B\u0117\3\2\2\2DF\5\4\3"+
		"\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\5\6\4"+
		"\2K\3\3\2\2\2LM\7\27\2\2MN\5> \2NO\7\31\2\2OP\5\6\4\2P\5\3\2\2\2QV\5\b"+
		"\5\2RS\7\16\2\2SU\5\b\5\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\7\3"+
		"\2\2\2XV\3\2\2\2Y\\\5\n\6\2Z\\\5\f\7\2[Y\3\2\2\2[Z\3\2\2\2\\\t\3\2\2\2"+
		"]^\7\r\2\2^_\5\64\33\2_`\7\f\2\2`a\5\6\4\2a\13\3\2\2\2bh\5\16\b\2ce\5"+
		"\22\n\2df\5\34\17\2ed\3\2\2\2ef\3\2\2\2fh\3\2\2\2gb\3\2\2\2gc\3\2\2\2"+
		"h\r\3\2\2\2io\5\30\r\2jk\5\20\t\2kl\5\30\r\2ln\3\2\2\2mj\3\2\2\2nq\3\2"+
		"\2\2om\3\2\2\2op\3\2\2\2p\17\3\2\2\2qo\3\2\2\2rs\t\2\2\2s\21\3\2\2\2t"+
		"z\5\24\13\2uv\5\26\f\2vw\5\24\13\2wy\3\2\2\2xu\3\2\2\2y|\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{\23\3\2\2\2|z\3\2\2\2}\177\7\30\2\2~}\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0084\5\36\20\2\u0084\25\3\2\2\2\u0085\u0086\t\3"+
		"\2\2\u0086\27\3\2\2\2\u0087\u008d\5\36\20\2\u0088\u0089\5\32\16\2\u0089"+
		"\u008a\5\36\20\2\u008a\u008c\3\2\2\2\u008b\u0088\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\31\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\t\4\2\2\u0091\33\3\2\2\2\u0092\u0093\7\20\2"+
		"\2\u0093\u0094\5\6\4\2\u0094\u0095\7\17\2\2\u0095\u0096\5\6\4\2\u0096"+
		"\35\3\2\2\2\u0097\u0098\b\20\1\2\u0098\u0099\7\21\2\2\u0099\u009a\5\6"+
		"\4\2\u009a\u009b\7\22\2\2\u009b\u00a6\3\2\2\2\u009c\u009d\7\3\2\2\u009d"+
		"\u009e\5\6\4\2\u009e\u009f\7\22\2\2\u009f\u00a6\3\2\2\2\u00a0\u00a6\5"+
		"*\26\2\u00a1\u00a6\5,\27\2\u00a2\u00a6\5\60\31\2\u00a3\u00a6\7\4\2\2\u00a4"+
		"\u00a6\5 \21\2\u00a5\u0097\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5\u00a0\3\2"+
		"\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00ab\3\2\2\2\u00a7\u00a8\f\b\2\2\u00a8\u00aa\5("+
		"\25\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b2\5\"\22"+
		"\2\u00af\u00b2\5$\23\2\u00b0\u00b2\5&\24\2\u00b1\u00ae\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2!\3\2\2\2\u00b3\u00b4\7\5\2\2\u00b4"+
		"\u00b5\5\6\4\2\u00b5\u00b6\7\6\2\2\u00b6\u00b7\5\6\4\2\u00b7\u00b8\7\22"+
		"\2\2\u00b8#\3\2\2\2\u00b9\u00ba\7\7\2\2\u00ba\u00bb\5\6\4\2\u00bb\u00bc"+
		"\7\22\2\2\u00bc%\3\2\2\2\u00bd\u00be\7\b\2\2\u00be\u00bf\5\6\4\2\u00bf"+
		"\u00c0\7\22\2\2\u00c0\'\3\2\2\2\u00c1\u00c3\7\21\2\2\u00c2\u00c4\5.\30"+
		"\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00cd"+
		"\7\22\2\2\u00c6\u00c8\7\21\2\2\u00c7\u00c9\5.\30\2\u00c8\u00c7\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\7\22\2\2\u00cb\u00c6"+
		"\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		")\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d4\5> \2\u00d1\u00d4\5@!\2\u00d2"+
		"\u00d4\5B\"\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2"+
		"\2\2\u00d4+\3\2\2\2\u00d5\u00d7\7\25\2\2\u00d6\u00d8\5.\30\2\u00d7\u00d6"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7\26\2\2"+
		"\u00da-\3\2\2\2\u00db\u00e0\5\6\4\2\u00dc\u00dd\7\16\2\2\u00dd\u00df\5"+
		"\6\4\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1/\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e5\7\23\2\2"+
		"\u00e4\u00e6\5\62\32\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e8\7\24\2\2\u00e8\61\3\2\2\2\u00e9\u00ee\5\n\6\2\u00ea"+
		"\u00eb\7\16\2\2\u00eb\u00ed\5\n\6\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3"+
		"\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\63\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f4\5\66\34\2\u00f2\u00f4\58\35\2\u00f3\u00f1\3"+
		"\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\65\3\2\2\2\u00f5\u00f9\5> \2\u00f6\u00f9"+
		"\5@!\2\u00f7\u00f9\5B\"\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f7\3\2\2\2\u00f9\67\3\2\2\2\u00fa\u00fc\7\25\2\2\u00fb\u00fd\5:\36"+
		"\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff"+
		"\7\26\2\2\u00ff9\3\2\2\2\u0100\u0105\5\64\33\2\u0101\u0102\7\16\2\2\u0102"+
		"\u0104\5\64\33\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0108"+
		"\u010a\5<\37\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a;\3\2\2\2"+
		"\u010b\u010e\7\t\2\2\u010c\u010f\5> \2\u010d\u010f\58\35\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010d\3\2\2\2\u010f=\3\2\2\2\u0110\u0111\7(\2\2\u0111?"+
		"\3\2\2\2\u0112\u0113\7\n\2\2\u0113A\3\2\2\2\u0114\u0116\7\30\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\t\5\2\2\u011b"+
		"C\3\2\2\2\35GV[egoz\u0080\u008d\u00a5\u00ab\u00b1\u00c3\u00c8\u00cd\u00d3"+
		"\u00d7\u00e0\u00e5\u00ee\u00f3\u00f8\u00fc\u0105\u0109\u010e\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}