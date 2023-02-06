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
	
	
	
}
