package boardgame;

public abstract class Piece { // Projeto Sistema de Jogo de Xadrez - Aula 183
	//  Classe alterada para 'abstract' em razão do método 'possibleMoves()'.
	
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
	
	// Projeto Sistema de Jogo de Xadrez - Aula 191.
	
	public abstract boolean[][] possibleMoves(); 
	// Método ABSTRATO que retorna uma matriz booleana.
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
		/*
		 * Este método concreto 'possibleMove()' se utilizou do método 
		 * abstrato acima 'possibleMoves()' evidenciando o chamado 
		 * 'Hook methods' (que em inglês significa 'gancho').
		 * 
		 * É um método faz um gancho com a subclasse!
		 */
	}
	
	public boolean isThereAnyPossibleMove() { // Outro caso de 'Hook Method'!
		// Informa se existe pelo menos um movimento possível para a peça!
		boolean[][] mat = possibleMoves();
		/* Chama novamente o método abstrato 'possibleMoves()' retornando
		 * uma matriz booleana.
		 */
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
		/* Varrem a matriz para verificar se pelo menos uma posição da matriz
		 * que seja verdadeiro (movimento possível para a peça!).
		 * Se não houver posição verdadeiro ==> A peça não pode ser movida!  
		 */
				if (mat[i][j]) {
					return true;
				/* Se na linha 'i', na coluna 'j' da matriz a posição for
				 * verdadeiro ==> Existe um movimento possível!
				 */
				}
			}
		}
		return false; 
		/* Se a varredura se esgotar e não retornar 'true', significa que
		 * nenhuma posição é verdadeira e retorna 'false'.
		 */
	}
	
	
	
	
	
	
	
	
	
	
}
