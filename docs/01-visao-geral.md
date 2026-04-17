# Biblioteca API — Visão do Projeto

## Objetivo

A Biblioteca API é um projeto de **aprendizado contínuo** em Java + Spring Boot.

O objetivo é evoluir uma API realista ao longo do tempo, servindo como base prática para estudar:
- fluxo HTTP
- arquitetura em camadas
- validação
- tratamento de erros
- testes
- segurança
- boas práticas de backend

O projeto não nasce “completo”. Ele **cresce conforme novas necessidades surgem**.

---

## Visão do Produto

Criar uma API REST que permita o gerenciamento de uma biblioteca, começando simples e evoluindo de forma incremental.

O foco não é entregar funcionalidades rapidamente, mas **entender profundamente cada decisão técnica tomada**.

---

## Requisitos Funcionais (estado atual)
- Cadastro de livros
- Listagem de livros
- Atualização de livros
- Remoção de livros
- Cadastro de autores
- Listagem de autores
- Atualização de autores
- Remoção de autores

---

## Requisitos Não Funcionais

- API no padrão RESTful
- Comunicação via protocolo HTTP
- Respostas no formato JSON
- Persistência em PostgreSQL em ambiente de produção
- Validação de dados de entrada utilizando Bean Validation
- Auditoria

---

## Domínio

- Livro
- Autor

Domínios futuros (planejados, não implementados):
- Usuário

---

## Filosofia do Projeto

- Aprender fazendo, não copiando
- Resolver problemas reais antes de abstrair
- Preferir clareza a “soluções mágicas”
- Documentar decisões depois de entendidas

---

## Ordem de Evolução da API

A ordem abaixo representa **o caminho que fez sentido** até agora.
Ela pode mudar conforme o projeto evolui.

### 0️⃣ CRUD ✔
- Entity `Livro`, `Autor`
- Repository JPA
- Service
- Controller
- Testes manuais via Postman

Objetivo:
> Ter algo funcional o mais rápido possível.

---

### 1️⃣ ResponseEntity ✔
- Definição explícita de status HTTP
- Controle do contrato da API

Objetivo:
> Fazer a API “falar HTTP” corretamente.

---

### 2️⃣ DTO ✔
- Separação entre Entity e contrato da API
- Conversão manual inicialmente

Objetivo:
> Controlar entrada e saída de dados.

---

### 3️⃣ Validação ✔
- Validação antes do banco
- Evitar erros 500 por dados inválidos

---
### 4️⃣ Auditoria ✔
- createdAt / updatedAt automáticos
- BaseEntity (herança ou composição)
- Preparação para rastreabilidade

Objetivo:
> Garantir histórico e integridade dos dados sem acoplar regra de negócio.
---

### 5️⃣ Exception Handler ✔
- Centralização do tratamento de erros
- Respostas previsíveis

---

### 6️⃣ Testes
- Testes de service
- Testes de controller quando fizer sentido

---

### 7️⃣ Paginação, sorting e filtros
- Endpoints de listagem mais realistas

---

### 8️⃣ Swagger / OpenAPI
- Documentação automática da API

---

### 9️⃣ Security
- Autenticação
- Autorização

---

### 🔟 Profiles e banco real ✔
- Separação de ambientes
- Banco real em produção

---

> Esta visão existe para dar **direção**, não para engessar o projeto.
