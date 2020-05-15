# School service

School service es un microservicio hecho con Maven y Spring Boot que implementa una api rest para administrar escuelas y los estados a donde pertenecen estas escuelas.

## Instalación

Clonar el proyecto en el directorio de su elección.
Para editarlo es necesario un importar el proyecto con un IDE compatible con proyectos maven como IntelliJ, Netbeans, Eclipse o Spring Tool Suite.
La persistencia de los datos funciona con una base de datos H2, por lo que no hace falta configurar nada.

## Ejecución

Para ejecutarse se accede a la clase JpaApiDemoApplication y se ejecuta el método main.
Esto va a crear un servidor en el puerto 8090, en caso de estar el puerto ocupado se puede cambiar el puerto donde se ejecuta en el archivo application.properties dentro del directorio resources.
Cambiar la propiedad server.port = 8090, por algún puerto desocupado.

## Accediendo a la api

Una vez iniciado el servidor para acceder a la api será necesario hacerlo desde un software como postman, el cual hace peticiones al servidor especificado. En este caso se puede acceder a través de la siguiente url:

    http://localhost:puerto/endpoint


## Endpoints

La api contiene los siguientes endpoints:

| Endpoint       | Método                        |Acción                       |
|----------------|-------------------------------|-----------------------------|
|/schools        |`GET`            |Retorna todas las escuelas en formato application/json            |
|/school/{id}    |`GET`            |Retorna la escuela con el id que se pase por parámetro            |
|/school         |`POST`		   |Inserta una escuela que se pase por parámetro en el body|

