package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{ // Projeto Sistema de Jogo de Xadrez - Aula 184

	public Rook(Board board, Color color) {
		super(board, color); 
		// Simplesmente repassa a chamada para o construtor da superclasse!
	}
	
	@Override
	public String toString() {
		return "R";
		/*
		 * Converter a Torre para uma 'String' fazendo a peça ser apenas uma
		 * letra que entrará na impressão do tabuleiro. Onde estiver a peça,
		 * aparecerá a letra "R". 
		 */
	}

	/* Autocorreção abaixo implementada na Aula 191 em razão da mudança 
	 * do status da classe 'ChessPiece' de concreta para 'abstract'.
	 */

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		// Criada uma matriz com a mesma dimensão (linhas e colunas) do tabuleiro!
		return mat;
		
		/* Temporariamente, sempre que chamados os movimentos possíveis de
		 * uma peça desta classe, retornará uma matriz com todas as posições
		 * valendo 'false'.
		 * 
		 *  É como se a peça estivesse presa!
		 */
	}


}
