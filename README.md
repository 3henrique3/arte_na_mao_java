# 🎨 API Arte na Mão - Spring Boot

API RESTful desenvolvida com Spring Boot para o marketplace Arte na Mão, uma plataforma que conecta artistas e apreciadores de arte, permitindo o gerenciamento de usuários, eventos e obras artesanais.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.8**
- **Spring Data JPA**
- **MySQL 8**
- **Lombok**
- **MapStruct 1.5.5**
- **SpringDoc OpenAPI 2.8.14** (Swagger)
- **Bean Validation**
- **Maven**

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- Java JDK 21 ou superior
- Maven 3.5.8+
- MySQL 8+

## 🔧 Configuração do Ambiente

### 1. Clone o Repositório

```bash
git clone https://github.com/3henrique3/arte_na_mao_java.git
cd arte_na_mao_java
```

### 2. Configure o Banco de Dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE artenamao CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

**Ou pelo terminal:**

```bash
# Entre no MySQL
mysql -u root -p

# Crie o banco
CREATE DATABASE artenamao;

# Saia do MySQL
exit;
```

### 3. Configure as Credenciais

Edite o arquivo `src/main/resources/application.yml` com suas credenciais do MySQL:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/artenamao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    username: root
    password: sua_senha_aqu
```

### 4. Execute a Aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080/api-artenamao/`

## 🏗️ Estrutura do Projeto

```
arte_na_mao_java/
├── src/
│   ├── main/
│   │   ├── java/com/arte/artenamao/
│   │   │   ├── document/
│   │   │   │   └── SpringDoc.java                # Configuração Swagger
│   │   │   ├── controller/
│   │   │   │   ├── UsuarioController.java        # Endpoints de usuários
│   │   │   │   ├── CompraController.java         # Endpoints de usuários
│   │   │   │   ├── ObraController.java           # Endpoints de usuários
│   │   │   │   └── EventoController.java         # Endpoints de eventos
│   │   │   ├── dtos/
│   │   │   │   ├── UsuarioRecordDto.java         # DTO de entrada
│   │   │   │   ├── ObraRecordDto.java            # DTO de entrada
│   │   │   │   ├── CompraRecordDto.java          # DTO de entrada
│   │   │   │   └── EventoRecordDto.java          # DTO de eventos
│   │   │   ├── model/
│   │   │   │   ├── ArtistaModel.java             # Entidade de Usuário
│   │   │   │   ├── ClienteModel.java             # Entidade de Usuário
│   │   │   │   ├── CarrinhoModel.java            # Entidade de Usuário
│   │   │   │   ├── CompraModel.java              # Entidade de Usuário
│   │   │   │   ├── ObraModel.java                # Entidade de Usuário
│   │   │   │   ├── EnderecoModel.java            # Entidade de Usuário
│   │   │   │   ├── EnderecoDiaHorarioModel.java  # Entidade de Usuário
│   │   │   │   ├── UsuarioModel.java             # Entidade de Usuário
│   │   │   │   └── EventoModel.java              # Entidade de Evento
│   │   │   ├── repository/
│   │   │   │   ├── ArtistaRepository.java        # Repositório JPA
│   │   │   │   ├── ClienteRepository.java        # Repositório JPA
│   │   │   │   ├── EnderecoRepository.java       # Repositório JPA
│   │   │   │   ├── CompraRepository.java         # Repositório JPA
│   │   │   │   ├── ObraRepository.java           # Repositório JPA
│   │   │   │   ├── UsuarioRepository.java        # Repositório JPA
│   │   │   │   └── EventoRepository.java         # Repositório JPA
│   │   │   ├── service/
│   │   │   │   ├── CompraService.java            # Serviço de usuários
│   │   │   │   ├── ObraService.java              # Serviço de usuários
│   │   │   │   ├── UsuarioService.java           # Serviço de usuários
│   │   │   │   └── EventoService.java            # Serviço de eventos
│   │   │   └── mapper/
│   │   │       ├── ArtistaMapper.java            # MapStruct mapper
│   │   │       ├── ClienteMapper.java            # MapStruct mapper
│   │   │       ├── ObraMapper.java               # MapStruct mapper
│   │   │       ├── CompraMapper.java             # MapStruct mapper
│   │   │       ├── EnderecoMapper.java           # MapStruct mapper
│   │   │       ├── EventoMapper.java             # MapStruct mapper
│   │   │       └── UsuarioMapper.java            # MapStruct mapper
│   │   └── resources/
│   │       └── application.yaml                  # Configurações
│   └── test/
├── pom.xml                                       # Dependências Maven
└── README.md                                     # Documentação
```

### Arquitetura em Camadas

A aplicação segue o padrão MVC com camadas bem definidas:

1. **Controller**: Recebe requisições HTTP e retorna respostas
2. **Service**: Contém a lógica de negócio
3. **Repository**: Gerencia o acesso aos dados
4. **Model**: Representa as entidades do banco de dados
5. **DTO**: Define os objetos de transferência de dados
6. **Mapper**: Converte entre entidades e DTOs usando MapStruct

