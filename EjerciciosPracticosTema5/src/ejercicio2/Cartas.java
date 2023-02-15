package ejercicio2;

import java.util.Scanner;

public class Cartas {

	static Scanner sc = new Scanner(System.in);
	
	//Creamos una función para generar las cartas aleatoriamente
	public static double GeneraCartas() {
		//Declaramos la variable puntos que son los puntos obtenidos en la partida
		double puntosObtenidos = 0;
		
		//Carta aleatoria puede ser: 1, 2, 3, 4, 5, 6, 7, sota, caballo y rey
		int cartaAletoria;
		
		//Carta aleatoria puede ser oros, copas, espadas y bastos
		int cartaPaloAleatoria;
		
		//Es la respuesta del usuario
		String respUsuario;
		
		//Asiganmos a los arrays los valores que deben tomar
		String[] cartas = {"1", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey"};
		String[] cartasPalo = {"oros", "copas", "espadas", "bastos"};
		
		//Le preguntamos al usuario si desea sacar una carta
		System.out.println("¿Desea sacar una carta, por favor responda con un 'si' o 'no'?");
		
		do {
			//leemos la respuesta del usuario
			respUsuario = sc.next();
			
			//Si el usuario añade como respuesta un si, el sistema generará una carta aleatoria
			if(respUsuario.equals("si")) {
				//Generación de carta aleatoria
				cartaAletoria = (int) (Math.random()*(cartas.length-1));
				cartaPaloAleatoria = (int) (Math.random()*(cartasPalo.length-1));
				
				//Le mostramos al usuario su carta generada aleatoriamente 
				System.out.println("Su carta es: " + cartas[cartaAletoria] + " de " + cartasPalo[cartaPaloAleatoria]);
				
				//Para poder hacer el recuento de los puntos hacemos un switch
				
				switch (cartas[cartaAletoria]) {
				case "1": 
					puntosObtenidos += 1;
					break;
				case "2":
					puntosObtenidos += 2;
					break;
				case "3":
					puntosObtenidos += 3;
					break;
				case "4":
					puntosObtenidos += 4;
					break;
				case "5":
					puntosObtenidos += 5;
					break;
				case "6":
					puntosObtenidos += 6;
					break;
				case "7":
					puntosObtenidos += 7;
					break;
				case "sota", "caballo", "rey":
					puntosObtenidos += 0.5;
				break;
				}
				
				//Le mostramos al usuario los puntos obtenidos de acuerdo a la carta que le haya tocado
				System.out.println("Los puntos obtenidos son:" + puntosObtenidos);
				
				//si el usuario saca menos de 7,5 puntos tiene oportunidad de sacar otra carta por tanto le preguntamos si desea sacar otra
				if(puntosObtenidos<= 7.5)
				System.out.println("¿Desea sacar otra carta?");
				else  //En caso de haber obtenido una puntuación mayor puntuación, indicaremos al usuario que ha sobrepasado los puntos
					System.out.println("Usted ha sobrepasado los puntos");
			}
		}while(respUsuario.equals("si") && puntosObtenidos<=7.5);
		
		//devolvemos los puntos obtenidos
		return puntosObtenidos;
	}
	
	
	public static String comparacionPuntos(double puntosJ1, double puntosJ2) {
		
		double resultado = 7.5; //Este es el numero de puntos que debe alcanzar el usuario sin sobrepasarse
		
		String ganador="ambos" ;
		
		
		//Si la resta de los puntos del jugador 1 con 7,5 es menor , el ganador es el jugador 1
			if((resultado-puntosJ1) < (resultado-puntosJ2)) {
				ganador = "Jugador 1";
			
		//Si la resta de los puntos del jugador 2 con 7,5 es menor , el ganador es el jugador 2
			}else if((resultado-puntosJ1) > (resultado-puntosJ2))
				ganador = "Jugador 2";
	
			//Si los puntos del jugador dos y el jugador uno son mayores al resultado ninguno es el ganador
			if(puntosJ1 > resultado) {
				if(puntosJ2 > resultado) {
					ganador = "ninguno";
				}else
					
					//Si los puntos del jugador 2 son menores al resultado y los del jugador 1 son mayores gana el jugador 2
					ganador = "Jugador 2";
				
			}else {
				//Finalmente los puntos del jugador 2 son mayores de 7,5 gana el jugador 1
				if(puntosJ2 > resultado)
					ganador = "Jugador 1";
			}
		
			//Si no se cumple nada de lo anterior empatan
			
			//Devolvemos el resultado
		return ganador;
	}
}
