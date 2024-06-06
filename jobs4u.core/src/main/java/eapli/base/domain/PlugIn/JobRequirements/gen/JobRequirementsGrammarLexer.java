// Generated from C:/Users/Marco/ISEP/2 ano 2 Semestre/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.JobRequirements.gen;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JobRequirementsGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, STRING=8, BOOLEAN=9, 
		INTEGER=10, REAL=11, COMMENT=12, WS=13, NONE=14, BACHELOR=15, MASTER=16, 
		DOCTORATE=17, JAVA=18, JAVASCRIPT=19, PHYTON=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "STRING", "BOOLEAN", 
			"INTEGER", "REAL", "COMMENT", "WS", "NONE", "BACHELOR", "MASTER", "DOCTORATE", 
			"JAVA", "JAVASCRIPT", "PHYTON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Requirement'", "'TrueOrFalse:'", "'AcademicDegree:'", "'ShortAnswer:'", 
			"'Programming Languages:'", "'Integer:'", "','", null, null, null, null, 
			null, null, "'None'", "'Bachelor'", "'Master'", "'Doctorate'", "'Java'", 
			"'JavaScript'", "'Phyton'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "STRING", "BOOLEAN", 
			"INTEGER", "REAL", "COMMENT", "WS", "NONE", "BACHELOR", "MASTER", "DOCTORATE", 
			"JAVA", "JAVASCRIPT", "PHYTON"
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
		"\u0004\u0000\u0014\u00f2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u0086\b\u0007\n\u0007\f\u0007\u0089\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\b\u0096\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u009b\b\t\n"+
		"\t\f\t\u009e\t\t\u0003\t\u00a0\b\t\u0001\n\u0004\n\u00a3\b\n\u000b\n\f"+
		"\n\u00a4\u0001\n\u0001\n\u0004\n\u00a9\b\n\u000b\n\f\n\u00aa\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00af\b\u000b\n\u000b\f\u000b\u00b2\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0004\f\u00b7\b\f\u000b\f\f\f\u00b8\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0000"+
		"\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0005"+
		"\u0002\u0000\"\"\\\\\u0001\u000019\u0001\u000009\u0002\u0000\n\n\r\r\u0003"+
		"\u0000\t\n\r\r  \u00fa\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001"+
		")\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u0005B\u0001"+
		"\u0000\u0000\u0000\u0007R\u0001\u0000\u0000\u0000\t_\u0001\u0000\u0000"+
		"\u0000\u000bv\u0001\u0000\u0000\u0000\r\u007f\u0001\u0000\u0000\u0000"+
		"\u000f\u0081\u0001\u0000\u0000\u0000\u0011\u0095\u0001\u0000\u0000\u0000"+
		"\u0013\u009f\u0001\u0000\u0000\u0000\u0015\u00a2\u0001\u0000\u0000\u0000"+
		"\u0017\u00ac\u0001\u0000\u0000\u0000\u0019\u00b6\u0001\u0000\u0000\u0000"+
		"\u001b\u00bc\u0001\u0000\u0000\u0000\u001d\u00c1\u0001\u0000\u0000\u0000"+
		"\u001f\u00ca\u0001\u0000\u0000\u0000!\u00d1\u0001\u0000\u0000\u0000#\u00db"+
		"\u0001\u0000\u0000\u0000%\u00e0\u0001\u0000\u0000\u0000\'\u00eb\u0001"+
		"\u0000\u0000\u0000)*\u0005R\u0000\u0000*+\u0005e\u0000\u0000+,\u0005q"+
		"\u0000\u0000,-\u0005u\u0000\u0000-.\u0005i\u0000\u0000./\u0005r\u0000"+
		"\u0000/0\u0005e\u0000\u000001\u0005m\u0000\u000012\u0005e\u0000\u0000"+
		"23\u0005n\u0000\u000034\u0005t\u0000\u00004\u0002\u0001\u0000\u0000\u0000"+
		"56\u0005T\u0000\u000067\u0005r\u0000\u000078\u0005u\u0000\u000089\u0005"+
		"e\u0000\u00009:\u0005O\u0000\u0000:;\u0005r\u0000\u0000;<\u0005F\u0000"+
		"\u0000<=\u0005a\u0000\u0000=>\u0005l\u0000\u0000>?\u0005s\u0000\u0000"+
		"?@\u0005e\u0000\u0000@A\u0005:\u0000\u0000A\u0004\u0001\u0000\u0000\u0000"+
		"BC\u0005A\u0000\u0000CD\u0005c\u0000\u0000DE\u0005a\u0000\u0000EF\u0005"+
		"d\u0000\u0000FG\u0005e\u0000\u0000GH\u0005m\u0000\u0000HI\u0005i\u0000"+
		"\u0000IJ\u0005c\u0000\u0000JK\u0005D\u0000\u0000KL\u0005e\u0000\u0000"+
		"LM\u0005g\u0000\u0000MN\u0005r\u0000\u0000NO\u0005e\u0000\u0000OP\u0005"+
		"e\u0000\u0000PQ\u0005:\u0000\u0000Q\u0006\u0001\u0000\u0000\u0000RS\u0005"+
		"S\u0000\u0000ST\u0005h\u0000\u0000TU\u0005o\u0000\u0000UV\u0005r\u0000"+
		"\u0000VW\u0005t\u0000\u0000WX\u0005A\u0000\u0000XY\u0005n\u0000\u0000"+
		"YZ\u0005s\u0000\u0000Z[\u0005w\u0000\u0000[\\\u0005e\u0000\u0000\\]\u0005"+
		"r\u0000\u0000]^\u0005:\u0000\u0000^\b\u0001\u0000\u0000\u0000_`\u0005"+
		"P\u0000\u0000`a\u0005r\u0000\u0000ab\u0005o\u0000\u0000bc\u0005g\u0000"+
		"\u0000cd\u0005r\u0000\u0000de\u0005a\u0000\u0000ef\u0005m\u0000\u0000"+
		"fg\u0005m\u0000\u0000gh\u0005i\u0000\u0000hi\u0005n\u0000\u0000ij\u0005"+
		"g\u0000\u0000jk\u0005 \u0000\u0000kl\u0005L\u0000\u0000lm\u0005a\u0000"+
		"\u0000mn\u0005n\u0000\u0000no\u0005g\u0000\u0000op\u0005u\u0000\u0000"+
		"pq\u0005a\u0000\u0000qr\u0005g\u0000\u0000rs\u0005e\u0000\u0000st\u0005"+
		"s\u0000\u0000tu\u0005:\u0000\u0000u\n\u0001\u0000\u0000\u0000vw\u0005"+
		"I\u0000\u0000wx\u0005n\u0000\u0000xy\u0005t\u0000\u0000yz\u0005e\u0000"+
		"\u0000z{\u0005g\u0000\u0000{|\u0005e\u0000\u0000|}\u0005r\u0000\u0000"+
		"}~\u0005:\u0000\u0000~\f\u0001\u0000\u0000\u0000\u007f\u0080\u0005,\u0000"+
		"\u0000\u0080\u000e\u0001\u0000\u0000\u0000\u0081\u0087\u0005\"\u0000\u0000"+
		"\u0082\u0086\b\u0000\u0000\u0000\u0083\u0084\u0005\\\u0000\u0000\u0084"+
		"\u0086\t\u0000\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005\"\u0000\u0000\u008b\u0010\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"t\u0000\u0000\u008d\u008e\u0005r\u0000\u0000\u008e\u008f\u0005u\u0000"+
		"\u0000\u008f\u0096\u0005e\u0000\u0000\u0090\u0091\u0005f\u0000\u0000\u0091"+
		"\u0092\u0005a\u0000\u0000\u0092\u0093\u0005l\u0000\u0000\u0093\u0094\u0005"+
		"s\u0000\u0000\u0094\u0096\u0005e\u0000\u0000\u0095\u008c\u0001\u0000\u0000"+
		"\u0000\u0095\u0090\u0001\u0000\u0000\u0000\u0096\u0012\u0001\u0000\u0000"+
		"\u0000\u0097\u00a0\u00050\u0000\u0000\u0098\u009c\u0007\u0001\u0000\u0000"+
		"\u0099\u009b\u0007\u0002\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u0097\u0001\u0000\u0000\u0000"+
		"\u009f\u0098\u0001\u0000\u0000\u0000\u00a0\u0014\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0007\u0002\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a8\u0005.\u0000\u0000\u00a7\u00a9\u0007\u0002\u0000\u0000\u00a8"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u0016\u0001\u0000\u0000\u0000\u00ac\u00b0\u0005#\u0000\u0000\u00ad\u00af"+
		"\b\u0003\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0006\u000b\u0000\u0000\u00b4\u0018\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b7\u0007\u0004\u0000\u0000\u00b6\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0006\f\u0000\u0000\u00bb\u001a\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005N\u0000\u0000\u00bd\u00be\u0005o\u0000\u0000"+
		"\u00be\u00bf\u0005n\u0000\u0000\u00bf\u00c0\u0005e\u0000\u0000\u00c0\u001c"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005B\u0000\u0000\u00c2\u00c3\u0005"+
		"a\u0000\u0000\u00c3\u00c4\u0005c\u0000\u0000\u00c4\u00c5\u0005h\u0000"+
		"\u0000\u00c5\u00c6\u0005e\u0000\u0000\u00c6\u00c7\u0005l\u0000\u0000\u00c7"+
		"\u00c8\u0005o\u0000\u0000\u00c8\u00c9\u0005r\u0000\u0000\u00c9\u001e\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005M\u0000\u0000\u00cb\u00cc\u0005a\u0000"+
		"\u0000\u00cc\u00cd\u0005s\u0000\u0000\u00cd\u00ce\u0005t\u0000\u0000\u00ce"+
		"\u00cf\u0005e\u0000\u0000\u00cf\u00d0\u0005r\u0000\u0000\u00d0 \u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0005D\u0000\u0000\u00d2\u00d3\u0005o\u0000"+
		"\u0000\u00d3\u00d4\u0005c\u0000\u0000\u00d4\u00d5\u0005t\u0000\u0000\u00d5"+
		"\u00d6\u0005o\u0000\u0000\u00d6\u00d7\u0005r\u0000\u0000\u00d7\u00d8\u0005"+
		"a\u0000\u0000\u00d8\u00d9\u0005t\u0000\u0000\u00d9\u00da\u0005e\u0000"+
		"\u0000\u00da\"\u0001\u0000\u0000\u0000\u00db\u00dc\u0005J\u0000\u0000"+
		"\u00dc\u00dd\u0005a\u0000\u0000\u00dd\u00de\u0005v\u0000\u0000\u00de\u00df"+
		"\u0005a\u0000\u0000\u00df$\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005J"+
		"\u0000\u0000\u00e1\u00e2\u0005a\u0000\u0000\u00e2\u00e3\u0005v\u0000\u0000"+
		"\u00e3\u00e4\u0005a\u0000\u0000\u00e4\u00e5\u0005S\u0000\u0000\u00e5\u00e6"+
		"\u0005c\u0000\u0000\u00e6\u00e7\u0005r\u0000\u0000\u00e7\u00e8\u0005i"+
		"\u0000\u0000\u00e8\u00e9\u0005p\u0000\u0000\u00e9\u00ea\u0005t\u0000\u0000"+
		"\u00ea&\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005P\u0000\u0000\u00ec\u00ed"+
		"\u0005h\u0000\u0000\u00ed\u00ee\u0005y\u0000\u0000\u00ee\u00ef\u0005t"+
		"\u0000\u0000\u00ef\u00f0\u0005o\u0000\u0000\u00f0\u00f1\u0005n\u0000\u0000"+
		"\u00f1(\u0001\u0000\u0000\u0000\n\u0000\u0085\u0087\u0095\u009c\u009f"+
		"\u00a4\u00aa\u00b0\u00b8\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}