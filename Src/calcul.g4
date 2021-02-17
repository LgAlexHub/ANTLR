grammar calcul;

@parser::members {
    private TablesSymboles tablesSymboles = new TablesSymboles();
    private String evalexpr (String op) {
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
// On initialise code, pour ensuite l'utiliser comme accumulateur 
	@after { System.out.println($code); }:(decl { $code += $decl.code; })* NEWLINE* (
		instruction { $code += $instruction.code;}
	)*EOF { $code += "  HALT\n"; };

decl
	returns[ String code ]:
    TYPE IDENTIFIANT '=' instruction{
        tablesSymboles.putVar($IDENTIFIANT.text,"int");
        $code=$instruction.code;
    }
    |TYPE IDENTIFIANT finInstruction {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
            $code = "PUSHI 0 \n";
        }
    ;

assignation
	returns[ String code ]:
	IDENTIFIANT '=' expression{  
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code+"STOREG "+at.adresse+"\n";
        };

instruction
	returns[ String code ]:
	expression finInstruction { 
            $code=$expression.code;
        }
	| assignation finInstruction { 
            $code= $assignation.code;
        }
	| finInstruction {
            $code="";
        };


expression
	returns[ String code ]:
	'(' a = expression ')' {
        $code = $a.code;
    }
	| oa = expression op = ('*' | '/') b = expression {
        $code = $a.code  + $b.code +  evalexpr($op.getText());
        }
	| a = expression op = ('+' | '-') b = expression {
        $code = $a.code  + $b.code +  evalexpr($op.getText());
        }
	| '-' ENTIER {
        $code = "PUSHI -"+$ENTIER.getText()+"\n";
        }
	| ENTIER {
        $code = "PUSHI "+$ENTIER.getText()+"\n";
        };

//=== LEXER ===
finInstruction: ( NEWLINE | ';' )+;

TYPE: 'int' | 'float';

IDENTIFIANT: ('a' ..'z')+;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

OPERATOR: '+' | '-' | '*' | '/';

UNMATCH: . -> skip;