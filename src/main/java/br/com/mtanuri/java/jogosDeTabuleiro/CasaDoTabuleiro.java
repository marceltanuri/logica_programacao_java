package br.com.mtanuri.java.jogosDeTabuleiro;

public class CasaDoTabuleiro {
    public PecaDoTabuleiro peca;

    public boolean estaOcupada() {
        if (peca != null)
            return true;

        else
            return false;
    }

    public boolean estaOcupadaPor(String nome) {

        if (peca != null && peca.getNome() == nome)
            return true;

        else
            return false;
    }

}