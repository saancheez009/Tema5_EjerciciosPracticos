package Ejercicio1;
import java.util.Arrays;

import java.util.Scanner;


public class BuscaMinas {

	//Creamos una variable global llamada minas, que es el número de minas totales que habrá en el tablero
		static final int MINAS=6;
		
		//Le adjudicamoss a la mina el valor de *
		public static char mina='*';
		
		//Impotamos el scanner para poder leer el teclado y los numeros introducidos por el jugador
		static Scanner read= new Scanner(System.in);
		
		//Creamos un array que será el tablero del busca minas
		static char tablero []= new char [20];
		//Creamos otro array que será el tablero que se irá mostrando al usuario con las posiciones destapadas
		static char tableroInteractivo []= new char [20];
		
		
		public static char[] tableroInicial() {
			
			
			//Utilizamos un for para recorrer el tablero
			for(int i=0; i<tableroInteractivo.length;i++) {
				 //El tablero en un principio es secreto por tanto lo llenamos de incógnitas
				//eL JUGADOR DEBERÁ IR DESTAPANADO LAS CASILLAS
				tableroInteractivo[i]='?';
				//Indicamos que el contenido del tablero sea '?'
				}

			//Devolvemos tablero inicial 
			return tableroInteractivo;
			
		}
		
		//Creamos otra funcion estática  para pintar el tablero con las minas 
		public static char[] crearTablero () {
			
			int contador;
			//declaramos la variable posAleatoria que será las posiciones aleatorias generadas en el array,
			// son un máximo de 6
			 int posAleatoria=0;
			 
			 //Introducimos un for en el que i debe ser menor o igual a 6 ya que solo necesitamos generar 6 posiciones aleatorias
			 for(int i=0; i<MINAS; i++) {
			do {
				//Generamos la posición aleatoria de las minas
				posAleatoria = (int) (Math.random()*20);
				
			}while(tablero[posAleatoria]=='*'); //Mientras que la posAleatoria del tablero sea un a mina, se le introduce una mina
			tablero[posAleatoria]='*';
			
			BuscaMinas.rellenoNumeros(tablero);
			 
			 }
			return tablero;
		}
		
			 
			 static char[] rellenoNumeros (char [] tablero){
			for (int i = 0; i <tablero.length; i++) {
				
				//Si inicilmente el array esta en 0, la posicion es distinta  mina y al sumarle uno hay una mina, 
				// El numero que aparecerá será 1 , eso significa que hay una mina adelante
				if (i == 0 && tablero[i]!=mina && tablero[i + 1]==mina) {
						
						tablero[i ] = '1';
					}
				
				//Si la posición 19 es distinta a mina y al sumarle uno hay una mina,
				// El numero que aparecerá será 1 , eso significa que hay una mina detrás
				else if (i == 19 && tablero[i]!=mina && tablero[i - 1]==mina) {
				
						tablero[i] = '1';
				}
				
				//si no empieza en 0 o 19 y hay una mina en los dos lados, es decir delante y atrás, el número a mostrar es 2
				//Esto significa que hay minas una a cada lateral
				else if ((i != 0 && i != 19) && (tablero[i - 1]==mina && tablero[i + 1] ==mina && tablero[i]!=mina )) {
					
					   tablero[i] = '2';
				}
				
				//Otra vez , si no empieza en 0  19 ,  la posición anterior o la siguiente es mina, y la otra casilla es una mina
				//Se mostrará el número 1 ya que significa que hay una mina en uno de los lados
				else if ((i != 0 && i != 19) && (tablero[i - 1] ==mina || tablero[i + 1]==mina) && tablero[i]!=mina ) {
					
					tablero[i] = '1';
				}
				//Finalmente si no hay mina en esa posición, el número a mostrar es 0
				else if (tablero[i]!=mina ) {
					
					tablero[i] = '0';
				}
			}
			
			return tablero; //devolvemos el tablero
			
			
			
		}
		
		
			 static void Interaccion () {
					int contador = 20;
					int posicion;
					
					
					do {
						//Le pedimos al usuario que introduzca la posicion a destapar y leemos el teclado
						System.out.println("Por favor introduzca la posición que desea destapar");
						posicion= read.nextInt();
						
						
						//Luego se igualan las posiciones de los tableros para que la posición del tablero interactivo coja la posicion del tablero
						tableroInteractivo[posicion]=tablero[posicion];
						contador--;
						
						
						//Mostramos al usuario la tabla destapada
						System.out.println(Arrays.toString(BuscaMinas.tableroInteractivo));
						
						//Si el contadorJugada llega a 6 y la posición introducida es distinta a mina,
						//Significa que el jugador ha ganado la partida ya que ha destapado correctamente las casillas sin destapar minas
						if (contador==6 && tableroInteractivo[posicion]!=mina) {
							System.out.println("¡ENHORABUENA! Ha ganado la partida ");
							break; //Introducimos un break para que en caso que pase eso, acabe la partida
							}
						
						
					//Lo anterior sucederá siempre y cuando la posición destapada no sea una mina 
					}while (tableroInteractivo[posicion]!= mina);
						
					//Si en la posición destapada hay una mina, el jugador habrá perdido la partida
					if (tableroInteractivo[posicion]==mina) {
						System.out.println("Ha perdido la partida...");
					}
					
					
				}
			 
			 
	}

