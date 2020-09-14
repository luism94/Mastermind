package codes;

public class Constants {

	static final String WELCOME = "Mastermind: Welcome!";
	static final String ILLEGAL_ARG_EXCP = "Opcion no valida";
	static final String EXIT = "Closing game..... ..... .....";
	static final String HOW_TO_PLAY_1 = "Mastermind es un juego de combinacion de colores, donde dos\r\n" + 
			"jugadores se enfrentan entre si, la maquina y el usuario.\nEn el " + 
			"juego la maquina creara una combinacion secreta de bolas de " + 
			"colores, la cual el usuario debera intentar adivinar, con cada " + 
			"intento la maquina indicara al usuario cuantos colores ha " + 
			"adivinado y si estan o no en la posicion correcta mediante un " + 
			"sistema de colores que le indicaran al usuario si esta adivinando la " + 
			"combinacion o no.";
	static final String HOW_TO_PLAY_2 = "Hay 4 modos de juego:\n" +
			"-Modo facil: la combinacion solo tendra 4 colores y el usuario podra realizar intentos " + 
			"infinitos para adivinarla, la combinacion secreta no puede tener colores repetidos\n" + 
			"- Modo normal: la combinacion tendra 4 colores y el usuario tendra 15 intentos para " + 
			"adivinarla la combinacion secreta no puede tener colores repetidos\n" + 
			"- Modo intermedio: la combinacion tendra 6 colores y el usuario tendra 20 intentos para " + 
			"adivinarla, y la combinacion secreta si puede tener colores repetidos\n" + 
			"- Modo dificil: la maquina controla a dos jugadores y obliga a enfrentarse entre si para " +
			"ver quien resulta ganador.";
	static final String COLOR_MENU_1 = "Introduce un entero para elegir uno de los siguientes colores: \n";
	static final String COLOR_MENU_2 = "1. ROJO\n2.VERDE\n3.AZUL\n4.AMARILLO\n5.MARRON\n6.NARANJA\n7.NEGRO\n8.BLANCO";
	static final String GAMEMODE_MENU_1 = "Introduce un entero para elegir uno de los modos de juego: \n";
	static final String GAMEMODE_MENU_2 = "1. FACIL\n2.NORMAL\n3.INTERMEDIO\n4.DIFICIL";
	static final String MAIN_MENU_1 = "MAIN MENU -- -- --";
	static final String MAIN_MENU_2 = "1. Start a new game\n2. How to play\n3. Exit game";
	static final String MAIN_MENU_3 = "Choose one option: ";
}
