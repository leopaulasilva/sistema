# Sistema de Usuários de Carros
A API fornece endpoints para operações relacionadas a usuários, carros e autenticação.




**1 - Título: Registro de Novo Usuário**

Descrição:
Como um novo usuário do aplicativo, desejo me registrar para poder acessar o sistema.

Critérios de Aceitação:

* Como usuário, quero preencher um formulário de registro com os seguintes campos obrigatórios: nome, e-mail, login e senha.
* Se eu não preencher algum dos campos obrigatórios, devo ser informado sobre os campos faltantes.
* O sistema deve verificar se o e-mail fornecido já está em uso por outro usuário. Se estiver, devo receber uma mensagem informando que o e-mail já está registrado.
* O sistema deve verificar se o login fornecido já está em uso por outro usuário. Se estiver, devo receber uma mensagem informando que o login já está em uso.
* Após o registro bem-sucedido, devo receber uma mensagem de confirmação indicando que meu registro foi concluído com sucesso.
* Após o registro, devo ser redirecionado para a página de login para acessar minha conta recém-criada.



**2 - Título: Login de Usuário**

Descrição:
Como um usuário registrado, desejo fazer login para acessar minha conta e usar os recursos do sistema.

Critérios de Aceitação:

* Como usuário, desejo preencher um formulário de login com os campos obrigatórios: login (ou e-mail) e senha.
* Se eu não preencher algum dos campos obrigatórios, devo ser informado sobre os campos faltantes.
* O sistema deve autenticar minhas credenciais de login. Se minhas credenciais estiverem incorretas, devo receber uma mensagem informando que meu login falhou.
* Se minhas credenciais de login estiverem corretas, devo ser redirecionado para a página inicial do aplicativo, indicando que fiz login com sucesso.
* Como um usuário autenticado, desejo permanecer conectado por um período de tempo adequado, para que eu não precise fazer login repetidamente durante uma única sessão de uso do aplicativo.
* Devo ter a opção de sair (fazer logout) da minha conta, para garantir a segurança dos meus dados quando não estiver mais usando o aplicativo.



**3 - Listagem de Usuários**

Título: Visualizar Lista de Usuários

Como um usuario logado do sistema, eu gostaria de ver uma lista de todos os usuários registrados.

Critérios de Aceitação:

* Quando acesso o endpoint /api/users via método GET, recebo uma resposta contendo uma lista de usuários.
* Cada usuário na lista deve conter informações básicas, como nome, e-mail e login.
* A lista deve ser ordenada de forma consistente (por exemplo, por ordem alfabética do login).


**4 - Criação de Novo Usuário**

Título: Registrar Novo Usuário

Como um usuário novo no sistema, eu gostaria de me registrar para obter acesso ao aplicativo, para que eu possa começar a usar os recursos disponíveis.

Critérios de Aceitação:

* Quando acesso o endpoint /api/users via método POST e forneço informações válidas, um novo usuário é registrado com sucesso.
* Se houver erros de validação nos dados fornecidos, recebo uma resposta de erro indicando quais campos precisam ser corrigidos.
* Se o e-mail ou o login fornecido já existir no sistema, recebo uma resposta de erro informando que o e-mail ou o login já está em uso.
* Visualização de Detalhes do Usuário

**5 - Título: Visualizar Detalhes do Usuário**

Como um administrador do sistema, eu gostaria de ver os detalhes de um usuário específico, para que eu possa revisar ou modificar as informações desse usuário.

Critérios de Aceitação:

* Quando acesso o endpoint /api/users/{id} via método GET, recebo uma resposta contendo os detalhes do usuário com o ID especificado.
* Os detalhes do usuário incluem informações como nome, e-mail e login.
* Se o usuário com o ID especificado não existir, recebo uma resposta de erro indicando que o usuário não foi encontrado.


Atualização de Informações do Usuário
Título: Atualizar Informações do Usuário

Como um administrador do sistema, eu gostaria de atualizar as informações de um usuário existente, para que eu possa manter os registros de usuários precisos e atualizados.