## 📡 Endpoints da API

### Base URL
```
http://localhost:8080/api-artenamao
```

### 👤 Usuários

| Método | Endpoint | Descrição | Status Code |
|--------|----------|-----------|-------------|
| POST | `/usuarios` | Criar novo usuário | 201 Created |
| GET | `/usuarios` | Listar todos os usuários | 200 OK |
| GET | `/usuarios/{id}` | Buscar usuário por ID | 200 OK |
| PUT | `/usuarios/{id}` | Atualizar usuário | 200 OK |
| DELETE | `/usuarios/{id}` | Deletar usuário | 204 No Content |

### 🎨 Obras
| Método | Endpoint | Descrição | Status Code |
|--------|----------|-----------|-------------|
| POST | `/obras` | Criar novo obra | 201 Created |
| POST | `/obras` | Listar todas as obras | 200 OK |
| GET	 | `/obras/{id}` | Buscar obra por ID | 200 OK |
| PUT	 | `/obras/{id}` | Atualizar obra por ID | 200 OK |
| DELETE | `/obras/{id}` | Deletar obra por ID | 204 No Content |

### 🛒 Compras
| Método | Endpoint | Descrição | Status Code |
|--------|----------|-----------|-------------|
| POST	| `/compra/comprarObra` |	Registrar compra de uma obra | 201 Created |
| GET	| `/compra` |	Listar todas as compras	| 200 OK |
| PATCH	| `/compra/status/{compraId}` |	Atualizar status de uma compra | 200 OK |
| DELETE | `/compra/{compraId}` | Deletar uma compra por ID	| 204 No Content |


### 🎭 Eventos

| Método | Endpoint | Descrição | Status Code |
|--------|----------|-----------|-------------|
| POST | `/eventos/criar` | Criar novo evento | 201 Created |
| GET | `/eventos` | Listar todos os eventos | 200 OK |
| GET | `/eventos/{eventoId}` | Buscar evento por ID | 200 OK |
| PUT | `/eventos/{eventoId}` | Atualizar evento | 200 OK |
| PATCH | `/eventos/status/{eventoId}` | Atualizar status do evento | 200 OK |
| DELETE | `/eventos/{eventoId}` | Deletar evento | 204 No Content |

---

## 📖 Documentação da API (Swagger)

Acesse a documentação interativa através do Swagger UI:

**Swagger UI:**
```
http://localhost:8080/api-artenamao/swagger-ui/index.html
```

**OpenAPI JSON:**
```
http://localhost:8080/api-artenamao/v3/api-docs
```

O Swagger oferece:
- Interface interativa para testar todos os endpoints
- Documentação completa de todos os DTOs e modelos
- Exemplos de requisições e respostas
- Validações e constraints de cada campo
- Schemas completos dos objetos

---

## 🛠️ Funcionalidades

- ✅ CRUD completo de usuários
- ✅ CRUD completo de obras
- ✅ CRUD completo de compras
- ✅ CRUD completo de eventos
- ✅ Validação de dados com Bean Validation
- ✅ Verificação de email único
- ✅ Mapeamento automático com MapStruct
- ✅ Persistência com JPA/Hibernate
- ✅ IDs únicos com UUID
- ✅ Logs SQL formatados e coloridos
- ✅ Documentação automática com Swagger
- ✅ CORS habilitado para todas as origens
- ✅ Tratamento de erros com status HTTP apropriados

---

## 🧪 Testes

Execute os testes com:

```bash
# Testes unitários
mvn test

# Testes com cobertura
mvn test jacoco:report

# Executar aplicação
mvn spring-boot:run
```

---

## 📦 Build para Produção

Para gerar o arquivo JAR executável:

```bash
mvn clean package
```

O arquivo será gerado em: `target/artenamao-0.0.1-SNAPSHOT.jar`

Para executar:

```bash
java -jar target/artenamao-0.0.1-SNAPSHOT.jar
```

---

## 🐳 Docker (Opcional)

### Dockerfile

```dockerfile
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### docker-compose.yml

```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: 1234
      MYSQL_DATABASE: artenamao
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

  api:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/artenamao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: 1234

volumes:
  mysql_data:
```

**Executar com Docker Compose:**
```bash
docker-compose up -d
```

---

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFeature`)
3. Commit suas mudanças (`git commit -m 'Add: nova feature'`)
4. Push para a branch (`git push origin feature/NovaFeature`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto está sob a licença Apache 2.0. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👥 Autores

- **Eduardo Henrique** - [@Satth](https://github.com/Satth)
- **Pedro Henrique** - [@3henrique3](https://github.com/3henrique3)
- **Wyldson Marllon** - [@WyldSLA](https://github.com/WyldSLA)

---

## 📞 Suporte

Para reportar bugs ou solicitar novas funcionalidades, abra uma [issue](https://github.com/3henrique3/arte_na_mao_java/issues).

---

⭐ **Arte na Mão** - Conectando artistas e apreciadores de arte!
