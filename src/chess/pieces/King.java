package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece { // Projeto Sistema de Jogo de Xadrez - Aula 184

	public King(Board board, Color color) {
		super(board, color);
		// Simplesmente repassa a chamada para o construtor da superclasse!
	}
	
	@Override
	public String toString() {
		return "K";
		/*
		 * Converter o Rei para uma 'String' fazendo a peça ser apenas uma
		 * letra que entrará na impressão do tabuleiro. Onde estiver a peça,
		 * aparecerá a letra "K". 
		 */

	}
	
	

}