Critérios de Aceitação:

* Quando acesso o endpoint /api/users/{id} via método PUT e forneço informações válidas, as informações do usuário com o ID especificado são atualizadas com sucesso.
* Se houver erros de validação nos dados fornecidos, recebo uma resposta de erro indicando quais campos precisam ser corrigidos.
* Se o e-mail ou o login fornecido já existir no sistema (exceto se pertencer ao próprio usuário sendo atualizado), recebo uma resposta de erro informando que o e-mail ou o login já está em uso.


**6 - Exclusão de Usuário**

Título: Excluir Usuário

Como um administrador do sistema, eu gostaria de excluir um usuário do sistema, para que eu possa remover registros de usuários desnecessários ou inativos.

Critérios de Aceitação:

* Quando acesso o endpoint /api/users/{id} via método DELETE, o usuário com o ID especificado é excluído do sistema com sucesso.
* Se o usuário com o ID especificado não existir, recebo uma resposta de sucesso indicando que o usuário não foi encontrado (não é necessário nenhum tratamento de erro, já que o resultado final é o mesmo).


**7 - Título: Atualizar Dados do Usuário**


Como um usuário registrado no sistema, desejo poder atualizar minhas informações pessoais, como e-mail ou login, caso haja necessidade de alteração.

Critérios de Aceitação:

* Ao acessar o endpoint /api/users/{id} via método PUT, fornecendo o ID do usuário que desejo atualizar, devo poder enviar os novos dados do usuário no corpo da solicitação.
* O sistema deve verificar se há erros de validação nos novos dados do usuário. Caso haja erros, o sistema deve retornar uma resposta de erro 400 Bad Request, informando os detalhes dos erros de validação.
* O sistema deve verificar se o e-mail e o login fornecidos já existem no sistema. Se o e-mail ou login forem alterados e já existirem, o sistema deve retornar uma resposta de erro 400 Bad Request, informando que o e-mail ou login já está em uso.
* Se todas as verificações passarem com sucesso, o sistema deve atualizar as informações do usuário com os novos dados fornecidos e retornar uma resposta de sucesso 200 OK, contendo os dados atualizados do usuário.
* Os campos que podem ser atualizados incluem e-mail, login e quaisquer outros dados relevantes do usuário.


**8 - Listar todos os carros**


Título: Visualizar Lista de Carros



Como um usuário do sistema, gostaria de visualizar uma lista de todos os carros disponíveis, para ter uma visão geral dos carros cadastrados no sistema.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars via método GET, devo receber uma lista de todos os carros disponíveis no sistema.
* A lista de carros deve conter informações relevantes, como modelo, ano, placa e outros detalhes importantes.


**9 - Adicionar um novo carro**

Título: Adicionar Novo Carro

Descrição:


Como um usuário do sistema, desejo poder adicionar um novo carro à lista de carros disponíveis, fornecendo todas as informações necessárias sobre o carro.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars via método POST, devo poder enviar os detalhes do novo carro no corpo da solicitação.
* O sistema deve verificar se há erros de validação nos dados do novo carro. Caso haja erros, o sistema deve retornar uma resposta de erro 400 Bad Request, informando os detalhes dos erros de validação.
* O sistema deve verificar se a placa do carro fornecida já existe no sistema. Se a placa já estiver em uso, o sistema deve retornar uma resposta de erro 400 Bad Request, informando que a placa já está em uso.
* Se todas as verificações passarem com sucesso, o sistema deve adicionar o novo carro à lista de carros disponíveis e retornar uma resposta de sucesso 200 OK, contendo os detalhes do novo carro adicionado.


**10 - Obter detalhes de um carro específico**


Título: Visualizar Detalhes de um Carro

