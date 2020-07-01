# Creacion de templates en jenkins servicios post
Creacion de jar
mvn clean package

Comando para la creacion de docker
docker build -t createtemplatesjenkins .

Comando para correr docker.
docker run -p 5000:8090 createtemplatesjenkins


