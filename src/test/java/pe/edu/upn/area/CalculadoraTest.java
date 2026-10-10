package pe.edu.upn.area;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    void areaDeRectangulo5x4Es20() {
        assertEquals(20, calc.calcularArea(5, 4));
    }
}
