// Generated from calcul.g4 by ANTLR 4.9
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, RETURN=31, 
		READ=32, WRITE=33, PARENTHESE_O=34, PARENTHESE_F=35, TYPE=36, IDENTIFIANT=37, 
		LOOP_WORD=38, NEWLINE=39, WS=40, ENTIER=41, FLOAT=42, OPERATOR=43, OPERATORLOG=44, 
		UNMATCH=45;
	public static final int
		RULE_start = 0, RULE_instruction = 1, RULE_expression = 2, RULE_decl = 3, 
		RULE_assignation = 4, RULE_branchements = 5, RULE_element = 6, RULE_loop = 7, 
		RULE_bloc_code = 8, RULE_condition = 9, RULE_finInstruction = 10, RULE_fonction = 11, 
		RULE_params = 12, RULE_args = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "instruction", "expression", "decl", "assignation", "branchements", 
			"element", "loop", "bloc_code", "condition", "finInstruction", "fonction", 
			"params", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return'", "'*'", "'/'", "'+'", "'-'", "'='", "'+='", "'++'", 
			"'--'", "'if'", "'IF'", "'else'", "'ELSE'", "'while'", "'WHILE'", "'for'", 
			"'FOR'", "';'", "'repeat'", "'REPEAT'", "'until'", "'UNTIL'", "'{'", 
			"'}'", "'true'", "'false'", "'!'", "'&&'", "'||'", "','", null, null, 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "RETURN", "READ", "WRITE", 
			"PARENTHESE_O", "PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", "NEWLINE", 
			"WS", "ENTIER", "FLOAT", "OPERATOR", "OPERATORLOG", "UNMATCH"
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
	    private TablesSymboles tablesSymboles = new TablesSymboles();

	    private String getNewLabel()
	    {
	        return "B" +(_cur_label++);
	    }

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

	    private String evalexprconditions (String op) {
	    if ( op.equals(">") ){
	        return "SUP\n";
	    } else if ( op.equals("<") ){
	        return "INF\n";
	    } else if ( op.equals("<=") ){
	        return "INFEQ\n";
	    } else if ( op.equals(">=") ){
	        return "SUPEQUAL\n";
	    } else if ( op.equals("==") ){
	        return "EQUAL\n";
	    }else if ( op.equals("!=") ){
	        return "NEQ\n";
	    } else {
	        System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	        throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }

	    private String read_func(String arg){
	        AdresseType at = tablesSymboles.getAdresseType(arg);
	        String res = ""; 
	        if (at == null)  throw new IllegalArgumentException("Adresse inconnu ou variable non déclarée");
	        else res+="READ \n STOREG "+tablesSymboles.getAdresseType(arg).adresse+" \n";
	        return res;
	    }

	public calculParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
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
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitStart(this);
		}
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
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					((StartContext)_localctx).decl = decl();
					 _localctx.code += ((StartContext)_localctx).decl.code; 
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 _localctx.code += "JUMP Main\n"; 
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37);
					match(NEWLINE);
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					((StartContext)_localctx).fonction = fonction();
					 _localctx.code += ((StartContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					match(NEWLINE);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL Main\n"; 
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << READ) | (1L << WRITE) | (1L << PARENTHESE_O) | (1L << TYPE) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << FLOAT))) != 0)) {
				{
				{
				setState(58);
				((StartContext)_localctx).instruction = instruction();
				 _localctx.code += ((StartContext)_localctx).instruction.code; 
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT\n"; 
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
		public ExpressionContext expression;
		public DeclContext decl;
		public AssignationContext assignation;
		public LoopContext loop;
		public BranchementsContext branchements;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public BranchementsContext branchements() {
			return getRuleContext(BranchementsContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((InstructionContext)_localctx).expression = expression(0);
				setState(69);
				finInstruction();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				((InstructionContext)_localctx).decl = decl();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).decl.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				((InstructionContext)_localctx).assignation = assignation();
				setState(79);
				finInstruction();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				((InstructionContext)_localctx).loop = loop();

				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loop.code;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				((InstructionContext)_localctx).branchements = branchements();

				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).branchements.code;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				match(T__0);
				setState(89);
				((InstructionContext)_localctx).expression = expression(0);
				setState(90);
				finInstruction();

				            AdresseType at = tablesSymboles.getAdresseType("return");
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code+"\nSTOREL "+at.adresse+"\n";
				            _localctx.code += "RETURN\n";
				        
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
		public String type;
		public ExpressionContext res1;
		public ExpressionContext expression;
		public ElementContext element;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public ExpressionContext a;
		public Token op;
		public ExpressionContext res2;
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode READ() { return getToken(calculParser.READ, 0); }
		public TerminalNode WRITE() { return getToken(calculParser.WRITE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(96);
				match(PARENTHESE_O);
				setState(97);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(98);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code = ((ExpressionContext)_localctx).expression.code;
				    
				}
				break;
			case 2:
				{
				setState(101);
				((ExpressionContext)_localctx).element = element();

				        ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).element.type;
				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).element.code;
				    
				}
				break;
			case 3:
				{
				setState(104);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(105);
				match(PARENTHESE_O);
				setState(106);
				((ExpressionContext)_localctx).args = args();
				setState(107);
				match(PARENTHESE_F);

				        String type = tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				        if(type.equals("int"))
				        {
				            ((ExpressionContext)_localctx).code =  "PUSHI 0\n";
				        }
				        if(((ExpressionContext)_localctx).args.code!=null)
				            _localctx.code+=((ExpressionContext)_localctx).args.code;
				        _localctx.code+="CALL "+(((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
				        for(int i=0;i<((ExpressionContext)_localctx).args.size;i++)
				            _localctx.code+="POP\n";
				    
				}
				break;
			case 4:
				{
				setState(110);
				match(READ);
				setState(111);
				match(PARENTHESE_O);
				setState(112);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(113);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  read_func((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				    
				}
				break;
			case 5:
				{
				setState(115);
				match(WRITE);
				setState(116);
				((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(1);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "WRITE\nPOP\n";
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.res1 = _prevctx;
						_localctx.res1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(122);
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
						setState(123);
						((ExpressionContext)_localctx).res2 = ((ExpressionContext)_localctx).expression = expression(7);

						                      ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).res1.type;
						                      ((ExpressionContext)_localctx).code = ((ExpressionContext)_localctx).res1.code;
						                      _localctx.code+=((ExpressionContext)_localctx).res2.code;
						                      _localctx.code+=evalexpr(((ExpressionContext)_localctx).op.getText());
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.res1 = _prevctx;
						_localctx.res1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(127);
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
						setState(128);
						((ExpressionContext)_localctx).res2 = ((ExpressionContext)_localctx).expression = expression(6);

						                      ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).res1.type;
						                      ((ExpressionContext)_localctx).code = ((ExpressionContext)_localctx).res1.code;
						                      _localctx.code+=((ExpressionContext)_localctx).res2.code;
						                      _localctx.code+=evalexpr(((ExpressionContext)_localctx).op.getText());
						              
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ElementContext element;
		public TerminalNode TYPE() { return getToken(calculParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(137);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(138);
				finInstruction();

				            tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            String type = ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null)).toLowerCase();
				            if(type.equals("int"))
				                ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            else if (type.equals("float"))
				                ((DeclContext)_localctx).code =  "PUSHF 0.0\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(142);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(143);
				match(T__5);
				setState(144);
				((DeclContext)_localctx).element = element();
				setState(145);
				finInstruction();

				            tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            AdresseType at = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				            String type = ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null)).toLowerCase();
				            if(type.equals("int"))
				            {
				                ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            }
				            else if (type.equals("float"))
				            {
				                ((DeclContext)_localctx).code =  "PUSHF 0.0\n";
				            }
				            if(at.adresse>=0)
				                _localctx.code += ((DeclContext)_localctx).element.code+"STOREG "+at.adresse+"\n";
				            else
				                _localctx.code += ((DeclContext)_localctx).element.code+"STOREL "+at.adresse+"\n";
				        
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignation);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(151);
				match(T__5);
				setState(152);
				((AssignationContext)_localctx).expression = expression(0);
				  
				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREG "+at.adresse+"\n";
				        }            
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(156);
				match(T__6);
				setState(157);
				((AssignationContext)_localctx).expression = expression(0);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+=((AssignationContext)_localctx).expression.code;
				            _localctx.code+="ADD \n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            if (at.type == "FLOAT" || at.type == "float"){
				                _localctx.code+=((AssignationContext)_localctx).expression.code;
				                _localctx.code+="FADD \n";
				                _localctx.code+="STOREG "+at.adresse+"\n";
				            }else{
				                _localctx.code+=((AssignationContext)_localctx).expression.code;
				                _localctx.code+="ADD \n";
				                _localctx.code+="STOREG "+at.adresse+"\n";
				            }
				        }
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(161);
				match(T__7);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="ADD\n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code =  "PUSHG "+at.adresse+"\n";
				            if (at.type == "FLOAT" || at.type == "float"){
				                _localctx.code+="PUSHF 1.0\n";
				                _localctx.code+="FADD\n";
				            }else{
				                _localctx.code+="PUSHI 1\n";
				                _localctx.code+="ADD\n";
				            }
				           _localctx.code+="STOREG "+at.adresse+"\n";
				        }
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(164);
				match(T__8);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="SUB\n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            if (at.type == "float" || at.type=="FLOAT"){
				                _localctx.code+="PUSHF 1.0\n";
				                _localctx.code+="FSUB\n";
				            }else{
				                _localctx.code+="PUSHI 1\n";
				                _localctx.code+="SUB\n";
				            }
				            _localctx.code+="STOREG "+at.adresse+"\n";
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

	public static class BranchementsContext extends ParserRuleContext {
		public String code;
		public ConditionContext a;
		public Bloc_codeContext b;
		public Bloc_codeContext c;
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<Bloc_codeContext> bloc_code() {
			return getRuleContexts(Bloc_codeContext.class);
		}
		public Bloc_codeContext bloc_code(int i) {
			return getRuleContext(Bloc_codeContext.class,i);
		}
		public BranchementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterBranchements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitBranchements(this);
		}
	}

	public final BranchementsContext branchements() throws RecognitionException {
		BranchementsContext _localctx = new BranchementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_branchements);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(169);
				match(PARENTHESE_O);
				setState(170);
				((BranchementsContext)_localctx).a = condition(0);
				setState(171);
				match(PARENTHESE_F);
				setState(172);
				((BranchementsContext)_localctx).b = bloc_code();
				setState(173);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				((BranchementsContext)_localctx).c = bloc_code();

				        ((BranchementsContext)_localctx).code =  ((BranchementsContext)_localctx).a.code;
				        _localctx.code+="JUMPF "+getNewLabel()+"\n";
				        _localctx.code+=((BranchementsContext)_localctx).b.code;
				        _localctx.code+="JUMP "+getNewLabel()+"\n";
				        _localctx.code+="LABEL B"+(_cur_label-2)+"\n";
				        _localctx.code+=((BranchementsContext)_localctx).c.code;
				        _localctx.code+="LABEL B"+(_cur_label-1)+"\n";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				match(PARENTHESE_O);
				setState(179);
				((BranchementsContext)_localctx).a = condition(0);
				setState(180);
				match(PARENTHESE_F);
				setState(181);
				((BranchementsContext)_localctx).b = bloc_code();

				        ((BranchementsContext)_localctx).code =  ((BranchementsContext)_localctx).a.code;
				        _localctx.code+="JUMPF "+getNewLabel()+"\n";
				        _localctx.code+=((BranchementsContext)_localctx).b.code;
				        _localctx.code+="LABEL "+(_cur_label-1)+"\n";
				    
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

	public static class ElementContext extends ParserRuleContext {
		public String code;
		public String type;
		public Token FLOAT;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public TerminalNode FLOAT() { return getToken(calculParser.FLOAT, 0); }
		public TerminalNode ENTIER() { return getToken(calculParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_element);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__4);
				setState(187);
				((ElementContext)_localctx).FLOAT = match(FLOAT);

				            ((ElementContext)_localctx).code =  "PUSHF -"+(((ElementContext)_localctx).FLOAT!=null?((ElementContext)_localctx).FLOAT.getText():null);
				            ((ElementContext)_localctx).type = "float";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((ElementContext)_localctx).FLOAT = match(FLOAT);

				            ((ElementContext)_localctx).code = "PUSHF "+(((ElementContext)_localctx).FLOAT!=null?((ElementContext)_localctx).FLOAT.getText():null);
				            ((ElementContext)_localctx).type = "float";
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(T__4);
				setState(192);
				((ElementContext)_localctx).ENTIER = match(ENTIER);

				            ((ElementContext)_localctx).code =  "PUSHI -"+((ElementContext)_localctx).ENTIER.getText()+"\n";
				            ((ElementContext)_localctx).type = "int";
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				((ElementContext)_localctx).ENTIER = match(ENTIER);

				            ((ElementContext)_localctx).code =  "PUSHI "+((ElementContext)_localctx).ENTIER.getText()+"\n";
				            ((ElementContext)_localctx).type = "int";
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				match(T__4);
				setState(197);
				((ElementContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            int addr = tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				            if (addr < 0){
				                ((ElementContext)_localctx).code = "PUSHL "+addr;
				                _localctx.code+="PUSHI -1\n MUL\n";
				                ((ElementContext)_localctx).type = "int";
				            }else{
				                ((ElementContext)_localctx).code = "PUSHG "+addr;
				                if (tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).type == "float" || tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).type == "FLOAT"){
				                    _localctx.code+="PUSHF -1\n MUL\n";
				                      ((ElementContext)_localctx).type = "float";
				                }else{
				                    _localctx.code+="PUSHI -1\n MUL\n";
				                    ((ElementContext)_localctx).type = "int";
				                }
				                
				            }   
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				((ElementContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            int addr = tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				            if (addr < 0){
				                ((ElementContext)_localctx).code =  "PUSHL "+addr+"\n";
				                ((ElementContext)_localctx).type = "int";
				            }else{
				                ((ElementContext)_localctx).code =  "PUSHG "+addr+"\n";
				                if (tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).type=="float"){
				                    ((ElementContext)_localctx).type = "float";
				                }else{
				                    ((ElementContext)_localctx).type = "int";
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

	public static class LoopContext extends ParserRuleContext {
		public String code;
		public ConditionContext a;
		public Bloc_codeContext bloc_code;
		public AssignationContext d;
		public ConditionContext e;
		public AssignationContext f;
		public Bloc_codeContext g;
		public ConditionContext h;
		public Bloc_codeContext bloc_code() {
			return getRuleContext(Bloc_codeContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_loop);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				((LoopContext)_localctx).a = condition(0);
				setState(205);
				((LoopContext)_localctx).bloc_code = bloc_code();

				            ((LoopContext)_localctx).code = "LABEL "+getNewLabel()+"\n";
				            _localctx.code+=((LoopContext)_localctx).a.code;
				            _localctx.code+="JUMPF B"+(_cur_label)+"\n";
				            _localctx.code+=((LoopContext)_localctx).bloc_code.code;
				            _localctx.code+=((LoopContext)_localctx).a.code;
				            _localctx.code+="JUMP B"+(_cur_label-1)+"\n";
				            _localctx.code+="LABEL "+getNewLabel()+"\n";
				    
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(209);
				match(PARENTHESE_O);
				setState(210);
				((LoopContext)_localctx).d = assignation();
				setState(211);
				match(T__17);
				setState(212);
				((LoopContext)_localctx).e = condition(0);
				setState(213);
				match(T__17);
				setState(214);
				((LoopContext)_localctx).f = assignation();
				setState(215);
				match(PARENTHESE_F);
				setState(216);
				((LoopContext)_localctx).g = bloc_code();

				        ((LoopContext)_localctx).code = ((LoopContext)_localctx).d.code;
				        _localctx.code+="LABEL "+getNewLabel()+"\n";
				        _localctx.code+=((LoopContext)_localctx).e.code;
				        _localctx.code+="JUMPF B"+(_cur_label)+"\n";
				        _localctx.code+=((LoopContext)_localctx).g.code;
				        _localctx.code+=((LoopContext)_localctx).f.code;
				        _localctx.code+="JUMP B"+(_cur_label-1)+"\n";
				        _localctx.code+="LABEL "+getNewLabel()+"\n";
				    
				}
				break;
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(220);
				((LoopContext)_localctx).g = bloc_code();
				setState(221);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(222);
				match(PARENTHESE_O);
				setState(223);
				((LoopContext)_localctx).h = condition(0);
				setState(224);
				match(PARENTHESE_F);

				        ((LoopContext)_localctx).code = "LABEL "+getNewLabel();
				        _localctx.code+=((LoopContext)_localctx).h.code;
				        _localctx.code+="JUMPF B"+(_cur_label)+"\n";
				        _localctx.code+=((LoopContext)_localctx).g.code;
				        _localctx.code+="JUMP B"+(_cur_label-1)+"\n";
				        _localctx.code+="LABEL "+getNewLabel()+"\n";
				    
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

	public static class Bloc_codeContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Bloc_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterBloc_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitBloc_code(this);
		}
	}

	public final Bloc_codeContext bloc_code() throws RecognitionException {
		Bloc_codeContext _localctx = new Bloc_codeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloc_code);
		 ((Bloc_codeContext)_localctx).code =  new String(); 
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(T__22);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << READ) | (1L << WRITE) | (1L << PARENTHESE_O) | (1L << TYPE) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << FLOAT))) != 0)) {
					{
					{
					setState(230);
					((Bloc_codeContext)_localctx).instruction = instruction();
					_localctx.code += ((Bloc_codeContext)_localctx).instruction.code; 
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238);
				match(T__23);
				}
				break;
			case T__0:
			case T__4:
			case T__9:
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case READ:
			case WRITE:
			case PARENTHESE_O:
			case TYPE:
			case IDENTIFIANT:
			case NEWLINE:
			case ENTIER:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				((Bloc_codeContext)_localctx).instruction = instruction();
				_localctx.code+=((Bloc_codeContext)_localctx).instruction.code;
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext c;
		public ConditionContext g;
		public ConditionContext k;
		public ConditionContext condition;
		public ExpressionContext a;
		public Token OPERATORLOG;
		public ExpressionContext b;
		public ConditionContext d;
		public ConditionContext e;
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OPERATORLOG() { return getToken(calculParser.OPERATORLOG, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(245);
				match(T__24);

				        ((ConditionContext)_localctx).code = "PUSHI 1\n";
					
				}
				break;
			case 2:
				{
				setState(247);
				match(T__25);

				        ((ConditionContext)_localctx).code = "PUSHI 0\n";
				    
				}
				break;
			case 3:
				{
				setState(249);
				match(PARENTHESE_O);
				setState(250);
				((ConditionContext)_localctx).k = ((ConditionContext)_localctx).condition = condition(0);
				setState(251);
				match(PARENTHESE_F);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).k.code;
				    
				}
				break;
			case 4:
				{
				setState(254);
				match(T__26);
				setState(255);
				((ConditionContext)_localctx).condition = condition(4);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code;
				        _localctx.code+="PUSHI 0\n";
				        _localctx.code+="EQUAL\n";
				    
				}
				break;
			case 5:
				{
				setState(258);
				((ConditionContext)_localctx).a = expression(0);
				setState(259);
				((ConditionContext)_localctx).OPERATORLOG = match(OPERATORLOG);
				setState(260);
				((ConditionContext)_localctx).b = expression(0);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				        _localctx.code+=((ConditionContext)_localctx).b.code;
				        _localctx.code+=evalexprconditions((((ConditionContext)_localctx).OPERATORLOG!=null?((ConditionContext)_localctx).OPERATORLOG.getText():null));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(275);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(265);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(266);
						match(T__27);
						setState(267);
						((ConditionContext)_localctx).d = ((ConditionContext)_localctx).condition = condition(4);

						                  ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).c.code;
						                  _localctx.code+=((ConditionContext)_localctx).d.code;
						                  _localctx.code+="MUL\n";
						                  _localctx.code+="PUSHI 1\n";
						                  _localctx.code+="EQUAL\n";
						              
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.g = _prevctx;
						_localctx.g = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						match(T__28);
						setState(272);
						((ConditionContext)_localctx).e = ((ConditionContext)_localctx).condition = condition(3);

						                  ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).g.code;
						                  _localctx.code+=((ConditionContext)_localctx).e.code;
						                  _localctx.code+="ADD\n";
						                  _localctx.code+="PUSHI 1\n";
						                  _localctx.code+="SUPEQ\n";
						              
						}
						break;
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(280);
					_la = _input.LA(1);
					if ( !(_la==T__17 || _la==NEWLINE) ) {
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
				setState(283); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public Bloc_codeContext bloc_code;
		public TerminalNode TYPE() { return getToken(calculParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public Bloc_codeContext bloc_code() {
			return getRuleContext(Bloc_codeContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fonction);
		tablesSymboles.newTableLocale();tablesSymboles.putVar("return","int");
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(286);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(287);
			match(PARENTHESE_O);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(288);
				params();
				}
			}

			setState(291);
			match(PARENTHESE_F);

			            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			            ((FonctionContext)_localctx).code =  "LABEL "+(((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
			        
			setState(293);
			((FonctionContext)_localctx).bloc_code = bloc_code();

			            _localctx.code += ((FonctionContext)_localctx).bloc_code.code;
			        
			}
			_ctx.stop = _input.LT(-1);
			tablesSymboles.dropTableLocale();
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

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(calculParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(calculParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(calculParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(calculParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(297);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			        
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(299);
				match(T__29);
				setState(300);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(301);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				                tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				            
				}
				}
				setState(307);
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calculListener ) ((calculListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << READ) | (1L << WRITE) | (1L << PARENTHESE_O) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOAT))) != 0)) {
				{
				setState(308);
				((ArgsContext)_localctx).expression = expression(0);

				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;
				        _localctx.size += 1;
				    
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__29) {
					{
					{
					setState(310);
					match(T__29);
					setState(311);
					((ArgsContext)_localctx).expression = expression(0);

					        _localctx.code += ((ArgsContext)_localctx).expression.code;
					        _localctx.size += 1;
					    
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0144\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2"+
		"%\13\2\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\2\7\2\61\n\2\f\2\16\2"+
		"\64\13\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\2\7\2@\n\2\f\2\16"+
		"\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0086"+
		"\n\4\f\4\16\4\u0089\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\u0097\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6\u00a9\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u00bb\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u00cc\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e6"+
		"\n\t\3\n\3\n\3\n\3\n\7\n\u00ec\n\n\f\n\16\n\u00ef\13\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00f5\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u010a\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0116\n\13\f\13\16\13\u0119\13"+
		"\13\3\f\6\f\u011c\n\f\r\f\16\f\u011d\3\r\3\r\3\r\3\r\5\r\u0124\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0132\n\16\f"+
		"\16\16\16\u0135\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u013d\n\17\f"+
		"\17\16\17\u0140\13\17\5\17\u0142\n\17\3\17\2\4\6\24\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\13\3\2\4\5\3\2\6\7\3\2\f\r\3\2\16\17\3\2\20\21"+
		"\3\2\22\23\3\2\25\26\3\2\27\30\4\2\24\24))\2\u015f\2#\3\2\2\2\4_\3\2\2"+
		"\2\6y\3\2\2\2\b\u0096\3\2\2\2\n\u00a8\3\2\2\2\f\u00ba\3\2\2\2\16\u00cb"+
		"\3\2\2\2\20\u00e5\3\2\2\2\22\u00f4\3\2\2\2\24\u0109\3\2\2\2\26\u011b\3"+
		"\2\2\2\30\u011f\3\2\2\2\32\u012a\3\2\2\2\34\u0141\3\2\2\2\36\37\5\b\5"+
		"\2\37 \b\2\1\2 \"\3\2\2\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$"+
		"&\3\2\2\2%#\3\2\2\2&*\b\2\1\2\')\7)\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2"+
		"*+\3\2\2\2+\62\3\2\2\2,*\3\2\2\2-.\5\30\r\2./\b\2\1\2/\61\3\2\2\2\60-"+
		"\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\638\3\2\2\2\64\62\3"+
		"\2\2\2\65\67\7)\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;"+
		"\3\2\2\2:8\3\2\2\2;A\b\2\1\2<=\5\4\3\2=>\b\2\1\2>@\3\2\2\2?<\3\2\2\2@"+
		"C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\b\2\1\2E\3\3\2\2\2"+
		"FG\5\6\4\2GH\5\26\f\2HI\b\3\1\2I`\3\2\2\2JK\5\26\f\2KL\b\3\1\2L`\3\2\2"+
		"\2MN\5\b\5\2NO\b\3\1\2O`\3\2\2\2PQ\5\n\6\2QR\5\26\f\2RS\b\3\1\2S`\3\2"+
		"\2\2TU\5\20\t\2UV\b\3\1\2V`\3\2\2\2WX\5\f\7\2XY\b\3\1\2Y`\3\2\2\2Z[\7"+
		"\3\2\2[\\\5\6\4\2\\]\5\26\f\2]^\b\3\1\2^`\3\2\2\2_F\3\2\2\2_J\3\2\2\2"+
		"_M\3\2\2\2_P\3\2\2\2_T\3\2\2\2_W\3\2\2\2_Z\3\2\2\2`\5\3\2\2\2ab\b\4\1"+
		"\2bc\7$\2\2cd\5\6\4\2de\7%\2\2ef\b\4\1\2fz\3\2\2\2gh\5\16\b\2hi\b\4\1"+
		"\2iz\3\2\2\2jk\7\'\2\2kl\7$\2\2lm\5\34\17\2mn\7%\2\2no\b\4\1\2oz\3\2\2"+
		"\2pq\7\"\2\2qr\7$\2\2rs\7\'\2\2st\7%\2\2tz\b\4\1\2uv\7#\2\2vw\5\6\4\3"+
		"wx\b\4\1\2xz\3\2\2\2ya\3\2\2\2yg\3\2\2\2yj\3\2\2\2yp\3\2\2\2yu\3\2\2\2"+
		"z\u0087\3\2\2\2{|\f\b\2\2|}\t\2\2\2}~\5\6\4\t~\177\b\4\1\2\177\u0086\3"+
		"\2\2\2\u0080\u0081\f\7\2\2\u0081\u0082\t\3\2\2\u0082\u0083\5\6\4\b\u0083"+
		"\u0084\b\4\1\2\u0084\u0086\3\2\2\2\u0085{\3\2\2\2\u0085\u0080\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\7\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7&\2\2\u008b\u008c\7\'\2\2\u008c"+
		"\u008d\5\26\f\2\u008d\u008e\b\5\1\2\u008e\u0097\3\2\2\2\u008f\u0090\7"+
		"&\2\2\u0090\u0091\7\'\2\2\u0091\u0092\7\b\2\2\u0092\u0093\5\16\b\2\u0093"+
		"\u0094\5\26\f\2\u0094\u0095\b\5\1\2\u0095\u0097\3\2\2\2\u0096\u008a\3"+
		"\2\2\2\u0096\u008f\3\2\2\2\u0097\t\3\2\2\2\u0098\u0099\7\'\2\2\u0099\u009a"+
		"\7\b\2\2\u009a\u009b\5\6\4\2\u009b\u009c\b\6\1\2\u009c\u00a9\3\2\2\2\u009d"+
		"\u009e\7\'\2\2\u009e\u009f\7\t\2\2\u009f\u00a0\5\6\4\2\u00a0\u00a1\b\6"+
		"\1\2\u00a1\u00a9\3\2\2\2\u00a2\u00a3\7\'\2\2\u00a3\u00a4\7\n\2\2\u00a4"+
		"\u00a9\b\6\1\2\u00a5\u00a6\7\'\2\2\u00a6\u00a7\7\13\2\2\u00a7\u00a9\b"+
		"\6\1\2\u00a8\u0098\3\2\2\2\u00a8\u009d\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a5\3\2\2\2\u00a9\13\3\2\2\2\u00aa\u00ab\t\4\2\2\u00ab\u00ac\7$\2\2"+
		"\u00ac\u00ad\5\24\13\2\u00ad\u00ae\7%\2\2\u00ae\u00af\5\22\n\2\u00af\u00b0"+
		"\t\5\2\2\u00b0\u00b1\5\22\n\2\u00b1\u00b2\b\7\1\2\u00b2\u00bb\3\2\2\2"+
		"\u00b3\u00b4\t\4\2\2\u00b4\u00b5\7$\2\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7"+
		"\7%\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00b9\b\7\1\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00aa\3\2\2\2\u00ba\u00b3\3\2\2\2\u00bb\r\3\2\2\2\u00bc\u00bd\7\7\2\2"+
		"\u00bd\u00be\7,\2\2\u00be\u00cc\b\b\1\2\u00bf\u00c0\7,\2\2\u00c0\u00cc"+
		"\b\b\1\2\u00c1\u00c2\7\7\2\2\u00c2\u00c3\7+\2\2\u00c3\u00cc\b\b\1\2\u00c4"+
		"\u00c5\7+\2\2\u00c5\u00cc\b\b\1\2\u00c6\u00c7\7\7\2\2\u00c7\u00c8\7\'"+
		"\2\2\u00c8\u00cc\b\b\1\2\u00c9\u00ca\7\'\2\2\u00ca\u00cc\b\b\1\2\u00cb"+
		"\u00bc\3\2\2\2\u00cb\u00bf\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cb\u00c4\3\2"+
		"\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\17\3\2\2\2\u00cd\u00ce"+
		"\t\6\2\2\u00ce\u00cf\5\24\13\2\u00cf\u00d0\5\22\n\2\u00d0\u00d1\b\t\1"+
		"\2\u00d1\u00e6\3\2\2\2\u00d2\u00d3\t\7\2\2\u00d3\u00d4\7$\2\2\u00d4\u00d5"+
		"\5\n\6\2\u00d5\u00d6\7\24\2\2\u00d6\u00d7\5\24\13\2\u00d7\u00d8\7\24\2"+
		"\2\u00d8\u00d9\5\n\6\2\u00d9\u00da\7%\2\2\u00da\u00db\5\22\n\2\u00db\u00dc"+
		"\b\t\1\2\u00dc\u00e6\3\2\2\2\u00dd\u00de\t\b\2\2\u00de\u00df\5\22\n\2"+
		"\u00df\u00e0\t\t\2\2\u00e0\u00e1\7$\2\2\u00e1\u00e2\5\24\13\2\u00e2\u00e3"+
		"\7%\2\2\u00e3\u00e4\b\t\1\2\u00e4\u00e6\3\2\2\2\u00e5\u00cd\3\2\2\2\u00e5"+
		"\u00d2\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e6\21\3\2\2\2\u00e7\u00ed\7\31\2"+
		"\2\u00e8\u00e9\5\4\3\2\u00e9\u00ea\b\n\1\2\u00ea\u00ec\3\2\2\2\u00eb\u00e8"+
		"\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f5\7\32\2\2\u00f1\u00f2\5"+
		"\4\3\2\u00f2\u00f3\b\n\1\2\u00f3\u00f5\3\2\2\2\u00f4\u00e7\3\2\2\2\u00f4"+
		"\u00f1\3\2\2\2\u00f5\23\3\2\2\2\u00f6\u00f7\b\13\1\2\u00f7\u00f8\7\33"+
		"\2\2\u00f8\u010a\b\13\1\2\u00f9\u00fa\7\34\2\2\u00fa\u010a\b\13\1\2\u00fb"+
		"\u00fc\7$\2\2\u00fc\u00fd\5\24\13\2\u00fd\u00fe\7%\2\2\u00fe\u00ff\b\13"+
		"\1\2\u00ff\u010a\3\2\2\2\u0100\u0101\7\35\2\2\u0101\u0102\5\24\13\6\u0102"+
		"\u0103\b\13\1\2\u0103\u010a\3\2\2\2\u0104\u0105\5\6\4\2\u0105\u0106\7"+
		".\2\2\u0106\u0107\5\6\4\2\u0107\u0108\b\13\1\2\u0108\u010a\3\2\2\2\u0109"+
		"\u00f6\3\2\2\2\u0109\u00f9\3\2\2\2\u0109\u00fb\3\2\2\2\u0109\u0100\3\2"+
		"\2\2\u0109\u0104\3\2\2\2\u010a\u0117\3\2\2\2\u010b\u010c\f\5\2\2\u010c"+
		"\u010d\7\36\2\2\u010d\u010e\5\24\13\6\u010e\u010f\b\13\1\2\u010f\u0116"+
		"\3\2\2\2\u0110\u0111\f\4\2\2\u0111\u0112\7\37\2\2\u0112\u0113\5\24\13"+
		"\5\u0113\u0114\b\13\1\2\u0114\u0116\3\2\2\2\u0115\u010b\3\2\2\2\u0115"+
		"\u0110\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\25\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\t\n\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\27\3\2\2\2\u011f\u0120\7&\2\2\u0120\u0121\7\'\2\2\u0121\u0123\7$\2\2"+
		"\u0122\u0124\5\32\16\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\7%\2\2\u0126\u0127\b\r\1\2\u0127\u0128\5\22\n\2\u0128"+
		"\u0129\b\r\1\2\u0129\31\3\2\2\2\u012a\u012b\7&\2\2\u012b\u012c\7\'\2\2"+
		"\u012c\u0133\b\16\1\2\u012d\u012e\7 \2\2\u012e\u012f\7&\2\2\u012f\u0130"+
		"\7\'\2\2\u0130\u0132\b\16\1\2\u0131\u012d\3\2\2\2\u0132\u0135\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\33\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0136\u0137\5\6\4\2\u0137\u013e\b\17\1\2\u0138\u0139\7 \2\2\u0139"+
		"\u013a\5\6\4\2\u013a\u013b\b\17\1\2\u013b\u013d\3\2\2\2\u013c\u0138\3"+
		"\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0136\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\35\3\2\2\2\32#*\628A_y\u0085\u0087\u0096\u00a8\u00ba\u00cb"+
		"\u00e5\u00ed\u00f4\u0109\u0115\u0117\u011d\u0123\u0133\u013e\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}