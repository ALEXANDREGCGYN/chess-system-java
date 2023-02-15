package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{ // Projeto Sistema de Jogo de Xadrez - Aula 184

	public Rook(Board board, Color color) {
		super(board, color); 
		// Simplesmente repassa a chamada para o construtor da superclasse!
	}
	
	@Override
	public String toString() {
		return "R";
		/*
		 * Converter a Torre para uma 'String' fazendo a peça ser apenas uma
		 * letra que entrará na impressão do tabuleiro. Onde estiver a peça,
		 * aparecerá a letra "R". 
		 */
	}

	/* Autocorreção abaixo implementada na Aula 191 em razão da mudança 
	 * do status da classe 'ChessPiece' de concreta para 'abstract'.
	 */

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		/* Criada uma matriz com a mesma dimensão (linhas e colunas) do 
		 * tabuleiro com todas valendo 'FALSE'!
		 */
	
	// Projeto Sistema de Jogo de Xadrez - Aula 192.
		
		/* Testando as posições livres da Torre nas quatro direções!
		 * Direita, Esquerda, Acima e Abaixo ==> Enquanto estiverem livres,
		 * será marcado como posição verdadeiro 'true'!
		 * Quando houver uma peça da mesma cor, não poderá avançar!
		 * Quando houver uma peça de cor diferente (adversário), avança e
		 * captura a peça! 
		 */
		Position p = new Position(0, 0);
		
		// Above (Linha ACIMA)**********************************************
		
		p.setValues(position.getRow() - 1, position.getColumn());
		/* 'position.getRow() - 1' ==> Linha ACIMA da posição da peça! 
		 * 
		 * O 'position' aqui é a posição da própria peça (atributo do
		 * tipo 'protected' na classe 'Piece').
		 * 
		 * Como estamos analisando as casas do tabuleiro ACIMA da peça,
		 * usamos a posição da peça menos um na linha dela!
		 * 
		 * Considerando um tabuleiro 8x8 onde a primeira linha é '0', a
		 * última linha (Abaixo) será a de número '7'. Se a peça está na 
		 * borda de baixo (na linha '7'), para verificarmos se a posição 
		 * ACIMA está livre para ser movimentada no método 'possibleMoves()'
		 * devemos aplicar o 'position.getRow() - 1' para avançar para a
		 * linha '6' e assim, sucessivamente!
		 */
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			/* Enquanto a posição 'p' existir + Enquanto vazia ==> NÃO houver 
			 * uma peça na posição 'p'...
			 */
			mat [p.getRow()][p.getColumn()] = true;
			/* Enquanto a posição ACIMA estiver vaga ==> Marca como 
			 * VERDADEIRA indicando que a peça poderá ser movida 
			 * para a posição alvo!
			 */
			
			p.setRow(p.getRow() - 1);
			// Faz a linha da posição movimentar acima sucessivamente!
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			/* Verifica se existe uma posição E SE HÁ uma peça adversária
			 * nesta posição!
			 */
			
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		/* Temporariamente, sempre que chamados os movimentos possíveis de
		 * uma peça desta classe, retornará uma matriz com todas as posições
		 * valendo 'false'.
		 * 
		 *  É como se a peça estivesse presa!
		 */
		
		// Left (Coluna ESQUERDA)*******************************************
		
		p.setValues(position.getRow(), position.getColumn() - 1);
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			
			mat [p.getRow()][p.getColumn()] = true;
		}

		// Right (Coluna DIREITA)*******************************************
		
		p.setValues(position.getRow(), position.getColumn() + 1);
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		// Below (Linha ABAIXO)*********************************************
		
		p.setValues(position.getRow() + 1, position.getColumn());
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			
			mat [p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
		
	}
	
}