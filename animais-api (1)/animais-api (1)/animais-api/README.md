# API de Animais para Adoção

API REST desenvolvida em Java com Spring Boot para cadastro e gerenciamento de animais disponíveis para adoção.

O projeto foi desenvolvido como atividade prática, aplicando os conceitos de API REST, arquitetura em camadas, persistência de dados, validação e tratamento de erros.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- Lombok
- Maven

## Estrutura do projeto

O projeto está organizado nas seguintes camadas:

- **Model:** representa a entidade Animal e seus atributos.
- **Repository:** responsável pelo acesso aos dados.
- **Service:** contém as regras e operações da aplicação.
- **Controller:** disponibiliza os endpoints da API.
- **Exception:** realiza o tratamento personalizado de erros.

## Animal

Cada animal possui os seguintes atributos:

- `id` - identificador único gerado automaticamente
- `nome` - nome do animal
- `especie` - espécie do animal
- `raca` - raça do animal
- `idade` - idade do animal
- `sexo` - sexo do animal
- `disponivelParaAdocao` - informa se o animal está disponível para adoção

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/animais` | Cadastrar um novo animal |
| GET | `/animais` | Listar todos os animais |
| GET | `/animais/{id}` | Buscar um animal pelo ID |
| PUT | `/animais/{id}` | Atualizar um animal |
| DELETE | `/animais/{id}` | Excluir um animal |

## Exemplo de cadastro

```json
{
  "nome": "Luna",
  "especie": "Cachorro",
  "raca": "Vira-lata",
  "idade": 3,
  "sexo": "Femea",
  "disponivelParaAdocao": true
}
```

## Validações

A API possui validações para impedir o cadastro de dados inválidos.

Alguns exemplos:

- Nome, espécie, raça e sexo são obrigatórios.
- A idade não pode ser negativa.
- A disponibilidade para adoção deve ser informada.

Quando os dados enviados são inválidos, a API retorna o status HTTP `400 Bad Request` com a descrição dos erros.

Exemplo:

```json
{
  "idade": "A idade não pode ser negativa",
  "nome": "O nome é obrigatório"
}
```

## Tratamento de erros

Ao tentar atualizar ou excluir um animal inexistente, a API retorna o status HTTP `404 Not Found`.

Exemplo:

```json
{
  "erro": "Animal não encontrado"
}
```

## Banco de dados

O projeto utiliza o banco de dados H2 em memória.

Os dados são armazenados enquanto a aplicação está em execução e são apagados quando a aplicação é encerrada.

## Executando o projeto

No Windows, o projeto pode ser iniciado utilizando o Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Após iniciar a aplicação, a API estará disponível em:

```text
http://localhost:8080/animais
```

## Autora

**Aline Julia Lasneau**
**Keizi Karin Santos Modesto **
