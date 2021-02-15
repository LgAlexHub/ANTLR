// Generated from c:\Users\alexl\Documents\Licence3\th�orie_comppil\TP59\Src\calculette.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NEWLINE=4, WS=5, ENTIER=6, OPERATOR=7, UNMATCH=8;
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_expr_o = 2, RULE_expr_f = 3, RULE_calcul = 4, 
		RULE_instruction = 5, RULE_expression = 6, RULE_finInstruction = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expr", "expr_o", "expr_f", "calcul", "instruction", "expression", 
			"finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NEWLINE", "WS", "ENTIER", "OPERATOR", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int evalexpr (int x, String op, int y) {
	        if ( op.equals("*") ){
	            return x*y;
	        } else if ( op.equals("+") ){
	            return x+y;
	        } else if ( op.equals("-") ){
	                    return x-y;
	        } else if ( op.equals("/") ){
	                            return x/y;
	        } else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }


	public calculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExprContext total;
		public TerminalNode EOF() { return getToken(calculetteParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((StartContext)_localctx).total = expr();
			setState(17);
			match(EOF);
			System.out.println(((StartContext)_localctx).total.result);
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

	public static class ExprContext extends ParserRuleContext {
		public int result;
		public Expr_oContext expr_o;
		public Token op;
		public Expr_fContext res2;
		public Expr_fContext expr_f;
		public Token ent;
		public Expr_oContext expr_o() {
			return getRuleContext(Expr_oContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(calculetteParser.OPERATOR, 0); }
		public Expr_fContext expr_f() {
			return getRuleContext(Expr_fContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(calculetteParser.ENTIER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				((ExprContext)_localctx).expr_o = expr_o();
				setState(21);
				((ExprContext)_localctx).op = match(OPERATOR);
				setState(22);
				((ExprContext)_localctx).res2 = ((ExprContext)_localctx).expr_f = expr_f();
				((ExprContext)_localctx).result =  evalexpr(((ExprContext)_localctx).expr_o.result,((ExprContext)_localctx).op.getText(),((ExprContext)_localctx).expr_f.result);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				((ExprContext)_localctx).ent = match(ENTIER);
				((ExprContext)_localctx).result =  Integer.parseInt((((ExprContext)_localctx).ent!=null?((ExprContext)_localctx).ent.getText():null));
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

	public static class Expr_oContext extends ParserRuleContext {
		public int result;
		public ExprContext expr;
		public Token ent;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(calculetteParser.ENTIER, 0); }
		public Expr_oContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_o; }
	}

	public final Expr_oContext expr_o() throws RecognitionException {
		Expr_oContext _localctx = new Expr_oContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr_o);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(T__0);
				setState(30);
				((Expr_oContext)_localctx).expr = expr();
				((Expr_oContext)_localctx).result =  ((Expr_oContext)_localctx).expr.result;
				}
				break;
			case ENTIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((Expr_oContext)_localctx).ent = match(ENTIER);
				((Expr_oContext)_localctx).result =  Integer.parseInt((((Expr_oContext)_localctx).ent!=null?((Expr_oContext)_localctx).ent.getText():null));
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

	public static class Expr_fContext extends ParserRuleContext {
		public int result;
		public ExprContext expr;
		public Token ent;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(calculetteParser.ENTIER, 0); }
		public Expr_fContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_f; }
	}

	public final Expr_fContext expr_f() throws RecognitionException {
		Expr_fContext _localctx = new Expr_fContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr_f);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((Expr_fContext)_localctx).expr = expr();
				setState(38);
				match(T__1);
				((Expr_fContext)_localctx).result = ((Expr_fContext)_localctx).expr.result;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				((Expr_fContext)_localctx).ent = match(ENTIER);
				((Expr_fContext)_localctx).result =  Integer.parseInt((((Expr_fContext)_localctx).ent!=null?((Expr_fContext)_localctx).ent.getText():null));
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<TerminalNode> NEWLINE() { return getTokens(calculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(calculetteParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					match(NEWLINE);
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==NEWLINE) {
				{
				{
				setState(51);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruction);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				expression();
				setState(62);
				finInstruction();
				 
				            // à compléter
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(calculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(calculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(72);
					_la = _input.LA(1);
					if ( !(_la==T__2 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(75); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\nP\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4&\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5.\n\5\3\6\7\6\61\n\6\f\6\16\6\64\13\6\3\6\3"+
		"\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"G\n\7\3\b\3\b\3\t\6\tL\n\t\r\t\16\tM\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3"+
		"\2\5\6\2N\2\22\3\2\2\2\4\35\3\2\2\2\6%\3\2\2\2\b-\3\2\2\2\n\62\3\2\2\2"+
		"\fF\3\2\2\2\16H\3\2\2\2\20K\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\25"+
		"\b\2\1\2\25\3\3\2\2\2\26\27\5\6\4\2\27\30\7\t\2\2\30\31\5\b\5\2\31\32"+
		"\b\3\1\2\32\36\3\2\2\2\33\34\7\b\2\2\34\36\b\3\1\2\35\26\3\2\2\2\35\33"+
		"\3\2\2\2\36\5\3\2\2\2\37 \7\3\2\2 !\5\4\3\2!\"\b\4\1\2\"&\3\2\2\2#$\7"+
		"\b\2\2$&\b\4\1\2%\37\3\2\2\2%#\3\2\2\2&\7\3\2\2\2\'(\5\4\3\2()\7\4\2\2"+
		")*\b\5\1\2*.\3\2\2\2+,\7\b\2\2,.\b\5\1\2-\'\3\2\2\2-+\3\2\2\2.\t\3\2\2"+
		"\2/\61\7\6\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		":\3\2\2\2\64\62\3\2\2\2\65\66\5\f\7\2\66\67\b\6\1\2\679\3\2\2\28\65\3"+
		"\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\b\6\1\2>\13"+
		"\3\2\2\2?@\5\16\b\2@A\5\20\t\2AB\b\7\1\2BG\3\2\2\2CD\5\20\t\2DE\b\7\1"+
		"\2EG\3\2\2\2F?\3\2\2\2FC\3\2\2\2G\r\3\2\2\2HI\3\2\2\2I\17\3\2\2\2JL\t"+
		"\2\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\21\3\2\2\2\t\35%-\62:"+
		"FM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}