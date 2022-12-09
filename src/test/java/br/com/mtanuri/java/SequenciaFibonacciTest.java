package br.com.mtanuri.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SequenciaFibonacciTest {
    @Test
    void deve_imprimir_sequencia_ate_o_numero_indicado() {
        assertEquals("0", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(0));
        assertEquals("0, 1, 1", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(1));
        assertEquals("0, 1, 1, 2, 3, 5, 8", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(8));
        assertEquals("0, 1, 1, 2, 3", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(4));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(15));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(25));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21", SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(21));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144",
                SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(150));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610",
                SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(700));
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946",
                SequenciaFibonacci.geraSequenciaAteSerIgualOuMaisProximo(10947));

    }

    @Test
    void deve_dizer_se_numero_pertence_a_sequencia() {
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(0));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(1));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(3));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(5));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(8));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(13));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(21));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(34));
        assertTrue(SequenciaFibonacci.numeroPertenceASequencia(610));
        assertFalse(SequenciaFibonacci.numeroPertenceASequencia(25));
        assertFalse(SequenciaFibonacci.numeroPertenceASequencia(124));
        assertFalse(SequenciaFibonacci.numeroPertenceASequencia(214));
        assertFalse(SequenciaFibonacci.numeroPertenceASequencia(920));
        assertFalse(SequenciaFibonacci.numeroPertenceASequencia(1515));
    }
}