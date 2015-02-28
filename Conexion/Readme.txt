*** Importante ***

Para poder utilizar el programa debe tenerse instalado el MongoDB y tener en ejecuci�n el cliente para acceder al servidor,
en este caso ser� el mongod.exe, adem�s se deber� referenc�a la librer�a jar al proyecto. 

- mongo-java-driver-2.13.0.jar

Librer�a de mongodb necesar�a para realizar las conexiones.


- Connection.java
	Clase encargada de realizar la conexi�n con el servidor.
	* private final static String DB = "TrivialDB";
		Nombre de la base de datos con la que queramos trabajar.
	- public static DB DatabaseConnection()
		Devolver� la base de datos con la que trabajaremos.

- Insert.java
	Clase encargada de insertar las preguntas en la base de datos. 	
	* private static DB db;
		Base de datos con la que se est� trabajando, en este caso TrivialDB
	* private static DBCollection collection;
		Dentro de la base de datos, con que colecci�n estamos trabajando.
	* private static FileInputStream archivo;
		Archivo en el que se encuentran los datos a insertar
	*private final static String coll = "Questions";
		Nombre de la colecci�n con la que queremos trabajar, en este caso Questions.
	- public static void importJSON(String path)
		Cargar� el archivo , cuya ruta est� especificada por el par�metro.
	- public static void insert(String coll)
		M�todo que lee el archivo linea a linea e introduce en la colleci�n seleccionada
	- public static void clearCollection(String coll)
		M�todo que limpia la colecci�n que se pasa por par�metro
	- public static void getElements(String coll)
		M�todo que devuelve los elementos de la colecci�n que se pasa por par�metro

- P.JSON
	Fichero de prueba con preguntas repetidas, l�neas vac�as,formatos incorrectos o preguntas repetidas.