Como um usuário interessado em um carro específico, desejo poder visualizar os detalhes desse carro, como marca, modelo, ano e outras informações relevantes.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars/{id} via método GET, fornecendo o ID do carro desejado, devo receber os detalhes desse carro.
* Se o carro com o ID fornecido existir no sistema, o sistema deve retornar uma resposta de sucesso 200 OK, contendo os detalhes completos do carro.
* Se o carro com o ID fornecido não existir no sistema, o sistema deve retornar uma resposta de erro 404 Not Found, indicando que o carro não foi encontrado.
* Os detalhes do carro devem incluir informações relevantes, como marca, modelo, ano, cor, placa e outras características importantes.


**11 - Listar carros de um usuário específico**


Título: Visualizar Carros de um Usuário


Como um usuário do sistema, desejo poder visualizar todos os carros pertencentes a um usuário específico, para entender quais carros estão associados a esse usuário.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars/user/{id} via método GET, fornecendo o ID do usuário desejado, devo receber uma lista de todos os carros pertencentes a esse usuário.
* Se o usuário com o ID fornecido existir no sistema e possuir carros associados a ele, o sistema deve retornar uma resposta de sucesso 200 OK, contendo uma lista dos carros pertencentes a esse usuário.
* Se o usuário com o ID fornecido não existir no sistema ou não possuir carros associados a ele, o sistema deve retornar uma resposta de sucesso 200 OK, contendo uma lista vazia.
* A lista de carros pertencentes ao usuário deve conter informações relevantes, como marca, modelo, ano e outras informações pertinentes.



**12 - Remover um carro**

Título: Remover Carro


Como um usuário do sistema, desejo poder remover um carro existente do sistema, caso não precise mais das informações desse carro.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars/{id} via método DELETE, fornecendo o ID do carro que desejo remover, o sistema deve remover esse carro do sistema.
* Se o carro com o ID fornecido existir no sistema e for removido com sucesso, o sistema deve retornar uma resposta de sucesso 204 No Content, indicando que o carro foi removido com sucesso.
* Se o carro com o ID fornecido não existir no sistema, o sistema deve retornar uma resposta de erro 404 Not Found, indicando que o carro não foi encontrado e não pode ser removido.


**13 - Atualizar informações de um carro**

Título: Atualizar Informações de um Carro

Como um usuário do sistema, desejo poder atualizar as informações de um carro existente, caso haja necessidade de correção ou atualização dessas informações.

Critérios de Aceitação:

* Ao acessar o endpoint /api/cars/{id} via método PUT, fornecendo o ID do carro que desejo atualizar, devo poder enviar os novos dados do carro no corpo da solicitação.
* O sistema deve verificar se há erros de validação nos novos dados do carro. Caso haja erros, o sistema deve retornar uma resposta de erro 400 Bad Request, informando os detalhes dos erros de validação.
* O sistema deve verificar se a placa de licença fornecida já existe no sistema. Se a placa de licença for alterada e já existir, o sistema deve retornar uma resposta de erro 400 Bad Request, informando que a placa de licença já está em uso.
* Se todas as verificações passarem com sucesso, o sistema deve atualizar as informações do carro com os novos dados fornecidos e retornar uma resposta de sucesso 200 OK, contendo os dados atualizados do carro.



**Especificações Técnicas - Sistema de Usuários de Carros**
Este documento descreve as especificações técnicas do sistema de usuários de carros.

**Visão Geral**
O sistema de usuários de carros é uma aplicação web desenvolvida com o framework Spring Boot. Ele fornece endpoints RESTful para realizar operações CRUD (Create, Read, Update, Delete) em entidades de usuário e carro.

**Requisitos de Desenvolvimento**
* Java 17: O sistema é desenvolvido usando Java na versão 17.
* Spring Boot 3.2.4: O framework Spring Boot é utilizado para o desenvolvimento do backend.
* Spring Data JPA: Utilizado para a camada de acesso a dados.
* Spring Web: Utilizado para a criação de endpoints RESTful.
* Spring Validation: Utilizado para a validação de dados de entrada.
* Spring Security: Utilizado para a segurança da aplicação.
* H2 Database: Utilizado como banco de dados em memória para ambiente de desenvolvimento.
* Lombok: Utilizado para reduzir a verbosidade do código Java.
* ModelMapper: Utilizado para mapear objetos entre diferentes camadas da aplicação.
* Logback: Utilizado como framework de logging.
* JUnit 5: Utilizado para testes unitários.
* Springdoc OpenAPI: Utilizado para documentação da API com OpenAPI (Swagger).
* JWT (JSON Web Tokens): Utilizado para autenticação e autorização baseada em token.
* Configuração do Ambiente
* O ambiente de desenvolvimento é configurado utilizando o Maven como gerenciador de dependências. As dependências do projeto são definidas no arquivo pom.xml.


