grammar BackEndDeveloperGrammar;

start: header interviewModel footer;

//HEADER
header: 'Create interview model' interviewName=String 'for job opening' jobOpeningReference=String 'as follows:';


//FOOTER
footer: 'Footer' score_definition '.';

score_definition: 'Passing results must score' passingScore=Decimal outstandingClause?;

outstandingClause: ', Outstanding results must' outstandingResults=Decimal;

//INTERVIEW
interviewModel: interview interviewModel
                | interview

interview: questions '\n' questionAnswer '\n' questionPoints=Decimal;

//question

questions: question questions
            | question

question: 'Question' id=Decimal ':' questionType;

questionType: trueOrFalseType
                |singleChoiceType
                |shortAnswerType
                |multipleChoiceType
                |integerType
                |dateType
                |timeType
                |scaleType
                ;

trueOrFalseType: STRING '( True or False ) with answer' answer=correctAnswer;
singleChoiceType: STRING '( Single Choice ) within options' STRING 'with answer' answer=correctAnswer;
shortAnswerType: STRING '( Short Answer ) with answer' answer=correctAnswer;
multipleChoiceType: STRING '( Multiple Choice ) within options' STRING 'with answer' answer=correctAnswer;
integerType: STRING '( Integer ) with answer' answer=correctAnswer;
dateType: STRING '( Date ) with answer' answer=correctAnswer;
timeType: STRING '( Time ) with answer' answer=correctAnswer;
scaleType: STRING '( Scale ) within range' INTEGER 'to' INTEGER 'with answer' answer=correctAnswer;

correctAnswer: BOOLEAN | INTEGER | REAL | STRING;

//answer
questionAnswers: 'Answer' INTEGER ':' correctAnswer;

//points
questionPoints: 'Awarding :' INTEGER 'points';


//Syntax tokens, sugar for the language
String: '"' ~'"'+ '"';
Decimal: '0'|[1-9][0-9]*;
REAL: Decimal ('.'|',') ([0-9]+[1-9]|'0');
BOOLEAN : 'true' | 'false';
//


//Skip comments or structural tokens.
COMMENT: '#' CommentBody '\r'?'\n' -> skip;
WS: [ \t\r\n]->skip;
//
