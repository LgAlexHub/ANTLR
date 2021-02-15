grammar calculette;

@parser::members {
    private int evalexpr (int x, String op, int y) {
        if ( op.equals("*") ){
            return x*y;
        } else if ( op.equals("+") ){
            return x+y;
        } else if ( op.equals("-") ){
                    return x-y;
        } else if ( op.equals("/") ){
                            return x/y;
        } else {
           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
        }
    }

}

start
    : total=expr EOF {System.out.println($total.result);};

expr returns [int result]
    : expr_o op=OPERATOR res2=expr_f {$result = evalexpr($expr_o.result,$op.getText(),$expr_f.result);}
    | ent=ENTIER {$result = Integer.parseInt($ent.text);}
    ;
expr_o returns [int result]:
    '(' expr {$result = $expr.result;}| ent=ENTIER {$result = Integer.parseInt($ent.text);}
;
expr_f returns [int result]:
    expr ')' {$result=$expr.result;}| ent=ENTIER {$result= Integer.parseInt($ent.text);}
;

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            // à compléter
        }
   | finInstruction
        {
            $code="";
        }
    ;

expression returns [ String code ]
    : 
    // à compléter
    ;

finInstruction : ( NEWLINE | ';' )+ ;



// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER: ('0'..'9')+  ;

OPERATOR : '+' | '-' | '*' | '/';

UNMATCH : . -> skip ;