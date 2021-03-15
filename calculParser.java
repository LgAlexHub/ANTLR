// Generated from calcul.g4 by ANTLR 4.9.1
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
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

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
		UNMATCH=44;
	public static final int
		RULE_start = 0, RULE_decl = 1, RULE_assignation = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_condition = 5, RULE_loop = 6, RULE_branchements = 7, 
		RULE_bloc_code = 8, RULE_fonction = 9, RULE_params = 10, RULE_args = 11, 
		RULE_finInstruction = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl", "assignation", "instruction", "expression", "condition", 
			"loop", "branchements", "bloc_code", "fonction", "params", "args", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'++'", "'--'", "'READ'", "'read'", "'WRITE'", "'write'", 
			"'*'", "'/'", "'+'", "'-'", "'true'", "'false'", "'!'", "'&&'", "'||'", 
			"'while'", "'WHILE'", "'for'", "'FOR'", "';'", "'repeat'", "'REPEAT'", 
			"'until'", "'UNTIL'", "'if'", "'IF'", "'else'", "'ELSE'", "'{'", "'}'", 
			"','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "PARENTHESE_O", 
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					((StartContext)_localctx).decl = decl();
					 _localctx.code += ((StartContext)_localctx).decl.code; 
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 _localctx.code += "  JUMP Main\n"; 
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					match(NEWLINE);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(41);
					((StartContext)_localctx).fonction = fonction();
					 _localctx.code += ((StartContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					match(NEWLINE);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL Main\n"; 
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					((StartContext)_localctx).instruction = instruction();
					 _localctx.code += ((StartContext)_localctx).instruction.code; 
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(TYPE);
				setState(67);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(68);
				match(T__0);
				setState(69);
				((DeclContext)_localctx).instruction = instruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        ((DeclContext)_localctx).code = ((DeclContext)_localctx).instruction.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(TYPE);
				setState(73);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(74);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(80);
				match(T__1);
				setState(81);
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(85);
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
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(88);
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
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(91);
				match(T__0);
				setState(92);
				((AssignationContext)_localctx).expression = expression(0);
				  
				            
				            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            if(at.adresse<0){
				                ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREL "+at.adresse+"\n";
				            }else{
				                ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code+"STOREG "+at.adresse+"\n";
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
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((InstructionContext)_localctx).assignation = assignation();
				setState(98);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				((InstructionContext)_localctx).branchements = branchements();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).branchements.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				((InstructionContext)_localctx).loop = loop();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loop.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				((InstructionContext)_localctx).expression = expression(0);
				setState(108);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
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
		public Token ENTIER;
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
		public TerminalNode ENTIER() { return getToken(calculParser.ENTIER, 0); }
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
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				match(PARENTHESE_O);
				setState(119);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(120);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  read_func((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				    
				}
				break;
			case 3:
				{
				setState(122);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(123);
				((ExpressionContext)_localctx).a = expression(9);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "WRITE\nPOP\n";
				    
				}
				break;
			case 4:
				{
				setState(126);
				match(PARENTHESE_O);
				setState(127);
				((ExpressionContext)_localctx).a = expression(0);
				setState(128);
				match(PARENTHESE_F);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				    
				}
				break;
			case 5:
				{
				setState(131);
				match(T__11);
				setState(132);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI -"+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 6:
				{
				setState(134);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				        ((ExpressionContext)_localctx).code =  "PUSHI "+((ExpressionContext)_localctx).ENTIER.getText()+"\n";
				        
				}
				break;
			case 7:
				{
				setState(136);
				match(T__11);
				setState(137);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        int addr = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        if (addr < 0){
				            ((ExpressionContext)_localctx).code = "PUSHL "+addr;
				            _localctx.code+="PUSHI -1\n MUL\n";
				        }else{
				            ((ExpressionContext)_localctx).code = "PUSHG "+addr;
				            _localctx.code+="PUSHI -1\n MUL\n";
				        }
				        
				    
				}
				break;
			case 8:
				{
				setState(139);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        int addr = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        if (addr < 0){
				            ((ExpressionContext)_localctx).code =  "PUSHL "+addr+"\n";
				        }else{
				            ((ExpressionContext)_localctx).code =  "PUSHG "+addr+"\n";
				        }
				        
				    
				}
				break;
			case 9:
				{
				setState(141);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(142);
				match(PARENTHESE_O);
				setState(143);
				((ExpressionContext)_localctx).args = args();
				setState(144);
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
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(159);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(150);
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
						setState(151);
						((ExpressionContext)_localctx).b = expression(8);

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
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(155);
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
						setState(156);
						((ExpressionContext)_localctx).b = expression(7);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
						                  _localctx.code+=((ExpressionContext)_localctx).b.code;
						                  _localctx.code+=evalexpr(((ExpressionContext)_localctx).op.getText());
						                  
						}
						break;
					}
					} 
				}
				setState(163);
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
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(165);
				match(T__12);

				        ((ConditionContext)_localctx).code = "PUSHI 1\n";
					
				}
				break;
			case 2:
				{
				setState(167);
				match(T__13);

				        ((ConditionContext)_localctx).code = "PUSHI 0\n";
				    
				}
				break;
			case 3:
				{
				setState(169);
				match(PARENTHESE_O);
				setState(170);
				((ConditionContext)_localctx).k = ((ConditionContext)_localctx).condition = condition(0);
				setState(171);
				match(PARENTHESE_F);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).k.code;
				    
				}
				break;
			case 4:
				{
				setState(174);
				match(T__14);
				setState(175);
				((ConditionContext)_localctx).condition = condition(4);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code;
				        _localctx.code+="PUSHI 0\n";
				        _localctx.code+="EQUAL\n";
				    
				}
				break;
			case 5:
				{
				setState(178);
				((ConditionContext)_localctx).a = expression(0);
				setState(179);
				((ConditionContext)_localctx).OPERATORLOG = match(OPERATORLOG);
				setState(180);
				((ConditionContext)_localctx).b = expression(0);

				        ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				        _localctx.code+=((ConditionContext)_localctx).b.code;
				        _localctx.code+=evalexprconditions((((ConditionContext)_localctx).OPERATORLOG!=null?((ConditionContext)_localctx).OPERATORLOG.getText():null));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(195);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(185);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(186);
						match(T__15);
						setState(187);
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
						setState(190);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(191);
						match(T__16);
						setState(192);
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
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(201);
				((LoopContext)_localctx).a = condition(0);
				setState(202);
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
				setState(205);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(206);
				match(PARENTHESE_O);
				setState(207);
				((LoopContext)_localctx).d = assignation();
				setState(208);
				match(T__21);
				setState(209);
				((LoopContext)_localctx).e = condition(0);
				setState(210);
				match(T__21);
				setState(211);
				((LoopContext)_localctx).f = assignation();
				setState(212);
				match(PARENTHESE_F);
				setState(213);
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
				setState(216);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				((LoopContext)_localctx).g = bloc_code();
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				match(PARENTHESE_O);
				setState(220);
				((LoopContext)_localctx).h = condition(0);
				setState(221);
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
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				match(PARENTHESE_O);
				setState(228);
				((BranchementsContext)_localctx).a = condition(0);
				setState(229);
				match(PARENTHESE_F);
				setState(230);
				((BranchementsContext)_localctx).b = bloc_code();
				setState(231);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(232);
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
				setState(235);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				match(PARENTHESE_O);
				setState(237);
				((BranchementsContext)_localctx).a = condition(0);
				setState(238);
				match(PARENTHESE_F);
				setState(239);
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
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(244);
				match(T__30);
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(245);
						((Bloc_codeContext)_localctx).instruction = instruction();
						}
						} 
					}
					setState(250);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(251);
				match(T__31);
				}
				break;
			case 2:
				{
				setState(252);
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public DeclContext decl;
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
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
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
		enterRule(_localctx, 18, RULE_fonction);
		 tablesSymboles.newTableLocale();tablesSymboles.putVar("RETURN__FUNC_RES","int"); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(TYPE);
			 
			        
			setState(259);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(260);
			match(PARENTHESE_O);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(261);
				params();
				}
			}

			setState(264);
			match(PARENTHESE_F);
			 
			           ((FonctionContext)_localctx).code =  "LABEL "+(((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
			        
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(266);
					((FonctionContext)_localctx).decl = decl();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			 
			            ((FonctionContext)_localctx).code =  ((FonctionContext)_localctx).decl.code; 
			        
			setState(273);
			((FonctionContext)_localctx).a = bloc_code();

			           ((FonctionContext)_localctx).code =  ((FonctionContext)_localctx).a.code+"RETURN\n";
			        
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
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(277);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 
			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			        
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(279);
				match(T__32);
				setState(280);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(281);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				                tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				            
				}
				}
				setState(287);
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
		enterRule(_localctx, 22, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(288);
				((ArgsContext)_localctx).expression = expression(0);
				 
				        _localctx.size+=1;
				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code; 
				    
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__32) {
					{
					{
					setState(290);
					match(T__32);
					setState(291);
					((ArgsContext)_localctx).expression = expression(0);
					 
					        
					        _localctx.size+=1;
					        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;        
					    
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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
		enterRule(_localctx, 24, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(301);
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
				setState(304); 
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
		case 5:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2"+
		"\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2\3"+
		"\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4b\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5u\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0096\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a2\n\6\f\6\16\6\u00a5"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u00ba\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\u00c6\n\7\f\7\16\7\u00c9\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e3\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00f5"+
		"\n\t\3\n\3\n\7\n\u00f9\n\n\f\n\16\n\u00fc\13\n\3\n\3\n\5\n\u0100\n\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u0109\n\13\3\13\3\13\3\13\7\13\u010e"+
		"\n\13\f\13\16\13\u0111\13\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u011e\n\f\f\f\16\f\u0121\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0129"+
		"\n\r\f\r\16\r\u012c\13\r\5\r\u012e\n\r\3\16\6\16\u0131\n\16\r\16\16\16"+
		"\u0132\3\16\2\4\n\f\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\r\3\2\7\b\3"+
		"\2\t\n\3\2\13\f\3\2\r\16\3\2\24\25\3\2\26\27\3\2\31\32\3\2\33\34\3\2\35"+
		"\36\3\2\37 \4\2\30\30))\2\u014f\2!\3\2\2\2\4O\3\2\2\2\6a\3\2\2\2\bt\3"+
		"\2\2\2\n\u0095\3\2\2\2\f\u00b9\3\2\2\2\16\u00e2\3\2\2\2\20\u00f4\3\2\2"+
		"\2\22\u00ff\3\2\2\2\24\u0103\3\2\2\2\26\u0116\3\2\2\2\30\u012d\3\2\2\2"+
		"\32\u0130\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2\36 \3\2\2\2\37\34\3\2\2"+
		"\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$(\b\2\1\2%\'"+
		"\7)\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\60\3\2\2\2*(\3\2\2\2"+
		"+,\5\24\13\2,-\b\2\1\2-/\3\2\2\2.+\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60"+
		"\61\3\2\2\2\61\66\3\2\2\2\62\60\3\2\2\2\63\65\7)\2\2\64\63\3\2\2\2\65"+
		"8\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29?\b\2\1"+
		"\2:;\5\b\5\2;<\b\2\1\2<>\3\2\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2"+
		"\2@B\3\2\2\2A?\3\2\2\2BC\b\2\1\2C\3\3\2\2\2DE\7&\2\2EF\7\'\2\2FG\7\3\2"+
		"\2GH\5\b\5\2HI\b\3\1\2IP\3\2\2\2JK\7&\2\2KL\7\'\2\2LM\5\32\16\2MN\b\3"+
		"\1\2NP\3\2\2\2OD\3\2\2\2OJ\3\2\2\2P\5\3\2\2\2QR\7\'\2\2RS\7\4\2\2ST\5"+
		"\n\6\2TU\b\4\1\2Ub\3\2\2\2VW\7\'\2\2WX\7\5\2\2Xb\b\4\1\2YZ\7\'\2\2Z[\7"+
		"\6\2\2[b\b\4\1\2\\]\7\'\2\2]^\7\3\2\2^_\5\n\6\2_`\b\4\1\2`b\3\2\2\2aQ"+
		"\3\2\2\2aV\3\2\2\2aY\3\2\2\2a\\\3\2\2\2b\7\3\2\2\2cd\5\6\4\2de\5\32\16"+
		"\2ef\b\5\1\2fu\3\2\2\2gh\5\20\t\2hi\b\5\1\2iu\3\2\2\2jk\5\16\b\2kl\b\5"+
		"\1\2lu\3\2\2\2mn\5\n\6\2no\5\32\16\2op\b\5\1\2pu\3\2\2\2qr\5\32\16\2r"+
		"s\b\5\1\2su\3\2\2\2tc\3\2\2\2tg\3\2\2\2tj\3\2\2\2tm\3\2\2\2tq\3\2\2\2"+
		"u\t\3\2\2\2v\u0096\b\6\1\2wx\t\2\2\2xy\7$\2\2yz\7\'\2\2z{\7%\2\2{\u0096"+
		"\b\6\1\2|}\t\3\2\2}~\5\n\6\13~\177\b\6\1\2\177\u0096\3\2\2\2\u0080\u0081"+
		"\7$\2\2\u0081\u0082\5\n\6\2\u0082\u0083\7%\2\2\u0083\u0084\b\6\1\2\u0084"+
		"\u0096\3\2\2\2\u0085\u0086\7\16\2\2\u0086\u0087\7+\2\2\u0087\u0096\b\6"+
		"\1\2\u0088\u0089\7+\2\2\u0089\u0096\b\6\1\2\u008a\u008b\7\16\2\2\u008b"+
		"\u008c\7\'\2\2\u008c\u0096\b\6\1\2\u008d\u008e\7\'\2\2\u008e\u0096\b\6"+
		"\1\2\u008f\u0090\7\'\2\2\u0090\u0091\7$\2\2\u0091\u0092\5\30\r\2\u0092"+
		"\u0093\7%\2\2\u0093\u0094\b\6\1\2\u0094\u0096\3\2\2\2\u0095v\3\2\2\2\u0095"+
		"w\3\2\2\2\u0095|\3\2\2\2\u0095\u0080\3\2\2\2\u0095\u0085\3\2\2\2\u0095"+
		"\u0088\3\2\2\2\u0095\u008a\3\2\2\2\u0095\u008d\3\2\2\2\u0095\u008f\3\2"+
		"\2\2\u0096\u00a3\3\2\2\2\u0097\u0098\f\t\2\2\u0098\u0099\t\4\2\2\u0099"+
		"\u009a\5\n\6\n\u009a\u009b\b\6\1\2\u009b\u00a2\3\2\2\2\u009c\u009d\f\b"+
		"\2\2\u009d\u009e\t\5\2\2\u009e\u009f\5\n\6\t\u009f\u00a0\b\6\1\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1\u009c\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\13\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a7\b\7\1\2\u00a7\u00a8\7\17\2\2\u00a8\u00ba\b\7\1\2"+
		"\u00a9\u00aa\7\20\2\2\u00aa\u00ba\b\7\1\2\u00ab\u00ac\7$\2\2\u00ac\u00ad"+
		"\5\f\7\2\u00ad\u00ae\7%\2\2\u00ae\u00af\b\7\1\2\u00af\u00ba\3\2\2\2\u00b0"+
		"\u00b1\7\21\2\2\u00b1\u00b2\5\f\7\6\u00b2\u00b3\b\7\1\2\u00b3\u00ba\3"+
		"\2\2\2\u00b4\u00b5\5\n\6\2\u00b5\u00b6\7-\2\2\u00b6\u00b7\5\n\6\2\u00b7"+
		"\u00b8\b\7\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00a6\3\2\2\2\u00b9\u00a9\3\2"+
		"\2\2\u00b9\u00ab\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b4\3\2\2\2\u00ba"+
		"\u00c7\3\2\2\2\u00bb\u00bc\f\5\2\2\u00bc\u00bd\7\22\2\2\u00bd\u00be\5"+
		"\f\7\6\u00be\u00bf\b\7\1\2\u00bf\u00c6\3\2\2\2\u00c0\u00c1\f\4\2\2\u00c1"+
		"\u00c2\7\23\2\2\u00c2\u00c3\5\f\7\5\u00c3\u00c4\b\7\1\2\u00c4\u00c6\3"+
		"\2\2\2\u00c5\u00bb\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\r\3\2\2\2\u00c9\u00c7\3\2\2\2"+
		"\u00ca\u00cb\t\6\2\2\u00cb\u00cc\5\f\7\2\u00cc\u00cd\5\22\n\2\u00cd\u00ce"+
		"\b\b\1\2\u00ce\u00e3\3\2\2\2\u00cf\u00d0\t\7\2\2\u00d0\u00d1\7$\2\2\u00d1"+
		"\u00d2\5\6\4\2\u00d2\u00d3\7\30\2\2\u00d3\u00d4\5\f\7\2\u00d4\u00d5\7"+
		"\30\2\2\u00d5\u00d6\5\6\4\2\u00d6\u00d7\7%\2\2\u00d7\u00d8\5\22\n\2\u00d8"+
		"\u00d9\b\b\1\2\u00d9\u00e3\3\2\2\2\u00da\u00db\t\b\2\2\u00db\u00dc\5\22"+
		"\n\2\u00dc\u00dd\t\t\2\2\u00dd\u00de\7$\2\2\u00de\u00df\5\f\7\2\u00df"+
		"\u00e0\7%\2\2\u00e0\u00e1\b\b\1\2\u00e1\u00e3\3\2\2\2\u00e2\u00ca\3\2"+
		"\2\2\u00e2\u00cf\3\2\2\2\u00e2\u00da\3\2\2\2\u00e3\17\3\2\2\2\u00e4\u00e5"+
		"\t\n\2\2\u00e5\u00e6\7$\2\2\u00e6\u00e7\5\f\7\2\u00e7\u00e8\7%\2\2\u00e8"+
		"\u00e9\5\22\n\2\u00e9\u00ea\t\13\2\2\u00ea\u00eb\5\22\n\2\u00eb\u00ec"+
		"\b\t\1\2\u00ec\u00f5\3\2\2\2\u00ed\u00ee\t\n\2\2\u00ee\u00ef\7$\2\2\u00ef"+
		"\u00f0\5\f\7\2\u00f0\u00f1\7%\2\2\u00f1\u00f2\5\22\n\2\u00f2\u00f3\b\t"+
		"\1\2\u00f3\u00f5\3\2\2\2\u00f4\u00e4\3\2\2\2\u00f4\u00ed\3\2\2\2\u00f5"+
		"\21\3\2\2\2\u00f6\u00fa\7!\2\2\u00f7\u00f9\5\b\5\2\u00f8\u00f7\3\2\2\2"+
		"\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd"+
		"\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\7\"\2\2\u00fe\u0100\5\b\5\2\u00ff"+
		"\u00f6\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\b\n"+
		"\1\2\u0102\23\3\2\2\2\u0103\u0104\7&\2\2\u0104\u0105\b\13\1\2\u0105\u0106"+
		"\7\'\2\2\u0106\u0108\7$\2\2\u0107\u0109\5\26\f\2\u0108\u0107\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7%\2\2\u010b\u010f\b\13"+
		"\1\2\u010c\u010e\5\4\3\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0112\u0113\b\13\1\2\u0113\u0114\5\22\n\2\u0114\u0115\b\13\1\2\u0115"+
		"\25\3\2\2\2\u0116\u0117\7&\2\2\u0117\u0118\7\'\2\2\u0118\u011f\b\f\1\2"+
		"\u0119\u011a\7#\2\2\u011a\u011b\7&\2\2\u011b\u011c\7\'\2\2\u011c\u011e"+
		"\b\f\1\2\u011d\u0119\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\27\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\5\n\6"+
		"\2\u0123\u012a\b\r\1\2\u0124\u0125\7#\2\2\u0125\u0126\5\n\6\2\u0126\u0127"+
		"\b\r\1\2\u0127\u0129\3\2\2\2\u0128\u0124\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2"+
		"\2\2\u012d\u0122\3\2\2\2\u012d\u012e\3\2\2\2\u012e\31\3\2\2\2\u012f\u0131"+
		"\t\f\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\33\3\2\2\2\32!(\60\66?Oat\u0095\u00a1\u00a3\u00b9"+
		"\u00c5\u00c7\u00e2\u00f4\u00fa\u00ff\u0108\u010f\u011f\u012a\u012d\u0132";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}