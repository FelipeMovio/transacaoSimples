# 💸 Transação Simples API

API REST desenvolvida em **Spring Boot**, simulando um sistema de transferência de valores semelhante ao fluxo do PicPay.  
Inclui autenticação JWT, controle de carteira, perfis de usuário (COMUM e LOJISTA), regras de negócio, camadas isoladas e validações.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot 3
- Spring Web
- Spring Security + JWT
- Spring Data JPA
- Banco H2
- Lombok
- Validation
- Swagger (OpenAPI 3)
- Maven

---

## 🎯 Objetivo da API

A API permite:

- Cadastro e autenticação de usuários  
- Login com geração de **JWT**  
- Controle de carteiras e saldo  
- Transferência de valores  
- Regras específicas para usuários **LOJISTAS**  
- Consultas de transações  
- Acesso administrativo (ADMIN)  
- Segurança com filtros JWT personalizados  
- Estrutura profissional com services, DTOs, mappers e controllers

---

## 📂 Arquitetura do Projeto

src/main/java/com/felipemovio/TransacaoSimples
│
├── controller
│ ├── auth → Login & Registro
│ ├── adm → Rotas administrativas
│ └── users → Funcionalidades do usuário
│
├── entity → Entidades do banco (Usuario, Carteira, Transacoes...)
├── repository → Acesso ao banco (JPA)
├── security → Configuração JWT + Filters + SecurityConfig
├── services → Regras de negócio
├── mappers → Conversão para DTOs
├── DTO → Request e Response
└── configs → Tratamento global de erros


---

## 🧩 Funcionalidades Principais

### 🔐 Autenticação JWT
- Login e cadastro
- Token carregado com roles e tipo de usuário
- Filtro personalizado `SecurityFilter`

### 💼 Carteira
- Cada usuário possui uma única carteira
- Saldo atualizado automaticamente

### 💳 Transferências
- Usuários **COMUNS** podem transferir  
- Usuários **LOJISTAS** **não podem enviar**, somente receber  
- Proibição de transferir para si mesmo  
- Verificação de saldo  
- Registro automático da transação

### 🧑‍💼 Admin
- Listagem de todas as carteiras
- Listagem de transações

---

## ⚙️ application.properties

```properties
spring.profiles.active=dev
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

jwt.secret=7e8a5f9cbe3a63f4e1a2...
jwt.expiration=3600000


🚀 Endpoints Principais
🔑 Autenticação – /api/auth
POST /register

Cadastro:

{
  "nomeCompleto": "João Silva",
  "email": "joao@email.com",
  "cpfCnpj": "12345678900",
  "senha": "123456",
  "tipoUsuario": "COMUN",
  "role": "ROLE_USER"
}

POST /login

Retorna o token:

{
  "email": "joao@email.com",
  "senha": "123456"
}

👤 Usuário – /user
GET /user/me

Retorna o usuário autenticado.

GET /user/transfer/pagador/{id}

Transações enviadas.

GET /user/transfer/recebedor/{id}

Transações recebidas.

💸 Transferências – /transfer
POST /

Realiza transferência:

{
  "value": 100.00,
  "payer": 1,
  "payee": 2
}

🧑‍💼 Admin – /admin
GET /admin/cartels

Lista todas as carteiras.

GET /admin/transactions

Lista todas as transações.

🔐 Segurança

JWT com claims:

userId, roles, tipoUsuario, email

Rotas com controle:

ADMIN: /admin/**

USER/ADMIN: /user/**, /transfer/**

Stateless

Suporte CORS

🧱 Banco de Dados (H2)

Console:

http://localhost:8080/h2-console

JDBC: jdbc:h2:mem:testdb

User: sa

Password: (vazio)

🧰 Como Rodar
1. Clonar:
git clone https://github.com/SEU_USUARIO/TransacaoSimples.git

2. Entrar na pasta:
cd TransacaoSimples

3. Rodar:
mvn spring-boot:run

📘 Documentação Swagger

/swagger-ui.html

/v3/api-docs

🤝 Contribuições

Sinta-se livre para criar issues, PRs e melhorias!
