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
    
        private String evalexprconditions (String op) {
        if ( op.equals(">") ){
            return "SUP\n";
        } else if ( op.equals("<") ){
            return "INF\n";
        } else if ( op.equals("<=") ){
            return "INFEQ\n";
        } else if ( op.equals(">=") ){
            return "SUPEQUAL\n";
        } else if ( op.equals("==") ){
            return "EQUAL\n";
        }else if ( op.equals("!=") ){
            return "NEQ\n";
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
	@init { $code = new String(); }
	// On initialise $code, pour ensuite l'utiliser comme accumulateur 
	@after { System.out.println($code); }: (decl { $code += $decl.code; })* { $code += "  JUMP Main\n"; } NEWLINE* (
		fonction { $code += $fonction.code; }
	)* NEWLINE* { $code += "LABEL Main\n"; } (
		instruction { $code += $instruction.code; }
	)* { $code += "  HALT\n"; };

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
	IDENTIFIANT '+=' expression {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+=$expression.code;
            $code+="ADD \n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code ="PUSHG "+at.adresse+"\n";
            $code+=$expression.code;
            $code+="ADD \n";
            $code+="STOREG "+at.adresse+"\n";
        }
    }
	| IDENTIFIANT '++' {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="ADD\n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code ="PUSHG "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="ADD\n";
            $code+="STOREG "+at.adresse+"\n";
        }
    }
	| IDENTIFIANT '--' {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="SUB\n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code ="PUSHG "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="SUB\n";
            $code+="STOREG "+at.adresse+"\n";
        } 
    }
	| IDENTIFIANT '=' expression {  
            
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if(at.adresse<0){
                $code = $expression.code+"STOREL "+at.adresse+"\n";
            }else{
                $code = $expression.code+"STOREG "+at.adresse+"\n";
            }            
    };

instruction
	returns[ String code ]:
	assignation finInstruction { 
            $code=$assignation.code;
    }
	| branchements {
        $code=$branchements.code;
    }
	| loop {
          $code = $loop.code;
    }
	| expression finInstruction { 
            $code=$expression.code;
    }
	| finInstruction {
            $code="";
        };

expression
	returns[ String code, String type ]:
	| ('READ' | 'read') PARENTHESE_O IDENTIFIANT PARENTHESE_F {
        $code = read_func($IDENTIFIANT.text);
    }
	| ('WRITE' | 'write') a = expression {
        $code = $a.code + "WRITE\nPOP\n";
    }
	| PARENTHESE_O a = expression PARENTHESE_F {
        $code = $a.code;
    }
	| a = expression op = ('*' | '/') b = expression {
        $code= $a.code;
        $code+=$b.code;
        $code+= evalexpr($op.getText());
        }
	| a = expression op = ('+' | '-') b = expression {
        $code= $a.code;
        $code+=$b.code;
        $code+=evalexpr($op.getText());
        }
	| '-' ENTIER {
        $code = "PUSHI -"+$ENTIER.getText()+"\n";
        }
	| ENTIER {
        $code = "PUSHI "+$ENTIER.getText()+"\n";
        }
	| '-' IDENTIFIANT {
        int addr = tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse;
        if (addr < 0){
            $code="PUSHL "+addr;
            $code+="PUSHI -1\n MUL\n";
        }else{
            $code="PUSHG "+addr;
            $code+="PUSHI -1\n MUL\n";
        }
        
    }
	| IDENTIFIANT {
        int addr = tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse;
        if (addr < 0){
            $code = "PUSHL "+addr+"\n";
        }else{
            $code = "PUSHG "+addr+"\n";
        }
        
    }
    | IDENTIFIANT '(' args ')' // appel de fonction  -
	{  
            $code="PUSHI 0\n";
            $code+= $args.code;
            $code+="CALL "+$IDENTIFIANT.text+"\n";
            for(int i = 0 ; i< $args.size;i++)
                $code+="POP\n";
    };

condition
	returns[String code]:
	'true' {
        $code="PUSHI 1\n";
	}
	| 'false' {
        $code="PUSHI 0\n";
    }
	| PARENTHESE_O k = condition PARENTHESE_F {
        $code=$k.code;
    }
	| '!' condition {
        $code =$condition.code;
        $code+="PUSHI 0\n";
        $code+="EQUAL\n";
    }
	| c = condition '&&' d = condition {
        $code=$c.code;
        $code+=$d.code;
        $code+="MUL\n";
        $code+="PUSHI 1\n";
        $code+="EQUAL\n";
    }
	| g = condition '||' e = condition {
        $code=$g.code;
        $code+=$e.code;
        $code+="ADD\n";
        $code+="PUSHI 1\n";
        $code+="SUPEQ\n";
    }
	| a = expression OPERATORLOG b = expression {
        $code=$a.code;
        $code+=$b.code;
        $code+=evalexprconditions($OPERATORLOG.text);
    };

