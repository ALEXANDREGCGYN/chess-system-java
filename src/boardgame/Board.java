package boardgame;

public class Board { // Projeto Sistema de Jogo de Xadrez - Aula 183
	
	private int rows;
	private int columns;
	private Piece[][] pieces; // Matriz de peças
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		// Instancia a matriz de peças com a qte de colunas e linhas informada.
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
/* 
 * GET e SET da peça NÃO será usado! o projeto prevê métodos próprios para
 * retornar as peças dadas as linhas, colunas e posições!
 * NÃO RETORNA a matriz de peças inteira! SOMENTE uma peça por vez!
 */
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
		// Retorna a matriz na linha e coluna
	}
	
	public Piece piece(Position position) { 
		return pieces[position.getRow()][position.getColumn()];
		// Sobrecarga retorna a peça pela posição
	}
	
	public void placePiece(Piece piece, Position position) {
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
}
