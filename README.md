## ValiDoc - App Fictício de Validação de Documentos

## Descrição
Meu primeiro contato com a linguagem de programação Kotlin. O tempo de desenvolvimento desse projeto foi 5 dias,
então ainda há bastante espaço para refatorações do código. Existem linhas repetidas, hardcoding em valores aplicados 
na interface do aplicativo, e assets que eu já tinha usado em outros projetos. Tive facilidade em entender a sintaxe, pela sua similaridade com Java.

## Objetivo
A proposta era criar o MVP de um aplicativo que pudesse estimular o conceito de cidades inteligentes - trazer a tecnologia para facilitar a gestão pública.

## Funcionalidades
O aplicativo ficou dividido em 3 telas:

### Tela Inicial
O usuário escolhe como deseja seguir na aplicação (login ou cadastro). Para simplificar o desenvolvimento do MVP, **criei somente a tela de cadastro**.

### Tela de Cadastro 
O usuário insere seus dados para criar uma conta. Os dois últimos campos (UF e cidade) exibem listas que são trazidas da API de localidades do IBGE
(https://servicodados.ibge.gov.br/api/v1/localidades) - a lista de cidades será exibida de acordo com o estado selecionado.

### Tela de Menu
Exibe todos os documentos cadastrados e uma tabela com as validações recentes de documentos. Na tabela devem aparecer dados importantes, como data,
documento validado, e local (farmácias, instituições financeiras, transportes públicos etc.) onde foi realizada cada validação. Aqui, é possível arrastar os cards 
de documentos para escolher qual documento validar. Para quando um card for clicado, fiz uma simples função de validar documento, que simula NFC - em alguns segundos
o documento é validado, como se o smartphone estivesse sendo aproximado de outro dispositivo para realizar uma validação.
