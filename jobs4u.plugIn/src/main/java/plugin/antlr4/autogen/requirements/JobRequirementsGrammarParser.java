// Generated from C:/Users/Utilizador/IdeaProjects/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package plugin.antlr4.autogen.requirements;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, STRING=8, BOOLEAN=9, 
		INTEGER=10, REAL=11, COMMENT=12, WS=13, NONE=14, BACHELOR=15, MASTER=16, 
		DOCTORATE=17, JAVA=18, JAVASCRIPT=19, PHYTON=20;
	public static final int
		RULE_start = 0, RULE_header = 1, RULE_requirements = 2, RULE_requirementType = 3, 
		RULE_trueOrFalseRequirement = 4, RULE_academicDegreeRequirement = 5, RULE_shortAnswerRequirement = 6, 
		RULE_programingLanguages = 7, RULE_integerRequirement = 8, RULE_correctAnswer = 9, 
		RULE_answersType = 10, RULE_trueOrFalseAnswer = 11, RULE_shortAnswerAnswer = 12, 
		RULE_academicDegreeAnswer = 13, RULE_languagesAnswer = 14, RULE_integerAnswer = 15, 
		RULE_languages = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "requirements", "requirementType", "trueOrFalseRequirement", 
			"academicDegreeRequirement", "shortAnswerRequirement", "programingLanguages", 
			"integerRequirement", "correctAnswer", "answersType", "trueOrFalseAnswer", 
			"shortAnswerAnswer", "academicDegreeAnswer", "languagesAnswer", "integerAnswer", 
			"languages"
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
			setState(34);
			header();
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				requirements();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(40);
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
			setState(42);
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
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
	 
		public RequirementsContext() { }
		public void copyFrom(RequirementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RequirementContext extends RequirementsContext {
		public Token id;
		public TerminalNode INTEGER() { return getToken(JobRequirementsGrammarParser.INTEGER, 0); }
		public List<RequirementTypeContext> requirementType() {
			return getRuleContexts(RequirementTypeContext.class);
		}
		public RequirementTypeContext requirementType(int i) {
			return getRuleContext(RequirementTypeContext.class,i);
		}
		public List<AnswersTypeContext> answersType() {
			return getRuleContexts(AnswersTypeContext.class);
		}
		public AnswersTypeContext answersType(int i) {
			return getRuleContext(AnswersTypeContext.class,i);
		}
		public RequirementContext(RequirementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementsContext requirements() throws RecognitionException {
		RequirementsContext _localctx = new RequirementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requirements);
		int _la;
		try {
			_localctx = new RequirementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(45);
			((RequirementContext)_localctx).id = match(INTEGER);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				requirementType();
				setState(47);
				answersType();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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
		public AcademicDegreeRequirementContext academicDegreeRequirement() {
			return getRuleContext(AcademicDegreeRequirementContext.class,0);
		}
		public ProgramingLanguagesContext programingLanguages() {
			return getRuleContext(ProgramingLanguagesContext.class,0);
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				trueOrFalseRequirement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				shortAnswerRequirement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				academicDegreeRequirement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				programingLanguages();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
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
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
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
			setState(60);
			((TrueOrFalseRequirementContext)_localctx).text = match(STRING);
			setState(61);
			match(T__1);
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
	public static class AcademicDegreeRequirementContext extends ParserRuleContext {
		public Token text;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public AcademicDegreeRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_academicDegreeRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterAcademicDegreeRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitAcademicDegreeRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitAcademicDegreeRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcademicDegreeRequirementContext academicDegreeRequirement() throws RecognitionException {
		AcademicDegreeRequirementContext _localctx = new AcademicDegreeRequirementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_academicDegreeRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((AcademicDegreeRequirementContext)_localctx).text = match(STRING);
			setState(64);
			match(T__2);
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
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 12, RULE_shortAnswerRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((ShortAnswerRequirementContext)_localctx).text = match(STRING);
			setState(67);
			match(T__3);
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
	public static class ProgramingLanguagesContext extends ParserRuleContext {
		public Token text;
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
		public ProgramingLanguagesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programingLanguages; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterProgramingLanguages(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitProgramingLanguages(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitProgramingLanguages(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramingLanguagesContext programingLanguages() throws RecognitionException {
		ProgramingLanguagesContext _localctx = new ProgramingLanguagesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_programingLanguages);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((ProgramingLanguagesContext)_localctx).text = match(STRING);
			setState(70);
			match(T__4);
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
		public TerminalNode STRING() { return getToken(JobRequirementsGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 16, RULE_integerRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((IntegerRequirementContext)_localctx).text = match(STRING);
			setState(73);
			match(T__5);
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
		enterRule(_localctx, 18, RULE_correctAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnswersTypeContext extends ParserRuleContext {
		public TrueOrFalseAnswerContext trueOrFalseAnswer() {
			return getRuleContext(TrueOrFalseAnswerContext.class,0);
		}
		public ShortAnswerAnswerContext shortAnswerAnswer() {
			return getRuleContext(ShortAnswerAnswerContext.class,0);
		}
		public AcademicDegreeAnswerContext academicDegreeAnswer() {
			return getRuleContext(AcademicDegreeAnswerContext.class,0);
		}
		public LanguagesAnswerContext languagesAnswer() {
			return getRuleContext(LanguagesAnswerContext.class,0);
		}
		public IntegerAnswerContext integerAnswer() {
			return getRuleContext(IntegerAnswerContext.class,0);
		}
		public AnswersTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answersType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterAnswersType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitAnswersType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitAnswersType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersTypeContext answersType() throws RecognitionException {
		AnswersTypeContext _localctx = new AnswersTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_answersType);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				trueOrFalseAnswer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				shortAnswerAnswer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				academicDegreeAnswer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				languagesAnswer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				integerAnswer();
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
	public static class TrueOrFalseAnswerContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(JobRequirementsGrammarParser.BOOLEAN, 0); }
		public TrueOrFalseAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalseAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterTrueOrFalseAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitTrueOrFalseAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitTrueOrFalseAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseAnswerContext trueOrFalseAnswer() throws RecognitionException {
		TrueOrFalseAnswerContext _localctx = new TrueOrFalseAnswerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_trueOrFalseAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(BOOLEAN);
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
	public static class ShortAnswerAnswerContext extends ParserRuleContext {
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public ShortAnswerAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterShortAnswerAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitShortAnswerAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitShortAnswerAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerAnswerContext shortAnswerAnswer() throws RecognitionException {
		ShortAnswerAnswerContext _localctx = new ShortAnswerAnswerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_shortAnswerAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			correctAnswer();
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
	public static class AcademicDegreeAnswerContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(JobRequirementsGrammarParser.NONE, 0); }
		public TerminalNode BACHELOR() { return getToken(JobRequirementsGrammarParser.BACHELOR, 0); }
		public TerminalNode MASTER() { return getToken(JobRequirementsGrammarParser.MASTER, 0); }
		public TerminalNode DOCTORATE() { return getToken(JobRequirementsGrammarParser.DOCTORATE, 0); }
		public AcademicDegreeAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_academicDegreeAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterAcademicDegreeAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitAcademicDegreeAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitAcademicDegreeAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcademicDegreeAnswerContext academicDegreeAnswer() throws RecognitionException {
		AcademicDegreeAnswerContext _localctx = new AcademicDegreeAnswerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_academicDegreeAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class LanguagesAnswerContext extends ParserRuleContext {
		public List<LanguagesContext> languages() {
			return getRuleContexts(LanguagesContext.class);
		}
		public LanguagesContext languages(int i) {
			return getRuleContext(LanguagesContext.class,i);
		}
		public LanguagesAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languagesAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterLanguagesAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitLanguagesAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitLanguagesAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguagesAnswerContext languagesAnswer() throws RecognitionException {
		LanguagesAnswerContext _localctx = new LanguagesAnswerContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_languagesAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			languages();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(91);
				match(T__6);
				setState(92);
				languages();
				}
				}
				setState(97);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerAnswerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(JobRequirementsGrammarParser.INTEGER, 0); }
		public IntegerAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterIntegerAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitIntegerAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitIntegerAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerAnswerContext integerAnswer() throws RecognitionException {
		IntegerAnswerContext _localctx = new IntegerAnswerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_integerAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(INTEGER);
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
	public static class LanguagesContext extends ParserRuleContext {
		public TerminalNode JAVA() { return getToken(JobRequirementsGrammarParser.JAVA, 0); }
		public TerminalNode JAVASCRIPT() { return getToken(JobRequirementsGrammarParser.JAVASCRIPT, 0); }
		public TerminalNode PHYTON() { return getToken(JobRequirementsGrammarParser.PHYTON, 0); }
		public LanguagesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languages; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).enterLanguages(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsGrammarListener ) ((JobRequirementsGrammarListener)listener).exitLanguages(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsGrammarVisitor ) return ((JobRequirementsGrammarVisitor<? extends T>)visitor).visitLanguages(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguagesContext languages() throws RecognitionException {
		LanguagesContext _localctx = new LanguagesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_languages);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
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
		"\u0004\u0001\u0014g\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0004\u0000%\b\u0000"+
		"\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"2\b\u0002\u000b\u0002\f\u00023\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nS\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e^\b\u000e\n\u000e\f\u000ea\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0003\u0001\u0000\b\u000b\u0001\u0000\u000e\u0011\u0001"+
		"\u0000\u0012\u0014`\u0000\"\u0001\u0000\u0000\u0000\u0002*\u0001\u0000"+
		"\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000"+
		"\b<\u0001\u0000\u0000\u0000\n?\u0001\u0000\u0000\u0000\fB\u0001\u0000"+
		"\u0000\u0000\u000eE\u0001\u0000\u0000\u0000\u0010H\u0001\u0000\u0000\u0000"+
		"\u0012K\u0001\u0000\u0000\u0000\u0014R\u0001\u0000\u0000\u0000\u0016T"+
		"\u0001\u0000\u0000\u0000\u0018V\u0001\u0000\u0000\u0000\u001aX\u0001\u0000"+
		"\u0000\u0000\u001cZ\u0001\u0000\u0000\u0000\u001eb\u0001\u0000\u0000\u0000"+
		" d\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#%\u0003\u0004\u0002"+
		"\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0005"+
		"\u0000\u0000\u0001)\u0001\u0001\u0000\u0000\u0000*+\u0005\b\u0000\u0000"+
		"+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0001\u0000\u0000-1\u0005\n\u0000"+
		"\u0000./\u0003\u0006\u0003\u0000/0\u0003\u0014\n\u000002\u0001\u0000\u0000"+
		"\u00001.\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u00004\u0005\u0001\u0000\u0000\u0000"+
		"5;\u0003\b\u0004\u00006;\u0003\f\u0006\u00007;\u0003\n\u0005\u00008;\u0003"+
		"\u000e\u0007\u00009;\u0003\u0010\b\u0000:5\u0001\u0000\u0000\u0000:6\u0001"+
		"\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":9\u0001\u0000\u0000\u0000;\u0007\u0001\u0000\u0000\u0000<=\u0005\b\u0000"+
		"\u0000=>\u0005\u0002\u0000\u0000>\t\u0001\u0000\u0000\u0000?@\u0005\b"+
		"\u0000\u0000@A\u0005\u0003\u0000\u0000A\u000b\u0001\u0000\u0000\u0000"+
		"BC\u0005\b\u0000\u0000CD\u0005\u0004\u0000\u0000D\r\u0001\u0000\u0000"+
		"\u0000EF\u0005\b\u0000\u0000FG\u0005\u0005\u0000\u0000G\u000f\u0001\u0000"+
		"\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0005\u0006\u0000\u0000J\u0011\u0001"+
		"\u0000\u0000\u0000KL\u0007\u0000\u0000\u0000L\u0013\u0001\u0000\u0000"+
		"\u0000MS\u0003\u0016\u000b\u0000NS\u0003\u0018\f\u0000OS\u0003\u001a\r"+
		"\u0000PS\u0003\u001c\u000e\u0000QS\u0003\u001e\u000f\u0000RM\u0001\u0000"+
		"\u0000\u0000RN\u0001\u0000\u0000\u0000RO\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\u0015\u0001\u0000\u0000"+
		"\u0000TU\u0005\t\u0000\u0000U\u0017\u0001\u0000\u0000\u0000VW\u0003\u0012"+
		"\t\u0000W\u0019\u0001\u0000\u0000\u0000XY\u0007\u0001\u0000\u0000Y\u001b"+
		"\u0001\u0000\u0000\u0000Z_\u0003 \u0010\u0000[\\\u0005\u0007\u0000\u0000"+
		"\\^\u0003 \u0010\u0000][\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u001d\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\n\u0000\u0000c\u001f\u0001"+
		"\u0000\u0000\u0000de\u0007\u0002\u0000\u0000e!\u0001\u0000\u0000\u0000"+
		"\u0005&3:R_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}