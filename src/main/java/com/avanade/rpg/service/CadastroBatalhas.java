package com.avanade.rpg.service;

import com.avanade.rpg.model.Batalhas;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.RepositorioBatalhas;
import com.avanade.rpg.repository.RepositorioPersonagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CadastroBatalhas {

    @Autowired
    private RepositorioBatalhas repositorioBatalhas;

    @Autowired
    private RepositorioPersonagens repositorioPersonagens;

    public List<Batalhas> findAll() {
        return repositorioBatalhas.findAll();
    }

    public List<Batalhas> findByIdBatalha( Integer batalha ) {

        final List<Batalhas> batalhas = repositorioBatalhas.findAllByBatalha(batalha);
        return batalhas;

    }

    public void update(Batalhas batalhas) {

        Optional<Personagem> personagem1 = repositorioPersonagens.findById(batalhas.getIdPersonagem1());
        if(personagem1.isEmpty())
        {
            return;
        }
        Optional<Personagem> personagem2 = repositorioPersonagens.findById(batalhas.getIdPersonagem2());
        if(personagem2.isEmpty())
        {
            return;
        }

//// -- Inicia a Gravação do Cabeçalho da Batalha

        long horaAtual = System.currentTimeMillis();
        Integer partida = ((int) horaAtual) *-1;
        int jogada = 0;
        Integer turno = 0;
        Integer vidaPersonagem1 = personagem1.get().getVida();
        Integer vidaPersonagem2 = personagem2.get().getVida();
        String vencedor = "";
        batalhas.setId(0);

//// Definição de qual jogador iniciará a Partida
        Integer iniciativa1 = 0;
        Integer iniciativa2 = 0;

        while (iniciativa1.equals(iniciativa2)) {
// Iniciativa Personagem 1
            Random randomIniciativa1 = new Random();
            iniciativa1 = randomIniciativa1.nextInt(20) +1;
            batalhas.setIniciativa1(iniciativa1);
//
// Iniciativa Personagem 2
            Random randomIniciativa2 = new Random();
            iniciativa2 = randomIniciativa2.nextInt(20) +1;
            batalhas.setIniciativa2(iniciativa2);
//
            if (iniciativa1 > iniciativa2) {
                jogada = 1;
            } else {
                jogada = 2;
            }
        }
////

        batalhas.setBatalha(partida);
        batalhas.setNomePersonagem1(personagem1.get().getNomePersonagem());
        batalhas.setNomePersonagem2(personagem2.get().getNomePersonagem());
        batalhas.setPontosVidaPersonagem1(personagem1.get().getVida());
        batalhas.setPontosVidaPersonagem2(personagem2.get().getVida());
        batalhas.setIdPersonagem1(batalhas.getIdPersonagem1());
        batalhas.setNomePersonagem1(batalhas.getNomePersonagem1());
        batalhas.setIdPersonagem2(batalhas.getIdPersonagem2());
        batalhas.setNomePersonagem2(batalhas.getNomePersonagem2());
        batalhas.setAtaquePersonagem1(0);
        batalhas.setDefesaPersonagem1(0);
        batalhas.setAtaquePersonagem2(0);
        batalhas.setDefesaPersonagem2(0);
        batalhas.setTurno(0);
        batalhas.setVencedor("");

        repositorioBatalhas.save(batalhas);
//// -- Finaliza a Gravação do Cabeçalho da Batalha

//// -- Inicia a Gravação dos Turnos da Batalha
        while (vencedor.equals("")) {

            turno++;

            if (jogada % 2 == 1) {

                if(batalhas.getPontosVidaPersonagem1() > 0){
                    batalhas.setPontosVidaPersonagem1(batalhas.getPontosVidaPersonagem1());
                }
                else {
                    batalhas.setPontosVidaPersonagem1(personagem1.get().getVida());
                }

//// Ataque Personagem 1
                Random randomAtaque1 = new Random();
                int randomNumberAtaque1 = randomAtaque1.nextInt(12) +1;
                int ataque1 = personagem1.get().getForca() + personagem1.get().getAgilidade() + randomNumberAtaque1;
                batalhas.setAtaquePersonagem1(ataque1);
////

//// Defesa Personagem 2
                Random randomDefesa2 = new Random();
                int randomNumberDefesa2 = randomDefesa2.nextInt(12) +1;
                int defesa2 = personagem2.get().getDefesa() + personagem2.get().getAgilidade() + randomNumberDefesa2;
                batalhas.setDefesaPersonagem2(defesa2);

////

//// Dano no Personagem 2
                if (ataque1 > defesa2) {
                    int totalDados = personagem1.get().getQuantidadeDados() * personagem1.get().getFacesDados();

                    Random randomDano1 = new Random();
                    int randomNumberDano1 = randomDano1.nextInt(totalDados) + personagem1.get().getQuantidadeDados();
                    int danoPersonagem2 = personagem1.get().getForca() + randomNumberDano1;
////

//// Diluição Pontos de Vida Personagem 2
                    vidaPersonagem2 = vidaPersonagem2 - danoPersonagem2;
                    batalhas.setPontosVidaPersonagem2(vidaPersonagem2);
                }
////
                if (vidaPersonagem2 <= 0) {
                    vencedor = batalhas.getNomePersonagem1();
                    batalhas.setVencedor(vencedor);
                }
                else
                {
                    batalhas.setVencedor("");
                }

                batalhas.setIdPersonagem1(batalhas.getIdPersonagem1());
                batalhas.setNomePersonagem1(batalhas.getNomePersonagem1());
                batalhas.setDefesaPersonagem1(batalhas.getDefesaPersonagem1());
                batalhas.setIdPersonagem2(batalhas.getIdPersonagem2());
                batalhas.setNomePersonagem2(batalhas.getNomePersonagem2());
                batalhas.setAtaquePersonagem2(0);
                batalhas.setDefesaPersonagem1(0);

            } else {

                if(batalhas.getPontosVidaPersonagem2() > 0){
                    batalhas.setPontosVidaPersonagem2(batalhas.getPontosVidaPersonagem2());
                }
                else {
                    batalhas.setPontosVidaPersonagem2(personagem2.get().getVida());
                }

//// Ataque Personagem 2
                Random randomAtaque2 = new Random();
                int randomNumberAtaque2 = randomAtaque2.nextInt(12) +1;
                int ataque2 = personagem2.get().getForca() + personagem2.get().getAgilidade() + randomNumberAtaque2;
                batalhas.setAtaquePersonagem2(ataque2);
////

//// Defesa Personagem 1
                Random randomDefesa1 = new Random();
                int randomNumberDefesa1 = randomDefesa1.nextInt(12) +1;
                int defesa1 = personagem1.get().getDefesa() + personagem1.get().getAgilidade() + randomNumberDefesa1;
                batalhas.setDefesaPersonagem1(defesa1);
////

//// Dano no Personagem 1
                if (ataque2 > defesa1) {
                    int totalDados = personagem2.get().getQuantidadeDados() * personagem2.get().getFacesDados();

                    Random randomDano2 = new Random();
                    int randomNumberDano2 = randomDano2.nextInt(totalDados) + personagem2.get().getQuantidadeDados();
                    int danoPersonagem2 = personagem1.get().getForca() + randomNumberDano2;
////

//// Diluição de Pontos de Vida do Personagem1
                    vidaPersonagem1 = vidaPersonagem1 - danoPersonagem2;
                    batalhas.setPontosVidaPersonagem1(vidaPersonagem1);
                }
////
                if (vidaPersonagem1 <= 0) {
                    vencedor = batalhas.getNomePersonagem2();
                    batalhas.setVencedor(vencedor);
                }
                else {
                    batalhas.setVencedor("");
                }

                batalhas.setIdPersonagem1(batalhas.getIdPersonagem1());
                batalhas.setNomePersonagem1(batalhas.getNomePersonagem1());
                batalhas.setDefesaPersonagem1(batalhas.getDefesaPersonagem1());
                batalhas.setIdPersonagem2(batalhas.getIdPersonagem2());
                batalhas.setNomePersonagem2(batalhas.getNomePersonagem2());
                batalhas.setAtaquePersonagem2(batalhas.getAtaquePersonagem2());
                batalhas.setAtaquePersonagem1(0);
                batalhas.setDefesaPersonagem2(0);
            }

            jogada++;
            batalhas.setTurno(turno);
            repositorioBatalhas.save(batalhas);
//// -- Finaliza a Gravação dos Turnos da Batalha
        }
    }
}




