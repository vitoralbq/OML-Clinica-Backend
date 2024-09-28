# OML-Clinica-Backend
Este é o repositório do backend da aplicação de clínica médica. Desenvolvido para gerenciar pacientes, médicos e consultas, oferecendo APIs REST para cadastro, atualização e consulta dessas informações. Este projeto foi construído utilizando *Java* com o framework *Spring Boot* e se conecta a um banco de dados para armazenar as informações.

## Tecnologias Utilizadas

- *Java*: Linguagem de programação principal.
- *Spring Boot*: Framework para criação da aplicação e APIs REST.
- *Spring Data JPA*: Para persistência de dados com o banco de dados.
- *Hibernate*: ORM para mapeamento objeto-relacional.
- *MySQL*: Banco de dados utilizado para armazenar informações.
- *Maven*: Gerenciador de dependências.
- *Docker*: Container para o MySql
- *Spring Security*: Para gerenciamento de autenticação e autorização (se aplicável).

## Estrutura do Projeto

- *src/main/java*: Contém todo o código-fonte do projeto.
  - *model*: Classes que representam as entidades do sistema (Paciente, Médico, Consulta).
  - *repository*: Interfaces que estendem `JpaRepository` para interação com o banco de dados.
  - *service*: Contém a lógica de negócio para gerenciar pacientes, médicos e consultas.
  - *controller*: Define os endpoints da API e direciona as solicitações para os serviços correspondentes.
  - *exception*: Classes para tratamento de exceções e validações.
- *src/main/resources*: Contém arquivos de configuração, incluindo `application.properties`.

## Estrutura de arquivos - Tree
```
.
├── docker-compose.yml
├── docs.md
├── pom.xml
└── src
  ├── main
  │   ├── java
  │   │   └── com
  │   │       └── tecnicas
  │   │           └── sistema_consultas
  │   │               ├── SistemaConsultasApplication.java
  │   │               ├── config
  │   │               │   └── CorsConfig.java
  │   │               ├── controller
  │   │               │   ├── ConsultaController.java
  │   │               │   ├── MedicoController.java
  │   │               │   ├── PacienteController.java
  │   │               │   └── UsuarioController.java
  │   │               ├── exception
  │   │               │   ├── ConsultaNotFoundException.java
  │   │               │   ├── ErrorDetails.java
  │   │               │   ├── GlobalExceptionHandler.java
  │   │               │   ├── MedicoNotFoundException.java
  │   │               │   ├── PacienteNotFoundException.java
  │   │               │   ├── ResourceNotFoundException.java
  │   │               │   └── UsuarioNotFoundException.java
  │   │               ├── model
  │   │               │   ├── Consulta.java
  │   │               │   ├── Medico.java
  │   │               │   ├── Paciente.java
  │   │               │   └── Usuario.java
  │   │               ├── repository
  │   │               │   ├── ConsultaRepository.java
  │   │               │   ├── MedicoRepository.java
  │   │               │   ├── PacienteRepository.java
  │   │               │   └── UsuarioRepository.java
  │   │               └── service
  │   │                   ├── ConsultaService.java
  │   │                   ├── MedicoService.java
  │   │                   ├── PacienteService.java
  │   │                   └── UsuarioService.java
  │   └── resources
  │       └── application.properties
  └── test
    └── java
      └── com
        └── tecnicas
          └── sistema_consultas
            └── SistemaConsultasApplicationTests.java
```

## Configuração do Banco de Dados

Certifique-se de que você tenha o MySQL instalado e em execução. Crie um banco de dados para o projeto:

```sql
CREATE DATABASE oml_clinica;
```

Atualize as configurações do banco de dados em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/oml_clinica
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Como Executar o Projeto

### Pré-requisitos

- Java 17 ou versão compatível instalada.
- Maven instalado.
- MySQL rodando localmente.

### Passo a Passo

Clone o repositório:

```bash
git clone https://github.com/vitoralbq/OML-Clinica-Backend
```

Navegue até o diretório do projeto:

```bash
cd OML-Clinica-Backend
```

Compile o projeto e instale as dependências:

```bash
mvn clean install
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Como Executar o Frontend

### Pré-requisitos

- Node.js e npm instalados.

### Passo a Passo

1. Navegue até o diretório do frontend:

```bash
cd OML_Clinica_Fronted
```

2. Instale as dependências do projeto

```bash
npm install
```

3. Execute a aplicação
```bash
npm run dev
```

Após isso o Frontend estará disponível em http://localhost:3001

Comece pela página http://localhost:3001/pages/cargo

## Endpoints da API

### Paciente

- **POST /pacientes** - Cadastrar um novo paciente.
- **GET /pacientes** - Listar todos os pacientes.
- **GET /pacientes/{id}** - Buscar paciente por ID.
- **PUT /pacientes/{id}** - Atualizar informações do paciente.
- **DELETE /pacientes/{id}** - Remover paciente do sistema.

### Médico

- **POST /medicos** - Cadastrar um novo médico.
- **GET /medicos** - Listar todos os médicos.
- **GET /medicos/{id}** - Buscar médico por ID.
- **PUT /medicos/{id}** - Atualizar informações do médico.
- **DELETE /medicos/{id}** - Remover médico do sistema.

### Consulta

- **POST /consultas** - Agendar uma nova consulta.
- **GET /consultas** - Listar todas as consultas.
- **GET /consultas/paciente/{pacienteId}** - Listar consultas por paciente.
- **GET /consultas/medicoDia** - Listar consultas de um médico e dia específico.
- **PUT /consultas/{id}** - Atualizar informações da consulta.
- **DELETE /consultas/{id}** - Cancelar uma consulta.

### Usuário

- **POST /usuarios** - Cadastrar um novo usuário.
- **GET /usuarios/{id}** - Buscar usuário por ID.
- **PUT /usuarios/{id}** - Atualizar informações do usuário.
- **DELETE /usuarios/{id}** - Remover usuário do sistema.
- **POST /usuarios/login** - Realizar login do usuário.

## Desenvolvedores

Desenvolvido por Vitor Albuquerque, Caio A. Macedo e João Vitor Mesquita