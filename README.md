# 📅 Calculadora de Idade

Projeto desenvolvido durante o curso de Java do [_@GustavoGuanabara_](https://www.cursoemvideo.com/) no CursoEmVideo.
O objetivo principal foi aprofundar os conhecimentos sobre entrada e saída de dados, interfaces interativas e manipulação de banco de dados.

## ✨ Sobre o Projeto

A **Calculadora de Idade** permite que o usuário insira sua data de nascimento e, com base na data atual da máquina, exibe sua idade.
Além disso, o projeto pode ser integrado a um banco de dados SQLite, permitindo o armazenamento tanto da data de nascimento quanto da idade do usuário. Isso possibilita uma organização mais eficiente dos dados, podendo ser utilizado como base para aplicações mais complexas.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada no desenvolvimento.
- **NetBeans**: Ambiente de desenvolvimento integrado (IDE) escolhido para o projeto.
- **Java Swing**: Biblioteca utilizada para a criação da interface gráfica.
- **SQLite**: Banco de dados utilizado para armazenar as informações dos usuários.

## 📚 O que Aprendi

✅ Manipulação de entrada e saída de dados em Java.  
✅ Criação de interfaces gráficas utilizando **Java Swing**.  
✅ Uso do **NetBeans** para desenvolvimento e organização do código.  
✅ Conexão e manipulação de um banco de dados **SQLite** em Java.  
✅ Implementação de operações CRUD (**Create, Read, Update, Delete**) para gerenciar os dados dos usuários.  
✅ Estruturação de menus interativos para melhorar a experiência do usuário.

## 🔄 Fluxograma da Aplicação

```mermaid
graph TD;
    A[Início] --> B[Abrir a aplicação]
    B --> C{Menu: Escolher uma opção}

    C --> D[Digitar novos dados - INSERT] --> B
    C --> E[Visualizar dados - SELECT] --> B
    C --> F[Atualizar dados - UPDATE] --> B
    C --> G[Excluir dados - DELETE] --> B
    C --> H[Sair da aplicação] 
```

## 📌 Funcionalidades

- [x] O usuário digita o ano de nascimento, e o código calcula a idade com base em **2025 - ano informado**.
- [x] O usuário digita o ano de nascimento, e a aplicação retorna a idade com base na data da máquina.
- [x] O usuário digita sua **data completa de nascimento**, e a aplicação retorna a idade baseada na data atual.
- [x] O usuário digita sua data de nascimento e nome, e a aplicação armazena **nome, data de nascimento e idade** em um banco de dados SQLite.
- [ ] O usuário pode **visualizar** os dados armazenados no banco.
- [ ] O usuário pode **atualizar** os dados armazenados.
- [ ] O usuário pode **excluir** dados previamente inseridos.

## 💡 Frase Motivacional

> "Falhe, desde que não desista, não estará falhando."

## 📥 Download do Executável

Para baixar o **.jar** e executar o programa, clique no link abaixo:  
[✨ Download .jar ✨](https://github.com/ifLauraAlmeida/CalculadoraIdade/tree/main/dist)


