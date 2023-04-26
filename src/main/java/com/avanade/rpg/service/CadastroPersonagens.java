package com.avanade.rpg.service;

import com.avanade.rpg.exception.InvalidInputException;
import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.RepositorioPersonagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroPersonagens{

    @Autowired
    private RepositorioPersonagens repositorio;
    public Personagem create(Personagem personagem ) {

        personagem.setNomePersonagem(personagem.getNomePersonagem());
        personagem.setTipoPersonagem(personagem.getTipoPersonagem());
        personagem.setAgilidade(personagem.getAgilidade());
        personagem.setForca(personagem.getForca());
        personagem.setDefesa(personagem.getDefesa());
        personagem.setVida(personagem.getVida());
        personagem.setQuantidadeDados(personagem.getQuantidadeDados());
        personagem.setFacesDados(personagem.getFacesDados());
        personagem.setId(personagem.getId());
        return this.repositorio.save( personagem );
    }

    public List<Personagem> findAll( ) {
        return repositorio.findAll( );
    }

    public Personagem findById( Integer id ) {
        return repositorio.findById( id ).orElseThrow( ( ) -> new ResourceNotFoundException("Personagem não encontrado como o ID: " + id ) );
    }

    public void delete( Integer id ) {
        repositorio.deleteById( id );
    }

    public Personagem update( Personagem personagem ) {
        if ( personagem.getId( ) == null ) {
            throw new InvalidInputException( "ID não encontrado!" );
        }
        return repositorio.save( personagem );
    }

}
