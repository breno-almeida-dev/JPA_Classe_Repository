# API de Gerenciamento de Clientes - Spring Boot (CRUD)

Este projeto foi desenvolvido em **Java utilizando Spring Boot**, com o objetivo de praticar a criação de uma **API REST completa com operações CRUD (Create, Read, Delete)** utilizando banco de dados e **Spring Data JPA**.

A aplicação permite gerenciar clientes, realizando operações de cadastro, listagem, busca por ID, busca por nome, busca por e-mail e exclusão.

Este projeto faz parte das atividades práticas da disciplina de **Back-End**, com foco em compreender o funcionamento de **APIs REST, persistência de dados e integração com banco de dados**.

---

# 🚀 Começando

O objetivo deste projeto é demonstrar, na prática, como criar uma API REST utilizando Spring Boot com:

- Criação de endpoints REST
- Integração com banco de dados via JPA
- Uso de Repository (JpaRepository)
- Validação de dados
- Testes utilizando Postman

---

# 📌 Funcionalidades Implementadas

A API possui os seguintes endpoints:

---

### 1️⃣ Cadastrar cliente (POST)

Realiza o cadastro de um novo cliente.

POST /clientes

**Exemplo JSON enviado:**

```json
{
  "nome": "Breno",
  "email": "breno@email.com",
  "telefone": "11999999999",
  "cpf": "12345678900"
}
```

**Resultado esperado:**

Retorna o cliente salvo com ID gerado automaticamente.

📸 Teste no Postman:

![POST Cliente](images/post_cliente.png)

---

### 2️⃣ Listar todos os clientes (GET)

Retorna todos os clientes cadastrados.

GET /clientes

📸 Teste no Postman:

![GET Todos](images/get_clientes.png)

---

### 3️⃣ Buscar cliente por ID (GET)

Busca um cliente específico pelo ID.

GET /clientes/{id}

**Exemplo:**

http://localhost:8080/clientes/1

📸 Teste no Postman:

![GET Por ID](images/get_cliente_id.png)

---

### 4️⃣ Deletar cliente (DELETE)

Remove um cliente pelo ID.

DELETE /clientes/{id}

**Resposta:**

Cliente removido com sucesso!

ou

Cliente não encontrado!

📸 Teste no Postman:

![DELETE Cliente](images/delete_cliente.png)

---

### 5️⃣ Buscar cliente por nome (GET)

Busca clientes cujo nome começa com o valor informado.

GET /clientes/buscarPorNome?nome=Breno

📸 Teste no Postman:

![GET Nome](images/get_cliente_nome.png)

---

### 6️⃣ Buscar cliente por e-mail (GET)

Busca um cliente pelo e-mail.

GET /clientes/buscarPorEmail?email=breno@email.com

📸 Teste no Postman:

![GET Email](images/get_cliente_email.png)

---

# 📋 Pré-requisitos

Para executar este projeto em sua máquina, você precisará ter instalado:

- **Java JDK 21 ou superior**
- **Maven ou Maven Wrapper**
- **VS Code ou Eclipse IDE**
- **Git**
- Conta no **GitHub**
- **Postman**

---

# 🔧 Instalação

Clone este repositório:

git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git

Entre na pasta do projeto:

cd NOME_DO_REPOSITORIO

Execute a aplicação:

.\mvnw.cmd spring-boot:run

Ou execute a classe principal:

AulaApplication.java

Após iniciar o projeto, a API ficará disponível em:

http://localhost:8080

---

# 🛠️ Construído com

Tecnologias utilizadas neste projeto:

- Java SE
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de dados (H2 ou outro configurado)
- Maven
- VS Code / Eclipse IDE
- Git
- GitHub
- Postman

---

# 📌 Versão

Versão atual do projeto:

Versão 1.0

Primeira implementação da API com operações CRUD de clientes utilizando Spring Boot.

---

# 📚 Conceitos praticados

Este projeto explora os seguintes conceitos:

- Criação de APIs REST
- Métodos HTTP: GET, POST, DELETE
- Uso de @RestController
- Uso de @RequestMapping
- Uso de @GetMapping, @PostMapping, @DeleteMapping
- Uso de @PathVariable
- Uso de @RequestParam
- Uso de @RequestBody
- Persistência com Spring Data JPA
- Uso de JpaRepository
- Queries derivadas (findBy...)
- Validação de dados
- Arquitetura em camadas (Controller, Repository, Model)

---

# ✒️ Autor

**Breno Gustavo Rocha de Almeida**

Projeto desenvolvido como atividade da disciplina de **Back-End**, com foco no aprendizado de **Spring Boot e desenvolvimento de APIs REST em Java**.
