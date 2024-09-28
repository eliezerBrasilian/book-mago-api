# book-mago-api

**Version**: 1.0  

## Descrição

A **Detona Movies API** é uma API gratuita desenvolvida para fornecer uma lista de livros, e nela você realiza conversão de preços para diferentes moedas.
Existem dois microserviços rodando:
1. book-service
2. cambio-service

É possível inserir mais cambios e livros. Para isto é necessário informar uma X-API-KEY válida no header da requisição:  

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



## Instalação e Execução

Para rodar esta aplicação localmente:

1. Clone o repositório:

   ```bash
   git clone https://github.com/eliezerBrasilian/book-mago-api.git
    ```

2. Execute o projeto. 

## Autor
Desenvolvido por @EliezerBrasilian.
