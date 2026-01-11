# Decisões técnicas

Este documento registra **decisões técnicas importantes** tomadas ao longo do desenvolvimento da Biblioteca API.

O objetivo não é justificar tudo tecnicamente, mas **explicar o raciocínio** por trás das escolhas feitas.

---

## Uso de H2 no início

Decisão:

* Utilizar H2 em memória durante o desenvolvimento inicial.

Motivos:

* Reduzir atrito para começar
* Evitar configuração de infraestrutura cedo demais
* Focar no domínio, fluxo HTTP e arquitetura da API

Aprendizado:

> Banco é detalhe de infraestrutura. Domínio vem primeiro.

---

## Deixar o banco estourar erro 500 no início

Decisão:

* Inicialmente não tratar erros de validação na API.

Motivos:

* Entender o comportamento padrão do Spring/JPA
* Ver como erros de banco se propagam
* Compreender a diferença entre erro do cliente e erro do servidor

Aprendizado:

> Nem todo erro 500 é bug. Às vezes é falta de validação.

---

## Evoluir a API de forma incremental

Decisão:

* Implementar funcionalidades em pequenos passos.

Motivos:

* Evitar complexidade prematura
* Entender cada problema antes de abstrair
* Manter o código simples no início

Aprendizado:

> Complexidade deve surgir por necessidade, não por antecipação.

---

## Foco em um projeto principal

Decisão:

* Usar esta API como projeto principal de aprendizado.

Motivos:

* Permitir evolução contínua
* Reutilizar conhecimento em um mesmo contexto
* Simular a vida real de um projeto em produção

Aprendizado:

> Um projeto vivo ensina mais do que vários projetos descartáveis.

---

## Separação de responsabilidades

Decisão:

* Manter responsabilidades bem definidas entre camadas.

Exemplos:

* Service não retorna HTTP
* Controller não contém regra de negócio
* Exception Handler centraliza erros

Aprendizado:

> Código mais simples surge quando cada camada tem um papel claro.

---

## Princípio geral adotado

Regra central:

> Primeiro fazer funcionar. Depois tornar elegante.

Essa regra guia a evolução do projeto e evita paralisia por perfeccionismo.

---

> Este documento será expandido conforme novas decisões relevantes forem tomadas.
