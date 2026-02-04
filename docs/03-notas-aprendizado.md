# Diário de Aprendizado — Biblioteca API

Este documento registra **entendimentos, dúvidas, erros e insights**
surgidos durante o desenvolvimento do projeto.

Não é documentação formal.
É um **registro de aprendizado em tempo real**.

---

## 📅 11-01-2026 — ResponseEntity e POST

**O que eu achava**
- Que dava pra montar a resposta antes de salvar no banco

**O que aprendi**
- O ID nasce no `save()`, não no request
- Quando `save()` gera id, mas n teve commit ainda, podendo ter rollback
- O id é usado pra criar a uri pra o ResponseEntity
- Quando metodo acaba sem erro, acontece o commit.

---

## 📅 11-01-2026 — DELETE e status HTTP

**Dúvida**
- Como construir um ResponseEntity sem corpo

**Aprendizado**
- ```ResponseEntity.noContent().build();```
- Usa o build, quando tiver corpo, usa o body

---

## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---
## 📅 YYYY-MM-DD — [Tema]

**Contexto**
- O que você estava tentando fazer

**Aprendizado**
- O que ficou claro depois
---