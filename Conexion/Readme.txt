*** Importante ***

Para poder utilizar el programa debe tenerse instalado el MongoDB y tener en ejecución el cliente para acceder al servidor,
en este caso será el mongod.exe, además se deberá referencía la librería jar al proyecto. 

- mongo-java-driver-2.13.0.jar

Librería de mongodb necesaría para realizar las conexiones.


- Connection.java
	Clase encargada de realizar la conexión con el servidor.
	* private final static String DB = "TrivialDB";
		Nombre de la base de datos con la que queramos trabajar.
	- public static DB DatabaseConnection()
		Devolverá la base de datos con la que trabajaremos.

- Insert.java
	Clase encargada de insertar las preguntas en la base de datos. 	
	* private static DB db;
		Base de datos con la que se está trabajando, en este caso TrivialDB
	* private static DBCollection collection;
		Dentro de la base de datos, con que colección estamos trabajando.
	* private static FileInputStream archivo;
		Archivo en el que se encuentran los datos a insertar
	*private final static String coll = "Questions";
		Nombre de la colección con la que queremos trabajar, en este caso Questions.
	- public static void importJSON(String path)
		Cargará el archivo , cuya ruta está especificada por el parámetro.
	- public static void insert(String coll)
		Método que lee el archivo linea a linea e introduce en la colleción seleccionada
	- public static void clearCollection(String coll)
		Método que limpia la colección que se pasa por parámetro
	- public static void getElements(String coll)
		Método que devuelve los elementos de la colección que se pasa por parámetro

- P.JSON
	Fichero de prueba con preguntas repetidas, líneas vacías,formatos incorrectos o preguntas repetidas.
