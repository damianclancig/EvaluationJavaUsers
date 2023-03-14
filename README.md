# Proyecto API registrar usuarios


## Tecnología utilizadas

* Java 11
* Framework Spring Boot
* Base de datos en memoria H2
* Gradle

## Installación

Clonar repositorio con 

```bash
git clone https://github.com/damianclancig/EvaluationJavaUsers.git
```
y luego compilar con gradle.
## Ejecución
Por defecto se utiliza el puerto 8090, se puede cambiar desde application.properties.

Realizar la llamada al siguiente endpoint 
```
http://localhost:8090/users/api/users/save
```
y enviar por body el json

```json
{
   "name":"nombre",
   "email":"mail@dominio.com",
   "password":"passSegura2023",
   "phones":[
      {
         "number":"123456",
         "cityCode":"11",
         "countryCode":"54"
      }
   ]
}
```

## Autor

+ Damián Clancig.
+ Java developer senior
+ Damian@clancig.com.ar
