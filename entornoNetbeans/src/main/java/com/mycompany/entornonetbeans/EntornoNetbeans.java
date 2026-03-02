/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entornonetbeans;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author alvar
 */
public class EntornoNetbeans {
    // Constantes del juego
    public static final int CASILLAS = 42;
    public static final int CASILLA_ALIENS = 31;
    public static final int CASILLA_RETROCESO = 13;
    public static final int CASILLA_AGUJERO_NEGRO = 33;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int posicion = 1;         // Empezamos en la casilla 1
        String galaxiaAnterior = "000";
        int valorAnterior = valorGalaxia(galaxiaAnterior);

        boolean fin = false;

        System.out.println("=== LA GUIA DEL VIAJERO INTERGALACTICO ===");
        System.out.println("Empiezas en la casilla 1, galaxia 000 (valor 0).");
        System.out.println();

        while (!fin) {
            mostrarTablero(posicion);
            System.out.println("Galaxia anterior: " + galaxiaAnterior + " (valor " + valorAnterior + ")");
            System.out.print("Pulsa ENTER para lanzar los 3 dados...");
            sc.nextLine();

            // Tirada de los 3 dados (0 a 8)
            int d1 = rand.nextInt(9); // 0-8
            int d2 = rand.nextInt(9);
            int d3 = rand.nextInt(9);

            String galaxiaActual = "" + d1 + d2 + d3;
            int valorActual = valorGalaxia(galaxiaActual);
            
            System.out.println("");
            System.out.println("Has obtenido galaxia " + galaxiaActual + " (valor " + valorActual + ")");
            int diferencia = Math.abs(valorActual - valorAnterior);
            System.out.println("Diferencia con la galaxia anterior: " + diferencia);

            if (diferencia <= 4) {
                System.out.println("Las galaxias son cercanas. Avanzas " + diferencia + " casillas.");
                posicion += diferencia;

                // Si se pasa de 42, vuelve a 1
                if (posicion > CASILLAS) {
                    posicion = 1;
                    System.out.println("Te has pasado de la casilla 42. Vuelves a la casilla 1.");
                }

                // Peligros y efectos especiales
                if (posicion == CASILLA_ALIENS) {
                    System.out.println("Oh no, Extraterrestres peligrosos en la casilla 31. Te envian a la casilla 13.");
                    posicion = CASILLA_RETROCESO;
                } else if (posicion == CASILLA_AGUJERO_NEGRO) {
                    System.out.println("Has caido en el agujero negro (casilla 33) Has perdido el juego.");
                    fin = true;
                } else if (posicion == CASILLAS) {
                    System.out.println("Has llegado a la casilla 42, Has ganado");
                    fin = true;
                }

            } else {
                System.out.println("Las galaxias son demasiado lejanas (>4 anios luz). No avanzas este turno.");
            }

            // Actualizamos galaxia anterior para el siguiente turno
            galaxiaAnterior = galaxiaActual;
            valorAnterior = valorActual;

            System.out.println("------------------------------------------");
        }

        mostrarTablero(posicion);
        System.out.println("Fin del juego. Estabas en la casilla " + posicion + ".");
        sc.close();
    }

    /**
     * Calcula el valor de una galaxia: suma de dígitos hasta que quede una sola cifra.
     * Ej: "184" -> 1+8+4=13 -> 1+3=4
     */
    public static int valorGalaxia(String galaxia) {
        int suma = 0;

        // Sumar cifras
        for (int i = 0; i < galaxia.length(); i++) {
            char c = galaxia.charAt(i);
            int digito = c - '0';
            suma += digito;
        }

        // Reducir a una sola cifra (tipo "raíz digital")
        while (suma >= 10) {
            int temp = suma;
            int nuevaSuma = 0;
            while (temp > 0) {
                nuevaSuma += temp % 10;
                temp /= 10;
            }
            suma = nuevaSuma;
        }

        return suma;
    }

    /**
     * Muestra el tablero de 42 casillas en varias filas, marcando la posición del jugador.
     */
    public static void mostrarTablero(int posicionJugador) {
        System.out.println();
        System.out.println("TABLERO:");
        for (int i = 1; i <= CASILLAS; i++) {
            if (i == posicionJugador) {
                System.out.printf("[J]");
            } else {
                System.out.printf("[%02d]", i); // muestra 01, 02, 03...
            }

            // salto de línea cada 7 casillas (6 filas de 7 casillas = 42)
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
}