Instrucciones para poner en funcionamiento el Entregable 2:
-------------
-------------

 1. [Descargar el .zip del proyecto (rama BancoDePruebas)](https://codeload.github.com/Arquisoft/Trivial3a/zip/BancoDePruebas)

 2. Descomprimir .zip

 3. Abrir eclipse e importar el proyecto como proyecto Gradle (hay que
    pulsar Build Model antes de seleccionar el proyecto)

 4. Para ejecutar la **primera vez** vamos a 'Run' -> 'Configurations' y en
    argumentos para la ejecución tecleamos <i>- -tools</i> para que se metan las preguntas a la base de datos MongoDB. Las sucesivas veces quitaremos este parámetro y nos ejecutara la aplicación con interfaz gráfica. 

 5. Nos situamos sobre la clase Main.java y la ejecutamos

 6. Seleccionamos en la consola que opcion queremos ejecutar

 7. Introducimos en la consola el PATH al fichero con las preguntas (assets/IoFiles/preguntas.GIFT)

-------------

#### <i class="icon-file"></i> Nota
Se requiere:
	 - Tener instalado eclipse con el plugin Gradle
	 - Tener una BBDD MongoDB abierta y funcionando en local. (La primera vez se requiere hacer una serie de cosas con el directorio que usa mongoDB -> explicadas en los links)
	 
[En mac](http://docs.mongodb.org/manual/tutorial/install-mongodb-on-os-x/) con tener instalado mongoDB, abrir una consola y teclear: 

> **mongod**

[En Windows](http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/)

> **C:\mongodb\bin\mongod.exe**
