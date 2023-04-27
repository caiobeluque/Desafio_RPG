package com.avanade.rpg.controller;

import com.avanade.rpg.model.Batalhas;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.CadastroBatalhas;
import com.avanade.rpg.service.CadastroPersonagens;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/rpg" )
@Api( value = "Desafio API REST RPG" )
@CrossOrigin( origins = "*" )
public class Controller {

	@Autowired
	private CadastroPersonagens cadastroPersonagens;
	@Autowired
	private CadastroBatalhas cadastroBatalhas;

	@PostMapping( "/personagens" )
	@ApiOperation( "Cadastrar Novo Personagem" )
	public ResponseEntity< Personagem > create( @RequestBody Personagem personagem ) {
		return new ResponseEntity<>( cadastroPersonagens.create( personagem ), HttpStatus.CREATED );
	}

	@PutMapping( "/personagens" )
	@ApiOperation( "Atualizar Personagem" )
	public ResponseEntity< Personagem > update( @RequestBody Personagem personagem ) {
		return new ResponseEntity<>( cadastroPersonagens.update( personagem ), HttpStatus.OK );
	}

	@GetMapping( "/personagens" )
	@ApiOperation( "Gerar lista com todos os Personagens Cadastrados" )
	public ResponseEntity< List<Personagem>  > getAll( ) {
		return new ResponseEntity<>(cadastroPersonagens.findAll( ), HttpStatus.OK );
	}
	@GetMapping( "/personagens/{id}" )
	@ApiOperation( "Pesquisar Personagem pelo ID" )
	public ResponseEntity< Personagem > getById( @PathVariable( value = "id" ) Integer id ) {
		return new ResponseEntity<>( cadastroPersonagens.findById( id ), HttpStatus.OK );
	}

	@DeleteMapping( "/personagens/{id}" )
	@ApiOperation( "Excluir Personagem pelo ID" )
	public ResponseEntity< HttpStatus > update( @RequestHeader Integer id ) {
		cadastroPersonagens.delete( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

	@GetMapping( "/personagem/ataque/{id}" )
	@ApiOperation( "Listar Atributos de Ataque do Personagem por ID" )
	public ResponseEntity< String > ataque( @PathVariable( value = "id" ) Integer id) {
		Personagem byId = cadastroPersonagens.findById(id);

		final StringBuffer mensagem = new StringBuffer();
		mensagem.append("O Personagem: ");
		mensagem.append(byId.getNomePersonagem().trim());
		mensagem.append(" Possui uma Força de: ");
		mensagem.append(byId.getForca());
		mensagem.append(" e Agilidade de: ");
		mensagem.append(byId.getAgilidade());
		mensagem.append(". Podendo Atacar com um total de até:");
		mensagem.append( 12 + byId.getForca() + byId.getAgilidade());

		return new ResponseEntity<>(mensagem.toString(), HttpStatus.OK );
	}

	@GetMapping( "/personagem/defesa/{id}" )
	@ApiOperation( "Listar Atributos de Defesa do Personagem por ID" )
	public ResponseEntity< String > defesa( @PathVariable( value = "id" ) Integer id) {
		Personagem byId = cadastroPersonagens.findById(id);

		final StringBuffer mensagem = new StringBuffer();
		mensagem.append("O Personagem: ");
		mensagem.append(byId.getNomePersonagem().trim());
		mensagem.append(" Possui uma Defesa de: ");
		mensagem.append(byId.getDefesa());
		mensagem.append(" e Agilidade de: ");
		mensagem.append(byId.getAgilidade());
		mensagem.append(". Podendo Atacar com um total de até:");
		mensagem.append( 12 + byId.getDefesa() + byId.getAgilidade());

		return new ResponseEntity<>(mensagem.toString(), HttpStatus.OK );
	}

	@GetMapping( "/personagem/danos/{id}" )
	@ApiOperation( "Listar Atributos de Danos do Personagem por ID" )
	public ResponseEntity< String > danos( @PathVariable( value = "id" ) Integer id) {
		Personagem byId = cadastroPersonagens.findById(id);

		final StringBuffer mensagem = new StringBuffer();
		mensagem.append("O Personagem: ");
		mensagem.append(byId.getNomePersonagem().trim());
		mensagem.append(" Possui uma Força de: ");
		mensagem.append(byId.getForca());
		mensagem.append(" e Agilidade de: ");
		mensagem.append(byId.getAgilidade());
		mensagem.append(". Podendo Atingir um Dano total de até:");
		mensagem.append((byId.getQuantidadeDados() * byId.getFacesDados()) + byId.getForca());

		return new ResponseEntity<>(mensagem.toString(), HttpStatus.OK );
	}

	@PutMapping( "/batalha" )
	@ApiOperation( "Jogar!" )
	public ResponseEntity< Batalhas > playGame( @RequestBody Batalhas batalhas ) {
		cadastroBatalhas.update(batalhas);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping( "/batalha" )
	@ApiOperation( "Gerar uma lista com todas as Batalhas" )
	public ResponseEntity< List<Batalhas>  > getAllBatalhas( ) {
		return new ResponseEntity<>(cadastroBatalhas.findAll( ), HttpStatus.OK );
	}

	@GetMapping( "/batalha/{batalha}" )
	@ApiOperation( "Listar Histórico da Batalha pelo Código da Batalha" )
	public ResponseEntity <List <Batalhas> > getByIdBatalha( @PathVariable Integer batalha ) {
		return ResponseEntity.ok( cadastroBatalhas.findByIdBatalha( batalha ));
	}


}








