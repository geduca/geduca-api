# GEDUCA-API


#### ambiente

- JDK 1.8
- Maven 3.6
- MySQL [5.5.5-10.1.36-MariaDB]
- Loombok

#### Spring e MySQL

Classe que inicia o projeto: `GeducaWebApplication`

Arquivo de configuração do Spring-Boot `application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/db_geduca?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=
```
Alterar nome de usuário, senha e porta caso seja necessário

```
spring.jpa.hibernate.ddl-auto=update
```
O banco de dados `db_geduca` será criado ou atualizado assim que a aplicação for iniciada

#### Acessos 

Url: 
```
http://localhost:12333/geduca
```

Todas uri's "/geduca/**" estão liberadas de autenticação para facilitar o desenvolvimento, neste momento.

#### Arquitetura

```
.
└── api
    ├── config (spring security)
    ├── model (Entidades Básicas)
    ├── repository (Repositorios e Implementacao)
    ├── service (Regras de Negocio)
    ├── controller (Rest controllers)
└── Resources (Configurações)
```
  

