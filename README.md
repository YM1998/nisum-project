# nisum-test
Prueba técnica para Nisum

En este README presentare como se realizo la el micro propuesto en la prueba.

## Comenzando 🚀
Se puede loguear, registrar y consulta los usuarios

### Pre-requisitos 📋
Java 8

## Metodologías y Librerías implementadas ⚙️

* Arquitectura Limpia
* Programación Funcional
* JWT
* Lombok
* OkHttp

## Pruebas Unitraias ⚙️
* JUnit
* Mockito

## Diagrama de la solución 🛠️

![cleanarchitecturemed](https://user-images.githubusercontent.com/42616321/146628811-b5652aa8-38e5-47c4-ae8e-2667d230e01f.jpg)


## Despliegue 📦

* Paso 1: clonar el proyecto
* Paso 2: Ejecutar el proyecto en un IDE
* Paso 3: Abrir Postman e importar las colecciones adjuntadas
* 

- Metodo: POST
- Endpoint: localhost:9001/nisum-project/api/user/login
- Body:

```
{
    "email":"yesidmurillosegura@hotmail.com",
    "password":"123"
}`

Response: 

```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzZWNyZXQiOiI1MTMyZDdlNi01M2E2LTQzY2QtODI5NC1lZTRiYjdlOWE4OGMiLCJzdWIiOiJ5ZXNpZG11cmlsbG9zZWd1cmFAaG90bWFpbC5jb20iLCJpYXQiOjE2NTI0MjQ0MDcsImV4cCI6MTY1MjQyOTQwN30.kmbl3C-ROk6kmhFmMWOMS5RUgDIQ00EIFSHoYSqtURZmZFlrk5qSG5e6r_NeyjtKrv7QkMdkiOPyoDe8SHcnXw"
}
```



Después de obtener el Bearer Token, ejecutamos el siguiente Endpoint y agregamos el token en el Header

- Metodo: POST
- Endpoint: localhost:9001/nisum-project/api/user
- Body:

```
{
    "name":"Yesid Murillo",
    "email":"ye2idmurillo@segurahotmail.com",
    "password":"ddd2dddddd",
    "phones": [{"number":"3122333", "cityCode":"CA", "countryCode":"COL"}]
}
```

Response: 

```
{
    "message": "Ok",
    "state": 200,
    "data": {
        "id": "4836d0c2-ee6c-4924-bac7-cc93a7f32b6c",
        "created": "2022-05-13T02:01:54.287",
        "modified": "2022-05-13T02:01:54.287",
        "lastLogin": "2022-05-13T02:01:54.308",
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzZWNyZXQiOiI3ZDQwYjk4Yi1kYmJlLTQ1NDItOTdkMi1hNzg2NGQ3NjgzMGIiLCJzdWIiOiJ5ZTJpZG11cmlsbG9Ac2VndXJhaG90bWFpbC5jb20iLCJpYXQiOjE2NTI0MjUzMTQsImV4cCI6MTY1MjQzMDMxNH0.RwD8PPaNBiUZ7utMAVmISnYKoComjnPXcd_2CzMJ8TCCVCvtUrEfaN-pWy5F-dRss6c2qPEuGsyIRI_0y1KNog",
        "isActive": true
    }
}
```


Después de obtener el Bearer Token, ejecutamos el siguiente Endpoint y agregamos el token en el Header
Mediante este servicio se pueden consultar los usuarios registrados

- Metodo: GET
- Endpoint: localhost:9001/nisum-project/api/user
- Body:

```

```

Response: 

```
{
    "message": "Ok",
    "state": 200,
    "data": [
        {
            "id": "1fc6524f-33ba-40b6-80e9-2064dc9b3ccd",
            "name": "Yesid Murillo",
            "email": "yesidmurillosegura@hotmail.com",
            "password": "123",
            "created": "2020-10-15T12:00:00.636333",
            "updated": "2020-10-15T12:00:00.636333"
        },
        {
            "id": "4836d0c2-ee6c-4924-bac7-cc93a7f32b6c",
            "name": "ye2idmurillo@segurahotmail.com",
            "email": "ye2idmurillo@segurahotmail.com",
            "password": "ddd2dddddd",
            "created": "2022-05-13T02:01:54.287",
            "updated": "2022-05-13T02:01:54.287"
        },
        {
            "id": "0306a9a0-9cd7-4ac4-8b4f-96ccd01a40de",
            "name": "juu@segurahotmail.com",
            "email": "juu@segurahotmail.com",
            "password": "1233kkkLksk",
            "created": "2022-05-13T02:02:11.962",
            "updated": "2022-05-13T02:02:11.962"
        }
    ]
}
```


## Información 📖

Cualquier duda, comunicarse al correo: yesidmurillosegura@hotmail.com
