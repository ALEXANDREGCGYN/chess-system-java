package chess;

import boardgame.Board;
import boardgame.Piece;
public class ChessPiece extends Piece{ // Projeto Sistema de Jogo de Xadrez - Aula 184
	
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
