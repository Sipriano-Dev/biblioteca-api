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

---

## Requisitos Não Funcionais

- API RESTful
- Comunicação via HTTP
- Respostas em JSON
- Banco H2 em memória no ambiente de desenvolvimento
- Banco Postgres em Ambiente de produção

---

## Domínio (inicial)

- Livro

Domínios futuros (planejados, não implementados):
- Autor
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

### 0️⃣ CRUD básico
- Entity `Livro`
- Repository JPA
- Service
- Controller
- Testes manuais via Postman

Objetivo:
> Ter algo funcional o mais rápido possível.

---

### 1️⃣ ResponseEntity
- Definição explícita de status HTTP
- Controle do contrato da API

Objetivo:
> Fazer a API “falar HTTP” corretamente.

---

### 2️⃣ DTO
- Separação entre Entity e contrato da API
- Conversão manual inicialmente
- Utilizar mapper depois

Objetivo:
> Controlar entrada e saída de dados.

---

### 3️⃣ Validação
- Validação antes do banco
- Evitar erros 500 por dados inválidos

---

### 4️⃣ Exception Handler
- Centralização do tratamento de erros
- Respostas previsíveis

---

### 5️⃣ Testes
- Testes de service
- Testes de controller quando fizer sentido

---

### 6️⃣ Paginação, sorting e filtros
- Endpoints de listagem mais realistas

---

### 7️⃣ Swagger / OpenAPI
- Documentação automática da API

---

### 8️⃣ Security
- Autenticação
- Autorização

---

### 9️⃣ Profiles e banco real
- Separação de ambientes
- Banco real em produção

---

> Esta visão existe para dar **direção**, não para engessar o projeto.
