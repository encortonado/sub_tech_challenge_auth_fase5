# 👤 Sistema de Cadastro e Autenticação de Clientes - Tech Challenge

Este projeto é uma aplicação desenvolvida em **Spring Boot** com **Java** e **Maven**. O sistema implementa funcionalidades de cadastro e autenticação de clientes, com o objetivo de atender à Avaliação Substitutiva de Fase do Tech Challenge da FIAP.

## 📑 Índice

1. [📋 Sobre o Projeto](#-sobre-o-projeto)
   - [🛠️ Tecnologias Utilizadas](#-tecnologias-utilizadas)
2. [🗂 Pré-requisitos](#-pré-requisitos)
3. [📁 Estrutura do Projeto](#-estrutura-do-projeto)
4. [🚀 Como Executar a Aplicação](#-como-executar-a-aplicação)
5. [🧪 Testes](#-executando-os-testes)
   - [Como Executar os Testes](#para-rodar-os-testes)
6. [🔗 Endpoints da API](#-endpoints-da-api)
   - [👤 Clientes](#-clientes)
7. [📚 Referências e Recursos Úteis](#-referências-e-recursos-úteis)



## 📋 Sobre o Projeto

A aplicação oferece uma API para cadastro de clientes, além de funcionalidades relacionadas à autorização e autenticação. A estrutura foi projetada para ser escalável e de fácil manutenção, utilizando as melhores práticas de desenvolvimento em **Spring Boot** e integração contínua.

### 🛠️ Tecnologias Utilizadas

- **Java** (JDK 17)
- **Spring Boot**
- **Maven**
- **JUnit** (Testes Unitários)
- **Docker** & **Docker Compose**

## 🛠 Pré-requisitos

### Para rodar o projeto:
- **Docker**
- **Docker Compose**

### Para desenvolvimento:
- **JDK 17**
- **Docker**
- **Docker Compose**
- **Maven**

## 📁 Estrutura do Projeto

- `src/main/java`: Contém o código-fonte da aplicação.
- `src/test/java`: Contém as classes de testes unitários.

## 🚀 Como Executar a Aplicação

1. **Clone o repositório**: 
   ```bash
   git clone https://github.com/encortonado/sub_tech_challenge_auth.git
   ```

2. **Rode os Comandos abaixo para executar** o banco de dados localmente:
   ```bash
   ./run-sh db
   ```
   
    ps. Caso for rodar as duas aplicações simultaneamente, rode apenas uma instância de banco de dados

3. **Execute a aplicação** localmente:
   ```bash
   ./run-sh app
   ```

## 🧪 Executando os Testes

Os testes unitários seguem as boas práticas de **Test-Driven Development (TDD)** e estão organizados para garantir a consistência das funcionalidades da aplicação.

### Para rodar os testes:

1. Na pasta raiz do projeto, execute:
   ```bash
   mvn test
   ```

## 🔗 Endpoints da API

A aplicação expõe os seguintes endpoints para cadastro e venda de veículos:

### 👤 Clientes

- **GET api/client/${cpf}e**  
  Buscar um Cliente Pelo CPF.

- **POST /api/client**  
  Cadastra um novo cliente.  
  **Body (JSON):**
  ```json
  {
    "cpf": 12345678901,
    "password": 123456
  }

- **POST api/client/login**  
  Realiza a verificação de cpf e senha e retorna um Bearer Token em caso de autenticado com sucesso.
  **Body (JSON):**
  ```json
  {
    "cpf": 12345678901,
    "password": 123456
  }

## 📚 Referências e Recursos Úteis

- [Documentação oficial do Spring](https://docs.spring.io)
- [Jakarta Bean Validations](https://beanvalidation.org/)
- [Cucumber](https://cucumber.io)
- [AssertJ](https://assertj.github.io/doc/)
- [RestAssured](https://rest-assured.io/)
- [JSON Schema](https://jsonschema.net/app/schemas/390701)

---

Este README foi criado para fins acadêmicos como parte da Avaliação Substitutiva de Fase do curso de Pós-Graduação em Tech da **FIAP**.

--- 

