# Instalación

Para compilar hay que ejecutar los siguientes comandos:

```
mvn install (para generar el jar)
nvm war:war (para generar el archivo war a deployar en jetty)
```

Luego el archivo .war que se generó en el directorio target copiarlo al directorio webapps de jetty (de ser necesario cambiar el nombre)
Por ejemplo si el nombre del archivo es app.war la app va a tener que ser accedida de la siguiente forma: http://localhost:8080/app

# Variable de entorno

Para configurar la fecha final de la cuenta regresiva existe una variable de entorno que la app va a interntar leer, esta variable de entontorno se llama END_DATE y el formato es el siguiente YYYY-MM-DDThh:mm:ss, por ejemplo 2019-06-04T00:00:00

Si la variable de entonro no es alcanzada o tiene valor "" el valor por defecto que va usar la APP es 2019-06-04T00:00:00

Configuración en windows

```
set END_DATE=2018-06-04T00:00:00
```

Configuración en linux

```
END_DATE=2018-06-04T00:00:00
```

(ejecutar antes de iniciar el servidor jetty)

# Iniciar Jetty

Bajar la version jetty-distribution-9.4.9.v20180320 de jetty y en el directorio donde se encuentra descomprimido jetty ejecutar:

```
java -jar start.jar
```

