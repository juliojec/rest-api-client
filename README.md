# Rest API de Clientes - Java Spring Boot 

API de Clientes, utilizando Java, Docker, Spring, Mysql

- cria��o de novos clientes;
- atualiza��o de clientes existentes;
- lista os clientes de forma paginada;
- Permite busca por id e nome do cliente;

## Pr� requisitos

- Maven 3+
- Java 8+
- Docker 18.02.0+ 

## Preparando ambiente

- Dentro da pasta principal, execute o `docker-compose up` para inicializar o mysql.

## Tests de Unidade

- Inicialize os tests rodando o commando abaixo 
````
.\mvnw test
````

## Executando 

- Inicialize o projeto 
````
.\mvnw spring-boot:run
````

## Documenta��o - Swagger 

Acesse o navegador no link abaixo
````
http://localhost:8080/swagger-ui.html#/user-resource
````
