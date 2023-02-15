package Ejercicio1;


import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		System.out.println("¡ Bienvenido al juego del Busca Minas !");
		//System.out.println(Arrays.toString(BuscaMinas.crearTablero()));
		
		//Le enseñamos el tablero al usuario y le pedimos que introduzca una posición
		System.out.println("Visualizado el tablero, por favor introduzca un número: ");
		//Le mostramos al usuario el tablero a destapar
		System.out.println(Arrays.toString(BuscaMinas.tableroInicial()));
		BuscaMinas.Interaccion();
		//Le mostramos al usuario el tablero final con el que interactúa el usuario y determina si es ganador o no
	}

}

