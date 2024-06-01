// Generated from C:/Users/leono/IdeaProjects/sem3pi2023/sem3pi2023/sem4pi-23-24-2dh3/jobs4u.core/src/main/resources/PlugIns/interviewModel/InterviewModelGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.InterviewModel.genClasses;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewModelGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, STRING=24, 
		BOOLEAN=25, INTEGER=26, REAL=27, COMMENT=28, WS=29;
	public static final int
		RULE_start = 0, RULE_header = 1, RULE_interviewModel = 2, RULE_interview = 3, 
		RULE_questions = 4, RULE_question = 5, RULE_questionType = 6, RULE_trueOrFalseQuestion = 7, 
		RULE_singleChoiceQuestion = 8, RULE_shortAnswerQuestion = 9, RULE_multipleChoiceQuestion = 10, 
		RULE_integerQuestion = 11, RULE_decimalQuestion = 12, RULE_dateQuestion = 13, 
		RULE_timeQuestion = 14, RULE_scaleQuestion = 15, RULE_correctAnswer = 16, 
		RULE_questionAnswers = 17, RULE_questionPoints = 18, RULE_footer = 19, 
		RULE_score_definition = 20, RULE_outstandingClause = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "interviewModel", "interview", "questions", "question", 
			"questionType", "trueOrFalseQuestion", "singleChoiceQuestion", "shortAnswerQuestion", 
			"multipleChoiceQuestion", "integerQuestion", "decimalQuestion", "dateQuestion", 
			"timeQuestion", "scaleQuestion", "correctAnswer", "questionAnswers", 
			"questionPoints", "footer", "score_definition", "outstandingClause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Create interview model'", "'for job opening'", "'as follows:'", 
			"'Question'", "':'", "'( True or False ) with answer'", "'( Single Choice ) within options'", 
			"'with answer'", "'( Short Answer ) with answer'", "'( Multiple Choice ) within options'", 
			"'( Integer ) with answer'", "'( Decimal ) with answer'", "'( Date ) with answer'", 
			"'( Time ) with answer'", "'( Scale ) within range'", "'to'", "'Answer'", 
			"'Awarding :'", "'points'", "'Footer'", "'.'", "'Passing results must score'", 
			"', Outstanding results must'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"STRING", "BOOLEAN", "INTEGER", "REAL", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "InterviewModelGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewModelGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public InterviewModelContext interviewModel() {
			return getRuleContext(InterviewModelContext.class,0);
		}
		public FooterContext footer() {
			return getRuleContext(FooterContext.class,0);
		}
		public TerminalNode EOF() { return getToken(InterviewModelGrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			header();
			setState(45);
			interviewModel();
			setState(46);
			footer();
			setState(47);
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
		public Token interviewName;
		public Token jobOpeningReference;
		public List<TerminalNode> STRING() { return getTokens(InterviewModelGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(InterviewModelGrammarParser.STRING, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			((HeaderContext)_localctx).interviewName = match(STRING);
			setState(51);
			match(T__1);
			setState(52);
			((HeaderContext)_localctx).jobOpeningReference = match(STRING);
			setState(53);
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
	public static class InterviewModelContext extends ParserRuleContext {
		public List<InterviewContext> interview() {
			return getRuleContexts(InterviewContext.class);
		}
		public InterviewContext interview(int i) {
			return getRuleContext(InterviewContext.class,i);
		}
		public InterviewModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interviewModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterInterviewModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitInterviewModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitInterviewModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterviewModelContext interviewModel() throws RecognitionException {
		InterviewModelContext _localctx = new InterviewModelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_interviewModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				interview();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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
	public static class InterviewContext extends ParserRuleContext {
		public QuestionsContext questions() {
			return getRuleContext(QuestionsContext.class,0);
		}
		public QuestionAnswersContext questionAnswers() {
			return getRuleContext(QuestionAnswersContext.class,0);
		}
		public QuestionPointsContext questionPoints() {
			return getRuleContext(QuestionPointsContext.class,0);
		}
		public InterviewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interview; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterInterview(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitInterview(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitInterview(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterviewContext interview() throws RecognitionException {
		InterviewContext _localctx = new InterviewContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interview);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			questions();
			setState(61);
			questionAnswers();
			setState(62);
			questionPoints();
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
	public static class QuestionsContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitQuestions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionsContext questions() throws RecognitionException {
		QuestionsContext _localctx = new QuestionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				question();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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
	public static class QuestionContext extends ParserRuleContext {
		public Token id;
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__3);
			setState(70);
			((QuestionContext)_localctx).id = match(INTEGER);
			setState(71);
			match(T__4);
			setState(72);
			questionType();
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
	public static class QuestionTypeContext extends ParserRuleContext {
		public TrueOrFalseQuestionContext trueOrFalseQuestion() {
			return getRuleContext(TrueOrFalseQuestionContext.class,0);
		}
		public SingleChoiceQuestionContext singleChoiceQuestion() {
			return getRuleContext(SingleChoiceQuestionContext.class,0);
		}
		public ShortAnswerQuestionContext shortAnswerQuestion() {
			return getRuleContext(ShortAnswerQuestionContext.class,0);
		}
		public MultipleChoiceQuestionContext multipleChoiceQuestion() {
			return getRuleContext(MultipleChoiceQuestionContext.class,0);
		}
		public IntegerQuestionContext integerQuestion() {
			return getRuleContext(IntegerQuestionContext.class,0);
		}
		public DecimalQuestionContext decimalQuestion() {
			return getRuleContext(DecimalQuestionContext.class,0);
		}
		public DateQuestionContext dateQuestion() {
			return getRuleContext(DateQuestionContext.class,0);
		}
		public TimeQuestionContext timeQuestion() {
			return getRuleContext(TimeQuestionContext.class,0);
		}
		public ScaleQuestionContext scaleQuestion() {
			return getRuleContext(ScaleQuestionContext.class,0);
		}
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitQuestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionType);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				trueOrFalseQuestion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				singleChoiceQuestion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				shortAnswerQuestion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				multipleChoiceQuestion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				integerQuestion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				decimalQuestion();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				dateQuestion();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				timeQuestion();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				scaleQuestion();
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
	public static class TrueOrFalseQuestionContext extends ParserRuleContext {
		public Token answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(InterviewModelGrammarParser.BOOLEAN, 0); }
		public TrueOrFalseQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalseQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterTrueOrFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitTrueOrFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitTrueOrFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseQuestionContext trueOrFalseQuestion() throws RecognitionException {
		TrueOrFalseQuestionContext _localctx = new TrueOrFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_trueOrFalseQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(STRING);
			setState(86);
			match(T__5);
			setState(87);
			((TrueOrFalseQuestionContext)_localctx).answer = match(BOOLEAN);
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
	public static class SingleChoiceQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public List<TerminalNode> STRING() { return getTokens(InterviewModelGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(InterviewModelGrammarParser.STRING, i);
		}
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public SingleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterSingleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitSingleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitSingleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleChoiceQuestionContext singleChoiceQuestion() throws RecognitionException {
		SingleChoiceQuestionContext _localctx = new SingleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_singleChoiceQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(STRING);
			setState(90);
			match(T__6);
			setState(91);
			match(STRING);
			setState(92);
			match(T__7);
			setState(93);
			((SingleChoiceQuestionContext)_localctx).answer = correctAnswer();
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
	public static class ShortAnswerQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public ShortAnswerQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterShortAnswerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitShortAnswerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitShortAnswerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerQuestionContext shortAnswerQuestion() throws RecognitionException {
		ShortAnswerQuestionContext _localctx = new ShortAnswerQuestionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_shortAnswerQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(STRING);
			setState(96);
			match(T__8);
			setState(97);
			((ShortAnswerQuestionContext)_localctx).answer = correctAnswer();
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
	public static class MultipleChoiceQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public List<TerminalNode> STRING() { return getTokens(InterviewModelGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(InterviewModelGrammarParser.STRING, i);
		}
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public MultipleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multipleChoiceQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(STRING);
			setState(100);
			match(T__9);
			setState(101);
			match(STRING);
			setState(102);
			match(T__7);
			setState(103);
			((MultipleChoiceQuestionContext)_localctx).answer = correctAnswer();
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
	public static class IntegerQuestionContext extends ParserRuleContext {
		public Token answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public IntegerQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterIntegerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitIntegerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitIntegerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerQuestionContext integerQuestion() throws RecognitionException {
		IntegerQuestionContext _localctx = new IntegerQuestionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integerQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(STRING);
			setState(106);
			match(T__10);
			setState(107);
			((IntegerQuestionContext)_localctx).answer = match(INTEGER);
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
	public static class DecimalQuestionContext extends ParserRuleContext {
		public Token answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public TerminalNode REAL() { return getToken(InterviewModelGrammarParser.REAL, 0); }
		public DecimalQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterDecimalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitDecimalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitDecimalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalQuestionContext decimalQuestion() throws RecognitionException {
		DecimalQuestionContext _localctx = new DecimalQuestionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_decimalQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(STRING);
			setState(110);
			match(T__11);
			setState(111);
			((DecimalQuestionContext)_localctx).answer = match(REAL);
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
	public static class DateQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public DateQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterDateQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitDateQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitDateQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateQuestionContext dateQuestion() throws RecognitionException {
		DateQuestionContext _localctx = new DateQuestionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dateQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(STRING);
			setState(114);
			match(T__12);
			setState(115);
			((DateQuestionContext)_localctx).answer = correctAnswer();
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
	public static class TimeQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public TimeQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterTimeQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitTimeQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitTimeQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeQuestionContext timeQuestion() throws RecognitionException {
		TimeQuestionContext _localctx = new TimeQuestionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_timeQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(STRING);
			setState(118);
			match(T__13);
			setState(119);
			((TimeQuestionContext)_localctx).answer = correctAnswer();
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
	public static class ScaleQuestionContext extends ParserRuleContext {
		public CorrectAnswerContext answer;
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(InterviewModelGrammarParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(InterviewModelGrammarParser.INTEGER, i);
		}
		public CorrectAnswerContext correctAnswer() {
			return getRuleContext(CorrectAnswerContext.class,0);
		}
		public ScaleQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scaleQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterScaleQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitScaleQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitScaleQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScaleQuestionContext scaleQuestion() throws RecognitionException {
		ScaleQuestionContext _localctx = new ScaleQuestionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_scaleQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(STRING);
			setState(122);
			match(T__14);
			setState(123);
			match(INTEGER);
			setState(124);
			match(T__15);
			setState(125);
			match(INTEGER);
			setState(126);
			match(T__7);
			setState(127);
			((ScaleQuestionContext)_localctx).answer = correctAnswer();
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
		public TerminalNode BOOLEAN() { return getToken(InterviewModelGrammarParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(InterviewModelGrammarParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(InterviewModelGrammarParser.STRING, 0); }
		public CorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correctAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorrectAnswerContext correctAnswer() throws RecognitionException {
		CorrectAnswerContext _localctx = new CorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_correctAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
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
	public static class QuestionAnswersContext extends ParserRuleContext {
		public Token id;
		public CorrectAnswerContext answer;
		public List<TerminalNode> INTEGER() { return getTokens(InterviewModelGrammarParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(InterviewModelGrammarParser.INTEGER, i);
		}
		public List<CorrectAnswerContext> correctAnswer() {
			return getRuleContexts(CorrectAnswerContext.class);
		}
		public CorrectAnswerContext correctAnswer(int i) {
			return getRuleContext(CorrectAnswerContext.class,i);
		}
		public QuestionAnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionAnswers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterQuestionAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitQuestionAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitQuestionAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionAnswersContext questionAnswers() throws RecognitionException {
		QuestionAnswersContext _localctx = new QuestionAnswersContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_questionAnswers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				match(T__16);
				setState(132);
				((QuestionAnswersContext)_localctx).id = match(INTEGER);
				setState(133);
				match(T__4);
				setState(134);
				((QuestionAnswersContext)_localctx).answer = correctAnswer();
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 );
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
	public static class QuestionPointsContext extends ParserRuleContext {
		public Token points;
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public QuestionPointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionPoints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterQuestionPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitQuestionPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitQuestionPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionPointsContext questionPoints() throws RecognitionException {
		QuestionPointsContext _localctx = new QuestionPointsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_questionPoints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__17);
			setState(140);
			((QuestionPointsContext)_localctx).points = match(INTEGER);
			setState(141);
			match(T__18);
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
	public static class FooterContext extends ParserRuleContext {
		public Score_definitionContext score_definition() {
			return getRuleContext(Score_definitionContext.class,0);
		}
		public FooterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_footer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterFooter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitFooter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitFooter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FooterContext footer() throws RecognitionException {
		FooterContext _localctx = new FooterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_footer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__19);
			setState(144);
			score_definition();
			setState(145);
			match(T__20);
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
	public static class Score_definitionContext extends ParserRuleContext {
		public Token passingScore;
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public OutstandingClauseContext outstandingClause() {
			return getRuleContext(OutstandingClauseContext.class,0);
		}
		public Score_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_score_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterScore_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitScore_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitScore_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Score_definitionContext score_definition() throws RecognitionException {
		Score_definitionContext _localctx = new Score_definitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_score_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__21);
			setState(148);
			((Score_definitionContext)_localctx).passingScore = match(INTEGER);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(149);
				outstandingClause();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OutstandingClauseContext extends ParserRuleContext {
		public Token outstandingResults;
		public TerminalNode INTEGER() { return getToken(InterviewModelGrammarParser.INTEGER, 0); }
		public OutstandingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outstandingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterOutstandingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitOutstandingClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitOutstandingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutstandingClauseContext outstandingClause() throws RecognitionException {
		OutstandingClauseContext _localctx = new OutstandingClauseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_outstandingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__22);
			setState(153);
			((OutstandingClauseContext)_localctx).outstandingResults = match(INTEGER);
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
		"\u0004\u0001\u001d\u009c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0004\u00029\b\u0002\u000b\u0002\f\u0002:\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004B\b\u0004\u000b\u0004"+
		"\f\u0004C\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006T\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011"+
		"\u0088\b\u0011\u000b\u0011\f\u0011\u0089\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0097\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000"+
		"\u0001\u0001\u0000\u0018\u001b\u0091\u0000,\u0001\u0000\u0000\u0000\u0002"+
		"1\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000\u0000\u0006<\u0001"+
		"\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000"+
		"\fS\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010Y\u0001"+
		"\u0000\u0000\u0000\u0012_\u0001\u0000\u0000\u0000\u0014c\u0001\u0000\u0000"+
		"\u0000\u0016i\u0001\u0000\u0000\u0000\u0018m\u0001\u0000\u0000\u0000\u001a"+
		"q\u0001\u0000\u0000\u0000\u001cu\u0001\u0000\u0000\u0000\u001ey\u0001"+
		"\u0000\u0000\u0000 \u0081\u0001\u0000\u0000\u0000\"\u0087\u0001\u0000"+
		"\u0000\u0000$\u008b\u0001\u0000\u0000\u0000&\u008f\u0001\u0000\u0000\u0000"+
		"(\u0093\u0001\u0000\u0000\u0000*\u0098\u0001\u0000\u0000\u0000,-\u0003"+
		"\u0002\u0001\u0000-.\u0003\u0004\u0002\u0000./\u0003&\u0013\u0000/0\u0005"+
		"\u0000\u0000\u00010\u0001\u0001\u0000\u0000\u000012\u0005\u0001\u0000"+
		"\u000023\u0005\u0018\u0000\u000034\u0005\u0002\u0000\u000045\u0005\u0018"+
		"\u0000\u000056\u0005\u0003\u0000\u00006\u0003\u0001\u0000\u0000\u0000"+
		"79\u0003\u0006\u0003\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0005\u0001"+
		"\u0000\u0000\u0000<=\u0003\b\u0004\u0000=>\u0003\"\u0011\u0000>?\u0003"+
		"$\u0012\u0000?\u0007\u0001\u0000\u0000\u0000@B\u0003\n\u0005\u0000A@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000D\t\u0001\u0000\u0000\u0000EF\u0005\u0004\u0000"+
		"\u0000FG\u0005\u001a\u0000\u0000GH\u0005\u0005\u0000\u0000HI\u0003\f\u0006"+
		"\u0000I\u000b\u0001\u0000\u0000\u0000JT\u0003\u000e\u0007\u0000KT\u0003"+
		"\u0010\b\u0000LT\u0003\u0012\t\u0000MT\u0003\u0014\n\u0000NT\u0003\u0016"+
		"\u000b\u0000OT\u0003\u0018\f\u0000PT\u0003\u001a\r\u0000QT\u0003\u001c"+
		"\u000e\u0000RT\u0003\u001e\u000f\u0000SJ\u0001\u0000\u0000\u0000SK\u0001"+
		"\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000"+
		"SN\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\r\u0001\u0000"+
		"\u0000\u0000UV\u0005\u0018\u0000\u0000VW\u0005\u0006\u0000\u0000WX\u0005"+
		"\u0019\u0000\u0000X\u000f\u0001\u0000\u0000\u0000YZ\u0005\u0018\u0000"+
		"\u0000Z[\u0005\u0007\u0000\u0000[\\\u0005\u0018\u0000\u0000\\]\u0005\b"+
		"\u0000\u0000]^\u0003 \u0010\u0000^\u0011\u0001\u0000\u0000\u0000_`\u0005"+
		"\u0018\u0000\u0000`a\u0005\t\u0000\u0000ab\u0003 \u0010\u0000b\u0013\u0001"+
		"\u0000\u0000\u0000cd\u0005\u0018\u0000\u0000de\u0005\n\u0000\u0000ef\u0005"+
		"\u0018\u0000\u0000fg\u0005\b\u0000\u0000gh\u0003 \u0010\u0000h\u0015\u0001"+
		"\u0000\u0000\u0000ij\u0005\u0018\u0000\u0000jk\u0005\u000b\u0000\u0000"+
		"kl\u0005\u001a\u0000\u0000l\u0017\u0001\u0000\u0000\u0000mn\u0005\u0018"+
		"\u0000\u0000no\u0005\f\u0000\u0000op\u0005\u001b\u0000\u0000p\u0019\u0001"+
		"\u0000\u0000\u0000qr\u0005\u0018\u0000\u0000rs\u0005\r\u0000\u0000st\u0003"+
		" \u0010\u0000t\u001b\u0001\u0000\u0000\u0000uv\u0005\u0018\u0000\u0000"+
		"vw\u0005\u000e\u0000\u0000wx\u0003 \u0010\u0000x\u001d\u0001\u0000\u0000"+
		"\u0000yz\u0005\u0018\u0000\u0000z{\u0005\u000f\u0000\u0000{|\u0005\u001a"+
		"\u0000\u0000|}\u0005\u0010\u0000\u0000}~\u0005\u001a\u0000\u0000~\u007f"+
		"\u0005\b\u0000\u0000\u007f\u0080\u0003 \u0010\u0000\u0080\u001f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0007\u0000\u0000\u0000\u0082!\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0011\u0000\u0000\u0084\u0085\u0005\u001a"+
		"\u0000\u0000\u0085\u0086\u0005\u0005\u0000\u0000\u0086\u0088\u0003 \u0010"+
		"\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a#\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0012\u0000\u0000"+
		"\u008c\u008d\u0005\u001a\u0000\u0000\u008d\u008e\u0005\u0013\u0000\u0000"+
		"\u008e%\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0014\u0000\u0000\u0090"+
		"\u0091\u0003(\u0014\u0000\u0091\u0092\u0005\u0015\u0000\u0000\u0092\'"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0016\u0000\u0000\u0094\u0096"+
		"\u0005\u001a\u0000\u0000\u0095\u0097\u0003*\u0015\u0000\u0096\u0095\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097)\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0005\u0017\u0000\u0000\u0099\u009a\u0005\u001a"+
		"\u0000\u0000\u009a+\u0001\u0000\u0000\u0000\u0005:CS\u0089\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}