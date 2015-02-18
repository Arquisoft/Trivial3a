// ************  Código a incluir ********************

package lexico;
import sintactico.Parser;

%%
// ************  Opciones ********************
// % debug // * Opción para depurar
%byaccj
%class Lexico
%public
%unicode
%line
%column

%{
// ************  Atributos y métodos ********************
// * El analizador sintáctico

private Parser parser;

public void setParser(Parser parser) {
	this.parser=parser;
}

// * Para acceder al número de línea (yyline es package)
public int getLinea() { 
	// * Flex empieza en cero
	return yyline+1;
}

// * Para acceder al número de columna (yycolumn es package)
public int getColumna() { 
	// * Flex empieza en cero
	return yycolumn+1;
}

public char metodo(String yytext){
		String text = yytext.replace("\'", "");
		text = text.replace("\\", "");
		int valor = Integer.parseInt(text);
		char ch = new Character((char) valor);		
		
		return ch;		
	}



%}

// ************  Patrones (macros) ********************
Espacios =[\t\f ]
FinLinea =\n | \r | \n\r
Letra = [A-Za-záéíóúÁÉÍÓÚñÑ]
Frase =({Letra}|[0-9]|"?"|"¿"|"."|","|{Espacios})*
Identificador = {Letra} ({Letra}|[0-9])*

%%
// ************  Acciones ********************



"::"				{parser.setYylval(yytext()); return Parser.DOBLESPUNTOS;}
"~" | "=" | "{" | "}"  {parser.setYylval(yytext()); return ((int) yycharat(0));}

{Identificador}		{parser.setYylval(yytext()); return Parser.ID;} 
{Frase} 			{parser.setYylval(yytext()); return Parser.FR;} 

{FinLinea} 	|
{Espacios} 	{}


.	{System.err.println("Error lexico en la linea "  + this.getLinea() + " y columna " + this.getColumna() + "\ncaracter " + yycharat(0) + " no reconocido" );}
