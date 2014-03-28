
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ahorcado{

public static void main(String[] args){

	System.out.println("\n\n***-.Juego del Ahorcado.-*** \n");
	System.out.println("(solo puedes tener 3 errores, + de 3 pierdes! >:D)\n");
	System.out.println("Introduzca una palabra: ");

	try{

		InputStreamReader r = new InputStreamReader(System.in);
  		BufferedReader lector = new BufferedReader(r);
		String palabraOriginal = lector.readLine();
		int tamanoPalabra = palabraOriginal.length();
		char[] nuevaPalabra = new char[tamanoPalabra];
		int errores = 0;
		boolean comparacionPalabras = false;

		if(tamanoPalabra != 0){
			System.out.println("\033[2J\n");
		}

		while (errores < 4 && comparacionPalabras != true){
			//*Dibujando los errores
			switch(errores){
				case 0: 
				System.out.println("\n*********\n* U  U  *\n*       *\n*   _   *\n*********\n    *    \n ******* \n    *    \n    *    \n   * *   \n  *   *  \n");
				break;
				case 1: 
				System.out.println("\n*********\n* x  x  *\n*       *\n*   O   *\n*********\n    *    \n ******* \n    *    \n    *    \n");
				break;
				case 2: 
				System.out.println("\n*********\n* x  x  *\n*       *\n*   O   *\n*********\n    *    \n ******* \n");
				break;
				case 3: 
				System.out.println("\n*********\n* x  x  *\n*       *\n*   ^   *\n*********\n    *    \n");
				break;
			}

			//*Pide una letra
			System.out.println("Introduzca una Letra: ");
			try{
				InputStreamReader lector2 = new InputStreamReader(System.in);
	      		BufferedReader in1 = new BufferedReader(lector2);
				String letraIntroducidaString = in1.readLine();

	    	//*Busca la letra en la palabra
			char letraIntroducidaChar = letraIntroducidaString.charAt(0);	//Convierte en char el string
			for(int i = 0; i < tamanoPalabra; i++){	
				
				char letra = palabraOriginal.charAt(i);		//El loop pasa por cada letra de la palabra dada, toma la 												//letra y la guarda en la variable letra
				
				if(letra == letraIntroducidaChar){		//Si la letra en la que el loop va pasando es igual a la 												// letra que se introdujo
					nuevaPalabra[i] = letra;		//Coloca la letra en el nuevo array 
				}
				if(!Character.isLetter(nuevaPalabra[i])){   //Revisa el array de la nueva palabra para saber si hay o no 											 //una letra, no la hay entonces guarda un _ en el nuevo array
					nuevaPalabra[i] = '_';
				}						
			}

			//*Cuenta los errores cuando no encuentra la letra
				int buscarErrores = 0;
				buscarErrores = palabraOriginal.indexOf(letraIntroducidaString); //Nos dará el index de la letra 																			 //en el array palabra
				if(buscarErrores == -1){	//Si no encuentra la letra introducida en el texto
					errores++;				//entonces suma un error
				}

			//*Compara la palabra buscada con la palabra que se tiene hasta el momento
			String nuevaPalabraString = new String(nuevaPalabra); // Se convierte en String el array nuevaPalabra
			if(nuevaPalabraString.equals(palabraOriginal)){
				comparacionPalabras = true;
			}

			//*Imprime la palabra mostrando solo las letras encontradas
			System.out.println(nuevaPalabra);			//Muestra las letras que llevas
			System.out.println("Errores: "+errores);	//Muestra los errores que llevas

			}catch (StringIndexOutOfBoundsException e){
	     		 System.out.println("Error al leer al usuario. Intentalo otra vez!\n\n\n\n");
	    	}

	    } 

	    //*Si ya tienes todos los errores, imprime que perdiste
	    if(errores == 4){
	    	System.out.println("\n***************** Lo siento, has perdido el juego >:D *******************\n");
	    	System.out.println("(Presione Enter para salir.)");
				try {
				System.in.read();
				} catch (IOException e) {
				return;
				}
	    }

	    //*Si terminaste de encontrar toda la palabra imprime que ganaste
	    if(comparacionPalabras == true){
	    	System.out.println("\n***************** GANASTE :D!!!! *******************\n");
	    	System.out.println("(Presione Enter para salir.)");
				try {
				System.in.read();
				} catch (IOException e) {
				return;
				}
	    }

	}catch (IOException e){
 		 System.out.println("Error al leer al usuario");
	}

}		
		
}


