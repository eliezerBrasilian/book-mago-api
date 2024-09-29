# book-mago-api

**Version**: 1.0  

## Descrição

Esta API gratuita é constituída de dois microserviços que se complementam em exibir livros e converter seus preços de uma moeda específica para outra.
Existem dois microserviços rodando:
1. book-service
2. cambio-service

É possível inserir mais cambios e livros. Para isto é necessário informar uma X-API-KEY válida no header da requisição:  

A documentação completa da API está disponível via Swagger, facilitando a exploração e o teste dos endpoints.  
Acesse a documentação completa:  
[book-service-documentation](http://191.252.92.39:8000/book-service-documentation/swagger-ui/index.html)
[cambio-service-documentation](http://191.252.92.39:8001/cambio-service-documentation/swagger-ui/index.html)

### Alguns endpoints abaixo

### `GET /book-service/list`

**Descrição**: Retorna uma lista de livros.  
**Método**: `GET`  
**Respostas**:
- **200**: Sucesso ao buscar os livros.
- **500**: Erro interno ao realizar a busca.

#### Exemplo de Requisição

```bash
curl -X GET "http://191.252.92.39:8000/book-service/list" -H "accept: application/json"
```

### Modelo de Livro

```json
{
  {
        "id": string,
        "author": string,
        "launchDate": Date,
        "price": number,
        "title": string
    }
}
```

### `GET /cambio-service/list`

**Descrição**: Retorna uma lista de cambios.  
**Método**: `GET`  
**Respostas**:
- **200**: Sucesso ao buscar os cambios.
- **500**: Erro interno ao realizar a busca.

#### Exemplo de Requisição

```bash
curl -X GET "http://191.252.92.39:8000/cambio-service/list" -H "accept: application/json"
```

### Modelo de Cambios

```json
{
  {
        {
        "id": string,
        "from": string,
        "to": string,
        "convertionFactor": number
    },
    }
}
```

### Tecnologias utilizadas
- MongoDB
- OpenFeign
- SpringBoot
- Swagger Open API


## Instalação e Execução

Para rodar esta aplicação localmente:

1. Clone o repositório:

   ```bash
   git clone https://github.com/eliezerBrasilian/book-mago-api.git
    ```

2. Execute o projeto. 

## Autor
Desenvolvido por @EliezerBrasilian.
