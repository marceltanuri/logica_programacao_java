package br.com.mtanuri.java;

public class SequenciaFibonacci {

    public static String geraSequenciaAteSerIgualOuMaisProximo(int numeroLimiteDaSequencia) {

        if (numeroLimiteDaSequencia == 0)
            return "0";

        String sequenciaFibonacci = "0, 1";

        int penultimoNumeroDaSequencia = 0;
        int ultimoNumeroDaSequencia = 1;

        while (true) {

            int somaDosDoisUltimosNumerosDaSequencia = ultimoNumeroDaSequencia + penultimoNumeroDaSequencia;

            penultimoNumeroDaSequencia = ultimoNumeroDaSequencia;
            ultimoNumeroDaSequencia = somaDosDoisUltimosNumerosDaSequencia;

            if (somaDosDoisUltimosNumerosDaSequencia > numeroLimiteDaSequencia)
                break;

            else
                sequenciaFibonacci += ", " + somaDosDoisUltimosNumerosDaSequencia;
        }

        return sequenciaFibonacci;
    }

    public static boolean numeroPertenceASequencia(int num) {

        String[] sequencia = geraSequenciaAteSerIgualOuMaisProximo(num).split(",");

        for (String numeroFibonacci : sequencia) {
            if (Integer.valueOf(numeroFibonacci.trim()) == num)
                return true;
        }

        return false;
    }
}