package chess;

import boardgame.Board;
import boardgame.Piece;
public abstract class ChessPiece extends Piece{ // Projeto Sistema de Jogo de Xadrez - Aula 184
	
	// Alterado para 'abstract' - Aula 191. Também nas classes 'King' e 'Rook'.
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	/* setColor(Color color) { // EXCLUÍDO - Cor só pode ser acessada
	 * mas não modificada!
	 */
	
	
	
}
