package br.com.mtanuri.java.jogos.tabuleiro;

public class CasaDoTabuleiro {
    public PecaDoTabuleiro peca;
    public String identificador;
    private int identificadorLinha;
    private int identificadorColuna;

    public CasaDoTabuleiro(int identificadorLinha, int identificadorColuna) {
        this.identificadorLinha = identificadorLinha;
        this.identificadorColuna = identificadorColuna;
    }

    public String getPosicao() {
        return "Linha: " + identificadorLinha + ", Coluna: " + identificadorColuna;
    }

    public String getIdentificadorAlfanumerico() {

        String identificadorAlfanumericoDaCasa = "";

        char inicioDoIdentificadorAlfabetico = 'A';
        for (int i = 0; i <= identificadorLinha; i++) {
            String identificadorAlfabetico = String.valueOf(inicioDoIdentificadorAlfabetico++);
            identificadorAlfanumericoDaCasa = identificadorAlfabetico + (identificadorColuna + 1);
        }

        return identificadorAlfanumericoDaCasa;
    }

    public boolean estaOcupada() {
        if (peca != null)
            return true;

        else
            return false;
    }

    public boolean estaOcupadaPor(String nomeDaPeca) {

        if (peca != null && peca.getNome() == nomeDaPeca)
            return true;

        else
            return false;
    }

}