package boardgame;

public class Position { // Projeto Sistema de Jogo de Xadrez - Aula 182
	
	private int row;
	private int column;
	
	public Position() {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	// Projeto Sistema de Jogo de Xadrez - Aula 192.
	public void setValues(int row, int column) {
		// Operação para atualizar os novos valores de uma posição!
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return row + ", " + column;
		
	}
	
	
	
	

}
