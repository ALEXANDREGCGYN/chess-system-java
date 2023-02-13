package chess;

import boardgame.BoardException;

public class ChessException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	// Projeto Sistema de Jogo de Xadrez - Aula 187
	
	public ChessException(String msg) {
		super(msg);
	}
	/*
	 * O método 'thereIsAPiece()' pode gerar uma nova exceção pois
	 * foi construído na classe 'Board' lançando uma 'BoardException'.
	 * Porém, o método 'validateSourcePosition()' descrito na classe
	 * 'ChessMatch' lança uma 'ChessException'.
	 * Para simplificar o tratamento das exceções pelo programa, foi 
	 * atualizada a classe 'ChessException' com a troca da 
	 * 'RuntimeException' por uma 'BoardException'.
	 */

}
