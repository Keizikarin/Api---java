# API de Canetas — Java + Spring Boot

API REST para cadastro e gerenciamento de canetas.

## Tecnologias
- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL ou H2
- JWT para autenticação
- JUnit 5

## Endpoints
Todas as rotas de canetas exigem `Authorization: Bearer <token>`.

| Método | Rota | Função |
|---|---|---|
| POST | `/auth/login` | Login e geração do JWT |
| GET | `/canetas` | Lista as canetas |
| GET | `/canetas/{id}` | Busca uma caneta |
| POST | `/canetas` | Cadastra uma caneta |
| PUT | `/canetas/{id}` | Atualiza uma caneta |
| DELETE | `/canetas/{id}` | Remove uma caneta |

## Dados da caneta

```json
{
  "nome": "Caneta Gel",
  "marca": "Pentel",
  "tipo": "GEL",
  "cor": "Azul",
  "ponta": "0.7 mm",
  "preco": 8.90,
  "estoque": 50
}
```

Tipos disponíveis: `ESFEROGRAFICA`, `GEL`, `HIDROGRAFICA`, `TINTEIRO`, `MARCA_TEXTO`, `TECNICA`.

## Login

Usuário padrão: `admin`  
Senha padrão: `admin123`

A aplicação mantém a autenticação JWT do projeto original.

## Como executar

Com PostgreSQL:

```bash
docker compose up -d
./mvnw spring-boot:run
```

Com H2:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

Testes:

```bash
./mvnw test
```

Na primeira inicialização são cadastradas quatro canetas de exemplo.
