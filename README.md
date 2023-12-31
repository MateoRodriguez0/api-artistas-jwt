# Api Restful of artist & Spring Data JPA for MusicApp 
Esta es una api que gestiona algunas peticiones para los artistass de una app de musica.
Contribuye a la creacion de un proyecto spring boot con el proposito de implementar spring security jWT.

Tiene como objetivo realizar las operaciones necesarias para los usuarios artistas de la app en la base de datos.

Este proyecto esta hecho con el proposito de pproveer la logica de negocio y  los end points a un microservico que se encarga de configurar la seguridad de la applicacion, y se comunica con este microservicio a traves de un [Rest Client: Feign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#spring-cloud-feign).

## Example of a ClientFeign 

```java
@FeignClient(name = "servicio-artistas", url = "localhost:8004")
public interface ArtistClient {
    //..
 }

```




## port 
```java
spring.application.name=servicio-artistas
server.port=8004
```

## Datasource and pool connection 
``` java

spring.datasource.url=jdbc:mysql://localhost:3306/appmusic?useSSL=false&serverTimezone=America/Bogota&AllowpublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.generate-ddl=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.show-sql=false
spring.jpa.open-in-view=true

spring.datasource.hikari.pool-name=coneccionOyentes
spring.datasource.hikari.maximum-pool-size=30
spring.datasource.hikari.connection-timeout=45000

```

## Requeriments
- Java 17 o una version superior.
- MySQL 8
- Lombock 

## Instalation
- Primero Descargamos la version mas actual del proyecto en el siguiente [enlace](https://github.com/MateoRodriguez0/appmusic-oyentes/releases/tag/version-1.0)
- luego, importamos la base de datos en nuestro gestor SGBD MySQL.
- importamos este proyecto en el IDE. 

luego de seguir los pasos anteriores solo faltaria ejecutar nuestro proyecto y probarlo.


## API Reference

#### GET todas las canciones

```http
  GET /canciones/explorar
```
devuelve una lista grande que contiene todas las canciones publicadas en la aplicacion,
con los artistas que que cantan cada cancion, fecha de estreno, y otras caracteristicas.

#### Buscar cancion

```http
  GET /canciones/search/{idCancion}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idCancion`      | `string` | Id de la cancion que será buscada.|



#### Buscar canciones por artista

```http
  GET /canciones/artista/{idArtista}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idArtista`      | `string` | Es el id del artista el cual se quiere ver su listado de canciones publicadas en la app.|


#### Publicar una cancion
```http
POST /canciones/publicar/{idArtista}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idArtista`      | `string` | se utiliza para agregar el artista que envia la peticion a la cancion.|

| RequestBody | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `cancion`      | `Cancion` |Es la cancion que será publicada.|



#### Actualizar una cancion
```http
PUT /canciones/update/{idArtista}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idArtista`      | `string` | se utiliza para verificar que el artista que intenta actualizar la cancion, pertenezca a esa cancion.|

| RequestBody | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `cancion`      | `Cancion` |Es la cancion con los datos actualizados.|



#### Eliminar una cancion

```http
  DELETE /canciones/delete/{idArtista}/{idCancion}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idArtista`      | `string` | se utiliza el id de artista para verificar que la cancion que será eliminada pertenezca a ese artista o aparezca en esa cancion|
| `idCancion`      | `string` | es el id de la cancion que se va a eliminar|


# Examples 


```http
localhost:8004/canciones/artista/1
```

```Javascript
 [
    {
        "id": 5,
        "titulo": "Canción 5",
        "genero": "R&B",
        "duracion": "00:03:10",
        "estreno": "2023-10-07T03:57:14.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 6,
        "titulo": "Billie Jean",
        "genero": "Pop",
        "duracion": "00:04:45",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 7,
        "titulo": "Thriller",
        "genero": "Pop",
        "duracion": "00:05:58",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 8,
        "titulo": "Beat It",
        "genero": "Rock",
        "duracion": "00:04:18",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 9,
        "titulo": "Smooth Criminal",
        "genero": "Pop",
        "duracion": "00:04:17",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 10,
        "titulo": "Black or White",
        "genero": "Pop",
        "duracion": "00:04:15",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 11,
        "titulo": "Bad",
        "genero": "Pop",
        "duracion": "00:04:07",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 12,
        "titulo": "The Way You Make Me Feel",
        "genero": "Pop",
        "duracion": "00:04:58",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 13,
        "titulo": "Don't Stop 'Til You Get Enough",
        "genero": "Disco",
        "duracion": "00:06:05",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 14,
        "titulo": "Man in the Mirror",
        "genero": "Pop",
        "duracion": "00:05:19",
        "estreno": "2023-10-09T15:11:56.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    },
    {
        "id": 15,
        "titulo": "Heal the World",
        "genero": "Pop",
        "duracion": "00:06:25",
        "estreno": "2023-10-09T15:11:56.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    }
]
```


```http
localhost:8004/canciones/delete/1/9

```
#### Response
```
Se eliminó la canción correctamente

En caso de que no se encuentre la cancion el response envia lo siguiente:

No se encontró la canción

```


### Recomendaciones al actualizar una canción
```http
   localhost:8004/canciones/update/1
```
Para actualizar una cancion se debe seguir estricatemente la siguiente sintaxis:

```javascript 
 {
        "id": 6,
        "titulo": "Billie Jean",
        "genero": "Pop",
        "duracion": "00:04:45",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1
            }
        ]
    }
```

- si la cancion tiene un error de sintaxis o no contiene un parametro del constrructor, la aplicacion lanzara una excepcion como por ejemplo:
```java
java.sql.SQLIntegrityConstraintViolationException:
```

- el id debe ser el id de la cancion, que será actualizada.
- se puede agregar nuevos artistas al arreglo de artistas sin ningún problema.
- en caso de que la cancion no exista, simplemente no retorna nada.

Si la peticion es procesada correctamente por el servidor el respuesta seria la siguiente:

```javascript
    {
        "id": 6,
        "titulo": "Billie Jean",
        "genero": "Pop",
        "duracion": "00:04:45",
        "estreno": "2023-10-09T15:11:05.000+00:00",
        "artistas": [
            {
                "id": 1,
                "nombre": "Michael Jackson"
            }
        ]
    }
```


# Publicar una cancion

En la siguiente url , el valor 3 es el id del usuario que realiza la peticion, se utiliza de esta manera debido a que esta api es una servicio independiente. La aplicacion principal será la encargada de implementar la seguridad con JWT por lo cual no seria optimo recuperar el usuario del token en cada recurso de esta api. Sino que el idArtista venga desde el cliente feign.
```http
POST localhost:8004/canciones/save/3
```
#### Body
```javascript
    {
        "titulo": "Lala",
        "genero": "urbano latino",
        "duracion": "00:03:18",      
    }
```
Si la cancion solo tiene un artista y es el que la esta publicando, no es necesrio especificar la lista de artistas, ya que automaticamente con el id que se envia en la URL se le asigna el artista a la cancion.
De lo contrario se crea la lista de artistas sin incluir al artista que esta haciendo la publicacion.

Y seria de la siguiente manera

```javascript
    {
        "titulo": "Lala",
        "genero": "urbano latino",
        "duracion": "00:03:18",
        "artistas":[
            {
                "id":1
            },
             {
                "id":100032
            },
               {
                "id":8762
            },
               {
                "id":32342
            }
        ]  
    }
```

## Tambien puedes mirar

 - [Api Restful of listeners & Spring Data JPA for MusicApp](https://github.com/MateoRodriguez0/api-oyentes-jwt)
 - [Music application with microservices](https://github.com/MateoRodriguez0/spring-security-jwt)

