# Instalación

Para compilar hay que ejecutar los siguientes comandos:

```
mvn install (para generar el jar)
nvm war:war (para generar el archivo war a deployar en jetty)
```

Luego el archivo .war que se generó en el directorio target copiarlo al directorio webapps de jetty (de ser necesario cambiar el nombre)
Por ejemplo si el nombre del archivo es app.war la app va a tener que ser accedida de la siguiente forma: http://localhost:8080/app

# Iniciar Jetty

Bajar la version jetty-distribution-9.4.9.v20180320 de jetty y en el directorio donde se encuentra descomprimido jetty ejecutar:

```
java -jar start.jar
```

