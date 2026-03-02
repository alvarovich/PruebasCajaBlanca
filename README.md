# PruebasCajaBlanca
Para ejecutar el código se deberá importar mediante el IDE de Netbeans una vez descargada la carpeta

Explicación de nodos:

1 (Círculo inicial): Inicio e inicialización de constantes (CASILLAS, ALIENS, etc.) y variables de juego.

2 (Bifurcación): Decisión del bucle principal while (!fin).

  - Si es VERDADERO, va al nodo 3.

  - Si es FALSO, va al nodo 11 (fin).

3 (Cuerpo del bucle): Lanzamiento de dados, cálculo del valor de la galaxia y la diferencia.

4 (Bifurcación): Decisión if (diferencia <= 4).

  - Si es VERDADERO, va al nodo 5 (avanzar).

  - Si es FALSO, va al nodo 9 (no avanza).

5 (Decisión/Ajuste): Bloque de avance de posición e if (posicion > CASILLAS) (reajusta a 1 si se pasa). La ejecución continúa hacia el nodo 6.

6 (Bifurcación): Decisión if (posicion == CASILLA_ALIENS).

  - Si es VERDADERO, reajusta posición y va a 10 (actualizar).

  - Si es FALSO, va a 7 (evaluar agujero negro).

7 (Bifurcación): Decisión else if (posicion == CASILLA_AGUJERO_NEGRO).

  - Si es VERDADERO, establece fin = true y va a 10 (actualizar).

  - Si es FALSO, va a 8 (evaluar victoria).

8 (Bifurcación): Decisión else if (posicion == CASILLAS) (¡Victoria!).

  - Si es VERDADERO, establece fin = true y va a 10 (actualizar).

  - Si es FALSO, va a 10 (actualizar normal).

9 (Bloque Else): Muestra mensaje de galaxias lejanas (no hay movimiento) y va a 10 (actualizar).

10 (Fin de iteración): Actualiza galaxiaAnterior y valorAnterior. La arista vuelve al nodo 2.

11 (Círculo final): Fin del programa (muestra resultados finales).
