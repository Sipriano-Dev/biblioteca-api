# Biblioteca API
## Visão geral
Esta API é um projeto de estudo contínuo em Java + Spring Boot, criada para evoluir junto com meu aprendizado.

O objetivo é construtir uma api completa e robusta, com paginação, sorting, filtros, relacionamentos, testes, security e tudo que for adequando pra um projeto sólido, Com código limpo e boas práticas
---
## O que esta API faz hoje
* CRUD completo de Livro
* Persistência com H2 (em memória)
* Testes manuais via Postman
* Estrutura em camadas (Controller / Service / Repository)
* ResponseEntity
---
## Filosofia do projeto
* Aprender fazendo, não copiando
* Evoluir a API por necessidade real
* Preferir código simples antes de abstrações
* Documentar decisões depois de implementadas
---
> Este documento existe para dar contexto ao projeto. As decisões técnicas e a ordem de evolução estão documentadas nos arquivos seguintes.

# Ordem de evolução da API

Este documento descreve a **ordem consciente de evolução** da Biblioteca API.

A ideia não é seguir um checklist fixo, mas registrar **o caminho que fez sentido** conforme o projeto foi crescendo.

---

## 0️⃣ CRUD básico

Primeiro passo do projeto.

* Entidade `Livro`
* Repository com JPA
* Service com regras simples
* Controller com endpoints CRUD
* Testes manuais via Postman

Objetivo:

> Ter algo funcional o mais rápido possível.

---

## 1️⃣ ResponseEntity

Introdução do controle explícito de respostas HTTP.

* Definir status corretos (200, 201, 204, 404)
* Parar de depender apenas do comportamento padrão do Spring

Objetivo:

> Fazer a API "falar HTTP" corretamente.

---

## 2️⃣ DTO (entrada e saída)
``` De inicio usar manual, futuramente implementar Mapper ```

Separação entre:

* Modelo de domínio (Entity)
* Contrato da API (DTO)

Benefícios:

* Não expor entidade diretamente
* Preparar terreno para validação
* Mais controle sobre o que entra e sai
* Organizar responsabilidades de camadas

---

## 3️⃣ Validação

Validação de dados de entrada antes de atingir o banco.

* Evitar erros 500 causados por dados inválidos
* Retornar 400 quando o erro é do cliente

Objetivo:

> Proteger a aplicação e melhorar a experiência da API.

---

## 4️⃣ Exception Handler

Centralização do tratamento de erros.

* Mapear exceções de negócio para status HTTP
* Padronizar respostas de erro
* Evitar try/catch espalhado pelo código

Objetivo:

> Ter respostas previsíveis e consistentes.

---

## 5️⃣ Testes

Introdução de testes automatizados.

* Testes unitários de Service
* Testes de Controller (quando fizer sentido)

Objetivo:

> Ganhar confiança para evoluir o projeto sem medo.

---

## 6️⃣ Paginação, sorting e filtro

Evolução dos endpoints de listagem.

* Paginação para evitar listas grandes
* Ordenação dos resultados
* Filtros simples por campos

Objetivo:

> Tornar a API mais realista e escalável.

---

## 7️⃣ Swagger / OpenAPI

Documentação automática da API.

* Visualização dos endpoints
* Parâmetros, respostas e erros

Objetivo:

> Ter uma vitrine clara da API e facilitar testes.

---

## 8️⃣ Security (básico)

Introdução de segurança na API.

* Autenticação
* Autorização
* Proteção de endpoints

Objetivo:

> Entender o fluxo de segurança em APIs reais.

---

## 9️⃣ Profiles e banco real

Separação de ambientes.

* Profile dev (H2)
* Profile prod (MySQL/Postgres)
* Configurações específicas por ambiente

Objetivo:

> Aproximar o projeto de um cenário real.

---

> Esta ordem pode mudar conforme novas necessidades surgirem. O importante é que cada etapa resolve um problema real exposto pela anterior.

