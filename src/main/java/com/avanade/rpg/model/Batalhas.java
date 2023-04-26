package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "BATALHAS" )
@Entity

public class Batalhas implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )

    @Column( name = "ID")
    private Integer  id;
    @Column( name = "PARTIDA")
    private Integer  Partida;
    @Column( name = "ID_PERSONAGEM1")
    private Integer  idPersonagem1;
    @Column( name = "NOME_PERSONAGEM1")
    private String  nomePersonagem1;
    @Column( name = "ATAQUE_PERSONAGEM1")
    private Integer  ataquePersonagem1;
    @Column( name = "DEFESA_PERSONAGEM1")
    private Integer  defesaPersonagem1;
    @Column( name = "PONTOS_VIDA_PERSONAGEM1")
    private Integer  pontosVidaPersonagem1;
    @Column( name = "ID_PERSONAGEM2")
    private Integer  idPersonagem2;
    @Column( name = "NOME_PERSONAGEM2")
    private String  nomePersonagem2;
    @Column( name = "ATAQUE_PERSONAGEM2")
    private Integer  ataquePersonagem2;
    @Column( name = "DEFESA_PERSONAGEM2")
    private Integer  defesaPersonagem2;
    @Column( name = "PONTOS_VIDA_PERSONAGEM2")
    private Integer  pontosVidaPersonagem2;
    @Column( name = "TURNO")
    private Integer turno;
    @Column( name = "VENCEDOR")
    private String vencedor;
    @Column( name = "INICIATIVA1")
    private Integer  iniciativa1;
    @Column( name = "INICIATIVA2")
    private Integer  iniciativa2;

}