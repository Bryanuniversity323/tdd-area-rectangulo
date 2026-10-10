# Bitácora y reflexión – TDD Área de Rectángulo

## 6. Bitácora

| Ciclo | Prueba escrita | ¿Por qué falló? | ¿Qué cambiaste en el código? |
|---|---|---|---|
| 1 | `areaDeRectangulo5x4Es20` | La clase `Calculadora` no existía. | Se creó `calcularArea` con `return 20`, aplicando el código mínimo para hacer pasar la primera prueba. |
| 2 | `calcularArea(3, 7)` → 21 | La implementación siempre devolvía 20. | Se reemplazó el valor fijo por la fórmula `base * altura`. |
| 3 | `calcularArea(1, 1)` → 1 | No falló: la fórmula del ciclo 2 ya cubría el lado válido mínimo. | No fue necesario cambiar el código; la prueba se conserva como valor límite. |
| 4 | `calcularArea(-5, 4)` → `IllegalArgumentException` | La fórmula devolvía -20 en lugar de rechazar el dato inválido. | Se agregó validación para lados negativos y el mensaje solicitado. |
| 5 | `calcularArea(0, 4)` y `calcularArea(5, 0)` → `IllegalArgumentException` | La validación del ciclo 4 solo rechazaba negativos y aceptaba cero. | Se cambió la condición a `base <= 0 || altura <= 0`. |
| 6 | Refactor | — | Se agruparon casos con `@ParameterizedTest` + `@CsvSource`, se extrajo `validarLados` y se centralizó el mensaje de error en una constante. |
| Reto | `calcularArea(50000, 50000)` → `ArithmeticException` | La multiplicación normal de `int` se desborda y devuelve un valor incorrecto sin avisar. | Se reemplazó la multiplicación por `Math.multiplyExact(base, altura)`. |

## 7. Preguntas de reflexión

### 1. ¿Por qué en el ciclo 1 se escribió `return 20` y no directamente `base * altura`? ¿Qué prueba te obligó a generalizar?

En el ciclo 1 se escribió `return 20` porque TDD indica que en Green se implementa únicamente el código mínimo necesario para hacer pasar la prueba actual. Como la primera prueba solo comprobaba que `calcularArea(5, 4)` devolviera 20, ese valor fijo era suficiente. La prueba del ciclo 2, `calcularArea(3, 7)`, obligó a generalizar porque el valor fijo dejó de funcionar y fue necesario utilizar `base * altura`. Esto evidencia la técnica de triangulación.

### 2. En el ciclo 4, ¿por qué es mejor lanzar una excepción que devolver 0 cuando un lado es negativo?

Un lado negativo representa una entrada inválida y debe comunicarse explícitamente como un error. Devolver 0 ocultaría el problema y podría interpretarse como un área válida. `IllegalArgumentException` detiene el cálculo y comunica claramente que la base y la altura deben ser mayores que cero.

### 3. ¿Qué valores límite probaste? Relaciónalos con las técnicas de la Semana 08.

Se probaron 1, 0 y valores negativos. El valor 1 representa el menor lado válido; 0 es el límite inmediatamente fuera del rango permitido, y los negativos representan la clase inválida por debajo del límite. También se probó el caso `50000 × 50000` como límite técnico de capacidad del tipo `int`, verificando el desbordamiento.
