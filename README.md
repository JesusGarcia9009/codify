# codify
Este repositorio esta destinado al montaje de un entorno de desarrollo Java con Docker y MariaDB

## Comenzando 🚀

Descargar Fuentes de git

```
git clone https://github.com/JesusGarcia9009/codify.git
git checkout main
```

Una vez descargada las fuentes de debe visualizar la siguente estructura de carpetas:
- DDL-MDB-CLIENTS
- DDL-MDB-SECURITY
- rm-codify-aplication
- rm-codify-security

La instalacion se va a realizar en dos partes una que seria la base de datos y la otra seria la aplicacion, para eso debemos tener instalado el gestor de base de datos MariaDB

## MariaDB
* [MariaDB](https://downloads.mariadb.org/) - Gestor de base de datos.

En MariaDB debemos generar 4 bases de datos
- codify_client --> primer cliente de la app
- codify_client_two --> segundo cliente de la app
- codify_default --> schema by default
- rm-codify-security --> orquesta todo lo referente a los accesos a la base de datos (Distintos clientes)

Para eso contamos con los siguientes scripts:

En la carpeta "DDL-MDB-CLIENTS"  existen los scripts de creacion de una base de datos para el microservicio de clientes, se deben ejecutar en el orden que esta definido en la carpeta.

En la carpeta "DDL-MDB-SECURITY" existen los scripts de creacion de una base de datos para el microservicio de seguridad, se deben ejecutar en el orden que esta definido en la carpeta.

Una vez que tenemos las bases de datos configuradas, la vista deberia quedar asi!

![Vista global de las bases de datos](https://github.com/JesusGarcia9009/codify/blob/main/README/BDs.PNG)

## MS de seguridad
 Primero debemos verificar que nuestro microservicio se encuentre apuntando a la base de datos correcta para ello vamos a la raiz del proyecto y accedemos hasta la carpeta resources
 
 > codify\rm-codify-security\src\main\resources
 
 Editar el archivo "application.properties" y editar la anotacion "spring.datasource.url" para asi especificar la url de acceso a la base de datos
 
 Una vez verificado pasamos a instalar el gestor de paquetes para JAVA en este caso es MAVEN
 
 * [Maven](https://maven.apache.org/) - Manejador de dependencias.
 
## Docker

para generar la imagen se deben ejecutar los siguientes comandos

```
docker build -t rm-codify-security .
docker run --name rm-codify-security -p 8080:8080  rm-codify-security
```

y para probar se utilizaria el postman y se invocaria el servicio en postman, dejo imagen de referencia

![Vista del logion request](https://github.com/JesusGarcia9009/codify/blob/main/README/login%20request.PNG)

Retornando y tocken con la siguiente estructura

![TOKEN](https://github.com/JesusGarcia9009/codify/blob/main/README/jwt.PNG)



