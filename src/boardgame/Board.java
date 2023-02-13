package boardgame;

public class Board { // Projeto Sistema de Jogo de Xadrez - Aula 183
	
	/*  A posição da peça nessa classe é dada por uma matriz 'Piece [][]'
	 *  com linhas e colunas de [0,0] até [8,8]. 
	 *  
	 *  Diferente da classe 'ChessPosition' onde a posição é a referência 
	 *  da letra da coluna, que vai de 'a' até 'h', com o número das 
	 *  linhas de 1 a 8 e que são visíveis ao jogador!
	 */
	
	private int rows;
	private int columns;
	private Piece[][] pieces; // Matriz de peças
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		} // Aula 186 = Programação defensiva!

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		// Instancia a matriz de peças com a qte de colunas e linhas informada.
	}

	public int getRows() {
		return rows;
	}

	/* 'public void setRows(int rows) {' EXCLUÍDO PARA NÃO PERMITIR 
	 * ALTERAR O NÚMERO DE LINHAS DO TABULEIRO! 
	 */

	public int getColumns() {
		return columns;
	}

	/* 'public void setColumns(int columns) {' EXCLUÍDO PARA NÃO PERMITIR 
	 * ALTERAR O NÚMERO DE COLUNAS DO TABULEIRO! 
	 */
	
/* 
 * GET e SET da peça NÃO será usado! o projeto prevê métodos próprios para
 * retornar as peças dadas as linhas, colunas e posições!
 * NÃO RETORNA a matriz de peças inteira! SOMENTE uma peça por vez!
 */
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board!");
		} // Aula 186 = Programação defensiva!
		/* Ao acessar uma peça 'piece' em uma determinada posição 'row'
		 * e 'column', caso a posição não exista, lançará uma exceção!
		 */
		return pieces[row][column];
		// Retorna a matriz na linha e coluna
	}
	;
	public Piece piece(Position position) { 
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		} // Aula 186 = Programação defensiva!
		/* Ao acessar uma peça 'piece' em uma determinada posição 
		 * 'position', caso a posição não exista, também lançará 
		 * uma mensagem de exceção!
		 */
		return pieces[position.getRow()][position.getColumn()];
		// Sobrecarga retorna a peça pela posição
	}
	
	public void placePiece(Piece piece, Position position) { 
		// Coloca uma peça em uma dada posição!
		
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position + "!");
		} // Se já existir uma peça nesta dada posição, não poderá inserir outra!
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		/* 
		 * O método acessa a matriz 'pieces[][]' do tabuleiro na linha e
		 * coluna informadas, atribui a peça 'piece' que veio como argumento!
		 * 
		 * A matriz de peças 'pieces[][]' é a matriz declarada acima no início 
		 * da classe 'Board' e instanciada no contrutor!
		 * 
		 * A peça passa a não estar na posição nula, mas na posição 'position'
		 * informada no método!
		 * 
		 * Mesmo que seja do tipo 'protected', a posição 'position' é acessível
		 * à classe 'Board' por pertencer ao mesmo pacote da classe 'Piece'. 
		 */
	}
	
// Projeto Sistema de Jogo de Xadrez - Aula 189.
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) { 
		// Programação defensiva: Se a posição NÃO existe, lança a mensagem!
			
			throw new BoardException("Position not on the board!");
		}
		if (piece(position) == null) {
			/* SE a peça do tabuleiro nessa posição é igual a nulo,
			 * significa que NÃO tem peça na posição!
			 * Então retorna nulo!
			 */
			return null;
		}
		Piece aux = piece(position); 
		// Recebe a peça que estiver no tabuleiro nessa posição!
		aux.position = null; 
		// A posição dela agora será nula = foi retirada do tabuleiro e não tem mais posição!
		pieces[position.getRow()][position.getColumn()] = null;
		/* Acessando a matriz de peças 'pieces' na posição da linha e 
		 * coluna informados irá receber um valor nulo, indicando que 
		 * não há mais peça na posição da matriz! 
		 */
		return aux; // Contem a peça que foi retirada!
	}

// Projeto Sistema de Jogo de Xadrez - Aula 186 = Testando se a posição existe!
	
	private boolean positionExists(int row, int column) {
		/* Método auxiliar usado para testar se uma posição existe pela
		 * linha e pela coluna de forma mais fácil que pela posição como
		 * no método abaixo!
		 */
		
		return row >= 0 && row < rows && column >= 0 && column < columns;
		/* Testa se a posição está dentro do tabuleiro verificando se
		 * a linha 'row' é maior/igual a zero e menor que o atributo 'rows' 
		 * que é a altura do tabuleiro passado pela classe, junto com a 
		 * coluna 'column' sendo maior/igual a zero e menor que o atributo 
		 * 'columns' passado pela classe.
		 */

	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
		
		/*
		 * Reaproveitamento de código = método 'positionExists()' acima!
		 */
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		} // Testa se existe uma dada posição, para então receber uma peça!
		
		return piece(position) != null; 
		
		/* 
		 * Método acima que retornara a peça que estiver na matriz
		 * na posição informada!
		 */
	}
	
	
	

}
