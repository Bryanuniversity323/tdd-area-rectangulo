package pe.edu.upn.area;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    void areaDeRectangulo5x4Es20() {
        assertEquals(20, calc.calcularArea(5, 4));
    }

    @Test
    void areaDeRectangulo3x7Es21() {
        assertEquals(21, calc.calcularArea(3, 7));
    }

    @Test
    void areaConLadoMinimo1x1Es1() {
        assertEquals(1, calc.calcularArea(1, 1));
    }
}


