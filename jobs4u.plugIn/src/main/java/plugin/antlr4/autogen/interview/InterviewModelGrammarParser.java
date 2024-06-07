// Generated from C:/Users/Utilizador/Desktop/sem4pi-23-24-2dh3/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/interviewModel/InterviewModelGrammar.g4 by ANTLR 4.13.1
package plugin.antlr4.autogen.interview;
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
		RULE_start = 0, RULE_header = 1, RULE_interview = 2, RULE_questions = 3, 
		RULE_question = 4, RULE_questionType = 5, RULE_trueOrFalseQuestion = 6, 
		RULE_singleChoiceQuestion = 7, RULE_shortAnswerQuestion = 8, RULE_multipleChoiceQuestion = 9, 
		RULE_integerQuestion = 10, RULE_decimalQuestion = 11, RULE_dateQuestion = 12, 
		RULE_timeQuestion = 13, RULE_scaleQuestion = 14, RULE_correctAnswer = 15, 
		RULE_questionAnswers = 16, RULE_questionPoints = 17, RULE_footer = 18, 
		RULE_score_definition = 19, RULE_outstandingClause = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "interview", "questions", "question", "questionType", 
			"trueOrFalseQuestion", "singleChoiceQuestion", "shortAnswerQuestion", 
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
		public InterviewContext interview() {
			return getRuleContext(InterviewContext.class,0);
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
			setState(42);
			header();
			setState(43);
			interview();
			setState(44);
			footer();
			setState(45);
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
			setState(47);
			match(T__0);
			setState(48);
			((HeaderContext)_localctx).interviewName = match(STRING);
			setState(49);
			match(T__1);
			setState(50);
			((HeaderContext)_localctx).jobOpeningReference = match(STRING);
			setState(51);
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
	public static class InterviewContext extends ParserRuleContext {
		public InterviewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interview; }
	 
		public InterviewContext() { }
		public void copyFrom(InterviewContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EvaluationContext extends InterviewContext {
		public List<QuestionsContext> questions() {
			return getRuleContexts(QuestionsContext.class);
		}
		public QuestionsContext questions(int i) {
			return getRuleContext(QuestionsContext.class,i);
		}
		public List<QuestionAnswersContext> questionAnswers() {
			return getRuleContexts(QuestionAnswersContext.class);
		}
		public QuestionAnswersContext questionAnswers(int i) {
			return getRuleContext(QuestionAnswersContext.class,i);
		}
		public List<QuestionPointsContext> questionPoints() {
			return getRuleContexts(QuestionPointsContext.class);
		}
		public QuestionPointsContext questionPoints(int i) {
			return getRuleContext(QuestionPointsContext.class,i);
		}
		public EvaluationContext(InterviewContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).enterEvaluation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelGrammarListener ) ((InterviewModelGrammarListener)listener).exitEvaluation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelGrammarVisitor ) return ((InterviewModelGrammarVisitor<? extends T>)visitor).visitEvaluation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterviewContext interview() throws RecognitionException {
		InterviewContext _localctx = new InterviewContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_interview);
		int _la;
		try {
			_localctx = new EvaluationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				questions();
				setState(54);
				questionAnswers();
				setState(55);
				questionPoints();
				}
				}
				setState(59); 
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
		enterRule(_localctx, 6, RULE_questions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				question();
				}
				}
				setState(64); 
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
		enterRule(_localctx, 8, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__3);
			setState(67);
			((QuestionContext)_localctx).id = match(INTEGER);
			setState(68);
			match(T__4);
			setState(69);
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
		enterRule(_localctx, 10, RULE_questionType);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				trueOrFalseQuestion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				singleChoiceQuestion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				shortAnswerQuestion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				multipleChoiceQuestion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				integerQuestion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				decimalQuestion();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				dateQuestion();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(78);
				timeQuestion();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(79);
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
		enterRule(_localctx, 12, RULE_trueOrFalseQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(STRING);
			setState(83);
			match(T__5);
			setState(84);
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
		enterRule(_localctx, 14, RULE_singleChoiceQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(STRING);
			setState(87);
			match(T__6);
			setState(88);
			match(STRING);
			setState(89);
			match(T__7);
			setState(90);
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
		enterRule(_localctx, 16, RULE_shortAnswerQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(STRING);
			setState(93);
			match(T__8);
			setState(94);
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
		enterRule(_localctx, 18, RULE_multipleChoiceQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(STRING);
			setState(97);
			match(T__9);
			setState(98);
			match(STRING);
			setState(99);
			match(T__7);
			setState(100);
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
		enterRule(_localctx, 20, RULE_integerQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(STRING);
			setState(103);
			match(T__10);
			setState(104);
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
		enterRule(_localctx, 22, RULE_decimalQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(STRING);
			setState(107);
			match(T__11);
			setState(108);
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
		enterRule(_localctx, 24, RULE_dateQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(STRING);
			setState(111);
			match(T__12);
			setState(112);
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
		enterRule(_localctx, 26, RULE_timeQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(STRING);
			setState(115);
			match(T__13);
			setState(116);
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
		enterRule(_localctx, 28, RULE_scaleQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(STRING);
			setState(119);
			match(T__14);
			setState(120);
			match(INTEGER);
			setState(121);
			match(T__15);
			setState(122);
			match(INTEGER);
			setState(123);
			match(T__7);
			setState(124);
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
		enterRule(_localctx, 30, RULE_correctAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		enterRule(_localctx, 32, RULE_questionAnswers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				match(T__16);
				setState(129);
				((QuestionAnswersContext)_localctx).id = match(INTEGER);
				setState(130);
				match(T__4);
				setState(131);
				((QuestionAnswersContext)_localctx).answer = correctAnswer();
				}
				}
				setState(134); 
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
		enterRule(_localctx, 34, RULE_questionPoints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__17);
			setState(137);
			((QuestionPointsContext)_localctx).points = match(INTEGER);
			setState(138);
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
		enterRule(_localctx, 36, RULE_footer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__19);
			setState(141);
			score_definition();
			setState(142);
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
		enterRule(_localctx, 38, RULE_score_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__21);
			setState(145);
			((Score_definitionContext)_localctx).passingScore = match(INTEGER);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(146);
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
		enterRule(_localctx, 40, RULE_outstandingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__22);
			setState(150);
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
		"\u0004\u0001\u001d\u0099\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002:\b\u0002\u000b\u0002\f\u0002;\u0001\u0003"+
		"\u0004\u0003?\b\u0003\u000b\u0003\f\u0003@\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005Q\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0004\u0010\u0085\b\u0010\u000b\u0010\f\u0010"+
		"\u0086\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0094\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000"+
		"\u0000\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(\u0000\u0001\u0001\u0000\u0018\u001b\u008f"+
		"\u0000*\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00049"+
		"\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000\bB\u0001\u0000"+
		"\u0000\u0000\nP\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e"+
		"V\u0001\u0000\u0000\u0000\u0010\\\u0001\u0000\u0000\u0000\u0012`\u0001"+
		"\u0000\u0000\u0000\u0014f\u0001\u0000\u0000\u0000\u0016j\u0001\u0000\u0000"+
		"\u0000\u0018n\u0001\u0000\u0000\u0000\u001ar\u0001\u0000\u0000\u0000\u001c"+
		"v\u0001\u0000\u0000\u0000\u001e~\u0001\u0000\u0000\u0000 \u0084\u0001"+
		"\u0000\u0000\u0000\"\u0088\u0001\u0000\u0000\u0000$\u008c\u0001\u0000"+
		"\u0000\u0000&\u0090\u0001\u0000\u0000\u0000(\u0095\u0001\u0000\u0000\u0000"+
		"*+\u0003\u0002\u0001\u0000+,\u0003\u0004\u0002\u0000,-\u0003$\u0012\u0000"+
		"-.\u0005\u0000\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/0\u0005\u0001"+
		"\u0000\u000001\u0005\u0018\u0000\u000012\u0005\u0002\u0000\u000023\u0005"+
		"\u0018\u0000\u000034\u0005\u0003\u0000\u00004\u0003\u0001\u0000\u0000"+
		"\u000056\u0003\u0006\u0003\u000067\u0003 \u0010\u000078\u0003\"\u0011"+
		"\u00008:\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0005"+
		"\u0001\u0000\u0000\u0000=?\u0003\b\u0004\u0000>=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0005\u0004\u0000\u0000CD\u0005"+
		"\u001a\u0000\u0000DE\u0005\u0005\u0000\u0000EF\u0003\n\u0005\u0000F\t"+
		"\u0001\u0000\u0000\u0000GQ\u0003\f\u0006\u0000HQ\u0003\u000e\u0007\u0000"+
		"IQ\u0003\u0010\b\u0000JQ\u0003\u0012\t\u0000KQ\u0003\u0014\n\u0000LQ\u0003"+
		"\u0016\u000b\u0000MQ\u0003\u0018\f\u0000NQ\u0003\u001a\r\u0000OQ\u0003"+
		"\u001c\u000e\u0000PG\u0001\u0000\u0000\u0000PH\u0001\u0000\u0000\u0000"+
		"PI\u0001\u0000\u0000\u0000PJ\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000"+
		"\u0000PL\u0001\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000PO\u0001\u0000\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0018\u0000\u0000ST\u0005\u0006\u0000\u0000TU\u0005\u0019\u0000"+
		"\u0000U\r\u0001\u0000\u0000\u0000VW\u0005\u0018\u0000\u0000WX\u0005\u0007"+
		"\u0000\u0000XY\u0005\u0018\u0000\u0000YZ\u0005\b\u0000\u0000Z[\u0003\u001e"+
		"\u000f\u0000[\u000f\u0001\u0000\u0000\u0000\\]\u0005\u0018\u0000\u0000"+
		"]^\u0005\t\u0000\u0000^_\u0003\u001e\u000f\u0000_\u0011\u0001\u0000\u0000"+
		"\u0000`a\u0005\u0018\u0000\u0000ab\u0005\n\u0000\u0000bc\u0005\u0018\u0000"+
		"\u0000cd\u0005\b\u0000\u0000de\u0003\u001e\u000f\u0000e\u0013\u0001\u0000"+
		"\u0000\u0000fg\u0005\u0018\u0000\u0000gh\u0005\u000b\u0000\u0000hi\u0005"+
		"\u001a\u0000\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0005\u0018\u0000"+
		"\u0000kl\u0005\f\u0000\u0000lm\u0005\u001b\u0000\u0000m\u0017\u0001\u0000"+
		"\u0000\u0000no\u0005\u0018\u0000\u0000op\u0005\r\u0000\u0000pq\u0003\u001e"+
		"\u000f\u0000q\u0019\u0001\u0000\u0000\u0000rs\u0005\u0018\u0000\u0000"+
		"st\u0005\u000e\u0000\u0000tu\u0003\u001e\u000f\u0000u\u001b\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0018\u0000\u0000wx\u0005\u000f\u0000\u0000xy\u0005"+
		"\u001a\u0000\u0000yz\u0005\u0010\u0000\u0000z{\u0005\u001a\u0000\u0000"+
		"{|\u0005\b\u0000\u0000|}\u0003\u001e\u000f\u0000}\u001d\u0001\u0000\u0000"+
		"\u0000~\u007f\u0007\u0000\u0000\u0000\u007f\u001f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0082\u0005\u001a\u0000\u0000"+
		"\u0082\u0083\u0005\u0005\u0000\u0000\u0083\u0085\u0003\u001e\u000f\u0000"+
		"\u0084\u0080\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087!\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0012\u0000\u0000\u0089"+
		"\u008a\u0005\u001a\u0000\u0000\u008a\u008b\u0005\u0013\u0000\u0000\u008b"+
		"#\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0014\u0000\u0000\u008d\u008e"+
		"\u0003&\u0013\u0000\u008e\u008f\u0005\u0015\u0000\u0000\u008f%\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005\u0016\u0000\u0000\u0091\u0093\u0005\u001a"+
		"\u0000\u0000\u0092\u0094\u0003(\u0014\u0000\u0093\u0092\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\'\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0005\u0017\u0000\u0000\u0096\u0097\u0005\u001a\u0000\u0000"+
		"\u0097)\u0001\u0000\u0000\u0000\u0005;@P\u0086\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}