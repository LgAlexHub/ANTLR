grammar calcul;

@parser::members {
    private String evalexpr (String x, String op, String y) {
        if ( op.equals("*") ){
            return "MUL\n";
        } else if ( op.equals("+") ){
            return "ADD\n";
        } else if ( op.equals("-") ){
                    return "SUB\n";
        } else if ( op.equals("/") ){
                            return "DIV\n";
        } else {
           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
        }
    }

}


start
	returns[ String code ]
	@init { $code = new String(); }
	@after { System.out.println($code); }:
	NEWLINE* (instruction { $code += $instruction.code; })* { $code += "  HALT\n"; };

instruction
	returns[ String code ]:
	expression finInstruction { 
            $code=$expression.code;
        }
	| finInstruction {
            $code="";
        };
finInstruction: ( NEWLINE | ';')+;

expression returns [ String code ]: 
    '('a=expression')'{
        $code = $a.code;
    }
    |a=expression op=('*'|'/') b=expression{
        $code = $a.code  + $b.code +  evalexpr($a.code,$op.getText(),$b.code);
    }
    |a=expression op=('+'|'-') b=expression{
        $code = $a.code  + $b.code +  evalexpr($a.code,$op.getText(),$b.code);
    }
    |'-'ENTIER{$code = "PUSHI -"+$ENTIER.getText()+"\n";}
    |ENTIER{
        $code = "PUSHI "+$ENTIER.getText()+"\n";
    }
    
;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

OPERATOR: '+' | '-' | '*' | '/';

UNMATCH: . -> skip;