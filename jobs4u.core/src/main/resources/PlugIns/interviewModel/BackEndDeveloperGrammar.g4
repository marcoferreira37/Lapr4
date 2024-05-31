grammar BackEndDeveloperGrammar;

start: header interviewModel footer;

//HEADER
header: 'Create interview model' interviewName=STRING 'for job opening' jobOpeningReference=STRING 'as follows:';

//INTERVIEW
interviewModel: interview+ ;

interview: questions questionAnswers questionPoints;

//questions
questions: question+ ;

question: 'Question' id=INTEGER ':' questionType;

questionType: trueOrFalseType
            | singleChoiceType
            | shortAnswerType
            | multipleChoiceType
            | integerType
            | dateType
            | timeType
            | scaleType;

trueOrFalseType: STRING '( True or False ) with answer' answer=correctAnswer;
singleChoiceType: STRING '( Single Choice ) within options' STRING 'with answer' answer=correctAnswer;
shortAnswerType: STRING '( Short Answer ) with answer' answer=correctAnswer;
multipleChoiceType: STRING '( Multiple Choice ) within options' STRING 'with answer' answer=correctAnswer;
integerType: STRING '( Integer ) with answer' answer=correctAnswer;
dateType: STRING '( Date ) with answer' answer=correctAnswer;
timeType: STRING '( Time ) with answer' answer=correctAnswer;
scaleType: STRING '( Scale ) within range' INTEGER 'to' INTEGER 'with answer' answer=correctAnswer;

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

//Skip comments or structural tokens.
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n] -> skip;
