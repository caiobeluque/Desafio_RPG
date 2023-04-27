DESAFIO RPG

Esta é uma API Rest em Java que simula um Jogo RPG. 
A API permite Cadastrar, Atualizar, Excluir, Pesquisar Personagens pelo ID e Gerar uma Lista com todos os Personagens.
Após o cadastro de um Personagem, é possível pesquisar seus Atributos de Ataque, Defesa e Dano através do ID.
Além da Batalha, a API conta com uma listagem por Batalha, que traz o histórico da Batalha, sendo necessário pesquisar pelo Codigo da Batalha. 
Também é possível gerar uma lista com todas as batalhas executadas.

Tecnologias utilizadas
Java 8
Spring Boot 3.0.6
Maven 2.7.2
PostgreSql 15.2-2
Swagger 2
IntelliJ IDEA C-2023.1

Executando a aplicação
Para executar a aplicação, é necessário ter o Java 8, Maven 2.7.2 e IntelliJ instalados na máquina. Em seguida, baixar o projeto que esta disposto no GITHUB (https://github.com/caiobeluque/Desafio_RPG) e abri-lo noIntelliJ.
Feito isso, basta executar a aplicação através da classe principal RpgApplication, após a subida do serviço, basta acessar o Swagger via browser no endereço (http://localhost:8080/swagger-ui/).

Endpoints disponíveis
GET /rpg/batalha: Gerar uma lista com todas as batalhas.
GET /rpg/batalha/: Lista Histórico da Batalha pelo Código da Batalha.
PUT /rpg/bstalha: Jogar!
GET /rpg/personagem/ataque/{id}: Listar Atributos de Ataque do Personagem por ID.
GET /rpg/personagem/danos/{id}: Listar Atributos de Dano do Personagem por ID.
GET /rpg/personagem/defesa/{id}: Listar Atributos de Defesa do Personagem por ID.
GET /rpg/personagens: Gerar uma lista com todos os Personagens Cadastrados.
POST /rpg/personagens: Cadastrar Novo Personagem.
PUT /rpg/personagens: Atualizar Personagem.
DELETE /rpg/personagens/{id}: Excluir Personagens pelo ID.
GET /rpg/personagens/{id}: Busca Personagem por ID.

Jogar:
Para Jogar basta seguir os passos abaixo:
 - Acessar o Swagger via browser no endereço (http://localhost:8080/swagger-ui/);
 - Selecionar o menu Controller;
 - Selecionar o Endpoint (PUT /rpg/bstalha: Jogar!); 
 - Clicar em Try it Out;
 - Será gerado um exemplo de Objeto como este:
   - {
       "ataquePersonagem1": 0,
       "ataquePersonagem2": 0,
       "defesaPersonagem1": 0,
       "defesaPersonagem2": 0,
       "id": 0,
       "idPersonagem1": 0,
       "idPersonagem2": 0,
       "iniciativa1": 0,
       "iniciativa2": 0,
       "nomePersonagem1": "string",
       "nomePersonagem2": "string",
       "partida": 0,
       "pontosVidaPersonagem1": 0,
       "pontosVidaPersonagem2": 0,
       "turno": 0,
       "vencedor": "string"
     }
   - Os únicos campos obrigatórios para preenchimento são:
	- idPersonagem1
	- idPersonagem2 
     
	Deste modo utilize o exemplo abaixo, trocando os zeros "0", pelos IDs dos seus personagens favoritos.

   - {
       "idPersonagem1": 0,
       "idPersonagem2": 0
     }

OBS: Portanto é de suma importância que se tenham personagens cadastrados para que a partida seja executada. 
Lembrando que é preciso ter ao menos 1 personagem cadastrado, porém ele só poderá batalhar com ele mesmo, então para uma melhor experiência é importante que mais de um personagem seja cadastrado.

Para auxiliar, disponibilizarei abaixo os jogadores default do sistema para cadastrar no Endpoint (POST /rpg/personagens: Cadastrar Novo Personagem.) 

/// --- Heróis --- ///
 
{
  "agilidade": 6,
  "defesa": 5,
  "faces_dados": 12,
  "forca": 7,
  "nome_personagem": "Guerreiro",
  "quantidade_dados": 1,
  "tipo_personagem": "Heróis",
  "vida": 20
}


{
  "agilidade": 5,
  "defesa": 2,
  "faces_dados": 8,
  "forca": 10,
  "nome_personagem": "Bárbaro",
  "quantidade_dados": 2,
  "tipo_personagem": "Heróis",
  "vida": 21
}

{
  "agilidade": 3,
  "defesa": 8,
  "faces_dados": 6,
  "forca": 6,
  "nome_personagem": "Cavaleiro",
  "quantidade_dados": 2,
  "tipo_personagem": "Heróis",
  "vida": 26
}

/// --- Monstros --- ///

{
  "agilidade": 2,
  "defesa": 1,
  "faces_dados": 4,
  "forca": 7,
  "nome_personagem": "Orc",
  "quantidade_dados": 3,
  "tipo_personagem": "Monstros",
  "vida": 42
}


{
  "agilidade": 4,
  "defesa": 4,
  "faces_dados": 6,
  "forca": 10,
  "nome_personagem": "Gigante",
  "quantidade_dados": 2,
  "tipo_personagem": "Monstros",
  "vida": 34
}

{
  "agilidade": 7,
  "defesa": 4,
  "faces_dados": 4,
  "forca": 7,
  "nome_personagem": "Lobisomen",
  "quantidade_dados": 2,
  "tipo_personagem": "Monstros",
  "vida": 34
}


Banco de dados
A aplicação utiliza o PostgreSQL como banco de dados. As configurações de acesso ao banco de dados estão no arquivo application.properties.

spring.datasource.url=jdbc:postgresql://localhost:5432/rpg?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver

Autor
Caio Felipe Beluque

E-mail: caio.felipe.beluque@avanade.com
        caiobeluque@gmail.com

GitHub: https://github.com/caiobeluque

