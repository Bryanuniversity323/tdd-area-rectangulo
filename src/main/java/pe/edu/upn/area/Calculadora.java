package pe.edu.upn.area;

/**
 * Calcula el área (en m²) de ambientes rectangulares.
 */
public class Calculadora {

    static final String MENSAJE_LADOS_INVALIDOS =
            "La base y la altura deben ser mayores que cero";

    public int calcularArea(int base, int altura) {
        validarLados(base, altura);
        return base * altura;
    }

    private static void validarLados(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException(MENSAJE_LADOS_INVALIDOS);
        }
    }
}
