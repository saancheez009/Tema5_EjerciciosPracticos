package ejercicio2;

public class Main {

	public static void main(String[] args) {
		//Declaramos las variables de los puntos del jugador 1 y 2 para asignarles una carta y unos puntos
		double puntosJ1;
		double Jugador2;
		System.out.println("¡BIENVENID@!");
		System.out.println("Este es el juego de las siete y media");
		System.out.println("Comencemos...");
		
		//Le asignamos al jugador 1 una crata y sus puntos correspondientes
		System.out.println("Es el turno del Jugador 1:");
		puntosJ1 = Cartas.GeneraCartas();
		
		//Le asiganmos al jugador 2 una carta y sus puntos correspondientes
		System.out.println("Turno del Jugador 2");
		Jugador2= Cartas.GeneraCartas();
		
		System.out.println("El ganador de la partida es: " + Cartas.comparacionPuntos(puntosJ1, Jugador2));

	}

}
