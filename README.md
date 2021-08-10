# Rest API de Clientes - Java Spring Boot 

API de Clientes, utilizando Java, Docker, Spring, Mysql

- criação de novos clientes;
- atualização de clientes existentes;
- lista os clientes de forma paginada;
- Permite busca por id e nome do cliente;

## Pré requisitos

- Maven 3+
- Java 11
- Docker 18.02.0+ 

## Preparando ambiente

- Dentro da pasta principal, execute o comando abaixo para inicializar o backend java 11 + mysql 5.7
````
docker-compose up
````

## Tests de Unidade

- Inicialize os tests rodando o commando abaixo 
````
.\mvnw test
````

## Documentação - Swagger 

Acesse o navegador no link abaixo
````
http://localhost:8080/swagger-ui.html#/user-resource
````
