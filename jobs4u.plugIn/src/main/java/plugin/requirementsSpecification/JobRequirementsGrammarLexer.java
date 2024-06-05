// Generated from C:/Users/Marco/ISEP/2 ano 2 Semestre/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package plugin.requirementsSpecification;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JobRequirementsGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, BOOLEAN=6, INTEGER=7, REAL=8, 
		COMMENT=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "STRING", "BOOLEAN", "INTEGER", "REAL", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Requirement'", "'TrueOrFalse:'", "'ShortAnswer:'", "'Integer:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "STRING", "BOOLEAN", "INTEGER", "REAL", 
			"COMMENT", "WS"
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


	public JobRequirementsGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JobRequirementsGrammar.g4"; }

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
		"\u0004\u0000\n\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004I\b\u0004\n\u0004\f\u0004L\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005Y\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006^\b\u0006\n\u0006\f\u0006a\t"+
		"\u0006\u0003\u0006c\b\u0006\u0001\u0007\u0004\u0007f\b\u0007\u000b\u0007"+
		"\f\u0007g\u0001\u0007\u0001\u0007\u0004\u0007l\b\u0007\u000b\u0007\f\u0007"+
		"m\u0001\b\u0001\b\u0005\br\b\b\n\b\f\bu\t\b\u0001\b\u0001\b\u0001\t\u0004"+
		"\tz\b\t\u000b\t\f\t{\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0001\u0000\u0005\u0002\u0000\"\"\\\\\u0001\u000019\u0001\u000009\u0002"+
		"\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0087\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003"+
		"!\u0001\u0000\u0000\u0000\u0005.\u0001\u0000\u0000\u0000\u0007;\u0001"+
		"\u0000\u0000\u0000\tD\u0001\u0000\u0000\u0000\u000bX\u0001\u0000\u0000"+
		"\u0000\rb\u0001\u0000\u0000\u0000\u000fe\u0001\u0000\u0000\u0000\u0011"+
		"o\u0001\u0000\u0000\u0000\u0013y\u0001\u0000\u0000\u0000\u0015\u0016\u0005"+
		"R\u0000\u0000\u0016\u0017\u0005e\u0000\u0000\u0017\u0018\u0005q\u0000"+
		"\u0000\u0018\u0019\u0005u\u0000\u0000\u0019\u001a\u0005i\u0000\u0000\u001a"+
		"\u001b\u0005r\u0000\u0000\u001b\u001c\u0005e\u0000\u0000\u001c\u001d\u0005"+
		"m\u0000\u0000\u001d\u001e\u0005e\u0000\u0000\u001e\u001f\u0005n\u0000"+
		"\u0000\u001f \u0005t\u0000\u0000 \u0002\u0001\u0000\u0000\u0000!\"\u0005"+
		"T\u0000\u0000\"#\u0005r\u0000\u0000#$\u0005u\u0000\u0000$%\u0005e\u0000"+
		"\u0000%&\u0005O\u0000\u0000&\'\u0005r\u0000\u0000\'(\u0005F\u0000\u0000"+
		"()\u0005a\u0000\u0000)*\u0005l\u0000\u0000*+\u0005s\u0000\u0000+,\u0005"+
		"e\u0000\u0000,-\u0005:\u0000\u0000-\u0004\u0001\u0000\u0000\u0000./\u0005"+
		"S\u0000\u0000/0\u0005h\u0000\u000001\u0005o\u0000\u000012\u0005r\u0000"+
		"\u000023\u0005t\u0000\u000034\u0005A\u0000\u000045\u0005n\u0000\u0000"+
		"56\u0005s\u0000\u000067\u0005w\u0000\u000078\u0005e\u0000\u000089\u0005"+
		"r\u0000\u00009:\u0005:\u0000\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005"+
		"I\u0000\u0000<=\u0005n\u0000\u0000=>\u0005t\u0000\u0000>?\u0005e\u0000"+
		"\u0000?@\u0005g\u0000\u0000@A\u0005e\u0000\u0000AB\u0005r\u0000\u0000"+
		"BC\u0005:\u0000\u0000C\b\u0001\u0000\u0000\u0000DJ\u0005\"\u0000\u0000"+
		"EI\b\u0000\u0000\u0000FG\u0005\\\u0000\u0000GI\t\u0000\u0000\u0000HE\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000"+
		"JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\"\u0000\u0000N\n\u0001\u0000"+
		"\u0000\u0000OP\u0005t\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005u\u0000"+
		"\u0000RY\u0005e\u0000\u0000ST\u0005f\u0000\u0000TU\u0005a\u0000\u0000"+
		"UV\u0005l\u0000\u0000VW\u0005s\u0000\u0000WY\u0005e\u0000\u0000XO\u0001"+
		"\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000Y\f\u0001\u0000\u0000\u0000"+
		"Zc\u00050\u0000\u0000[_\u0007\u0001\u0000\u0000\\^\u0007\u0002\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000bZ\u0001\u0000\u0000\u0000b[\u0001\u0000\u0000\u0000c\u000e"+
		"\u0001\u0000\u0000\u0000df\u0007\u0002\u0000\u0000ed\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0005.\u0000\u0000jl\u0007\u0002"+
		"\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0010\u0001\u0000\u0000"+
		"\u0000os\u0005#\u0000\u0000pr\b\u0003\u0000\u0000qp\u0001\u0000\u0000"+
		"\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0006"+
		"\b\u0000\u0000w\u0012\u0001\u0000\u0000\u0000xz\u0007\u0004\u0000\u0000"+
		"yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006\t\u0000"+
		"\u0000~\u0014\u0001\u0000\u0000\u0000\n\u0000HJX_bgms{\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}