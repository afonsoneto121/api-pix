# API PIX

## Descrição 

Simulação do sistema de pagamento PIX utilizando microserviços para gerenciar o pagamento. 

## Arquitetura
A arquitetura é dividida em dois microsserviços(transfer e payment). Transfer é responsável por gerenciar uma API REST que cria e consulta transações, transferência de uma chave pix para outra. Payment é um serviço centralizado que efetiva uma transação, transferindo o valor de uma carteira para outra. Quando uma transação é criada, ela é armazenada em um tópico kafka com informações de status e processamento. Um Consumer ler as transações e a efetiva registrando em um novo tópico com as informações de sucesso ou falha. A integridade dos dados é feita através  do Schema Registry que fornece uma camada de serviço para os metadados das mensagens. As mensagens são registradas como o formato Apache Avro. A imagem abaixo descreve a arquitetura. 

![Diagrama](https://i.ibb.co/4JcSwBj/Diagrama-em-branco.png)

## Stack
- Java 11
  - Spring Cloud Stream
  - Spring Data
- PostgreSQL
- MongoDB
- Git
- Docker
- Apache Kafka
  - Schema Registry
  - Apache Avro


# Em desenvolvimento
