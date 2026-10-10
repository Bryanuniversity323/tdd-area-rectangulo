# Guía para obtener las capturas TDD en VS Code

El proyecto conserva los commits necesarios para recrear cada evidencia sin editar código manualmente.

En cada estado ejecuta:

```powershell
mvn test
```

## Ciclo 1
- RED: `git checkout a45a717`
- GREEN: `git checkout de0c159`

## Ciclo 2
- RED: `git checkout 9037435`
- GREEN: `git checkout 8f9d722`

## Ciclo 3
- Evidencia directa en verde: `git checkout a80a1af`
- La prueba `1 × 1 = 1` pasa sin cambios porque la fórmula del ciclo 2 ya es general.

## Ciclo 4
- RED: `git checkout 53cfcc2`
- GREEN: `git checkout 980d06a`

## Ciclo 5
- RED: `git checkout e5b2151`
- GREEN: `git checkout 6c14397`

## Ciclo 6 – Refactor
- `git checkout b0f8c70`

## Reto
- RED: `git checkout 262fac3`
- GREEN: `git checkout c806a59`

## Volver al estado final

```powershell
git switch main
mvn test
```

## Títulos sugeridos para las capturas
1. Ciclo 1 – Fase Red: prueba inicial antes de implementar `Calculadora`.
2. Ciclo 1 – Fase Green: prueba aprobada con la implementación mínima.
3. Ciclo 2 – Fase Red: fallo que obliga a generalizar el cálculo.
4. Ciclo 2 – Fase Green: cálculo general mediante `base * altura`.
5. Ciclo 3: verificación del valor límite mínimo válido.
6. Ciclo 4 – Fase Red: fallo ante una base negativa.
7. Ciclo 4 – Fase Green: validación correcta de lados negativos.
8. Ciclo 5 – Fase Red: fallo ante lados iguales a cero.
9. Ciclo 5 – Fase Green: validación correcta de lados iguales a cero.
10. Ciclo 6 – Refactorización: pruebas parametrizadas y validación extraída.
11. Reto – Fase Red: desbordamiento sin controlar.
12. Reto – Fase Green/final: desbordamiento controlado y pruebas en verde.