loop
	returns[String code]:
	('while' | 'WHILE') a = condition bloc_code {
            $code="LABEL "+getNewLabel()+"\n";
            $code+=$a.code;
            $code+="JUMPF B"+(_cur_label)+"\n";
            $code+=$bloc_code.code;
            $code+=$a.code;
            $code+="JUMP B"+(_cur_label-1)+"\n";
            $code+="LABEL "+getNewLabel()+"\n";
    }
	| ('for' | 'FOR') PARENTHESE_O d = assignation ';' e = condition ';' f = assignation
		PARENTHESE_F g = bloc_code {
        $code=$d.code;
        $code+="LABEL "+getNewLabel()+"\n";
        $code+=$e.code;
        $code+="JUMPF B"+(_cur_label)+"\n";
        $code+=$g.code;
        $code+=$f.code;
        $code+="JUMP B"+(_cur_label-1)+"\n";
        $code+="LABEL "+getNewLabel()+"\n";
    }
	| ('repeat' | 'REPEAT') g = bloc_code ('until' | 'UNTIL') PARENTHESE_O h = condition
		PARENTHESE_F {
        $code ="LABEL "+getNewLabel();
        $code+=$h.code;
        $code+="JUMPF B"+(_cur_label)+"\n";
        $code+=$g.code;
        $code+="JUMP B"+(_cur_label-1)+"\n";
        $code+="LABEL "+getNewLabel()+"\n";
    };

branchements
	returns[String code]:
	('if' | 'IF') PARENTHESE_O a = condition PARENTHESE_F b = bloc_code (
		'else'
		| 'ELSE'
	) c = bloc_code {
            $code = $a.code;
            $code+="JUMPF "+getNewLabel()+"\n";
            $code+=$b.code;
            $code+="JUMP "+getNewLabel()+"\n";
            $code+="LABEL B"+(_cur_label-2)+"\n";
            $code+=$c.code;
            $code+="LABEL B"+(_cur_label-1)+"\n";
        }
	| ('if' | 'IF') PARENTHESE_O a = condition PARENTHESE_F b = bloc_code {
            $code = $a.code;
            $code+="JUMPF "+getNewLabel()+"\n";
            $code+=$b.code;
            $code+="LABEL "+(_cur_label-1)+"\n";
        };

bloc_code
	returns[String code]:
    
	('{' (instruction)* '}' | instruction) {
            $code=$instruction.code;
        };

fonction
	returns[ String code ]
	@init { tablesSymboles.newTableLocale();tablesSymboles.putVar("RETURN__FUNC_RES","int"); } // instancier la table locale
	@after {tablesSymboles.dropTableLocale(); } : // détruire la table locale
	TYPE { 
        } IDENTIFIANT '(' params? ')' { 
           $code = "LABEL "+$IDENTIFIANT.text+"\n";
        } decl* { 
            $code = $decl.code; 
        } a = bloc_code {
           $code = $a.code+"RETURN\n";
        };

params:
	TYPE IDENTIFIANT { 
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
        } (
		',' TYPE IDENTIFIANT { 
                tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            }
	)*;

// init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null) args va
// donner le nombre d'aguments et va ajouter sur la pile les variables
args
	returns[ String code, int size]
	@init { $code = new String(); $size = 0; }: (
		expression { 
        $size+=1;
        $code = $expression.code; 
    } (',' expression { 
        
        $size+=1;
        $code = $expression.code;        
    }
)*
)?;

//=== LEXER ===
finInstruction: ( NEWLINE | ';')+;

PARENTHESE_O: '(';

PARENTHESE_F: ')';

TYPE: 'int' | 'float' | 'void';

IDENTIFIANT: ('a' ..'z')+;

LOOP_WORD: 'WHILE' | 'FOR';

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

OPERATOR: '+' | '-' | '*' | '/';

OPERATORLOG: '<' | '>' | '<=' | '>=' | '==' | '!=';

UNMATCH: . -> skip;