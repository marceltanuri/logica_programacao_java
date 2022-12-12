package br.com.mtanuri.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    void deve_somar_dois_numeros_inteiros(){
        int resultado = Calculadora.soma(2, 3);
        assertEquals(5, resultado);
     }

    @Test
    void deve_subtrair_dois_numeros_inteiros(){
        int resultado = Calculadora.subtrai(2, 3);
        assertEquals(-1, resultado);
    }


    @Test
    void deve_dividir_dois_numeros_inteiros(){
        int resultado = Calculadora.divide(2, 3);
        assertEquals(0, resultado);
    }

    @Test
    void deve_multiplicar_dois_numeros_inteiros(){
        int resultado = Calculadora.multiplica(2, 3);
        assertEquals(6, resultado);
    }
    
    @Test
    void deve_calcular_a_raiz_quadrada_de_um_numero_inteiro(){
        double resultado = Calculadora.raiz(4);
        assertEquals(2.0, resultado);
    }
    
}
