# Configurações da aplicação


## Banco de dados (H2)
```
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:

  jpa:
    defer-datasource-initialization: true #Pra usar o data.sql
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

  h2:
    console:
      enabled: true
      path: /h2-console
```
### resources/data.sql
```
INSERT INTO livro (titulo, isbn, data_publicacao, autor) VALUES
('Dom Casmurro', '9788535902778', '1899-01-01', 'Machado de Assis');

INSERT INTO livro (titulo, isbn, data_publicacao, autor) VALUES
('1984', '9780451524935', '1949-06-08', 'George Orwell');

INSERT INTO livro (titulo, isbn, data_publicacao, autor) VALUES
('O Senhor dos Anéis: A Sociedade do Anel', '9780261103573', '1954-07-29', 'J. R. R. Tolkien');
```

# Padrões Úteis — Biblioteca API

Snippets e padrões recorrentes usados no projeto.
Arquivo de **referência pessoal**.

---

## Criar uri (POST - 201 Created)

**Quando usar**
- Quando precisar retorna o endereço como no método salvar

**Padrão**
```java

 ServletUriComponentsBuilder
    .fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(entity.getId())
    .toUri()

```
## Nome
**Quando usar** 

**Padrão**
```java

```
## Nome
**Quando usar** 

**Padrão**
```java

```
## Nome
**Quando usar** 

**Padrão**
```java

```
## Nome
**Quando usar** 

**Padrão**
```java

```
## Nome
**Quando usar** 

**Padrão**
```java

```
## Nome
**Quando usar** 

**Padrão**
```java

```