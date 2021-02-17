// Generated from c:\Users\alexl\Documents\Licence3\th�orie_comppil\TP59\Src\calcul.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PARENTHESE_O=8, 
		PARENTHESE_F=9, TYPE=10, IDENTIFIANT=11, NEWLINE=12, WS=13, ENTIER=14, 
		OPERATOR=15, UNMATCH=16;
	public static final int
		RULE_start = 0, RULE_decl = 1, RULE_assignation = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_finInstruction = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl", "assignation", "instruction", "expression", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'read'", "'*'", "'/'", "'+'", "'-'", "';'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PARENTHESE_O", "PARENTHESE_F", 
			"TYPE", "IDENTIFIANT", "NEWLINE", "WS", "ENTIER", "OPERATOR", "UNMATCH"
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
	public String getGrammarFileName() { return "calcul.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private TablesSymboles tablesSymboles = new TablesSymboles();
	    private String evalexpr (String op) {
	        if ( op.equals("*") ){
	            return "MUL\n";
	        } else if ( op.equals("+") ){
	            return "ADD\n";
	        } else if ( op.equals("-") ){
	                    return "SUB\n";
	        } else if ( op.equals("/") ){
	                            return "DIV\n";
	        } else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }


	public calculParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public TerminalNode EOF() { return getToken(calculParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(calculParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(calculParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		 
		        ((StartContext)_localctx).code =  new String();
		    
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(12);
				((StartContext)_localctx).decl = decl();
				 _localctx.code += ((StartContext)_localctx).decl.code; 
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					match(NEWLINE);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__6) | (1L << PARENTHESE_O) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(26);
				((StartContext)_localctx).instruction = instruction();
				 _localctx.code += ((StartContext)_localctx).instruction.code;
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(EOF);
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public InstructionContext instruction;
		public TerminalNode TYPE() { return getToken(calculParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(TYPE);
				setState(38);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(39);
				match(T__0);
				setState(40);
				((DeclContext)_localctx).instruction = instruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        ((DeclContext)_localctx).code = ((DeclContext)_localctx).instruction.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(TYPE);
				setState(44);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(45);
				finInstruction();

				            tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				            ((DeclContext)_localctx).code =  "PUSHI 0 \n";
				        
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(51);
			match(T__0);
			setState(52);
			((AssignationContext)_localctx).expression = expression(0);
			  
			            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREG "+at.adresse+"\n";
			        
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public AssignationContext assignation;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__5:
			case PARENTHESE_O:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((InstructionContext)_localctx).expression = expression(0);
				setState(56);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				((InstructionContext)_localctx).assignation = assignation();
				setState(60);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case T__6:
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public Token IDENTIFIANT;
		public InstructionContext instruction;
		public Token ENTIER;
		public Token op;
		public ExpressionContext b;
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public TerminalNode NEWLINE() { return getToken(calculParser.NEWLINE, 0); }
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(calculParser.ENTIER, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(69);
				match(T__1);
				setState(70);
				match(PARENTHESE_O);
				setState(71);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(72);
				match(PARENTHESE_F);
				setState(73);
				match(NEWLINE);
				setState(74);
				((ExpressionContext)_localctx).instruction = instruction();

				        tablesSymboles.putVar((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null),"int");
				        AdresseType at = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExpressionContext)_localctx).code = "PUSHI 0 \n READ \n"+((ExpressionContext)_localctx).instruction.code+"STOREG "+at.adresse+"\n";
				    
				}
				break;
			case PARENTHESE_O:
				{
				setState(77);
				match(PARENTHESE_O);
				setState(78);
				((ExpressionContext)_localctx).a = expression(0);
				setState(79);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case T__5:
				{
				setState(82);
				match(T__5);
				setState(83);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI -"+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case ENTIER:
				{
				setState(85);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI "+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(99);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(90);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((ExpressionContext)_localctx).b = expression(5);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code  + ((ExpressionContext)_localctx).b.code +  evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(95);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						((ExpressionContext)_localctx).b = expression(4);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code  + ((ExpressionContext)_localctx).b.code +  evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(calculParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(calculParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(104);
					_la = _input.LA(1);
					if ( !(_la==T__6 || _la==NEWLINE) ) {
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
				setState(107); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22p\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5E"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6Z\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6f\n\6\f"+
		"\6\16\6i\13\6\3\7\6\7l\n\7\r\7\16\7m\3\7\2\3\n\b\2\4\6\b\n\f\2\5\3\2\5"+
		"\6\3\2\7\b\4\2\t\t\16\16\2u\2\23\3\2\2\2\4\62\3\2\2\2\6\64\3\2\2\2\bD"+
		"\3\2\2\2\nY\3\2\2\2\fk\3\2\2\2\16\17\5\4\3\2\17\20\b\2\1\2\20\22\3\2\2"+
		"\2\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\31\3\2\2"+
		"\2\25\23\3\2\2\2\26\30\7\16\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2"+
		"\2\2\31\32\3\2\2\2\32!\3\2\2\2\33\31\3\2\2\2\34\35\5\b\5\2\35\36\b\2\1"+
		"\2\36 \3\2\2\2\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2"+
		"\2#!\3\2\2\2$%\7\2\2\3%&\b\2\1\2&\3\3\2\2\2\'(\7\f\2\2()\7\r\2\2)*\7\3"+
		"\2\2*+\5\b\5\2+,\b\3\1\2,\63\3\2\2\2-.\7\f\2\2./\7\r\2\2/\60\5\f\7\2\60"+
		"\61\b\3\1\2\61\63\3\2\2\2\62\'\3\2\2\2\62-\3\2\2\2\63\5\3\2\2\2\64\65"+
		"\7\r\2\2\65\66\7\3\2\2\66\67\5\n\6\2\678\b\4\1\28\7\3\2\2\29:\5\n\6\2"+
		":;\5\f\7\2;<\b\5\1\2<E\3\2\2\2=>\5\6\4\2>?\5\f\7\2?@\b\5\1\2@E\3\2\2\2"+
		"AB\5\f\7\2BC\b\5\1\2CE\3\2\2\2D9\3\2\2\2D=\3\2\2\2DA\3\2\2\2E\t\3\2\2"+
		"\2FG\b\6\1\2GH\7\4\2\2HI\7\n\2\2IJ\7\r\2\2JK\7\13\2\2KL\7\16\2\2LM\5\b"+
		"\5\2MN\b\6\1\2NZ\3\2\2\2OP\7\n\2\2PQ\5\n\6\2QR\7\13\2\2RS\b\6\1\2SZ\3"+
		"\2\2\2TU\7\b\2\2UV\7\20\2\2VZ\b\6\1\2WX\7\20\2\2XZ\b\6\1\2YF\3\2\2\2Y"+
		"O\3\2\2\2YT\3\2\2\2YW\3\2\2\2Zg\3\2\2\2[\\\f\6\2\2\\]\t\2\2\2]^\5\n\6"+
		"\7^_\b\6\1\2_f\3\2\2\2`a\f\5\2\2ab\t\3\2\2bc\5\n\6\6cd\b\6\1\2df\3\2\2"+
		"\2e[\3\2\2\2e`\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\13\3\2\2\2ig\3\2"+
		"\2\2jl\t\4\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\r\3\2\2\2\13\23"+
		"\31!\62DYegm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}