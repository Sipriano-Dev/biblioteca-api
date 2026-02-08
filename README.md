# biblioteca-API
## Sobre o Projeto
API backend para gerenciamento básico de uma biblioteca. Desenvolvida com foco em aprendizado, modelagem, testes, security, boas práticas, e tudo que componha uma api robusta.

## 🛠️ Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- 
## ▶️ Como executar o projeto

### Pré-requisitos
- Java 21 ou superior
- Maven (ou Maven Wrapper)
- Postman
### Instruções de uso
- ```./mvnw spring-boot:run```
A aplicação será iniciada em: http://localhost:8080
- Endereço da API: 
http://localhost:8080/livros
- Exemplo de objeto livro inserido e retornado
```
  {
    "titulo": "Domain-Driven Design",
    "autor": "Eric Evans",
    "isbn": "9780321125217",
    "anoPublicacao": 2003
  }
```
### Endpoints da api

- GET /livros → Retorna todos os livros
- POST /livros → Cadastra um novo livro
- GET /livros/{id} → Retorna um livro por ID
- PUT /livros/{id} → Atualiza um livro
- DELETE /livros/{id} → Remove um livro

## 🗄️ Banco de Dados
Este projeto utiliza o banco de dados H2 em memória para desenvolvimento.
Console H2 disponível em: http://localhost:8080/h2-console
Configurações padrão:
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (vazia)

