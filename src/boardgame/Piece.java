package boardgame;

public class Piece { // Projeto Sistema de Jogo de Xadrez - Aula 183
	
	protected Position position; 
	private Board board;
	/*
	 * 'Position' NÃO é a posição do xadrez e sim uma posição de matriz.
	 * É "protected" pois NÃO será visível na camada de Xadrez! 
	 */
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	/* Pra criar uma peça 'piece' é necessário informar o tabuleiro 'board'
	 * e sua posição é nula pois ainda não foi colocada no tabuleiro!
	 */
	

	protected Board getBoard() { 
		return board;
// Somente classes e subclasses do mesmo pacote poderão acessar o 'Board' 
	}

	// setBoard(Board board) = NÃO SERÁ USADO! O tabuleiro não será alterado!
	
	
	
	
	
	
	
	
}
