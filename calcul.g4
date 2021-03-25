grammar calcul;

@parser::members {
    private int _cur_label = 1;
    private TablesSymboles tablesSymboles = new TablesSymboles();

    private String getNewLabel()
    {
        return "B" +(_cur_label++);
    }

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

start returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :
        (decl { $code += $decl.code; })* 
        { $code += "JUMP Main\n"; }

        NEWLINE*

        (fonction { $code += $fonction.code; })*
        NEWLINE*

        { $code += "LABEL Main\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

instruction returns [ String code ]
    : expression finInstruction{
            $code=$expression.code;
    }| finInstruction{
            $code="";
    }| decl {
            $code=$decl.code;
    }| assignation finInstruction{
        $code=$assignation.code;
    }|loop{
        $code = $loop.code;
    }| branchements{
        $code = $branchements.code;
    } | 'return' expression finInstruction {
            AdresseType at = tablesSymboles.getAdresseType("return");
            $code = $expression.code+"\nSTOREL "+at.adresse+"\n";
            $code += "RETURN\n";
        }
    ;

expression returns [ String code, String type]:
    '(' expression ')' {
        $code=$expression.code;
    }|res1=expression op=('*'|'/') res2=expression{
            $type = $res1.type;
            $code=$res1.code;
            $code+=$res2.code;
            $code+=evalexpr($op.getText());
    }| res1=expression op=('+'|'-') res2=expression{
            $type = $res1.type;
            $code=$res1.code;
            $code+=$res2.code;
            $code+=evalexpr($op.getText());
    }|element {
        $type = $element.type;
        $code = $element.code;
    }|IDENTIFIANT '(' args ')'{
        String type = tablesSymboles.getFunction($IDENTIFIANT.text);
        if(type.equals("int"))
        {
            $code = "PUSHI 0\n";
        }
        if($args.code!=null)
            $code+=$args.code;
        $code+="CALL "+$IDENTIFIANT.text+"\n";
        for(int i=0;i<$args.size;i++)
            $code+="POP\n";
    }|READ PARENTHESE_O IDENTIFIANT PARENTHESE_F {
        $code = read_func($IDENTIFIANT.text);
    }|WRITE  a = expression {
        $code = $a.code + "WRITE\nPOP\n";
    }
;

decl returns [ String code ]:
        TYPE IDENTIFIANT finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            String type = ($TYPE.text).toLowerCase();
            if(type.equals("int"))
                $code = "PUSHI 0\n";
            else if (type.equals("float"))
                $code = "PUSHF 0.0\n";
        }
        |
        TYPE IDENTIFIANT '=' element finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            String type = ($TYPE.text).toLowerCase();
            if(type.equals("int"))
            {
                $code = "PUSHI 0\n";
            }
            else if (type.equals("float"))
            {
                $code = "PUSHF 0.0\n";
            }
            if(at.adresse>=0)
                $code += $element.code+"STOREG "+at.adresse+"\n";
            else
                $code += $element.code+"STOREL "+at.adresse+"\n";
        }
    ;

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
            if (at.type == "float" || at.type=="FLOAT"){
                $code+="PUSHF 1.0\n";
                $code+="FSUB\n";
            }else{
                $code+="PUSHI 1\n";
                $code+="SUB\n";
            }
            $code+="STOREG "+at.adresse+"\n";
        } 
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

element 
    returns[String code, String type]: 
        '-' VIRGULE {
            $code = "PUSHF -"+$VIRGULE.text+"\n";
            $type="float";
        }|VIRGULE{
            $code="PUSHF "+$VIRGULE.text+"\n";
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
                $type="int";
            }else{
                $code = "PUSHG "+addr+"\n";
                if (tablesSymboles.getAdresseType($IDENTIFIANT.text).type=="float"){
                    $type="float";
                }else{
                    $type="int";
                }
            } 
        }
    ;



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
    }| ('repeat' | 'REPEAT') g = bloc_code ('until' | 'UNTIL') PARENTHESE_O h = condition PARENTHESE_F {
        String label = getNewLabel();
        $code ="LABEL "+label+"\n";
        $code+=$g.code;
        $code+=$h.code;
        $code+="JUMPF "+label+"\n";
    };

bloc_code
	returns[String code]
    @init{ $code = new String(); }:
        '{'(instruction {$code += $instruction.code; })*'}'
    |
        instruction{$code+=$instruction.code;}
    
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



finInstruction : ( NEWLINE | ';' )+ ;


fonction returns [ String code ]
@init{tablesSymboles.newTableLocale();tablesSymboles.putVar("return","int");}
@after{tablesSymboles.dropTableLocale();}
    : TYPE IDENTIFIANT '('  params ? ')'
        {
            tablesSymboles.newFunction($IDENTIFIANT.text, $TYPE.text);
            $code = "LABEL "+$IDENTIFIANT.text+"\n";
        }
        bloc_code
        {
            $code += $bloc_code.code;
        }
    ;


params:
        TYPE IDENTIFIANT
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
        }
        ( ',' TYPE IDENTIFIANT
            {
                tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            }
        )*
    ;


args returns [ String code, int size] @init{ $code = new String(); $size = 0; }:
    ( expression
    {
        $code = $expression.code;
        $size += 1;
    }
    ( ',' expression
    {
        $code += $expression.code;
        $size += 1;
    }
    )*
      )?
    ;

VIRGULE: ('0'..'9')+ '.' ('0'..'9')+;

ENTIER: ('0' ..'9')+;

RETURN: 'return'| 'RETURN';

READ : ('READ' | 'read') ;

WRITE : ('WRITE' | 'write');

PARENTHESE_O: '(';

PARENTHESE_F: ')';

TYPE: 'int' | 'float' | 'void';

IDENTIFIANT: ('a' ..'z')+;

LOOP_WORD: 'WHILE' | 'FOR';

NEWLINE: '\r'? '\n' ;

WS : (' ' | '\t')+ -> skip;

OPERATOR: '+' | '-' | '*' | '/';

OPERATORLOG: '<' | '>' | '<=' | '>=' | '==' | '!=';

// lexer


UNMATCH: . -> skip;
