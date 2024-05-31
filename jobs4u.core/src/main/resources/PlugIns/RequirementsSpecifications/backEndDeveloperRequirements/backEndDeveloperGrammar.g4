grammar backEndDeveloperGrammar;

start: requirements;

requirements: '* Requirements' requirements_body;

requirements_body: requirements_atomic+;

requirements_atomic: '->' requirementName=STRING 'as' requirementsType '.';

requirementsType: 'text' ('may be' STRING)?
                | 'number' ('may be' ('^')? INTEGER ('+'?)?)
                | 'group may be one of' '[' arr ']'
                | 'yes/no may be' ('yes'|'no');

arr: STRING (',' STRING)*;

// Tokens
STRING: '"' (~["\\] | '\\' .)* '"';
BOOLEAN: 'true' | 'false';
INTEGER: ('0'|[1-9][0-9]*);

// Skip comments and whitespace
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n] -> skip;



