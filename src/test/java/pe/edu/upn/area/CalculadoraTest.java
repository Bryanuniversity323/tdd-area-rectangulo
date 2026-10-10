package pe.edu.upn.area;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    void areaDeRectangulo5x4Es20() {
        assertEquals(20, calc.calcularArea(5, 4));
    }

    @ParameterizedTest(name = "{0} x {1} = {2}")
    @CsvSource({
        "3, 7, 21",
        "1, 1, 1",
        "10, 10, 100"
    })
    void areaEsBasePorAltura(int base, int altura, int esperado) {
        assertEquals(esperado, calc.calcularArea(base, altura));
    }

    @ParameterizedTest(name = "base {0}, altura {1} lanza excepción")
    @CsvSource({ "-5, 4", "5, -4", "0, 4", "5, 0" })
    void ladoNoPositivoLanzaExcepcion(int base, int altura) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.calcularArea(base, altura));
        assertEquals(Calculadora.MENSAJE_LADOS_INVALIDOS, ex.getMessage());
    }
}
