# Sistema de Gerenciamento de Rodoviária

Este projeto é uma aplicação para o gerenciamento de uma rodoviária, desenvolvida em Java utilizando o padrão de projeto Builder. A aplicação permite a construção de diferentes tipos de sanduíches, seguindo o padrão de design Builder e Factory.

## Descrição

O sistema é composto por:

- **Padrão de Projeto Builder**: Utilizado para construir objetos complexos (sandwiches) passo a passo.
- **Padrão de Projeto Factory**: Implementado para criar diferentes tipos de sanduíches (Artesanal, Integral e X-Tudo).
- **Classes e Interfaces**:
  - `SanduicheBuilder`: Classe responsável por construir sanduíches utilizando uma fábrica.
  - `SanduicheFactory`: Classe abstrata que define o contrato para criação dos ingredientes do sanduíche.
  - `SanduicheArtesanalFactory`, `SanduicheIntegralFactory`, `SanduicheXTudoFactory`: Fábricas concretas que implementam a criação dos ingredientes específicos.
  - **Interfaces e Produtos**: Incluem `Pao`, `Queijo`, `Presunto`, `Ovo`, e suas implementações concretas como `PaoFrances`, `QueijoPrato`, etc.
  - **Modelo**: `Sanduiche`, que representa o objeto final composto pelos ingredientes.
  - **Testes**: Incluem testes para validar a criação dos ingredientes e a construção dos sanduíches.

## Funcionalidades

- **Criação de Sanduíches**:
  - Sanduíche Artesanal
  - Sanduíche Integral
  - Sanduíche X-Tudo

- **Testes Automatizados**: Utiliza JUnit para garantir que a criação dos sanduíches e seus ingredientes estão funcionando conforme esperado.

## Estrutura do Projeto

- **builder/SanduicheBuilder.java**: Implementa o padrão Builder para criar um sanduíche.
- **criadorAbstrato/SanduicheFactory.java**: Define a fábrica abstrata para a criação dos ingredientes do sanduíche.
- **criadoresConcretos/SanduicheArtesanalFactory.java**, **SanduicheIntegralFactory.java**, **SanduicheXTudoFactory.java**: Implementações concretas da fábrica para diferentes tipos de sanduíches.
- **interfacesProdutos/Ovo.java**, **Pao.java**, **Presunto.java**, **Queijo.java**: Interfaces para os produtos dos ingredientes.
- **produtosConcretos**: Contém as implementações concretas dos ingredientes.
- **modelo/Sanduiche.java**: Representa o sanduíche final com seus ingredientes.
- **testes**: Contém testes automatizados para validar o funcionamento do sistema.
- **Main.java**: Classe principal para demonstrar a criação dos diferentes tipos de sanduíches.

## Como Executar

1. **Compile o Projeto**: Utilize um compilador Java para compilar o código.
2. **Execute a Classe Principal**: Rode a classe `Main.java` para ver a criação e exibição dos sanduíches.
3. **Execute os Testes**: Utilize JUnit para rodar os testes e garantir que tudo está funcionando corretamente.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para implementação.
- **JUnit**: Framework para testes automatizados.
- **Padrão de Projeto Builder e Factory**: Para a construção e criação dos objetos complexos.

