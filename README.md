# Cripto Exchange 💻

## 📌 Sobre o Projeto

Este projeto visa o desenvolvimento de uma aplicação Java Ant vinculada a um banco de dados PostgreSQL, simulando a usabilidade de uma **Exchange de Criptomoedas**. 

A aplicação oferece as seguintes funcionalidades:

- **Login / Cadastro de Usuário**: Cadastro e autenticação de usuários utilizando CPF e senha numérica de 6 dígitos.
- **Saldo**: Visualização do saldo em carteira do usuário.
- **Extrato**: Visualização do extrato de transações realizadas.
- **Depósito / Saque**: Funcionalidade para realizar depósitos e saques em reais.
- **Compra**: Permite a compra de moedas cadastradas na plataforma, com exibição das cotações no momento da compra.
- **Venda**: Permite a venda de moedas em carteira, exibindo as cotações no momento da venda.
- **Atualização de Cotação**: Um botão que atualiza as cotações das moedas, com uma variação de 0 a 5% para mais ou para menos.

## 💻 Tecnologias

- **Java**
- **PostgreSQL**
- **Ant**

### Pré-requisitos

- **JDK 17+ ou Java 8+**
- **PostgreSQL 17+**

## 🌐 Criação do Banco de Dados

A aplicação utiliza um banco de dados PostgreSQL local para armazenar os dados dos investidores. Caso queira rodar o projeto em sua máquina, siga os passos abaixo para configurar o banco de dados.

### Passos para Configuração

1. **Alterar a Senha do Usuário Padrão (`postgres`)**

   No PostgreSQL, altere a senha do usuário `postgres` para `1234`:

   ```sql
   ALTER USER postgres WITH PASSWORD '1234';

  Caso você esteja utilizando outro usuário ou senha no seu banco de dados PostgreSQL, e queira utilizar a aplicação sem modifica-lo, será necessário modificar as configurações de conexão no projeto, no arquivo localizado em `\src\DAO\Conexao.java`.
    

2. **Criar a Database**

   Crie a database `cripto-exchange`:

   ```sql
   CREATE DATABASE "cripto-exchange";
3. **Criar as Tabelas Necessárias**

   Após criar o banco de dados, execute os seguintes comandos para criar as tabelas necessárias para a aplicação:

   - **Tabela `investidores`**

     ```sql
     CREATE TABLE investidores (
         id SERIAL PRIMARY KEY,             -- Identificador único gerado automaticamente
         nome TEXT NOT NULL,                -- Nome do investidor
         sobrenome TEXT,                    -- Sobrenome do investidor
         cpf TEXT UNIQUE NOT NULL,          -- CPF único e obrigatório
         senha TEXT NOT NULL,               -- Senha do investidor
         real DOUBLE PRECISION DEFAULT 0,   -- Saldo em reais
         bitcoin DOUBLE PRECISION DEFAULT 0, -- Saldo em Bitcoin
         ethereum DOUBLE PRECISION DEFAULT 0, -- Saldo em Ethereum
         ripple DOUBLE PRECISION DEFAULT 0   -- Saldo em Ripple
     );
     ```

   - **Tabela `extrato`**

     ```sql
     CREATE TABLE extrato (
         id SERIAL PRIMARY KEY,             -- Identificador único gerado automaticamente
         hora TEXT NOT NULL,                -- Hora do registro (em formato textual)
         op TEXT NOT NULL,                  -- Operação realizada (ex.: compra(+)/venda(-))
         valor DOUBLE PRECISION NOT NULL,   -- Valor da operação
         moeda TEXT NOT NULL,               -- Moeda utilizada (ex.: bitcoin, ethereum)
         cotacao DOUBLE PRECISION NOT NULL, -- Cotação da moeda no momento da operação
         taxa DOUBLE PRECISION NOT NULL,    -- Taxa aplicada na operação
         real DOUBLE PRECISION NOT NULL,    -- Saldo final em reais
         bitcoin DOUBLE PRECISION NOT NULL, -- Saldo final em Bitcoin
         ethereum DOUBLE PRECISION NOT NULL, -- Saldo final em Ethereum
         ripple DOUBLE PRECISION NOT NULL   -- Saldo final em Ripple
     );
     ```

   - **Tabela `moedas`**

     ```sql
     CREATE TABLE moedas (
         id INTEGER NOT NULL,               -- Identificador da moeda
         nome TEXT NOT NULL,                -- Nome da moeda
         valor DOUBLE PRECISION NOT NULL,   -- Valor atual da moeda
         PRIMARY KEY (id, nome)             -- Chave primária composta por id e nome
     );
     ```

   - **Inserir os Valores Iniciais para as Moedas**

     ```sql
     INSERT INTO moedas (id, nome, valor) VALUES
         (0, 'real', 1),                    -- Real com valor de 1
         (1, 'bitcoin', 400000),            -- Bitcoin com valor de 400 mil
         (2, 'ethereum', 13000),            -- Ethereum com valor de 13 mil
         (3, 'ripple', 5);                  -- Ripple com valor de 5
     ```
