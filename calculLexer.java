// Generated from calcul.g4 by ANTLR 4.9
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, PARENTHESE_O=13, PARENTHESE_F=14, TYPE=15, 
		IDENTIFIANT=16, LOOP_WORD=17, NEWLINE=18, WS=19, ENTIER=20, OPERATOR=21, 
		UNMATCH=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "PARENTHESE_O", "PARENTHESE_F", "TYPE", "IDENTIFIANT", 
			"LOOP_WORD", "NEWLINE", "WS", "ENTIER", "OPERATOR", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'READ'", "'read'", "'WRITE'", "'write'", "'*'", "'/'", 
			"'+'", "'-'", "'true'", "'false'", "';'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "PARENTHESE_O", "PARENTHESE_F", "TYPE", "IDENTIFIANT", "LOOP_WORD", 
			"NEWLINE", "WS", "ENTIER", "OPERATOR", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20i\n\20\3\21\6\21l\n\21\r\21\16\21m\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22x\n\22\3\23\5\23{\n\23\3\23\3\23"+
		"\3\23\3\23\3\24\6\24\u0082\n\24\r\24\16\24\u0083\3\24\3\24\3\25\6\25\u0089"+
		"\n\25\r\25\16\25\u008a\3\26\3\26\3\27\3\27\3\27\3\27\2\2\30\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30\3\2\4\4\2\13\13\"\"\5\2,-//\61\61\2\u0097\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2"+
		"\5\61\3\2\2\2\7\66\3\2\2\2\t;\3\2\2\2\13A\3\2\2\2\rG\3\2\2\2\17I\3\2\2"+
		"\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27T\3\2\2\2\31Z\3\2\2\2\33\\\3"+
		"\2\2\2\35^\3\2\2\2\37h\3\2\2\2!k\3\2\2\2#w\3\2\2\2%z\3\2\2\2\'\u0081\3"+
		"\2\2\2)\u0088\3\2\2\2+\u008c\3\2\2\2-\u008e\3\2\2\2/\60\7?\2\2\60\4\3"+
		"\2\2\2\61\62\7T\2\2\62\63\7G\2\2\63\64\7C\2\2\64\65\7F\2\2\65\6\3\2\2"+
		"\2\66\67\7t\2\2\678\7g\2\289\7c\2\29:\7f\2\2:\b\3\2\2\2;<\7Y\2\2<=\7T"+
		"\2\2=>\7K\2\2>?\7V\2\2?@\7G\2\2@\n\3\2\2\2AB\7y\2\2BC\7t\2\2CD\7k\2\2"+
		"DE\7v\2\2EF\7g\2\2F\f\3\2\2\2GH\7,\2\2H\16\3\2\2\2IJ\7\61\2\2J\20\3\2"+
		"\2\2KL\7-\2\2L\22\3\2\2\2MN\7/\2\2N\24\3\2\2\2OP\7v\2\2PQ\7t\2\2QR\7w"+
		"\2\2RS\7g\2\2S\26\3\2\2\2TU\7h\2\2UV\7c\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2"+
		"Y\30\3\2\2\2Z[\7=\2\2[\32\3\2\2\2\\]\7*\2\2]\34\3\2\2\2^_\7+\2\2_\36\3"+
		"\2\2\2`a\7k\2\2ab\7p\2\2bi\7v\2\2cd\7h\2\2de\7n\2\2ef\7q\2\2fg\7c\2\2"+
		"gi\7v\2\2h`\3\2\2\2hc\3\2\2\2i \3\2\2\2jl\4c|\2kj\3\2\2\2lm\3\2\2\2mk"+
		"\3\2\2\2mn\3\2\2\2n\"\3\2\2\2op\7Y\2\2pq\7J\2\2qr\7K\2\2rs\7N\2\2sx\7"+
		"G\2\2tu\7H\2\2uv\7Q\2\2vx\7T\2\2wo\3\2\2\2wt\3\2\2\2x$\3\2\2\2y{\7\17"+
		"\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\f\2\2}~\3\2\2\2~\177\b\23\2\2\177"+
		"&\3\2\2\2\u0080\u0082\t\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\b\24\2\2\u0086(\3\2\2\2\u0087\u0089\4\62;\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b*\3\2\2\2"+
		"\u008c\u008d\t\3\2\2\u008d,\3\2\2\2\u008e\u008f\13\2\2\2\u008f\u0090\3"+
		"\2\2\2\u0090\u0091\b\27\2\2\u0091.\3\2\2\2\t\2hmwz\u0083\u008a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}