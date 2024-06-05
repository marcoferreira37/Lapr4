// Generated from C:/Users/Marco/ISEP/2 ano 2 Semestre/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package plugin.requirementsSpecification;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JobRequirementsGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, BOOLEAN=6, INTEGER=7, REAL=8, 
		COMMENT=9, WS=10;
	public static final int
		RULE_start = 0, RULE_header = 1, RULE_requirements = 2, RULE_requirementType = 3, 
		RULE_trueOrFalseRequirement = 4, RULE_shortAnswerRequirement = 5, RULE_integerRequirement = 6, 
		RULE_correctAnswer = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "requirements", "requirementType", "trueOrFalseRequirement", 
			"shortAnswerRequirement", "integerRequirement", "correctAnswer"
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

	@Override
	public String getGrammarFileName() { return "JobRequirementsGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JobRequirementsGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JobRequirementsGrammarParser.EOF, 0); }
		public List<RequirementsContext> requirements() {
			return getRuleContexts(RequirementsContext.class);
		}
		public RequirementsContext requirements(int i) {
			return getRuleContext(RequirementsContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			header();
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17);
				requirements();
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(22);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public Token text;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((HeaderContext)_localctx).text = match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RequirementsContext extends ParserRuleContext {
		public Token id;
		public RequirementTypeContext requirementType() {
			return getRuleContext(RequirementTypeContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(JobRequirementsGrammarParser.INTEGER, 0); }
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterRequirements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitRequirements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitRequirements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementsContext requirements() throws RecognitionException {
		RequirementsContext _localctx = new RequirementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requirements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			((RequirementsContext)_localctx).id = match(INTEGER);
			setState(28);
			requirementType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RequirementTypeContext extends ParserRuleContext {
		public TrueOrFalseRequirementContext trueOrFalseRequirement() {
			return getRuleContext(TrueOrFalseRequirementContext.class,0);
		}
		public ShortAnswerRequirementContext shortAnswerRequirement() {
			return getRuleContext(ShortAnswerRequirementContext.class,0);
		}
		public IntegerRequirementContext integerRequirement() {
			return getRuleContext(IntegerRequirementContext.class,0);
		}
		public RequirementTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterRequirementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitRequirementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitRequirementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementTypeContext requirementType() throws RecognitionException {
		RequirementTypeContext _localctx = new RequirementTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_requirementType);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				trueOrFalseRequirement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				shortAnswerRequirement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				integerRequirement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TrueOrFalseRequirementContext extends ParserRuleContext {
		public Token text;
		public Token answer;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(JobRequirementsGrammarParser.BOOLEAN, 0); }
		public TrueOrFalseRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalseRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterTrueOrFalseRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitTrueOrFalseRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitTrueOrFalseRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseRequirementContext trueOrFalseRequirement() throws RecognitionException {
		TrueOrFalseRequirementContext _localctx = new TrueOrFalseRequirementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_trueOrFalseRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((TrueOrFalseRequirementContext)_localctx).text = match(STRING);
			setState(36);
			match(T__1);
			setState(37);
			((TrueOrFalseRequirementContext)_localctx).answer = match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShortAnswerRequirementContext extends ParserRuleContext {
		public Token text;
		public CorrectAnswerContext answer;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public ShortAnswerRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterShortAnswerRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitShortAnswerRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitShortAnswerRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerRequirementContext shortAnswerRequirement() throws RecognitionException {
		ShortAnswerRequirementContext _localctx = new ShortAnswerRequirementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_shortAnswerRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((ShortAnswerRequirementContext)_localctx).text = match(STRING);
			setState(40);
			match(T__2);
			setState(41);
			((ShortAnswerRequirementContext)_localctx).answer = correctAnswer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerRequirementContext extends ParserRuleContext {
		public Token text;
		public Token answer;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(JobRequirementsGrammarParser.INTEGER, 0); }
		public IntegerRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterIntegerRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitIntegerRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitIntegerRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerRequirementContext integerRequirement() throws RecognitionException {
		IntegerRequirementContext _localctx = new IntegerRequirementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_integerRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((IntegerRequirementContext)_localctx).text = match(STRING);
			setState(44);
			match(T__3);
			setState(45);
			((IntegerRequirementContext)_localctx).answer = match(INTEGER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CorrectAnswerContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(JobRequirementsGrammarParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(JobRequirementsGrammarParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(JobRequirementsGrammarParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public CorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correctAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorrectAnswerContext correctAnswer() throws RecognitionException {
		CorrectAnswerContext _localctx = new CorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_correctAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\n2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0004\u0000\u0013\b\u0000\u000b\u0000\f\u0000\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0000\u0001\u0001\u0000\u0005\b,\u0000\u0010"+
		"\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0004\u001a"+
		"\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000\b#\u0001\u0000"+
		"\u0000\u0000\n\'\u0001\u0000\u0000\u0000\f+\u0001\u0000\u0000\u0000\u000e"+
		"/\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011\u0013"+
		"\u0003\u0004\u0002\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0005\u0000\u0000\u0001\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0005\u0005\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0005\u0001\u0000\u0000\u001b\u001c\u0005\u0007\u0000\u0000\u001c\u001d"+
		"\u0003\u0006\u0003\u0000\u001d\u0005\u0001\u0000\u0000\u0000\u001e\"\u0003"+
		"\b\u0004\u0000\u001f\"\u0003\n\u0005\u0000 \"\u0003\f\u0006\u0000!\u001e"+
		"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000! \u0001\u0000"+
		"\u0000\u0000\"\u0007\u0001\u0000\u0000\u0000#$\u0005\u0005\u0000\u0000"+
		"$%\u0005\u0002\u0000\u0000%&\u0005\u0006\u0000\u0000&\t\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u0005\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0003\u000e"+
		"\u0007\u0000*\u000b\u0001\u0000\u0000\u0000+,\u0005\u0005\u0000\u0000"+
		",-\u0005\u0004\u0000\u0000-.\u0005\u0007\u0000\u0000.\r\u0001\u0000\u0000"+
		"\u0000/0\u0007\u0000\u0000\u00000\u000f\u0001\u0000\u0000\u0000\u0002"+
		"\u0014!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}