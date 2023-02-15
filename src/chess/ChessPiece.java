package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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
	
	// Projeto Sistema de Jogo de Xadrez - Aula 192.
	
	protected boolean isThereOpponentPiece(Position position) {
		// 'abstract' ==> Acessada pela classe e pelas classes do mesmo pacote!
		
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		/* Recebe a peça que está na posição 'position', armazena em uma
		 * variável do tipo 'ChessPiece' (peça de xadrez) e testa se é 
		 * uma peça adversária!
		 */
		return p != null && p.getColor() != color;
		// Adversária = Não vazia e Não da mesma cor!
	}
	
}
