# CRUD Spring 

Rest API de Clientes, utilizando Java, Docker, Spring, Mysql

- criação de novos clientes;
- atualização de clientes existentes;
- lista os clientes de forma paginada;
- Permite busca por id e nome do cliente;

## Pré requisitos

- Maven 3+
- Java 8+
- Docker 18.02.0+ 

## Preparando ambiente

- Dentro da pasta principal, execute o `docker-compose up` para inicializar o mysql.

## Tests de Unidade

- Inicialize os tests rodando o commando abaixo 
````
.\mvnw spring-boot:run
````

## Executando 

- Inicialize o projeto 
````
.\mvnw spring-boot:run
````

## Documentação - Swagger 

Acesse o navegador no link abaixo
````
http://localhost:8080/swagger-ui.html#/user-resource
````
