

%{
// * Declaraciones de c�digo Java
// * Se sit�an al comienzo del archivo generado
// * El package lo a�ade yacc si utilizamos la opci�n -Jpackage
import lexico.Lexico;
import pregunta.Pregunta;
%}

// * Declaraciones Yacc
%token DOBLESPUNTOS
%token ID
%token FR

%%

programa: listapreguntas 
		; 

listapreguntas: pregunta | pregunta listapreguntas
		;
		
pregunta : DOBLESPUNTOS ID DOBLESPUNTOS FR '{' tiporespuesta FR tiporespuesta FR tiporespuesta FR tiporespuesta FR '}' 
{$$ = new Pregunta ((String)$2, (String)$4, (String) $7, (String) $9, (String) $11, (String) $13); }
		;

tiporespuesta: '~'
		| '='
		;



%%



// * C�digo Java
// * Se crea una clase "Parser", lo que aqu� ubiquemos ser�:
//	- Atributos, si son variables
//	- M�todos, si son funciones
//   de la clase "Parser"

// * Estamos obligados a implementar:
//	int yylex()
//	void yyerror(String)

// * Referencia al analizador l�xico
private Lexico lexico;

// * Llamada al analizador l�xico
private int yylex () {
    int token=0;
    try { 
	token=lexico.yylex(); 
    } catch(Throwable e) {
	    System.err.println ("Error L�xico en l�nea " + lexico.getLinea()+
		" y columna "+lexico.getColumna()+":\n\t"+e); 
    }
    return token;
}



// * Manejo de Errores Sint�cticos
public void yyerror (String error) {
    System.err.println ("Error Sint�ctico en l�nea " + lexico.getLinea()+
		" y columna "+lexico.getColumna()+":\n\t"+error);
}

// * El yylval no es un atributo p�blico
public Object getYylval() {
    	return yylval;
}
public void setYylval(Object yylval) {
        this.yylval = yylval;
}

// * Constructor del Sint�ctico
public Parser(Lexico lexico) {
	this.lexico = lexico;
	lexico.setParser(this);
}