**Build e Execução**

O projeto utiliza o plugin Maven do Spring Boot para build e execução. Para compilar o projeto, execute o seguinte comando:

`mvn clean install`

Para iniciar a aplicação, utilize o seguinte comando:

`mvn spring-boot:run
`

**Documentação da API**

A documentação da API é gerada automaticamente usando o Springdoc OpenAPI. Acesse os seguintes URLs para visualizar a documentação:

* Swagger UI (WebFlux)

**Testes**

O projeto possui testes unitários escritos com JUnit 5. Para executar os testes, utilize o seguinte comando:


`mvn test
`

**Segurança**

A segurança da aplicação é garantida com o uso de Spring Security e JWT. Os endpoints estão protegidos e requerem autenticação por token JWT.

**Endpoints**

//
**Registra um novo usuário.**

* POST /api/auth/signup

`{
"firstName": "string",
"lastName": "string",
"email": "string",
"password": "string",
"login": "string"
}`

//
**Inicia sessão de usuário.**

* POST /api/auth/signin


`{
"login": "string",
"password": "string"
}`


*Recupera todos os usuários cadastrados.

GET /api/users

*Cria um novo usuário com os dados fornecidos no corpo da solicitação.

`{
"firstName": "string",
"lastName": "string",
"email": "string",
"password": "string",
"login": "string"
}`


***Recupera um usuário específico pelo seu ID.**

GET /api/users/{id}

**Exclui um usuário específico pelo seu ID.

DELETE /api/users/{id}



*Atualiza um usuário específico pelo seu ID com os dados fornecidos no corpo da solicitação.

PUT /api/users/{id}

`_{
"id": "long",
"firstName": "string",
"lastName": "string",
"email": "string",
"password": "string",
"login": "string"
}_`


*Recupera todos os carros cadastrados.

GET /api/cars



*Cria um novo carro com os dados fornecidos no corpo da solicitação.


POST /api/cars


json

`{
"licensePlate": "string",
"make": "string",
"model": "string",
"year": "int"
}`

*Recupera um carro específico pelo seu ID.

GET /api/cars/{id}



*Recupera todos os carros associados a um usuário específico pelo seu ID.

GET /api/cars/user/{id}


*Exclui um carro específico pelo seu ID.

DELETE /api/cars/{id}


*Atualiza um carro específico pelo seu ID com os dados fornecidos no corpo da solicitação.
PUT /api/cars/{id}

json

`{
"licensePlate": "string",
"make": "string",
"model": "string",
"year": "int"
}
`


Respostas
* 200 OK: Para solicitações bem-sucedidas de recuperação, criação ou atualização.
* 400 BAD REQUEST: Se houver erros de validação nos dados do usuário fornecidos ou se o e-mail/login já existir.
* 404 NOT FOUND: Se o usuário não puder ser encontrado para as operações de recuperação, exclusão ou atualização.
* 


**Defesa Técnica:** 

Utiliza um conjunto de tecnologias modernas e amplamente adotadas, como Java, Spring Boot, Spring Security, entre outras, garantindo um ambiente de desenvolvimento robusto e seguro. A integração de ferramentas como Springdoc OpenAPI e Swagger simplifica a documentação da API, facilitando a compreensão e o uso por parte dos desenvolvedores. O uso de testes unitários com JUnit 5 assegura a qualidade do código e a robustez da aplicação. O padrão JWT para autenticação proporciona uma camada adicional de segurança, garantindo que apenas usuários

