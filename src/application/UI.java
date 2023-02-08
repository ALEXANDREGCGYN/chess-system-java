package application;

import chess.ChessPiece;

public class UI { // Projeto Sistema de Jogo de Xadrez - Aula 184
	
	// Função 'UI' User Interface, imprimi as peças da partida!
	
	public static void printBoard(ChessPiece[][] pieces) { 

		// O método recebe a matriz de nome 'pieces' do tipo 'ChessPiece[][]'. 

		// Imprime o tabuleiro!
		
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece) { // Imprime 1 única peça!
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
	
	
}
