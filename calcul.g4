grammar calcul;

@parser::members {
    private TablesSymboles tablesSymboles = new TablesSymboles();
    private int _cur_label = 1;

    private String getNewLabel() { 
        return "B" +(_cur_label++); 
    }

    private String evalexpr (String op, String type) {
        if ( op.equals("*") ){
            return (type == "float" ? "FMUL\n":"MUL\n");
        } else if ( op.equals("+") ){
            return (type == "float" ? "FADD\n":"ADD\n");
        } else if ( op.equals("-") ){
                    (type == "float" ? "FSUB\n":"SUB\n");
        } else if ( op.equals("/") ){
                            (type == "float" ? "FDIV\n":"DIV\n");
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

    private String floatOrInt(String type){
        return ((type == "float" | type =="FLOAT")? "PUSHF" : "PUSHI"); 
    }
}

start
	returns[ String code ]
	@init { $code = new String();}
	@after { System.out.println($code);}
    : 
        (decl {$code += $decl.code; })* 
        {$code += "  JUMP Main\n"; }
        NEWLINE*
        (fonction {$code += $fonction.code; })* 
        NEWLINE* 
        { $code += "LABEL Main\n"; } 
        (instruction { $code += $instruction.code; })* 
        { $code += "  HALT\n";  };

decl
	returns[ String code ]:
	TYPE IDENTIFIANT '=' expression {
        tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
        $code=$expression.code;
        System.out.println("DEBUG=>"+$code);
        if(tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse<0){
            $code+="STOREL "+tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse+"\n";
        }else{
            $code+="STOREG "+tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse+"\n";
        }
    }| TYPE IDENTIFIANT  {
        tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
        $code = "PUSHF 0.0 \n";
        };

assignation
	returns[ String code ]:
    IDENTIFIANT '=' expression {  
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code = $expression.code+"STOREL "+at.adresse+"\n";
        }else{
            $code = $expression.code+"STOREG "+at.adresse+"\n";
        }            
    }|IDENTIFIANT '+=' expression {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+=$expression.code;
            $code+="ADD \n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code ="PUSHG "+at.adresse+"\n";
            if (at.type == "FLOAT" || at.type == "float"){
                $code+=$expression.code;
                $code+="FADD \n";
                $code+="STOREG "+at.adresse+"\n";
            }else{
                $code+=$expression.code;
                $code+="ADD \n";
                $code+="STOREG "+at.adresse+"\n";
            }
        }
    }| IDENTIFIANT '++' {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="ADD\n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code = "PUSHG "+at.adresse+"\n";
            if (at.type == "FLOAT" || at.type == "float"){
                $code+="PUSHF 1.0\n";
                $code+="FADD\n";
            }else{
                $code+="PUSHI 1\n";
                $code+="ADD\n";
            }
           $code+="STOREG "+at.adresse+"\n";
        }
    }|IDENTIFIANT '--' {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        if(at.adresse<0){
            $code ="PUSHL "+at.adresse+"\n";
            $code+="PUSHI 1\n";
            $code+="SUB\n";
            $code+="STOREL "+at.adresse+"\n";
        }else{
            $code="PUSHG "+at.adresse+"\n";
            if (at.type == "float" || at.type="FLOAT"){
                $code+="PUSHF 1.0\n";
                $code+="FSUB\n";
            }else{
                $code+="PUSHI 1\n";
                $code+="SUB\n";
            }
            $code+="STOREG "+at.adresse+"\n";
        } 
    };

instruction
	returns[ String code ]
    @init{String code = new String();}:
    RETURN instruction {
        AdresseType at = tablesSymboles.getAdresseType("RETURN__FUNC_RES");
        $code=$instruction.code+"STOREL "+at.adresse+" \n RETURN";
    }|expression finInstruction { 
        $code=$expression.code;
    }|decl finInstruction {
        $code=$decl.code;
    }|assignation finInstruction { 
        $code=$assignation.code;
    }| branchements {
        $code=$branchements.code;
    }| loop {
        $code = $loop.code;
    }| finInstruction {
            $code="";
    };
	

expression
	returns[ String code, String type ]:
	READ PARENTHESE_O IDENTIFIANT PARENTHESE_F {
        $code = read_func($IDENTIFIANT.text);
    }|WRITE  a = expression {
        $code = $a.code + "WRITE\nPOP\n";
    }| PARENTHESE_O a = expression PARENTHESE_F {
        $code = $a.code;
    }| a = expression op = ('*' | '/') b = expression {
        $type = $a.type;
        $code= $a.code;
        $code+=$b.code;
        $code+= evalexpr($op.getText(),$type.text);
    }|a = expression op = ('+' | '-') b = expression {
        $type = $a.type;
        $code= $a.code;
        $code+=$b.code;
        $code+=evalexpr($op.getText(),$type.text);
    }|d=element{
        $type = $a.type;
        $code = $d.code;
    }| IDENTIFIANT '(' args ')' // appel de fonction  -
	{  
        $code="PUSHI 0\n";
        $code+= $args.code;
        $code+="CALL "+$IDENTIFIANT.text+"\n";
        for(int i = 0 ; i< $args.size;i++)
        $code+="POP\n";
    }
;

