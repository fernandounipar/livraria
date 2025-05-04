Claro! Aqui está o texto em markdown para o seu arquivo README.md:

````markdown
# Livraria

Projeto desenvolvido para a disciplina de Programação para Internet, utilizando Spring Boot, JPA e PostgreSQL.

## Visão Geral

O sistema permite o cadastro e a gestão de autores e livros, incluindo o relacionamento entre eles (um autor pode ter vários livros). Possui endpoints REST para operações CRUD e para consulta de autores com seus respectivos livros.

---

## Entidades Principais

### Autor
- `id`: Long
- `nome`: String
- `nacionalidade`: String
- `dataNascimento`: Date
- `email`: String
- `livros`: Lista de livros associados ao autor

### Livro
- `id`: Long
- `titulo`: String
- `numeroPaginas`: Integer
- `genero`: String
- `autor`: Autor associado ao livro

---

## Endpoints

### Autor

#### GET /autores/listar
Lista todos os autores cadastrados.

**Exemplo de resposta:**

```json
[
  {
    "id": 1,
    "nome": "Machado de Assis",
    "nacionalidade": "Brasileiro",
    "dataNascimento": "1839-06-21T00:00:00.000+00:00",
    "email": "machado@literatura.com"
  }
]
````

#### GET /autores/buscar/{id}

Busca um autor específico pelo ID.

#### POST /autores/salvar

Cria um novo autor.

**Exemplo de body:**

```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileiro",
  "dataNascimento": "1839-06-21",
  "email": "machado@literatura.com"
}
```

#### PUT /autores/editar/{id}

Edita informações de um autor existente.

**Exemplo de body:**

```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileiro",
  "dataNascimento": "1839-06-21",
  "email": "machado@literatura.com"
}
```

#### DELETE /autores/excluir/{id}

Deleta um autor pelo ID.

#### GET /autores/listar-com-livros

Lista todos os autores e, para cada autor, traz todos os livros que ele escreveu.

**Exemplo de resposta:**

```json
[
  {
    "id": 1,
    "nome": "Machado de Assis",
    "nacionalidade": "Brasileiro",
    "dataNascimento": "1839-06-21T00:00:00.000+00:00",
    "email": "machado@literatura.com",
    "livros": [
      {
        "id": 1,
        "titulo": "Dom Casmurro",
        "numeroPaginas": 256,
        "genero": "Romance"
      }
    ]
  }
]
```

---

### Livro

#### GET /livros/listar

Lista todos os livros cadastrados.

#### GET /livros/buscar/{id}

Busca um livro específico pelo ID.

#### GET /livros/buscar/por-titulo?titulo={titulo}

Busca livros pelo título.

#### GET /livros/buscar/por-genero?genero={genero}

Busca livros pelo gênero.

#### GET /livros/buscar/por-genero-paginas?genero={genero}\&paginasMinimas={valor}

Busca livros por gênero e número mínimo de páginas.

#### POST /livros/salvar

Cria um novo livro.

**Exemplo de body:**

```json
{
  "titulo": "Dom Casmurro",
  "numeroPaginas": 256,
  "genero": "Romance",
  "autor": {
    "id": 1
  }
}
```

#### PUT /livros/editar/{id}

Edita informações de um livro existente.

**Exemplo de body:**

```json
{
  "titulo": "Dom Casmurro",
  "numeroPaginas": 256,
  "genero": "Romance",
  "autor": {
    "id": 1
  }
}
```

#### DELETE /livros/excluir/{id}

Deleta um livro pelo ID.

---

## Observações

* Para os métodos GET, não é necessário enviar body.
* Para POST e PUT, envie o body em formato JSON conforme os exemplos acima.
* O campo `autor` em Livro deve conter ao menos o id do autor já cadastrado.

---

## Como Executar

1. Configure o banco de dados PostgreSQL e ajuste as credenciais no arquivo `application.properties`.
2. Execute a aplicação com `mvn spring-boot:run` ou pela sua IDE.
3. Utilize ferramentas como Postman para testar os endpoints.

