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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, PARENTHESE_O=34, PARENTHESE_F=35, TYPE=36, IDENTIFIANT=37, 
		LOOP_WORD=38, NEWLINE=39, WS=40, ENTIER=41, OPERATOR=42, OPERATORLOG=43, 
		RETURN=44, UNMATCH=45;
	public static final int
		RULE_start = 0, RULE_decl = 1, RULE_assignation = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_element = 5, RULE_condition = 6, RULE_loop = 7, 
		RULE_branchements = 8, RULE_bloc_code = 9, RULE_fonction = 10, RULE_params = 11, 
		RULE_args = 12, RULE_finInstruction = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl", "assignation", "instruction", "expression", "element", 
			"condition", "loop", "branchements", "bloc_code", "fonction", "params", 
			"args", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'++'", "'--'", "'READ'", "'read'", "'WRITE'", "'write'", 
			"'*'", "'/'", "'+'", "'-'", "'true'", "'false'", "'!'", "'&&'", "'||'", 
			"'while'", "'WHILE'", "'for'", "'FOR'", "';'", "'repeat'", "'REPEAT'", 
			"'until'", "'UNTIL'", "'if'", "'IF'", "'else'", "'ELSE'", "'{'", "'}'", 
			"','", "'('", "')'", null, null, null, null, null, null, null, null, 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "PARENTHESE_O", 
			"PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", "NEWLINE", "WS", 
			"ENTIER", "OPERATOR", "OPERATORLOG", "RETURN", "UNMATCH"
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
	    private int _cur_label = 1;

	    private String getNewLabel() { 
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
			_localctx.code += "  JUMP Main\n"; 
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << PARENTHESE_O) | (1L << TYPE) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << RETURN))) != 0)) {
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
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(calculParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(TYPE);
				setState(69);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(70);
				match(T__0);
				setState(71);
				((DeclContext)_localctx).expression = expression(0);

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        ((DeclContext)_localctx).code = ((DeclContext)_localctx).expression.code;
				        System.out.println("DEBUG=>"+_localctx.code);
				        if(tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null)).adresse<0){
				            _localctx.code+="STOREL "+tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null)).adresse+"\n";
				            System.out.println("DEBUG=>"+_localctx.code);
				        }else{
				            _localctx.code+="STOREG "+tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null)).adresse+"\n";
				            System.out.println("DEBUG=>"+_localctx.code);
				        }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(TYPE);
				setState(75);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

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
		enterRule(_localctx, 4, RULE_assignation);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(80);
				match(T__0);
				setState(81);
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
				setState(84);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(85);
				match(T__1);
				setState(86);
				((AssignationContext)_localctx).expression = expression(0);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+=((AssignationContext)_localctx).expression.code;
				            _localctx.code+="ADD \n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            _localctx.code+=((AssignationContext)_localctx).expression.code;
				            _localctx.code+="ADD \n";
				            _localctx.code+="STOREG "+at.adresse+"\n";
				        }
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(90);
				match(T__2);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="ADD\n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="ADD\n";
				            _localctx.code+="STOREG "+at.adresse+"\n";
				        }
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(93);
				match(T__3);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        if(at.adresse<0){
				            ((AssignationContext)_localctx).code = "PUSHL "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="SUB\n";
				            _localctx.code+="STOREL "+at.adresse+"\n";
				        }else{
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            _localctx.code+="PUSHI 1\n";
				            _localctx.code+="SUB\n";
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public DeclContext decl;
		public AssignationContext assignation;
		public BranchementsContext branchements;
		public LoopContext loop;
		public TerminalNode RETURN() { return getToken(calculParser.RETURN, 0); }
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
		public BranchementsContext branchements() {
			return getRuleContext(BranchementsContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
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
		enterRule(_localctx, 6, RULE_instruction);
		String code = new String();
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(RETURN);
				setState(98);
				((InstructionContext)_localctx).expression = expression(0);
				setState(99);
				finInstruction();

				        AdresseType at = tablesSymboles.getAdresseType("RETURN__FUNC_RES");
				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code+"STOREL "+at.adresse+" \n RETURN";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((InstructionContext)_localctx).expression = expression(0);
				setState(103);
				finInstruction();
				 
				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				((InstructionContext)_localctx).decl = decl();
				setState(107);
				finInstruction();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).decl.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				((InstructionContext)_localctx).assignation = assignation();
				setState(111);
				finInstruction();
				 
				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				((InstructionContext)_localctx).branchements = branchements();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).branchements.code;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				((InstructionContext)_localctx).loop = loop();

				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loop.code;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
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
		public String type;
		public ExpressionContext a;
		public Token IDENTIFIANT;
		public ElementContext d;
		public ArgsContext args;
		public Token op;
		public ExpressionContext b;
		public TerminalNode PARENTHESE_O() { return getToken(calculParser.PARENTHESE_O, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(calculParser.IDENTIFIANT, 0); }
		public TerminalNode PARENTHESE_F() { return getToken(calculParser.PARENTHESE_F, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(126);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(127);
				match(PARENTHESE_O);
				setState(128);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(129);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  read_func((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				    
				}
				break;
			case 2:
				{
				setState(131);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				((ExpressionContext)_localctx).a = expression(6);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "WRITE\nPOP\n";
				    
				}
				break;
			case 3:
				{
				setState(135);
				match(PARENTHESE_O);
				setState(136);
				((ExpressionContext)_localctx).a = expression(0);
				setState(137);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case 4:
				{
				setState(140);
				((ExpressionContext)_localctx).d = element();

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).d.code;
				    
				}
				break;
			case 5:
				{
				setState(143);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(144);
				match(PARENTHESE_O);
				setState(145);
				((ExpressionContext)_localctx).args = args();
				setState(146);
				match(PARENTHESE_F);
				  
				        ((ExpressionContext)_localctx).code = "PUSHI 0\n";
				        _localctx.code+= ((ExpressionContext)_localctx).args.code;
				        _localctx.code+="CALL "+(((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
				        for(int i = 0 ; i< ((ExpressionContext)_localctx).args.size;i++)
				        _localctx.code+="POP\n";
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(152);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						((ExpressionContext)_localctx).b = expression(5);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
						                  _localctx.code+=((ExpressionContext)_localctx).b.code;
						                  _localctx.code+= evalexpr(((ExpressionContext)_localctx).op.getText());
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(157);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(158);
						((ExpressionContext)_localctx).b = expression(4);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
						                  _localctx.code+=((ExpressionContext)_localctx).b.code;
						                  _localctx.code+=evalexpr(((ExpressionContext)_localctx).op.getText());
						              
						}
						break;
					}
					} 
				}
				setState(165);
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

	public static class ElementContext extends ParserRuleContext {
		public String code;
		public Token ENTIER;
		public Token IDENTIFIANT;
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
		enterRule(_localctx, 10, RULE_element);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__11);
				setState(167);
				((ElementContext)_localctx).ENTIER = match(ENTIER);

				            ((ElementContext)_localctx).code =  "PUSHI -"+((ElementContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((ElementContext)_localctx).ENTIER = match(ENTIER);

				            ((ElementContext)_localctx).code =  "PUSHI "+((ElementContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__11);
				setState(172);
				((ElementContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            int addr = tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				            if (addr < 0){
				                ((ElementContext)_localctx).code = "PUSHL "+addr;
				                _localctx.code+="PUSHI -1\n MUL\n";
				            }else{
				                ((ElementContext)_localctx).code = "PUSHG "+addr;
				                _localctx.code+="PUSHI -1\n MUL\n";
				            }   
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				((ElementContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            int addr = tablesSymboles.getAdresseType((((ElementContext)_localctx).IDENTIFIANT!=null?((ElementContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				            if (addr < 0){
				                ((ElementContext)_localctx).code =  "PUSHL "+addr+"\n";
				            }else{
				                ((ElementContext)_localctx).code =  "PUSHG "+addr+"\n";
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(179);
				match(T__12);

				        ((ConditionContext)_localctx).code = "PUSHI 1\n";
					
				}
				break;
			case 2:
				{
				setState(181);
				match(T__13);

				        ((ConditionContext)_localctx).code = "PUSHI 0\n";
				    
				}
				break;
			case 3:
				{
				setState(183);
				match(PARENTHESE_O);
				setState(184);
				((ConditionContext)_localctx).k = ((ConditionContext)_localctx).condition = condition(0);
				setState(185);
				match(PARENTHESE_F);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).k.code;
				    
				}
				break;
			case 4:
				{
				setState(188);
				match(T__14);
				setState(189);
				((ConditionContext)_localctx).condition = condition(4);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code;
				        _localctx.code+="PUSHI 0\n";
				        _localctx.code+="EQUAL\n";
				    
				}
				break;
			case 5:
				{
				setState(192);
				((ConditionContext)_localctx).a = expression(0);
				setState(193);
				((ConditionContext)_localctx).OPERATORLOG = match(OPERATORLOG);
				setState(194);
				((ConditionContext)_localctx).b = expression(0);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				        _localctx.code+=((ConditionContext)_localctx).b.code;
				        _localctx.code+=evalexprconditions((((ConditionContext)_localctx).OPERATORLOG!=null?((ConditionContext)_localctx).OPERATORLOG.getText():null));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(199);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(200);
						match(T__15);
						setState(201);
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
						setState(204);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(205);
						match(T__16);
						setState(206);
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
				setState(213);
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
			unrollRecursionContexts(_parentctx);
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
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				((LoopContext)_localctx).a = condition(0);
				setState(216);
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
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(220);
				match(PARENTHESE_O);
				setState(221);
				((LoopContext)_localctx).d = assignation();
				setState(222);
				match(T__21);
				setState(223);
				((LoopContext)_localctx).e = condition(0);
				setState(224);
				match(T__21);
				setState(225);
				((LoopContext)_localctx).f = assignation();
				setState(226);
				match(PARENTHESE_F);
				setState(227);
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
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(231);
				((LoopContext)_localctx).g = bloc_code();
				setState(232);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(233);
				match(PARENTHESE_O);
				setState(234);
				((LoopContext)_localctx).h = condition(0);
				setState(235);
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
		enterRule(_localctx, 16, RULE_branchements);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(241);
				match(PARENTHESE_O);
				setState(242);
				((BranchementsContext)_localctx).a = condition(0);
				setState(243);
				match(PARENTHESE_F);
				setState(244);
				((BranchementsContext)_localctx).b = bloc_code();
				setState(245);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(246);
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
				setState(249);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(250);
				match(PARENTHESE_O);
				setState(251);
				((BranchementsContext)_localctx).a = condition(0);
				setState(252);
				match(PARENTHESE_F);
				setState(253);
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
		enterRule(_localctx, 18, RULE_bloc_code);
		 ((Bloc_codeContext)_localctx).code =  new String(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(258);
				match(T__30);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << PARENTHESE_O) | (1L << TYPE) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << RETURN))) != 0)) {
					{
					{
					setState(259);
					((Bloc_codeContext)_localctx).instruction = instruction();
					_localctx.code += ((Bloc_codeContext)_localctx).instruction.code; 
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267);
				match(T__31);
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__11:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__26:
			case T__27:
			case PARENTHESE_O:
			case TYPE:
			case IDENTIFIANT:
			case NEWLINE:
			case ENTIER:
			case RETURN:
				{
				setState(268);
				((Bloc_codeContext)_localctx).instruction = instruction();
				_localctx.code+=((Bloc_codeContext)_localctx).instruction.code;
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public Bloc_codeContext a;
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
		enterRule(_localctx, 20, RULE_fonction);
		 tablesSymboles.newTableLocale();tablesSymboles.putVar("RETURN__FUNC_RES","int"); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(274);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(275);
			match(PARENTHESE_O);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(276);
				params();
				}
			}

			setState(279);
			match(PARENTHESE_F);

			        tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null),(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			        ((FonctionContext)_localctx).code =  "LABEL "+(((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
			    
			setState(281);
			((FonctionContext)_localctx).a = bloc_code();

			           _localctx.code += ((FonctionContext)_localctx).a.code+"RETURN\n";
			    
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
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(285);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 
			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			    
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(287);
				match(T__32);
				setState(288);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(289);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				        tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				    
				}
				}
				setState(295);
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
		enterRule(_localctx, 24, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << PARENTHESE_O) | (1L << IDENTIFIANT) | (1L << ENTIER))) != 0)) {
				{
				setState(296);
				((ArgsContext)_localctx).expression = expression(0);
				 
				        _localctx.size+=1;
				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code; 
				    
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__32) {
					{
					{
					setState(298);
					match(T__32);
					setState(299);
					((ArgsContext)_localctx).expression = expression(0);
					 
					        
					        _localctx.size+=1;
					        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;        
					    
					}
					}
					setState(306);
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
		enterRule(_localctx, 26, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(309);
					_la = _input.LA(1);
					if ( !(_la==T__21 || _la==NEWLINE) ) {
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
				setState(312); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		case 6:
			return condition_sempred((ConditionContext)_localctx, predIndex);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2"+
		"%\13\2\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\2\7\2\61\n\2\f\2\16\2"+
		"\64\13\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\2\7\2@\n\2\f\2\16"+
		"\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4b\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5~\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0098\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a4\n\6\f\6\16"+
		"\6\u00a7\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b3\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u00c8\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00d4\n"+
		"\b\f\b\16\b\u00d7\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00f1\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0103\n\n"+
		"\3\13\3\13\3\13\3\13\7\13\u0109\n\13\f\13\16\13\u010c\13\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0112\n\13\3\f\3\f\3\f\3\f\5\f\u0118\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0126\n\r\f\r\16\r\u0129\13\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\7\16\u0131\n\16\f\16\16\16\u0134\13\16\5"+
		"\16\u0136\n\16\3\17\6\17\u0139\n\17\r\17\16\17\u013a\3\17\2\4\n\16\20"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\r\3\2\7\b\3\2\t\n\3\2\13\f\3\2"+
		"\r\16\3\2\24\25\3\2\26\27\3\2\31\32\3\2\33\34\3\2\35\36\3\2\37 \4\2\30"+
		"\30))\2\u0156\2#\3\2\2\2\4O\3\2\2\2\6a\3\2\2\2\b}\3\2\2\2\n\u0097\3\2"+
		"\2\2\f\u00b2\3\2\2\2\16\u00c7\3\2\2\2\20\u00f0\3\2\2\2\22\u0102\3\2\2"+
		"\2\24\u0111\3\2\2\2\26\u0113\3\2\2\2\30\u011e\3\2\2\2\32\u0135\3\2\2\2"+
		"\34\u0138\3\2\2\2\36\37\5\4\3\2\37 \b\2\1\2 \"\3\2\2\2!\36\3\2\2\2\"%"+
		"\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&*\b\2\1\2\')\7)\2\2("+
		"\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\62\3\2\2\2,*\3\2\2\2-.\5\26"+
		"\f\2./\b\2\1\2/\61\3\2\2\2\60-\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\638\3\2\2\2\64\62\3\2\2\2\65\67\7)\2\2\66\65\3\2\2\2\67:\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;A\b\2\1\2<=\5\b\5\2="+
		">\b\2\1\2>@\3\2\2\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2"+
		"CA\3\2\2\2DE\b\2\1\2E\3\3\2\2\2FG\7&\2\2GH\7\'\2\2HI\7\3\2\2IJ\5\n\6\2"+
		"JK\b\3\1\2KP\3\2\2\2LM\7&\2\2MN\7\'\2\2NP\b\3\1\2OF\3\2\2\2OL\3\2\2\2"+
		"P\5\3\2\2\2QR\7\'\2\2RS\7\3\2\2ST\5\n\6\2TU\b\4\1\2Ub\3\2\2\2VW\7\'\2"+
		"\2WX\7\4\2\2XY\5\n\6\2YZ\b\4\1\2Zb\3\2\2\2[\\\7\'\2\2\\]\7\5\2\2]b\b\4"+
		"\1\2^_\7\'\2\2_`\7\6\2\2`b\b\4\1\2aQ\3\2\2\2aV\3\2\2\2a[\3\2\2\2a^\3\2"+
		"\2\2b\7\3\2\2\2cd\7.\2\2de\5\n\6\2ef\5\34\17\2fg\b\5\1\2g~\3\2\2\2hi\5"+
		"\n\6\2ij\5\34\17\2jk\b\5\1\2k~\3\2\2\2lm\5\4\3\2mn\5\34\17\2no\b\5\1\2"+
		"o~\3\2\2\2pq\5\6\4\2qr\5\34\17\2rs\b\5\1\2s~\3\2\2\2tu\5\22\n\2uv\b\5"+
		"\1\2v~\3\2\2\2wx\5\20\t\2xy\b\5\1\2y~\3\2\2\2z{\5\34\17\2{|\b\5\1\2|~"+
		"\3\2\2\2}c\3\2\2\2}h\3\2\2\2}l\3\2\2\2}p\3\2\2\2}t\3\2\2\2}w\3\2\2\2}"+
		"z\3\2\2\2~\t\3\2\2\2\177\u0080\b\6\1\2\u0080\u0081\t\2\2\2\u0081\u0082"+
		"\7$\2\2\u0082\u0083\7\'\2\2\u0083\u0084\7%\2\2\u0084\u0098\b\6\1\2\u0085"+
		"\u0086\t\3\2\2\u0086\u0087\5\n\6\b\u0087\u0088\b\6\1\2\u0088\u0098\3\2"+
		"\2\2\u0089\u008a\7$\2\2\u008a\u008b\5\n\6\2\u008b\u008c\7%\2\2\u008c\u008d"+
		"\b\6\1\2\u008d\u0098\3\2\2\2\u008e\u008f\5\f\7\2\u008f\u0090\b\6\1\2\u0090"+
		"\u0098\3\2\2\2\u0091\u0092\7\'\2\2\u0092\u0093\7$\2\2\u0093\u0094\5\32"+
		"\16\2\u0094\u0095\7%\2\2\u0095\u0096\b\6\1\2\u0096\u0098\3\2\2\2\u0097"+
		"\177\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u0089\3\2\2\2\u0097\u008e\3\2\2"+
		"\2\u0097\u0091\3\2\2\2\u0098\u00a5\3\2\2\2\u0099\u009a\f\6\2\2\u009a\u009b"+
		"\t\4\2\2\u009b\u009c\5\n\6\7\u009c\u009d\b\6\1\2\u009d\u00a4\3\2\2\2\u009e"+
		"\u009f\f\5\2\2\u009f\u00a0\t\5\2\2\u00a0\u00a1\5\n\6\6\u00a1\u00a2\b\6"+
		"\1\2\u00a2\u00a4\3\2\2\2\u00a3\u0099\3\2\2\2\u00a3\u009e\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\13\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\16\2\2\u00a9\u00aa\7+\2\2\u00aa\u00b3"+
		"\b\7\1\2\u00ab\u00ac\7+\2\2\u00ac\u00b3\b\7\1\2\u00ad\u00ae\7\16\2\2\u00ae"+
		"\u00af\7\'\2\2\u00af\u00b3\b\7\1\2\u00b0\u00b1\7\'\2\2\u00b1\u00b3\b\7"+
		"\1\2\u00b2\u00a8\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\b\b\1\2\u00b5\u00b6\7\17\2"+
		"\2\u00b6\u00c8\b\b\1\2\u00b7\u00b8\7\20\2\2\u00b8\u00c8\b\b\1\2\u00b9"+
		"\u00ba\7$\2\2\u00ba\u00bb\5\16\b\2\u00bb\u00bc\7%\2\2\u00bc\u00bd\b\b"+
		"\1\2\u00bd\u00c8\3\2\2\2\u00be\u00bf\7\21\2\2\u00bf\u00c0\5\16\b\6\u00c0"+
		"\u00c1\b\b\1\2\u00c1\u00c8\3\2\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4\7-"+
		"\2\2\u00c4\u00c5\5\n\6\2\u00c5\u00c6\b\b\1\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00b4\3\2\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7\u00be\3\2"+
		"\2\2\u00c7\u00c2\3\2\2\2\u00c8\u00d5\3\2\2\2\u00c9\u00ca\f\5\2\2\u00ca"+
		"\u00cb\7\22\2\2\u00cb\u00cc\5\16\b\6\u00cc\u00cd\b\b\1\2\u00cd\u00d4\3"+
		"\2\2\2\u00ce\u00cf\f\4\2\2\u00cf\u00d0\7\23\2\2\u00d0\u00d1\5\16\b\5\u00d1"+
		"\u00d2\b\b\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00ce\3\2"+
		"\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\17\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\t\6\2\2\u00d9\u00da\5\16\b"+
		"\2\u00da\u00db\5\24\13\2\u00db\u00dc\b\t\1\2\u00dc\u00f1\3\2\2\2\u00dd"+
		"\u00de\t\7\2\2\u00de\u00df\7$\2\2\u00df\u00e0\5\6\4\2\u00e0\u00e1\7\30"+
		"\2\2\u00e1\u00e2\5\16\b\2\u00e2\u00e3\7\30\2\2\u00e3\u00e4\5\6\4\2\u00e4"+
		"\u00e5\7%\2\2\u00e5\u00e6\5\24\13\2\u00e6\u00e7\b\t\1\2\u00e7\u00f1\3"+
		"\2\2\2\u00e8\u00e9\t\b\2\2\u00e9\u00ea\5\24\13\2\u00ea\u00eb\t\t\2\2\u00eb"+
		"\u00ec\7$\2\2\u00ec\u00ed\5\16\b\2\u00ed\u00ee\7%\2\2\u00ee\u00ef\b\t"+
		"\1\2\u00ef\u00f1\3\2\2\2\u00f0\u00d8\3\2\2\2\u00f0\u00dd\3\2\2\2\u00f0"+
		"\u00e8\3\2\2\2\u00f1\21\3\2\2\2\u00f2\u00f3\t\n\2\2\u00f3\u00f4\7$\2\2"+
		"\u00f4\u00f5\5\16\b\2\u00f5\u00f6\7%\2\2\u00f6\u00f7\5\24\13\2\u00f7\u00f8"+
		"\t\13\2\2\u00f8\u00f9\5\24\13\2\u00f9\u00fa\b\n\1\2\u00fa\u0103\3\2\2"+
		"\2\u00fb\u00fc\t\n\2\2\u00fc\u00fd\7$\2\2\u00fd\u00fe\5\16\b\2\u00fe\u00ff"+
		"\7%\2\2\u00ff\u0100\5\24\13\2\u0100\u0101\b\n\1\2\u0101\u0103\3\2\2\2"+
		"\u0102\u00f2\3\2\2\2\u0102\u00fb\3\2\2\2\u0103\23\3\2\2\2\u0104\u010a"+
		"\7!\2\2\u0105\u0106\5\b\5\2\u0106\u0107\b\13\1\2\u0107\u0109\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0112\7\"\2\2\u010e"+
		"\u010f\5\b\5\2\u010f\u0110\b\13\1\2\u0110\u0112\3\2\2\2\u0111\u0104\3"+
		"\2\2\2\u0111\u010e\3\2\2\2\u0112\25\3\2\2\2\u0113\u0114\7&\2\2\u0114\u0115"+
		"\7\'\2\2\u0115\u0117\7$\2\2\u0116\u0118\5\30\r\2\u0117\u0116\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7%\2\2\u011a\u011b\b\f"+
		"\1\2\u011b\u011c\5\24\13\2\u011c\u011d\b\f\1\2\u011d\27\3\2\2\2\u011e"+
		"\u011f\7&\2\2\u011f\u0120\7\'\2\2\u0120\u0127\b\r\1\2\u0121\u0122\7#\2"+
		"\2\u0122\u0123\7&\2\2\u0123\u0124\7\'\2\2\u0124\u0126\b\r\1\2\u0125\u0121"+
		"\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\31\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\5\n\6\2\u012b\u0132\b\16\1"+
		"\2\u012c\u012d\7#\2\2\u012d\u012e\5\n\6\2\u012e\u012f\b\16\1\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012c\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u012a\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136\33\3\2\2\2\u0137\u0139\t\f\2\2\u0138\u0137"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\35\3\2\2\2\32#*\628AOa}\u0097\u00a3\u00a5\u00b2\u00c7\u00d3\u00d5\u00f0"+
		"\u0102\u010a\u0111\u0117\u0127\u0132\u0135\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}