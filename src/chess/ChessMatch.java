package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { // Projeto Sistema de Jogo de Xadrez - Aula 184 e 188
	
	// Esta classe CONTÉM AS REGRAS do jogo de xadrez!
	
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); 
		/*
		 * Quem deve saber a dimensão do tabuleiro é a classe que contém 
		 * as regras do jogo!
		 */
		initialSetup();
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
	/* Recebe as coordenadas do xadrez!
	 * Usa a operação 'toPosition()' da classe 'ChessPosition' para 
	 * instanciar as peças de xadrez informando as coordenadas no sistema 
	 * do xadrez e não no sistema da matriz para não ficar confuso!!!
	 */
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		/*
		 * Chama o 'placePiece' da classe 'Board' passando a peça 'piece'. 
		 * Intancia uma 'ChessPosition' recebendo a coluna e a linha e 
		 * converte para a posição de matriz com o 'toPosition()'.
		 * 
		 * Temos então uma operação de colocar peça passando as coordenadas
		 * do xadrez.
		 */

	}
	
	private void initialSetup() {
		//board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		/* 
		 * Ao invés de passar a posição da matriz, informaremos a posição do
		 * tabuleiro.
		 * Ex.: Matriz (2 , 1) = Tabuleiro b6.
		 * Resultando em... 
		 */
		//placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		
		//board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		//placeNewPiece('e', 8, new King(board, Color.BLACK));
		
		//board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		//placeNewPiece('e', 1, new King(board, Color.WHITE));
		
		// COMANDOS SUBSTITUÍDOS PELO CÓDIGO ABAIXO:
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
		
		

	}
	
	
	
	
}
