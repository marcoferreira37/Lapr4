grammar JobRequirementsGrammar;

start: header requirements+ EOF;

header: text=STRING;


requirements: 'Requirement' id=INTEGER requirementType;

requirementType: trueOrFalseRequirement
                | shortAnswerRequirement
                | integerRequirement
                ;

trueOrFalseRequirement: text=STRING 'TrueOrFalse:' answer=BOOLEAN;

shortAnswerRequirement: text=STRING 'ShortAnswer:' answer=correctAnswer;

integerRequirement: text=STRING 'Integer:' answer=INTEGER;

correctAnswer: BOOLEAN | INTEGER | REAL | STRING;

// Tokens
STRING: '"' (~["\\] | '\\' .)* '"';
BOOLEAN: 'true' | 'false';
INTEGER: ('0' | [1-9][0-9]*);
TRUEORFALSEANSWER: 'True' | 'False' | 'true' | 'false';

// Skip comments and whitespace
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;
