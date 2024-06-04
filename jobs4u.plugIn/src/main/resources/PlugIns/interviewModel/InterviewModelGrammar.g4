grammar InterviewModelGrammar;

start: header interviewModel footer EOF;

//HEADER
header: 'Create interview model' interviewName=STRING 'for job opening' jobOpeningReference=STRING 'as follows:';

//INTERVIEW
interviewModel: interview+ ;

interview: questions questionAnswers questionPoints #evaluation;

//questions
questions: question+ ;

question: 'Question' id=INTEGER ':' questionType;

questionType: trueOrFalseQuestion
                |singleChoiceQuestion
                |shortAnswerQuestion
                |multipleChoiceQuestion
                |integerQuestion
                |decimalQuestion
                |dateQuestion
                |timeQuestion
                |scaleQuestion
                ;

trueOrFalseQuestion: STRING '( True or False ) with answer' answer=BOOLEAN;
singleChoiceQuestion: STRING '( Single Choice ) within options' STRING 'with answer' answer=correctAnswer;
shortAnswerQuestion: STRING '( Short Answer ) with answer' answer=correctAnswer;
multipleChoiceQuestion: STRING '( Multiple Choice ) within options' STRING 'with answer' answer=correctAnswer;
integerQuestion: STRING '( Integer ) with answer' answer=INTEGER;
decimalQuestion: STRING '( Decimal ) with answer' answer=REAL;
dateQuestion: STRING '( Date ) with answer' answer=correctAnswer;
timeQuestion: STRING '( Time ) with answer' answer=correctAnswer;
scaleQuestion: STRING '( Scale ) within range' INTEGER 'to' INTEGER 'with answer' answer=correctAnswer;

correctAnswer: BOOLEAN | INTEGER | REAL | STRING;
//answers
questionAnswers: ('Answer' id=INTEGER ':' answer=correctAnswer)+ ;

//points
questionPoints: 'Awarding :' points=INTEGER 'points';

//FOOTER
footer: 'Footer' score_definition '.';

score_definition: 'Passing results must score' passingScore=INTEGER outstandingClause?;

outstandingClause: ', Outstanding results must' outstandingResults=INTEGER;

//Syntax tokens, sugar for the language
STRING: '"' (~["\\] | '\\' .)* '"';
BOOLEAN: 'true' | 'false';
INTEGER: ('0'|[1-9][0-9]*);
REAL: INTEGER ('.'|',') ([0-9]+[1-9]|'0');

//Skip comments or structural tokens.
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n] -> skip;
