# language: es
Caracter�stica: Gesti�n de usuarios

Escenario: Registrar usuario
    Dada una lista vac�a de usuarios
    Cuando creo un usuario de nombre "Pepe" y clave "Pepe12"
    Entonces el n�mero de usuarios es 1
    
Escenario: Error al registrar un usuario por no introducir la contrase�a
    Dada una lista vac�a de usuarios
    Cuando creo un usuario de nombre "Pepe" y clave ""
    Entonces el n�mero de usuarios es 0
    
Escenario: Error al registrar un usuario por no introducir el nombre
    Dada una lista vac�a de usuarios
    Cuando creo un usuario de nombre "" y clave "pepe"
    Entonces el n�mero de usuarios es 0
    
Escenario: Error al registrar un usuario porque el nombre de usuario ya existe
    Dada la siguiente lista de usuarios:
      | nombre | clave   |
      | pepe   | pepe12  |
    Cuando creo un usuario de nombre "pepe" y clave "pepe"
    Entonces el n�mero de usuarios es 2

Escenario: Entrar en el sistema
	Dada la siguiente lista de usuarios:
      | nombre | clave   |
      | pepe   | pepe12  |
      | luis   | siul    |
      | mari   | 2mmm2   |
    Cuando introduzco el nombre "pepe" y la clave "pepe12"
    Entonces puedo entrar en el sistema 
    
Escenario: Error al entrar en el sistema porque el usuario no est� registrado
	Dada la siguiente lista de usuarios:
      | nombre | clave   |
      | luis   | siul    |
    Cuando introduzco el nombre "pepe" y la clave "pepe12"
    Entonces no puedo entrar en el sistema 
    
Escenario: Error al entrar en el sistema porque la contrase�a es incorrecta
	Dada la siguiente lista de usuarios:
      | pepe   | pepe12  |
    Cuando introduzco el nombre "pepe" y la clave "pepe"
    Entonces no puedo entrar en el sistema 