element 
    returns[String code, String type]: 
        '-' FLOAT {
            $code = "PUSHF -"+$FLOAT.text;
            $type="float";
        }|FLOAT{
            $code="PUSHF "+$FLOAT.text;
              $type="float";
        }
        |'-' ENTIER {
            $code = "PUSHI -"+$ENTIER.getText()+"\n";
            $type ="int";
        }| ENTIER {
            $code = "PUSHI "+$ENTIER.getText()+"\n";
            $type="int";
        }| '-' IDENTIFIANT {
            int addr = tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse;
            if (addr < 0){
                $code="PUSHL "+addr;
                $code+="PUSHI -1\n MUL\n";
                $type="int";
            }else{
                $code="PUSHG "+addr;
                if (tablesSymboles.getAdresseType($IDENTIFIANT.text).type == "float" || tablesSymboles.getAdresseType($IDENTIFIANT.text).type == "FLOAT"){
                    $code+="PUSHF -1\n MUL\n";
                      $type="float";
                }else{
                    $code+="PUSHI -1\n MUL\n";
                    $type="int";
                }
                
            }   
        }|IDENTIFIANT {
            int addr = tablesSymboles.getAdresseType($IDENTIFIANT.text).adresse;
            if (addr < 0){
                $code = "PUSHL "+addr+"\n";
                type="int";
            }else{
                $code = "PUSHG "+addr+"\n";
                if (tablesSymboles.getAdresseType($IDENTIFIANT.text).type=="float"){
                    type="float";
                }else{
                    type="int";
                }
            } 
        }
    ;


condition
	returns[String code]:
	'true' {
        $code="PUSHI 1\n";
	}| 'false' {
        $code="PUSHI 0\n";
    }| PARENTHESE_O k = condition PARENTHESE_F {
        $code=$k.code;
    }| '!' condition {
        $code =$condition.code;
        $code+="PUSHI 0\n";
        $code+="EQUAL\n";
    }| c = condition '&&' d = condition {
        $code=$c.code;
        $code+=$d.code;
        $code+="MUL\n";
        $code+="PUSHI 1\n";
        $code+="EQUAL\n";
    }| g = condition '||' e = condition {
        $code=$g.code;
        $code+=$e.code;
        $code+="ADD\n";
        $code+="PUSHI 1\n";
        $code+="SUPEQ\n";
    }| a = expression OPERATORLOG b = expression {
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
    }| ('for' | 'FOR') PARENTHESE_O d = assignation ';' e = condition ';' f = assignation
		PARENTHESE_F g = bloc_code {
        $code=$d.code;
        $code+="LABEL "+getNewLabel()+"\n";
        $code+=$e.code;
        $code+="JUMPF B"+(_cur_label)+"\n";
        $code+=$g.code;
        $code+=$f.code;
        $code+="JUMP B"+(_cur_label-1)+"\n";
        $code+="LABEL "+getNewLabel()+"\n";
    }| ('repeat' | 'REPEAT') g = bloc_code ('until' | 'UNTIL') PARENTHESE_O h = condition
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
	('if' | 'IF') PARENTHESE_O a = condition PARENTHESE_F b = bloc_code ('else'| 'ELSE') c = bloc_code {
        $code = $a.code;
        $code+="JUMPF "+getNewLabel()+"\n";
        $code+=$b.code;
        $code+="JUMP "+getNewLabel()+"\n";
        $code+="LABEL B"+(_cur_label-2)+"\n";
        $code+=$c.code;
        $code+="LABEL B"+(_cur_label-1)+"\n";
    }| ('if' | 'IF') PARENTHESE_O a = condition PARENTHESE_F b = bloc_code {
        $code = $a.code;
        $code+="JUMPF "+getNewLabel()+"\n";
        $code+=$b.code;
        $code+="LABEL "+(_cur_label-1)+"\n";
    };

bloc_code
	returns[String code]
    @init{ $code = new String(); }:
    ('{'(instruction {$code += $instruction.code; })*'}'|instruction{$code+=$instruction.code;});

fonction
	returns[ String code ]
	@init { tablesSymboles.newTableLocale();tablesSymboles.putVar("RETURN__FUNC_RES","int"); } 
	@after {tablesSymboles.dropTableLocale(); } : 
	TYPE IDENTIFIANT '(' params? ')' {
        tablesSymboles.newFunction($IDENTIFIANT.text,$TYPE.text);
        $code = "LABEL "+$IDENTIFIANT.text+"\n";
    } a = bloc_code {
           $code += $a.code+"RETURN\n";
    };

params:
	TYPE IDENTIFIANT { 
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
    } (',' TYPE IDENTIFIANT { 
        tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
    }
    )*;

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

READ : ('READ' | 'read') ;

WRITE : ('WRITE' | 'write');

PARENTHESE_O: '(';

PARENTHESE_F: ')';

TYPE: 'int' | 'float' | 'void';

IDENTIFIANT: ('a' ..'z')+;

LOOP_WORD: 'WHILE' | 'FOR';

NEWLINE: '\r'? '\n' ;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

FLOAT: ('0..9')+'.'('0..9')+;

OPERATOR: '+' | '-' | '*' | '/';

OPERATORLOG: '<' | '>' | '<=' | '>=' | '==' | '!=';

// lexer
RETURN: 'return';

UNMATCH: . -> skip;