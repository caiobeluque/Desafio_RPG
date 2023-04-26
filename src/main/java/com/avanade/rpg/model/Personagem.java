package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "PERSONAGENS" )
@Entity
public class Personagem implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )

    @Column( name = "ID")
    private Integer  id;
    @Column( name = "NOME_PERSONAGEM")
    private String  nomePersonagem;
    @Column( name = "TIPO_PERSONAGEM")
    private String  tipoPersonagem;
    @Column( name = "AGILIDADE")
    private Integer  agilidade;
    @Column( name = "FORCA")
    private Integer forca;
    @Column( name = "DEFESA")
    private Integer defesa;
    @Column( name = "VIDA")
    private Integer vida;
    @Column( name = "QUANTIDADE_DADOS")
    private Integer quantidadeDados;
    @Column( name = "FACES_DADOS")
    private Integer facesDados;


}