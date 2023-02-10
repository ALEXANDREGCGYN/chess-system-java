package chess;

import boardgame.Piece;
import boardgame.Position;

public class ChessPosition { // Projeto Sistema de Jogo de Xadrez - Aula 187
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			// Aula 186 = Programação defensiva!

			throw new ChessException("Error instatiating ChessPosition. Valid values are from a1 to h8");
		}
		
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	// 'setColumn(char column)'

	public int getRow() {
		return row;
	}

	// 'setRow(int row)'
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	/* Este método converte uma posição do xadrez 'ChessPosition' para 
	 * uma posição normal na matriz 'Piece[][] pieces' na classe 'Board'.
	 * 
	 * Ex.: Quem seria a posição 'a8' (coluna a, linha 8) no tabuleiro,
	 * convertido para a matriz?
	 * Resposta: Posição [0 , 0] da matriz!
	 * Ex.2: Posição 'a7' (coluna a, linha 7)?
	 * Resposta: Posição [1 , 0] da matriz!
	 * 
	 * Logo: A linha 8 no xadrez = 8 - 8 = 0 na matriz!
	 * 		 A linha 7 no xadrez = 8 - 7 = 1 na matriz!...
	 * 
	 * Então: A linha do xadrez 'matrix_row' = 8 - 'chess_row'. 
	 * 
	 * A coluna 'a' do xadrez = coluna 0 da matriz;
	 * A coluna 'b' do xadrez = coluna 1 da matriz;
	 * A coluna 'c' do xadrez = coluna 2 da matriz...
	 * 
	 * Logo: Se usarmos o código unicode do caracter 'a' e subtrair o
	 * código unicode do caracter 'a', teremos: 'a' - 'a' = 0;
	 * 		 Se usarmos o código unicode do caracter 'b' e subtrair o
	 * código unicode do caracter 'a', teremos: 'b' - 'a' = 1;
	 * 		 'c' - 'a' = 2;
	 * 		 'd' - 'a' = 3...
	 * 
	 * Então: 'matriz_column' = 'chess_column' - 'a'.
	 * 
	 */
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
		// Feito um 'casting' para 'char' no caracter da posição do tabuleiro!
		
	/* Este método converte uma posição normal na matriz 'Piece[][] pieces' 
	 * na classe 'Board' para uma posição no xadrez 'ChessPosition'.
	 */
		
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
	

}
