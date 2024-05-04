grammar backEndDeveloperGrammar;

start: requirements;


requirements: BULLET_POINT_T REQUIREMENTS requirements_body;

requirements_body: requirements_atomic requirements_body    //Eventhough left recursion is supported by ANTLR4 let's not do that for compatibility issues with other parsers
                 | requirements_atomic
                 ;

//TODO Define the requirements for the language
requirements_atomic: ENTRY_T requirementName=String AS requirementsType TERMINAL_T ;


requirementsType: 'text' (MAY_BE String)?
                | 'number' MAY_BE AT_LEAST? Decimal
                | 'number' MAY_BE Decimal AND_MORE
                | 'group' MAY_BE 'one of' '[' arr ']'
                | 'yes/no' MAY_BE ('yes'|'no')
                ;
arr: arr COMA_T String
   | String
   ;



//Categories

fragment CreateCapitalized: 'Create';
fragment CreateUncapitalized: 'create';
fragment RequirementsCapitalized: 'Requirements';
fragment RequirementsUncapitalized: 'requirements';
fragment InterviewCapitalized : 'Interview';
fragment InterviewUncapitalized : 'interview';
fragment FooterCapitalized : 'Footer';
fragment FooterUncapitalized : 'footer';
fragment PassingCapitalized : 'Passing';
fragment PassingUncapitalized : 'passing';
fragment CommentBody: ~[#\n]*;
fragment QuestionCapitalized: 'Question';
fragment QuestionUncapitalized : 'question';

FOOTER: FooterCapitalized | FooterUncapitalized;
INTERVIEW: InterviewCapitalized | InterviewUncapitalized;
REQUIREMENTS: RequirementsCapitalized | RequirementsUncapitalized;
CREATE: CreateCapitalized | CreateUncapitalized;
PASSING: PassingCapitalized | PassingUncapitalized;
QUESTION: QuestionCapitalized| QuestionUncapitalized;

//


 //Semantic tokens, soul of the language and the readability to

 AND: 'and';
 AS: 'as';
 AWARDING: 'awarding';
 BEING: 'being';
 BETWEEN: 'between';
 CONDUCTED: 'conducted';
 DIFFICULTY: 'difficulty';
 FALSE: 'false';
 FOLLOWS: 'follows';
 FOR_JOB: 'for job opening';
 FROM: 'from';
 IN: 'in';
 INTERVIEW_MODEL: 'interview model';
 IS_DEFINED: 'is defined';
 ITS_VALIDATION: [Ii]'ts validation'; //Note how more necessary work is needed to understand the parsing vs the fragment approach
 MAY_BE: 'may be';
 MUST_SCORE: 'must score';
 OF:'of';
 OUTSTANDING: 'outstanding';
 ORDER: 'order';
 RESULTS: 'results';
 SHOULD_BE:'should be';
 TRUE: 'true';
 TYPE: 'type';
 WITH: 'with';

 //

 //Syntax tokens, sugar for the language
 BULLET_POINT_T: '*';
 COMA_T: ',';
 ENTRY_T: '->';
 SPECIFICATION_T: ':';
 TERMINAL_T: '.';
 String: '"' ~'"'+ '"';
 Decimal: '0'|[1-9][0-9]*;
 Real: Decimal (TERMINAL_T|COMA_T) ('0' | [0-9]*[1-9]);
 AND_MORE: '+';
 AT_LEAST: '^';

 ORDER_TYPE: ([rR]'andom'|[pP]'riority'|[dD]'ifficulty');
 ORDER_METHOD: ([aA]'scending'|[dD]'escending');




 //


 //Skip comments or structural tokens.
 COMMENT: '#' CommentBody '\r'?'\n' -> skip;
 WS: [ \t\r\n]->skip;
 //


 TRUE_FALSE: [tT]'rue/false';
 SHORT_TEXT: [sS]'hort text';
 SINGLE_CHOICE: [sS]'ingle choice';
 MULTIPLE_CHOICE: [mM]'ultiple choice';
 INTEGER_NUMBER: [iI]'nteger number';
 REAL_NUMBER: [rR]'eal number';
 DATE: [dD]'ate';
 TIME: [tT]'ime';
 SCALE: [sS]'cale';
 ID:'id';