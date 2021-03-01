// Generated from c:\Users\alexl\Documents\Licence3\théorie_comppil\TP59\Src\calcul.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INPUT_FUNC=9, 
		PARENTHESE_O=10, PARENTHESE_F=11, TYPE=12, IDENTIFIANT=13, LOOP_WORD=14, 
		NEWLINE=15, WS=16, ENTIER=17, OPERATOR=18, UNMATCH=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "INPUT_FUNC", 
			"PARENTHESE_O", "PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", "NEWLINE", 
			"WS", "ENTIER", "OPERATOR", "UNMATCH"
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


	public calculLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "calcul.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\nJ\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\rX\n\r\3\16\6\16[\n\16\r\16\16\16\\\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17g\n\17\3\20\5\20j\n\20\3\20\3\20\3\20\3\20\3\21\6\21"+
		"q\n\21\r\21\16\21r\3\21\3\21\3\22\6\22x\n\22\r\22\16\22y\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\4\4\2\13\13\"\"\5\2,-"+
		"//\61\61\2\u0087\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3"+
		"\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\178\3\2\2\2\21>\3\2\2\2\23"+
		"I\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31W\3\2\2\2\33Z\3\2\2\2\35f\3\2\2\2"+
		"\37i\3\2\2\2!p\3\2\2\2#w\3\2\2\2%{\3\2\2\2\'}\3\2\2\2)*\7?\2\2*\4\3\2"+
		"\2\2+,\7,\2\2,\6\3\2\2\2-.\7\61\2\2.\b\3\2\2\2/\60\7-\2\2\60\n\3\2\2\2"+
		"\61\62\7/\2\2\62\f\3\2\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7w\2\2\66\67"+
		"\7g\2\2\67\16\3\2\2\289\7h\2\29:\7c\2\2:;\7n\2\2;<\7u\2\2<=\7g\2\2=\20"+
		"\3\2\2\2>?\7=\2\2?\22\3\2\2\2@A\7T\2\2AB\7G\2\2BC\7C\2\2CJ\7F\2\2DE\7"+
		"Y\2\2EF\7T\2\2FG\7K\2\2GH\7V\2\2HJ\7G\2\2I@\3\2\2\2ID\3\2\2\2J\24\3\2"+
		"\2\2KL\7*\2\2L\26\3\2\2\2MN\7+\2\2N\30\3\2\2\2OP\7k\2\2PQ\7p\2\2QX\7v"+
		"\2\2RS\7h\2\2ST\7n\2\2TU\7q\2\2UV\7c\2\2VX\7v\2\2WO\3\2\2\2WR\3\2\2\2"+
		"X\32\3\2\2\2Y[\4c|\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\34\3"+
		"\2\2\2^_\7Y\2\2_`\7J\2\2`a\7K\2\2ab\7N\2\2bg\7G\2\2cd\7H\2\2de\7Q\2\2"+
		"eg\7T\2\2f^\3\2\2\2fc\3\2\2\2g\36\3\2\2\2hj\7\17\2\2ih\3\2\2\2ij\3\2\2"+
		"\2jk\3\2\2\2kl\7\f\2\2lm\3\2\2\2mn\b\20\2\2n \3\2\2\2oq\t\2\2\2po\3\2"+
		"\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\b\21\2\2u\"\3\2\2\2vx\4"+
		"\62;\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z$\3\2\2\2{|\t\3\2\2|&\3"+
		"\2\2\2}~\13\2\2\2~\177\3\2\2\2\177\u0080\b\24\2\2\u0080(\3\2\2\2\n\2I"+
		"W\\firy\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}