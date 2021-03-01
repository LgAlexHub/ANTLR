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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INPUT_FUNC=9, 
		PARENTHESE_O=10, PARENTHESE_F=11, TYPE=12, IDENTIFIANT=13, LOOP_WORD=14, 
		NEWLINE=15, WS=16, ENTIER=17, OPERATOR=18, UNMATCH=19;
	public static final int
		RULE_start = 0, RULE_decl = 1, RULE_assignation = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_condition = 5, RULE_finInstruction = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl", "assignation", "instruction", "expression", "condition", 
			"finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'*'", "'/'", "'+'", "'-'", "'true'", "'false'", "';'", 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "INPUT_FUNC", "PARENTHESE_O", 
			"PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", "NEWLINE", "WS", 
			"ENTIER", "OPERATOR", "UNMATCH"
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


	     private int _cur_label = 1;
	    /** générateur de nom d'étiquettes pour les boucles */
	    private String getNewLabel() { 
	        return "B" +(_cur_label++); 
	    }
	    //...

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

	    private String input_func(String func, String arg){
	        AdresseType at = tablesSymboles.getAdresseType(arg);
	        String res = ""; 
	        if (func == "READ"){
	            if (at == null)  throw new IllegalArgumentException("Adresse inconnu ou variable non déclarée");
	            else res+=func+" \n STOREG "+tablesSymboles.getAdresseType(arg).adresse+" \n";
	        }else{
	            if (at == null)  throw new IllegalArgumentException("Adresse inconnu ou variable non déclarée");
	            else res+="PUSHG "+tablesSymboles.getAdresseType(arg).adresse+" \n"+func+" \nPOP \n";
	        }
	        return res;
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(14);
				((StartContext)_localctx).decl = decl();
				 _localctx.code += ((StartContext)_localctx).decl.code; 
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(22);
					match(NEWLINE);
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << INPUT_FUNC) | (1L << PARENTHESE_O) | (1L << IDENTIFIANT) | (1L << LOOP_WORD) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(28);
				((StartContext)_localctx).instruction = instruction();
				 _localctx.code += ((StartContext)_localctx).instruction.code;
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(TYPE);
				setState(40);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(41);
				match(T__0);
				setState(42);
				((DeclContext)_localctx).instruction = instruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        ((DeclContext)_localctx).code = ((DeclContext)_localctx).instruction.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(TYPE);
				setState(46);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(47);
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
			setState(52);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(53);
			match(T__0);
			setState(54);
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case INPUT_FUNC:
			case PARENTHESE_O:
			case LOOP_WORD:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((InstructionContext)_localctx).expression = expression(0);
				setState(58);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				((InstructionContext)_localctx).assignation = assignation();
				setState(62);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case T__7:
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
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
		public Token INPUT_FUNC;
		public Token IDENTIFIANT;
		public Token ENTIER;
		public Token op;
		public ExpressionContext b;
		public TerminalNode INPUT_FUNC() { return getToken(calculParser.INPUT_FUNC, 0); }
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOOP_WORD() { return getToken(calculParser.LOOP_WORD, 0); }
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT_FUNC:
				{
				setState(71);
				((ExpressionContext)_localctx).INPUT_FUNC = match(INPUT_FUNC);
				setState(72);
				match(PARENTHESE_O);
				setState(73);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(74);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  input_func((((ExpressionContext)_localctx).INPUT_FUNC!=null?((ExpressionContext)_localctx).INPUT_FUNC.getText():null), (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				    
				}
				break;
			case PARENTHESE_O:
				{
				setState(76);
				match(PARENTHESE_O);
				setState(77);
				((ExpressionContext)_localctx).a = expression(0);
				setState(78);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case LOOP_WORD:
				{
				setState(81);
				match(LOOP_WORD);

				        
				    
				}
				break;
			case T__4:
				{
				setState(83);
				match(T__4);
				setState(84);
				match(PARENTHESE_O);
				setState(85);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(86);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  "PUSHI -"+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case ENTIER:
				{
				setState(88);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI "+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(93);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						((ExpressionContext)_localctx).b = expression(6);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code  + ((ExpressionContext)_localctx).b.code +  evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(98);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						((ExpressionContext)_localctx).b = expression(5);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code  + ((ExpressionContext)_localctx).b.code +  evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					}
					} 
				}
				setState(106);
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(T__5);
				_localctx.code="PUSHI 0\n"
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__6);
				_localctx.code="PUSHI 0\n"
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
		enterRule(_localctx, 12, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(113);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==NEWLINE) ) {
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
				setState(116); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\2\7\2\"\n\2\f"+
		"\2\16\2%\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\7\3\7\3\7\3\7\5\7r\n\7\3\b\6\bu\n\b\r"+
		"\b\16\bv\3\b\2\3\n\t\2\4\6\b\n\f\16\2\5\3\2\4\5\3\2\6\7\4\2\n\n\21\21"+
		"\2\177\2\25\3\2\2\2\4\64\3\2\2\2\6\66\3\2\2\2\bF\3\2\2\2\n\\\3\2\2\2\f"+
		"q\3\2\2\2\16t\3\2\2\2\20\21\5\4\3\2\21\22\b\2\1\2\22\24\3\2\2\2\23\20"+
		"\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\33\3\2\2\2\27\25"+
		"\3\2\2\2\30\32\7\21\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34"+
		"\3\2\2\2\34#\3\2\2\2\35\33\3\2\2\2\36\37\5\b\5\2\37 \b\2\1\2 \"\3\2\2"+
		"\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7"+
		"\2\2\3\'(\b\2\1\2(\3\3\2\2\2)*\7\16\2\2*+\7\17\2\2+,\7\3\2\2,-\5\b\5\2"+
		"-.\b\3\1\2.\65\3\2\2\2/\60\7\16\2\2\60\61\7\17\2\2\61\62\5\16\b\2\62\63"+
		"\b\3\1\2\63\65\3\2\2\2\64)\3\2\2\2\64/\3\2\2\2\65\5\3\2\2\2\66\67\7\17"+
		"\2\2\678\7\3\2\289\5\n\6\29:\b\4\1\2:\7\3\2\2\2;<\5\n\6\2<=\5\16\b\2="+
		">\b\5\1\2>G\3\2\2\2?@\5\6\4\2@A\5\16\b\2AB\b\5\1\2BG\3\2\2\2CD\5\16\b"+
		"\2DE\b\5\1\2EG\3\2\2\2F;\3\2\2\2F?\3\2\2\2FC\3\2\2\2G\t\3\2\2\2HI\b\6"+
		"\1\2IJ\7\13\2\2JK\7\f\2\2KL\7\17\2\2LM\7\r\2\2M]\b\6\1\2NO\7\f\2\2OP\5"+
		"\n\6\2PQ\7\r\2\2QR\b\6\1\2R]\3\2\2\2ST\7\20\2\2T]\b\6\1\2UV\7\7\2\2VW"+
		"\7\f\2\2WX\7\17\2\2XY\7\r\2\2Y]\b\6\1\2Z[\7\23\2\2[]\b\6\1\2\\H\3\2\2"+
		"\2\\N\3\2\2\2\\S\3\2\2\2\\U\3\2\2\2\\Z\3\2\2\2]j\3\2\2\2^_\f\7\2\2_`\t"+
		"\2\2\2`a\5\n\6\bab\b\6\1\2bi\3\2\2\2cd\f\6\2\2de\t\3\2\2ef\5\n\6\7fg\b"+
		"\6\1\2gi\3\2\2\2h^\3\2\2\2hc\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\13"+
		"\3\2\2\2lj\3\2\2\2mn\7\b\2\2nr\b\7\1\2op\7\t\2\2pr\b\7\1\2qm\3\2\2\2q"+
		"o\3\2\2\2r\r\3\2\2\2su\t\4\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2"+
		"w\17\3\2\2\2\f\25\33#\64F\\hjqv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}