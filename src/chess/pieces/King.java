package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece { // Projeto Sistema de Jogo de Xadrez - Aula 184

	public King(Board board, Color color) {
		super(board, color);
		// Simplesmente repassa a chamada para o construtor da superclasse!
	}
	
	@Override
	public String toString() {
		return "K";
		/*
		 * Converter o Rei para uma 'String' fazendo a peça ser apenas uma
		 * letra que entrará na impressão do tabuleiro. Onde estiver a peça,
		 * aparecerá a letra "K". 
		 */

	}
	
	// Aula 194 - Implementando os movimentos do REI.
	
	private boolean canMove(Position position) {
		// Método informa se o Rei pode se mover para uma determinada posição.
		
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		// Capta a peça 'p' que está na posição 'position'
		
		return p == null || p.getColor() != getColor();
		/* Verifica se a peça 'p' que está na posição É NULA (vazia)
		 * ou SE É ADVERSÁRIA (de cor diferente)!
		 */
	}
	
	/* Autocorreção abaixo implementada na Aula 191 em razão da mudança 
	 * do status da classe 'ChessPiece' de concreta para 'abstract'.
	 */
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		// Criada uma matriz com a mesma dimensão (linhas e colunas) do tabuleiro!

		// Posição auxiliar com posição zero para referência!
		Position p = new Position(0, 0); 
		
		// Teste de cada uma das 8 direções possíveis para o REI se mover!

		/* Testando as posições livres do REI nas 8 direções possíveis!
		 * Direita, Diagonal Dir/Abaixo, Abaixo, Diagonal Esq/Abaixo, 
		 * Esquerda, Diagonal Esq/Acima e Acima ==> Enquanto estiverem livres,
		 * será marcado como posição verdadeiro 'true'!
		 * Quando houver uma peça da mesma cor, não poderá avançar!
		 * Quando houver uma peça de cor diferente (adversário), avança e
		 * captura a peça! 
		 */
		
		// ABOVE (ACIMA)
		p.setValues(position.getRow() - 1, position.getColumn());
		// Aponta a direção da jogada...
		if (getBoard().positionExists(p) && canMove(p)) {
			// Se a posição existe e pode ser utilizada...
			mat[p.getRow()][p.getColumn()] = true;
			// Marca a posição da matriz como verdadeiro!
		}
		
		// BELOW (ABAIXO)
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// LEFT (ESQUERDA)
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// RIGHT (DIREITA)
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// DIAGONAL LEFT ABOVE (DIAGONAL ESQ/ACIMA)
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// DIAGONAL RIGHT ABOVE (DIAGONAL DIR/ACIMA)
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// DIAGONAL RIGHT BELOW (DIAGONAL DIR/ABAIXO)
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// DIAGONAL LEFT BELOW (DIAGONAL ESQ/ABAIXO)
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
		
		/* Temporariamente, sempre que chamados os movimentos possíveis de
		 * uma peça desta classe, retornará uma matriz com todas as posições
		 * valendo 'false'.
		 * 
		 *  É como se a peça estivesse presa!
		 */
	}
	
	

}
