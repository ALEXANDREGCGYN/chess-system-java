package application;

import java.util.Scanner;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class ChessProgram { // Projeto Sistema de Jogo de Xadrez - Aula 181

	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
		UI.printBoard(chessMatch.getPieces());
		
		/* Função 'UI' = User Interface pra imprimir as peças da partida,
		 * que traz o método 'printBoard()' que recebe a matriz de peças
		 * da partida 'chessMatch.getPieces()'.
		 */
		System.out.println();
		System.out.println("Source: ");
		ChessPosition source = UI.readChessPosition(sc);
		
		System.out.println();
		System.out.println("Target: ");
		ChessPosition target = UI.readChessPosition(sc);
		
		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
		
				
		
		
	}

}
