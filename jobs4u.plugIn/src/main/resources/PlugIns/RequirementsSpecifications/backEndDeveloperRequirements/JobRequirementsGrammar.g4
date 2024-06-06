grammar JobRequirementsGrammar;

start: header requirements+ EOF;

header: text=STRING;

requirements: 'Requirement' id=INTEGER (requirementType answersType) +  #requirement;

requirementType: trueOrFalseRequirement
                | shortAnswerRequirement
                | academicDegreeRequirement
                | programingLanguages
                | integerRequirement
                ;

trueOrFalseRequirement: text=STRING 'TrueOrFalse:';

academicDegreeRequirement: text=STRING 'AcademicDegree:';
shortAnswerRequirement: text=STRING 'ShortAnswer:';

programingLanguages: text=STRING 'Programming Languages:';

integerRequirement: text=STRING 'Integer:';

correctAnswer: BOOLEAN | INTEGER | REAL | STRING;

answersType: trueOrFalseAnswer | shortAnswerAnswer | academicDegreeAnswer | languagesAnswer | integerAnswer;

trueOrFalseAnswer: BOOLEAN;
shortAnswerAnswer: correctAnswer;
academicDegreeAnswer: NONE | BACHELOR | MASTER | DOCTORATE;
languagesAnswer: languages (',' languages)*;
integerAnswer: INTEGER;

languages: JAVA | JAVASCRIPT | PHYTON;

// Tokens
STRING: '"' (~["\\] | '\\' .)* '"';
BOOLEAN: 'true' | 'false';
INTEGER: ('0' | [1-9][0-9]*);
REAL: [0-9]+ '.' [0-9]+;

// Skip comments and whitespace
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

NONE: 'None';
BACHELOR: 'Bachelor';
MASTER: 'Master';
DOCTORATE: 'Doctorate';

JAVA: 'Java';
JAVASCRIPT: 'JavaScript';
PHYTON: 'Phyton';