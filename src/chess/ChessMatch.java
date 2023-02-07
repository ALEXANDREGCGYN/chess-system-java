package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessMatch { // Esta classe CONTÉM AS REGRAS do jogo de xadrez!
	
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); 
		/*
		 * Quem deve saber a dimensão do tabuleiro é a classe que contém 
		 * as regras do jogo!
		 */
	}
	
	public ChessPiece[][] getPieces(){
	/* Retorna uma matriz de peças de xadrez correspondente à partida
	 * 'ChessMatch()'.
	 * Por isso o método 'getPieces()' é do tipo 'ChessPiece', diferente
	 * das peças do tabuleiro 'Piece[][] pieces' na classe 'Board', pois 
	 * pertence à camada de xadrez 'chess' e NÃO NA CAMADA DE TABULEIRO 
	 * do tipo 'boardgame'. 
	 */
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/* Libera para o 'ChessProgram' na categoria 'application', uma matriz 
		 * do tipo 'ChessPiece[][]' para que esse programa conheça apenas a 
		 * camada de xadrez 'chess' e não a camada de tabuleiro 'boardgame'.
		 * 
		 */
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j); 
		// Downcasting para interpretar como peça de xadrez e não como peça comum!
			}
		}
		return mat;	// Retorna a matriz de peças da partida de xadrez.
	}
	
	
	
	
	
	
}
