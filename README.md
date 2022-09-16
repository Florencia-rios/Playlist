# Playlist

Para levantar la aplicación se puede usar el comando:
mvn spring-boot:run -Dspring-boot.run.fork=false
De esta manera también se puede levantar la app en modo debug

En el repositorio hay una colección de postman con todos los endpoints, incluyendo el endpoint que devuelve el token.

1) Conseguir el token desde el endpoint /user, especificando:
- Body -> x-www-form-urlencoded
- Y pasar el user y password deseado
2) Agregar al resto de los endpoint el header Authorization con el token devuelto en el step anterior, es decir:
Bearer + token

