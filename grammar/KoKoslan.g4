/*
  @author Denis Rodriguez Viquez
          Luis Vasquez Quiros
          Walter Chavez Oviedo
  @since 2017
*/

grammar KoKoslan;


program      : definition* expression
;
definition   : 'let' id '=' expression
;
expression   : part_expr ((',' | '|') part_expr)*
;
part_expr    :  lambda_expr | evaluable_expr 
;
lambda_expr  : ('\\' pattern '.' expression) | (pattern ARROW expression) 
;
evaluable_expr    :  add_expr | (bool_expr test_expr?)
;
add_expr          :  mult_expr (add_oper mult_expr)*
;
add_oper          : oper = ('+' | '-')
;
bool_expr         : bool_Not_expr (bool_oper bool_Not_expr)*
;
bool_Not_expr	  : NOT*value_expr
;
bool_oper         : oper = (OR | AND | EQS | NEQ | LEQ | GEQ | LS | GS)
;
mult_expr         :  value_expr (mult_oper value_expr)*
;
mult_oper         : oper=('*' | '/')
;
test_expr         :  '?' expression ':' expression
;
// Value Expressions
value_expr   :    LEFT_PAR expression RIGHT_PAR 	#ParentValueExpr
                 | SUB expression                 #Negative
                 | 'print(' expression ')'        #PrintValue
                 | value_expr call_args	          #callValueExpr
                 | atomic_value 		              #AtomicValueExpr
				         | list_value 			              #ListValueExpr
                 | case_value			                #CaseValueExpr
				         | 'fail()' 			                #FailValue 
                 | primitive                      #PrimitiveExpr        
                 | list_pat			    	            #ListPattern        
;
primitive   :  cons | rest | first | length
;
cons        : 'cons('expression')('expression')'
;
rest        : 'rest('expression')'
;
first       : 'first('expression')'
;
length      : 'length('expression')'
;
call_args	:	'(' list_expr? ')' ( '(' list_expr? ')' )*
;
atomic_value : id | number | bool 
;
// List expressions
list_value   :  '[' list_expr? ']'
; 
list_expr    :  expression ( ','  expression)*
;

// Case expressions
case_value   :  '{' case_expr? '}'
;
case_expr    :  lambda_expr ( ','  lambda_expr)*
;

// Patterns
pattern      :  atomic_pat | list_pat
;
atomic_pat   : id | number | bool 
;
list_pat     : '[' list_body_pat? ']'
;
list_body_pat : pattern (',' pattern)* rest_body_pat?
;
rest_body_pat : '|' (id | list_pat)
;

id : ID
;
number : NUMBER
;
bool : NOT* (TRUE | FALSE)
;

////////////////////////////////////////////////////////////////
//                    Lexer    
///////////////////////////////////////////////////////////////
NUMBER : ('-')? INTEGER ('.' INTEGER)? 
;
fragment INTEGER : [0-9]+ ;

STRING : ('"' (~'"')* '"' )
;
DOT : '.'
;
BACK_SLASH : '\\'
;
COMMA : ','
;
COLON : ':'
;
QUESTION_MARK : '?'
;
LEFT_PAR : '('
;
RIGHT_PAR : ')'
;
LEFT_CURLY : '{'
;
RIGHT_CURLY : '}'
;
LEFT_BRACKET : '['
;
RIGHT_BRACKET : ']'
;
LET : 'let'
;
NOT : '!'
;
EQ : '='
;
EQS : '=='
;
NEQ : '!='
;
LEQ : '<='
;
GEQ : '>='
;
LS   : '<'
;
GS   : '>'
;
OR : '||'
;
AND: '&&'
;
TRUE : 'true'
;
FALSE : 'false'
;
MUL :   '*' 
; 
DIV :   '/' 
;
ADD :   '+' 
;
SUB :   '-' 
;
ARROW:    '->'
;
ID : [a-zA-Z][a-zA-Z_0-9]* 
;
PRINT: 'print'
;
////////////////////////////////////////////////
// Ignored tokens
SLC :   '/*'.*? '*/' -> skip
;
MLC : '//'.*?'\r'?'\n' -> skip
;         
WS  : [ \t\r\n]+ -> skip
; 


