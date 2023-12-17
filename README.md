# Event Management API

## Geral

Este projeto visa produzir uma API RESTful para um sistema que visa apoiar a organização de eventos. Foi produzido para atender um trabalho da disciplina Desenvolvimento Web Avançado, da Universidade Federal Fluminense, no semestre 2023.2.

Grupo formado por: Caique Guimarães, Marcos Zina, Natália Ignácio e Ruan Pablo.

O projeto será desenvolvido em Java. A especificação da API foi desenvolvida utilizando o Swagger Editor, seguindo uma versão da OpenAPI Specification.

Na especificação da API, os endpoints receberam tags de acordo com os atores que devem ter acesso a eles. Alguns endpoints podem ser acessados por mais de um ator, com restrições nos métodos disponíveis para cada um. Por exemplo, algumas requisições HTTP GET podem ser feitas por usuários gerais e administradores, mas POST e DELETE são reservados aos administradores.

## Começando

Para visualizar a documentação da API, baixe o arquivo [swagger.yml](https://github.com/apieceofCAKE/event-management-api/blob/master/swagger.yml) e utilize o [Swagger Editor](https://editor-next.swagger.io/) para executar o arquivo corretamente.

## Autenticação

Essa API utiliza *HTTP basic authentication* para a maioria de seus endpoints. Inclua credenciais válidas em suas requisições.

## Licença

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
