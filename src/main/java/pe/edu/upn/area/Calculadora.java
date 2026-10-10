package pe.edu.upn.area;

public class Calculadora {

    public int calcularArea(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser mayores que cero");
        }
        return base * altura;
    }
}
