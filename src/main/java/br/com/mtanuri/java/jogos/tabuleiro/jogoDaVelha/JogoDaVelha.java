package br.com.mtanuri.java.jogos.tabuleiro.jogoDaVelha;

import static java.lang.System.out;

import java.util.Scanner;

import br.com.mtanuri.java.jogos.CasaDoTabuleiro;
import br.com.mtanuri.java.jogos.PecaDoTabuleiro;
import br.com.mtanuri.java.jogos.Tabuleiro;

public class JogoDaVelha {

    private static Tabuleiro tabuleiro = Tabuleiro.construir(3, 3);

    private static Scanner sc = null;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        imprimeBannerDeInicioDoJogo();
        imprimirTabuleiro();

        while (!isFimDeJogo()) {

            for (Jogadores jogador : Jogadores.values()) {
                novaRodada(jogador);
                if (isFimDeJogo())
                    break;
            }
        }

        imprimeResultadoFinal();

        if (sc != null)
            sc.close();
    }

    private static void imprimirTabuleiro() {
        System.out.println(tabuleiro.imprimir());
    }


    private static void imprimeBannerDeInicioDoJogo() {
        out.println("========================");
        out.println("==== Jogo da Velha =====");
        out.println("========================");
    }

    private static boolean isFimDeJogo() {
        if (obterVencedor() != null)
            return true;

        for (CasaDoTabuleiro[] i : tabuleiro.casas) {
            for (CasaDoTabuleiro j : i) {
                if (j.peca == null)
                    return false;
            }
        }
        return true;
    }

    private static void novaRodada(Jogadores jogador) {
        String coordinates = obterCoordenadasViaTerminal(jogador);
        efetuaJogada(coordinates, jogador);
        imprimirTabuleiro();
    }

    private static String obterCoordenadasViaTerminal(Jogadores jogador) {
        out.println("Jogador " + jogador.nome + ": escolha a sua jogada.");
        String coordinates = sc.next();
        return coordinates;
    }

    private static void efetuaJogada(String coordenadas, Jogadores jogador) {
        CasaDoTabuleiro casaDoTabuleiro = tabuleiro.obterCasasPor(coordenadas);
        System.out.println(casaDoTabuleiro.getPosicao());
        if (casaDoTabuleiro.estaOcupada()){
            out.println("Casa já ocupada, tente novamente");
            novaRodada(jogador);
        }
        else {
            PecaDoTabuleiro peca = new JogoDaVelha().new PecaDoTabuleiroJogoDaVelha(jogador.nome);
            casaDoTabuleiro.peca = peca;
        }
    }

    private static void imprimeResultadoFinal() {
        out.println("==================================");

        if (obterVencedor() != null)
            out.println("Jogador vencedor: " + obterVencedor() + "  ᕦ(ツ)ᕤ");
        else
            out.println("Jogo empatado ¯\\_(ツ)_/¯");

        out.println("==================================");
        imprimirTabuleiro();
    }

    private static Jogadores obterVencedor() {

        for (Jogadores jogador : Jogadores.values()) {

            for (int i = 0; i < tabuleiro.casas.length; i++) {

                boolean vencedorNaHorizontal = tabuleiro.casas[i][0].estaOcupadaPor(jogador.nome)
                        && tabuleiro.casas[i][1].estaOcupadaPor(jogador.nome)
                        && tabuleiro.casas[i][2].estaOcupadaPor(jogador.nome);
                if (vencedorNaHorizontal)
                    return jogador;

                boolean vencedorNaVertical = tabuleiro.casas[0][i].estaOcupadaPor(jogador.nome)
                        && tabuleiro.casas[1][i].estaOcupadaPor(jogador.nome)
                        && tabuleiro.casas[2][i].estaOcupadaPor(jogador.nome);
                if (vencedorNaVertical)
                    return jogador;
            }

            boolean vencedorNaDiagonalEsquerda = tabuleiro.casas[0][0].estaOcupadaPor(jogador.nome)
                    && tabuleiro.casas[1][1].estaOcupadaPor(jogador.nome)
                    && tabuleiro.casas[2][2].estaOcupadaPor(jogador.nome);
            if (vencedorNaDiagonalEsquerda)
                return jogador;

            boolean vencedorNaDiagonalDireita = tabuleiro.casas[0][2].estaOcupadaPor(jogador.nome)
                    && tabuleiro.casas[1][1].estaOcupadaPor(jogador.nome)
                    && tabuleiro.casas[2][0].estaOcupadaPor(jogador.nome);
            if (vencedorNaDiagonalDireita)
                return jogador;

        }
        return null;
    }

    public enum Jogadores {

        JOGADOR_X("X"), JOGADOR_O("O");

        private String nome;

        Jogadores(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

    }

    public class PecaDoTabuleiroJogoDaVelha extends PecaDoTabuleiro {

        private String nome;

        public PecaDoTabuleiroJogoDaVelha(String nome) {
            this.nome = nome;
        }

        public PecaDoTabuleiroJogoDaVelha() {
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

}
