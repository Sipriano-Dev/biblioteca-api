# biblioteca-api
API backend para gerenciamento básico de uma biblioteca, desenvolvida com foco em estudo de modelagem de domínio, persistência de dados e boas práticas com Spring Boot.

## 🧩 Status do Projeto
Em desenvolvimento  

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
### Executando a aplicação
./mvnw spring-boot:run
A aplicação será iniciada em: http://localhost:8080

## 🗄️ Banco de Dados
Este projeto utiliza o banco de dados H2 em memória para desenvolvimento.
Console H2 disponível em: http://localhost:8080/h2-console
Configurações padrão:
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (vazia)

## 📚 Domínio
Atualmente o sistema possui o domínio Livro, com funcionalidades básicas de persistência e consulta.
Novos domínios e relacionamentos serão adicionados gradualmente.

## 📌 Observações
Este projeto tem como objetivo aprendizado prático e evolução incremental, priorizando clareza de código e boas decisões de modelagem.
Por que agora não quebra

