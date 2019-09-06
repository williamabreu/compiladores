lexer grammar Scanner;

DEC: 'DECLARACOES';
ALG: 'ALGORITMO';
INT: 'INTEIRO';
REA: 'REAL';
ATR: 'ATRIBUIR';
LER: 'LER';
IMP: 'IMPRIMIR';
SE: 'SE';
ENT: 'ENTAO';
ENQ: 'ENQUANTO';
INI: 'INICIO';
FIM: 'FIM';
A: 'A';

OpArit: '*'|'/'|'+'|'-';

OpRel: '<'|'<='|'>='|'>'|'='|'<>';

Delim: ':';

AP: '(';
FP: ')';

Var: ('a'..'z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

NumI: ('0'..'9')+;
NumR: ('0'..'9')+ ',' ('0'..'9');
Str: '"' (~('\\'|'"') )* '"';

NEWLINE: '\r'? '\n' -> skip;
WS  :    [ \t]+ -> skip;
COMMENT: '%' ~'\n'* -> skip;
