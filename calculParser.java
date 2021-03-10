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
		T__31=32, PARENTHESE_O=33, PARENTHESE_F=34, TYPE=35, IDENTIFIANT=36, LOOP_WORD=37, 
		NEWLINE=38, WS=39, ENTIER=40, OPERATOR=41, OPERATORLOG=42, UNMATCH=43;
	public static final int
		RULE_start = 0, RULE_decl = 1, RULE_assignation = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_condition = 5, RULE_loop = 6, RULE_branchements = 7, 
		RULE_bloc_code = 8, RULE_finInstruction = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl", "assignation", "instruction", "expression", "condition", 
			"loop", "branchements", "bloc_code", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'++'", "'--'", "'READ'", "'read'", "'WRITE'", "'write'", 
			"'*'", "'/'", "'+'", "'-'", "'true'", "'false'", "'!'", "'&&'", "'||'", 
			"'while'", "'WHILE'", "'for'", "'FOR'", "';'", "'repeat'", "'REPEAT'", 
			"'until'", "'UNTIL'", "'if'", "'IF'", "'else'", "'ELSE'", "'{'", "'}'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "PARENTHESE_O", 
			"PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", "NEWLINE", "WS", 
			"ENTIER", "OPERATOR", "OPERATORLOG", "UNMATCH"
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
		    
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					((StartContext)_localctx).decl = decl();
					 _localctx.code += ((StartContext)_localctx).decl.code; 
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					match(NEWLINE);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					((StartContext)_localctx).instruction = instruction();
					 _localctx.code += ((StartContext)_localctx).instruction.code;
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(42);
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
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(TYPE);
				setState(46);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(47);
				match(T__0);
				setState(48);
				((DeclContext)_localctx).instruction = instruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        ((DeclContext)_localctx).code = ((DeclContext)_localctx).instruction.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(TYPE);
				setState(52);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(53);
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
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(59);
				match(T__1);
				setState(60);
				((AssignationContext)_localctx).expression = expression(0);

				            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				            _localctx.code+=((AssignationContext)_localctx).expression.code;
				            _localctx.code+="ADD \n";
				            _localctx.code+="STOREG "+at.adresse+"\n";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(64);
				match(T__2);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				        _localctx.code+="PUSHI 1\n";
				        _localctx.code+="ADD\n";
				        _localctx.code+="STOREG "+at.adresse+"\n";
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(67);
				match(T__3);

				        AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        ((AssignationContext)_localctx).code = "PUSHG "+at.adresse+"\n";
				        _localctx.code+="PUSHI 1\n";
				        _localctx.code+="SUB\n";
				        _localctx.code+="STOREG "+at.adresse+"\n";
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(70);
				match(T__0);
				setState(71);
				((AssignationContext)_localctx).expression = expression(0);
				  
				            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREG "+at.adresse+"\n";
				    
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
		public AssignationContext assignation;
		public BranchementsContext branchements;
		public LoopContext loop;
		public ExpressionContext expression;
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public BranchementsContext branchements() {
			return getRuleContext(BranchementsContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				((InstructionContext)_localctx).assignation = assignation();
				setState(77);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				((InstructionContext)_localctx).branchements = branchements();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).branchements.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				((InstructionContext)_localctx).loop = loop();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loop.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				((InstructionContext)_localctx).expression = expression(0);
				setState(87);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
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
		public ExpressionContext a;
		public Token IDENTIFIANT;
		public Token ENTIER;
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
		public TerminalNode ENTIER() { return getToken(calculParser.ENTIER, 0); }
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				match(PARENTHESE_O);
				setState(98);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(99);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  read_func((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				    
				}
				break;
			case 3:
				{
				setState(101);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(102);
				((ExpressionContext)_localctx).a = expression(8);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "WRITE\nPOP\n";
				    
				}
				break;
			case 4:
				{
				setState(105);
				match(PARENTHESE_O);
				setState(106);
				((ExpressionContext)_localctx).a = expression(0);
				setState(107);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case 5:
				{
				setState(110);
				match(T__11);
				setState(111);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI -"+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 6:
				{
				setState(113);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI "+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 7:
				{
				setState(115);
				match(T__11);
				setState(116);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        ((ExpressionContext)_localctx).code = "PUSHG "+tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        _localctx.code+="PUSHI -1\n MULT \n";
				    
				}
				break;
			case 8:
				{
				setState(118);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        ((ExpressionContext)_localctx).code =  "PUSHG "+tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).adresse+"\n";
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(123);
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
						setState(124);
						((ExpressionContext)_localctx).b = expression(7);

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
						setState(127);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(128);
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
						setState(129);
						((ExpressionContext)_localctx).b = expression(6);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
						                  _localctx.code+=((ExpressionContext)_localctx).b.code;
						                  _localctx.code+=evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					}
					} 
				}
				setState(136);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(138);
				match(T__12);

				        ((ConditionContext)_localctx).code = "PUSHI 1\n";
					
				}
				break;
			case 2:
				{
				setState(140);
				match(T__13);

				        ((ConditionContext)_localctx).code = "PUSHI 0\n";
				    
				}
				break;
			case 3:
				{
				setState(142);
				match(PARENTHESE_O);
				setState(143);
				((ConditionContext)_localctx).k = ((ConditionContext)_localctx).condition = condition(0);
				setState(144);
				match(PARENTHESE_F);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).k.code;
				    
				}
				break;
			case 4:
				{
				setState(147);
				match(T__14);
				setState(148);
				((ConditionContext)_localctx).condition = condition(4);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code;
				        _localctx.code+="PUSHI -1\n";
				        _localctx.code+="MULT\n";
				    
				}
				break;
			case 5:
				{
				setState(151);
				((ConditionContext)_localctx).a = expression(0);
				setState(152);
				((ConditionContext)_localctx).OPERATORLOG = match(OPERATORLOG);
				setState(153);
				((ConditionContext)_localctx).b = expression(0);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				        _localctx.code+=((ConditionContext)_localctx).b.code;
				        _localctx.code+=evalexprconditions((((ConditionContext)_localctx).OPERATORLOG!=null?((ConditionContext)_localctx).OPERATORLOG.getText():null));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						match(T__15);
						setState(160);
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
						setState(163);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(164);
						match(T__16);
						setState(165);
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
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 12, RULE_loop);
		int _la;
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				((LoopContext)_localctx).a = condition(0);
				setState(175);
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
				setState(178);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(179);
				match(PARENTHESE_O);
				setState(180);
				((LoopContext)_localctx).d = assignation();
				setState(181);
				match(T__21);
				setState(182);
				((LoopContext)_localctx).e = condition(0);
				setState(183);
				match(T__21);
				setState(184);
				((LoopContext)_localctx).f = assignation();
				setState(185);
				match(PARENTHESE_F);
				setState(186);
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
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				((LoopContext)_localctx).g = bloc_code();
				setState(191);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				match(PARENTHESE_O);
				setState(193);
				((LoopContext)_localctx).h = condition(0);
				setState(194);
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
		enterRule(_localctx, 14, RULE_branchements);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(200);
				match(PARENTHESE_O);
				setState(201);
				((BranchementsContext)_localctx).a = condition(0);
				setState(202);
				match(PARENTHESE_F);
				setState(203);
				((BranchementsContext)_localctx).b = bloc_code();
				setState(204);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205);
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
				setState(208);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
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
				((BranchementsContext)_localctx).a = condition(0);
				setState(211);
				match(PARENTHESE_F);
				setState(212);
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
		enterRule(_localctx, 16, RULE_bloc_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(217);
				match(T__30);
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(218);
						((Bloc_codeContext)_localctx).instruction = instruction();
						}
						} 
					}
					setState(223);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(224);
				match(T__31);
				}
				break;
			case 2:
				{
				setState(225);
				((Bloc_codeContext)_localctx).instruction = instruction();
				}
				break;
			}

			            ((Bloc_codeContext)_localctx).code = ((Bloc_codeContext)_localctx).instruction.code;
			        
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
		enterRule(_localctx, 18, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(230);
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
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		case 5:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5`\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6{\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0087\n\6"+
		"\f\6\16\6\u008a\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009f\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00c8\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u00da\n\t\3\n\3\n\7\n\u00de\n\n\f\n\16\n\u00e1\13\n\3\n\3"+
		"\n\5\n\u00e5\n\n\3\n\3\n\3\13\6\13\u00ea\n\13\r\13\16\13\u00eb\3\13\2"+
		"\4\n\f\f\2\4\6\b\n\f\16\20\22\24\2\r\3\2\7\b\3\2\t\n\3\2\13\f\3\2\r\16"+
		"\3\2\24\25\3\2\26\27\3\2\31\32\3\2\33\34\3\2\35\36\3\2\37 \4\2\30\30("+
		"(\2\u0103\2\33\3\2\2\2\4:\3\2\2\2\6L\3\2\2\2\b_\3\2\2\2\nz\3\2\2\2\f\u009e"+
		"\3\2\2\2\16\u00c7\3\2\2\2\20\u00d9\3\2\2\2\22\u00e4\3\2\2\2\24\u00e9\3"+
		"\2\2\2\26\27\5\4\3\2\27\30\b\2\1\2\30\32\3\2\2\2\31\26\3\2\2\2\32\35\3"+
		"\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35\33\3\2\2\2\36 \7(\2"+
		"\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\")\3\2\2\2#!\3\2\2\2"+
		"$%\5\b\5\2%&\b\2\1\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2"+
		"\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-.\b\2\1\2.\3\3\2\2\2/\60\7%\2\2\60\61"+
		"\7&\2\2\61\62\7\3\2\2\62\63\5\b\5\2\63\64\b\3\1\2\64;\3\2\2\2\65\66\7"+
		"%\2\2\66\67\7&\2\2\678\5\24\13\289\b\3\1\29;\3\2\2\2:/\3\2\2\2:\65\3\2"+
		"\2\2;\5\3\2\2\2<=\7&\2\2=>\7\4\2\2>?\5\n\6\2?@\b\4\1\2@M\3\2\2\2AB\7&"+
		"\2\2BC\7\5\2\2CM\b\4\1\2DE\7&\2\2EF\7\6\2\2FM\b\4\1\2GH\7&\2\2HI\7\3\2"+
		"\2IJ\5\n\6\2JK\b\4\1\2KM\3\2\2\2L<\3\2\2\2LA\3\2\2\2LD\3\2\2\2LG\3\2\2"+
		"\2M\7\3\2\2\2NO\5\6\4\2OP\5\24\13\2PQ\b\5\1\2Q`\3\2\2\2RS\5\20\t\2ST\b"+
		"\5\1\2T`\3\2\2\2UV\5\16\b\2VW\b\5\1\2W`\3\2\2\2XY\5\n\6\2YZ\5\24\13\2"+
		"Z[\b\5\1\2[`\3\2\2\2\\]\5\24\13\2]^\b\5\1\2^`\3\2\2\2_N\3\2\2\2_R\3\2"+
		"\2\2_U\3\2\2\2_X\3\2\2\2_\\\3\2\2\2`\t\3\2\2\2a{\b\6\1\2bc\t\2\2\2cd\7"+
		"#\2\2de\7&\2\2ef\7$\2\2f{\b\6\1\2gh\t\3\2\2hi\5\n\6\nij\b\6\1\2j{\3\2"+
		"\2\2kl\7#\2\2lm\5\n\6\2mn\7$\2\2no\b\6\1\2o{\3\2\2\2pq\7\16\2\2qr\7*\2"+
		"\2r{\b\6\1\2st\7*\2\2t{\b\6\1\2uv\7\16\2\2vw\7&\2\2w{\b\6\1\2xy\7&\2\2"+
		"y{\b\6\1\2za\3\2\2\2zb\3\2\2\2zg\3\2\2\2zk\3\2\2\2zp\3\2\2\2zs\3\2\2\2"+
		"zu\3\2\2\2zx\3\2\2\2{\u0088\3\2\2\2|}\f\b\2\2}~\t\4\2\2~\177\5\n\6\t\177"+
		"\u0080\b\6\1\2\u0080\u0087\3\2\2\2\u0081\u0082\f\7\2\2\u0082\u0083\t\5"+
		"\2\2\u0083\u0084\5\n\6\b\u0084\u0085\b\6\1\2\u0085\u0087\3\2\2\2\u0086"+
		"|\3\2\2\2\u0086\u0081\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\13\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c"+
		"\b\7\1\2\u008c\u008d\7\17\2\2\u008d\u009f\b\7\1\2\u008e\u008f\7\20\2\2"+
		"\u008f\u009f\b\7\1\2\u0090\u0091\7#\2\2\u0091\u0092\5\f\7\2\u0092\u0093"+
		"\7$\2\2\u0093\u0094\b\7\1\2\u0094\u009f\3\2\2\2\u0095\u0096\7\21\2\2\u0096"+
		"\u0097\5\f\7\6\u0097\u0098\b\7\1\2\u0098\u009f\3\2\2\2\u0099\u009a\5\n"+
		"\6\2\u009a\u009b\7,\2\2\u009b\u009c\5\n\6\2\u009c\u009d\b\7\1\2\u009d"+
		"\u009f\3\2\2\2\u009e\u008b\3\2\2\2\u009e\u008e\3\2\2\2\u009e\u0090\3\2"+
		"\2\2\u009e\u0095\3\2\2\2\u009e\u0099\3\2\2\2\u009f\u00ac\3\2\2\2\u00a0"+
		"\u00a1\f\5\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3\5\f\7\6\u00a3\u00a4\b"+
		"\7\1\2\u00a4\u00ab\3\2\2\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\23\2\2\u00a7"+
		"\u00a8\5\f\7\5\u00a8\u00a9\b\7\1\2\u00a9\u00ab\3\2\2\2\u00aa\u00a0\3\2"+
		"\2\2\u00aa\u00a5\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\r\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\t\6\2\2"+
		"\u00b0\u00b1\5\f\7\2\u00b1\u00b2\5\22\n\2\u00b2\u00b3\b\b\1\2\u00b3\u00c8"+
		"\3\2\2\2\u00b4\u00b5\t\7\2\2\u00b5\u00b6\7#\2\2\u00b6\u00b7\5\6\4\2\u00b7"+
		"\u00b8\7\30\2\2\u00b8\u00b9\5\f\7\2\u00b9\u00ba\7\30\2\2\u00ba\u00bb\5"+
		"\6\4\2\u00bb\u00bc\7$\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00be\b\b\1\2\u00be"+
		"\u00c8\3\2\2\2\u00bf\u00c0\t\b\2\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\t"+
		"\t\2\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\5\f\7\2\u00c4\u00c5\7$\2\2\u00c5"+
		"\u00c6\b\b\1\2\u00c6\u00c8\3\2\2\2\u00c7\u00af\3\2\2\2\u00c7\u00b4\3\2"+
		"\2\2\u00c7\u00bf\3\2\2\2\u00c8\17\3\2\2\2\u00c9\u00ca\t\n\2\2\u00ca\u00cb"+
		"\7#\2\2\u00cb\u00cc\5\f\7\2\u00cc\u00cd\7$\2\2\u00cd\u00ce\5\22\n\2\u00ce"+
		"\u00cf\t\13\2\2\u00cf\u00d0\5\22\n\2\u00d0\u00d1\b\t\1\2\u00d1\u00da\3"+
		"\2\2\2\u00d2\u00d3\t\n\2\2\u00d3\u00d4\7#\2\2\u00d4\u00d5\5\f\7\2\u00d5"+
		"\u00d6\7$\2\2\u00d6\u00d7\5\22\n\2\u00d7\u00d8\b\t\1\2\u00d8\u00da\3\2"+
		"\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00d2\3\2\2\2\u00da\21\3\2\2\2\u00db\u00df"+
		"\7!\2\2\u00dc\u00de\5\b\5\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e2\u00e5\7\"\2\2\u00e3\u00e5\5\b\5\2\u00e4\u00db\3\2\2\2\u00e4"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\n\1\2\u00e7\23\3\2\2"+
		"\2\u00e8\u00ea\t\f\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\25\3\2\2\2\23\33!):L_z\u0086\u0088"+
		"\u009e\u00aa\u00ac\u00c7\u00d9\u00df\u00e4\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}