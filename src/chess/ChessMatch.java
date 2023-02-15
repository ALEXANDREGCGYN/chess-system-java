package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { // Projeto Sistema de Jogo de Xadrez - Aula 184 e 188
	
	// Esta classe CONTÉM AS REGRAS do jogo de xadrez!
	
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); 
		/*
		 * Quem deve saber a dimensão do tabuleiro é a classe que contém 
		 * as regras do jogo!
		 */
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
	/* Retorna uma matriz de peças de xadrez correspondente à partida
	 * 'ChessMatch()'.
	 * Por isso o método 'getPieces()' é do tipo 'ChessPiece', diferente
	 * das peças do tabuleiro 'Piece[][] pieces' na classe 'Board', pois 
	 * pertence à camada de xadrez 'chess' e NÃO NA CAMADA DE TABULEIRO 
	 * do tipo 'boardgame'. 
	 */
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/* Libera para o 'ChessProgram' na categoria 'application', uma matriz 
		 * do tipo 'ChessPiece[][]' para que esse programa conheça apenas a 
		 * camada de xadrez 'chess' e não a camada de tabuleiro 'boardgame'.
		 * 
		 */
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j); 
		// Downcasting para interpretar como peça de xadrez e não como peça comum!
			}
		}
		return mat;	// Retorna a matriz de peças da partida de xadrez.
	}
	
	// Aula 193 - Imprimindo os movimentos possíveis
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		/* Permite, na aplicação, imprimir as posições possíveis a partir
		 * da posição de origem!
		 */
		Position position = sourcePosition.toPosition();
		// Converte a posição de xadrez em uma posição de matriz.
		validateSourcePosition(position);
		// Valida a posição de origem no ato da entrada do usuário!
		return board.piece(position).possibleMoves();
		// Retorna os movimentos possíveis da peça nessa posição!
	}
	
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition(); // Posição de origem da peça
		Position target = targetPosition.toPosition(); // Posição de destino da peça
		validateSourcePosition(source);
		// Valida SE na posição de origem 'source' realmente havia uma peça!
		
		// Projeto Sistema de Jogo de Xadrez - Aula 192.
		validateTargetPosition(source, target);
		
		Piece capturedPiece = makeMove(source, target);
		// Realiza o movimento da peça informando origem e destino no formato de matriz!
		return (ChessPiece)capturedPiece;
		/* Retorna a peça capturada fazendo um 'downcasting' pois a peça
		 * capturada é do tipo 'Piece' e o método é do tipo 'ChessPiece'.
		 */
	}
	
	// Projeto Sistema de Jogo de Xadrez - Aula 189

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); 
		// Retira a peça que estava na posição de origem 'source'.
		Piece capturedPiece = board.removePiece(target);
		// Remove a possível peça que esteja na posição de destino 'target'.
		board.placePiece(p, target);
		/* Removidas as duas peças (origem e destino), é possível colocar
		 * a peça que estava na origem 'Piece p' na posição 'target' de 
		 * destino com o 'placePiece(p, target)'.  
		 */
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		// Validação da peça de origem terá 2 verificações!
		
		if (!board.thereIsAPiece(position)) { //Se não existir uma peça na posição...
			throw new ChessException("There is no piece on source position!");
			/*
			 * Este método 'thereIsAPiece()' pode gerar uma nova exceção pois
			 * foi construído na classe 'Board' lançando uma 'BoardException'.
			 * Porém, o método 'validateSourcePosition()' aqui descrito lança 
			 * uma 'ChessException'.
			 * Para simplificar o tratamento das exceções pelo programa, foi 
			 * atualizada a classe 'ChessException' com a troca da 
			 * 'RuntimeException' por uma 'BoardException'.
			 */
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves from the chosen piece!");
			/*
			 * Testa se existem movimentos possíveis para a peça! Se não houver
			 * movimentos possíveis para a peça, a mesma não pode ser acessada
			 * e uma exceção será lançada!
			 */
		}
	}
	
	// Projeto Sistema de Jogo de Xadrez - Aula 192.
	
	private void validateTargetPosition(Position source, Position target) {
		/* Verifica e valida se a posição de destino 'target' é um movimento possível
		 * 'possibleMove()' em relação a peça na posição de origem 'source'. 
		 */
		
		if (!board.piece(source).possibleMove(target)) {
			/* Se para a peça de origem 'source', a posição de destino 'target'
			 * NÃO É UM MOVIMENTO POSSÍVEL, a peça não pode ser movimentada!
			 */
			throw new ChessException("The chosen piece can't move to target position!");
		}
		
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
	/* Recebe as coordenadas do xadrez!
	 * Usa a operação 'toPosition()' da classe 'ChessPosition' para 
	 * instanciar as peças de xadrez informando as coordenadas no sistema 
	 * do xadrez e não no sistema da matriz para não ficar confuso!!!
	 */
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		/*
		 * Chama o 'placePiece' da classe 'Board' passando a peça 'piece'. 
		 * Intancia uma 'ChessPosition' recebendo a coluna e a linha e 
		 * converte para a posição de matriz com o 'toPosition()'.
		 * 
		 * Temos então uma operação de colocar peça passando as coordenadas
		 * do xadrez.
		 */

	}
	
	private void initialSetup() {
		//board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		/* 
		 * Ao invés de passar a posição da matriz, informaremos a posição do
		 * tabuleiro.
		 * Ex.: Matriz (2 , 1) = Tabuleiro b6.
		 * Resultando em... 
		 */
		//placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		
		//board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		//placeNewPiece('e', 8, new King(board, Color.BLACK));
		
		//board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		//placeNewPiece('e', 1, new King(board, Color.WHITE));
		
		// COMANDOS SUBSTITUÍDOS PELO CÓDIGO ABAIXO:
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

	}
	
}