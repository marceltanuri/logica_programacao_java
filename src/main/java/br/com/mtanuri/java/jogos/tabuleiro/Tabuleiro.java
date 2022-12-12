package br.com.mtanuri.java.jogos.tabuleiro;

public class Tabuleiro {
    public CasaDoTabuleiro[][] casas;

    public static Tabuleiro construir(int linhas, int colunas) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.casas = new CasaDoTabuleiro[linhas][colunas];

        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                tabuleiro.casas[linha][coluna] = new CasaDoTabuleiro(linha, coluna);
            }
        }
        return tabuleiro;
    }

    public String imprimir() {

        StringBuilder sb = new StringBuilder();

        sb.append(imprimeCabecalhoColunas());
        sb.append("\n");

        for (int i = 0; i < this.casas.length; i++) {

            sb.append(imprimeIdentificadorAlfabeticoDaLinha(i) + " |  ");

            for (int j = 0; j < this.casas[i].length; j++) {

                CasaDoTabuleiro casaDoTabuleiro = this.casas[i][j];
                String identificadorDaPeca = casaDoTabuleiro.peca != null ? casaDoTabuleiro.peca.getNome()
                        : " ";
                identificadorDaPeca += "  |  ";
                sb.append(identificadorDaPeca);
            }

            sb.append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String imprimeCabecalhoColunas() {
        StringBuilder sb = new StringBuilder();
        String colunaVaziaParaInterseccao = "  ";
        sb.append(colunaVaziaParaInterseccao);
        for (int i = 1; i <= this.casas.length; i++) {
            sb.append(("|  " + (i) + "  "));
        }
        return sb.toString();
    }

    private String imprimeIdentificadorAlfabeticoDaLinha(int indexLinha) {

        char identificadorDeLinha = 'A';
        for (int i = 0; (i < indexLinha && identificadorDeLinha < 'Z'); i++) {
            identificadorDeLinha++;
        }

        return String.valueOf(identificadorDeLinha);
    }

    public CasaDoTabuleiro obterCasasPor(String identificadorAlfanumerico) {
        for (CasaDoTabuleiro[] casaDoTabuleiros : casas) {
            for (CasaDoTabuleiro casaDoTabuleiro : casaDoTabuleiros) {
                if (casaDoTabuleiro.getIdentificadorAlfanumerico().equals(identificadorAlfanumerico))
                    return casaDoTabuleiro;
            }
        }
        return null;
    }

}
