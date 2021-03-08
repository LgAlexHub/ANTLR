grammar calcul;

@parser::members {
     private int _cur_label = 1;
    /** générateur de nom d'étiquettes pour les boucles */
    private String getNewLabel() { 
        return "B" +(_cur_label++); 
    }
    //...

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

    private String read_func(String arg){
        AdresseType at = tablesSymboles.getAdresseType(arg);
        String res = ""; 
        if (at == null)  throw new IllegalArgumentException("Adresse inconnu ou variable non déclarée");
        else res+="READ \n STOREG "+tablesSymboles.getAdresseType(arg).adresse+" \n";
        return res;
    }
}

start
	returns[ String code ]
	@init { 
        $code = new String();
    }
// On initialise code, pour ensuite l'utiliser comme accumulateur 
	@after { System.out.println($code); }: (decl { $code += $decl.code; })* NEWLINE* (
		instruction { $code += $instruction.code;}
	)* EOF { $code += "  HALT\n"; };

decl
	returns[ String code ]:
	TYPE IDENTIFIANT '=' instruction {
        tablesSymboles.putVar($IDENTIFIANT.text,"int");
        $code=$instruction.code;
    }
	| TYPE IDENTIFIANT finInstruction {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
            $code = "PUSHI 0 \n";
        };

assignation
	returns[ String code ]:
	IDENTIFIANT '=' expression {  
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
	('READ'|'read') PARENTHESE_O IDENTIFIANT PARENTHESE_F{
        $code = read_func($IDENTIFIANT.text);
    }
    |('WRITE'|'write') a=expression{
        $code = $a.code + "WRITE \n";
    }
	| PARENTHESE_O a = expression PARENTHESE_F {
        $code = $a.code;
    }
	| a = expression op = ('*' | '/') b = expression {
        $code = $a.code  + $b.code +  evalexpr($op.getText());
        }
	| a = expression op = ('+' | '-') b = expression {
        $code = $a.code  + $b.code +  evalexpr($op.getText());
        }
    |'-' ENTIER {
        $code = "PUSHI -"+$ENTIER.getText()+"\n";
        }
	| ENTIER {
        $code = "PUSHI "+$ENTIER.getText()+"\n";
        }
	| '-' IDENTIFIANT {
        $code = "PUSHG "+tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse + "PUSHI -1\n MULT \n";
    }
	| IDENTIFIANT {
        $code = "PUSHG "+tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse+"\n";
    };

condition
	returns[String code]: 'true' {$code="PUSHI 0\n";} | 'false' {$code="PUSHI 0\n";};

//=== LEXER ===
finInstruction: ( NEWLINE | ';')+;

PARENTHESE_O: '(';

PARENTHESE_F: ')';

TYPE: 'int' | 'float';

IDENTIFIANT: ('a' ..'z')+;

LOOP_WORD: 'WHILE' | 'FOR';

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

OPERATOR: '+' | '-' | '*' | '/';

UNMATCH: . -> skip;