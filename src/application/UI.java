package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI { // Projeto Sistema de Jogo de Xadrez - Aula 184 e 188.
	
	// Função 'UI' User Interface, imprimi as peças da partida!
	
	// RETIRADO DO GITHUB DO PROF.NELIO ALVES = FUNÇÃO DE COLORIR AS PEÇAS!
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	// Projeto Sistema de Jogo de Xadrez - Aula 190
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() { // Método usado para limpar da tela a jogada anterior!
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	
	
	public static ChessPosition readChessPosition(Scanner sc) { 
		// Método para LER a posição do xadrez com formato letra/número ('a1').
		try {
			String s = sc.nextLine();
			char column = s.charAt(0); 
			// A coluna da posição de xadrez é o primeiro caracter do String.
			int row = Integer.parseInt(s.substring(1));
			/* Para obtermos a linha, o '.substring(1)' recorta o string 's'
			 * a partir da posição 1, converte em uma variável do tipo 'Integer' 
			 * via 'parseInt' e atribui à variável 'row' do tipo inteiro.
			 */
			
			return new ChessPosition(column, row); 
		}
		catch (RuntimeException e) { // Evita qualquer problema de formato!
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8!");
			// É um tipo de exceção pré-existente no Java (Erro de entrada de dados!)
		}
	}
	
	// Aula 195 - Método para imprimir a partida (não só o tabuleiro!).
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces()); // 1º Imprime o tabuleiro...
		System.out.println(); // Quebra de linha...
		System.out.println("Turn: " + chessMatch.getTurn()); // Imprime o turno...
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());;
		// Mensagem de "Aguardando o jogador ??"
	}
	
	
	public static void printBoard(ChessPiece[][] pieces) { 

		// O método recebe a matriz de nome 'pieces' do tipo 'ChessPiece[][]'. 

		// Imprime o tabuleiro!
		
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
				// Indica que nenhuma peça deve ter o fundo colorido!
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	// Aula 193 - Imprimindo os movimentos possíveis
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		// Nova versão vai imprimir a matriz de movimentos possíveis

		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
				// Pinta o fundo colorido dependendo da posição i e j.
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
/*	private static void printPiece(ChessPiece piece) { // Imprime 1 única peça!
*		if (piece == null) {
*			System.out.print("-");
*		} else {
*			System.out.print(piece);
*		}
*		System.out.print(" ");
*	}
*	ESTE MÉTODO FOI TROCADO PELO MÉTODO ABAIXO RETIRADO DO GITHUB acenelio!!!
*/
	
	private static void printPiece(ChessPiece piece, boolean background) { // Aula 193 - Alterado 
    	if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	
}
