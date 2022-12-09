package br.com.mtanuri.java.jogosDeTabuleiro;

public class Tabuleiro {
    public CasaDoTabuleiro[][] casas;

    public static Tabuleiro construir(int linhas, int colunas) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.casas = new CasaDoTabuleiro[linhas][colunas];

        for (int i = 0; i < tabuleiro.casas.length; i++) {
            for (int j = 0; j < tabuleiro.casas.length; j++) {
                tabuleiro.casas[i][j] = new CasaDoTabuleiro();
            }
        }
        return tabuleiro;
    }

    }
