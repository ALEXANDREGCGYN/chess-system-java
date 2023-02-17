package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class ChessProgram { // Projeto Sistema de Jogo de Xadrez - Aula 181

	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch(); // Declara uma partida!
		List<ChessPiece> captured = new ArrayList<>();
		/* Define a lista de peças capturadas!
		 * Será usada como argumento para imprimir a partida!
		 */
		
		while (true) {
			try { // Projeto Sistema de Jogo de Xadrez - Aula 190
				UI.clearScreen(); 
				//UI.printBoard(chessMatch.getPieces()); // Aula 195 - Troca de turno.
				UI.printMatch(chessMatch, captured);
				
				/* Função 'UI' = 'User Interface' pra imprimir as peças da partida,
				 * que traz o método 'printBoard()' que recebe a matriz de peças
				 * da partida 'chessMatch.getPieces()'.
				 */
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				// Aula 193 - Imprimindo os movimentos possíveis
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				/* Declara uma matriz recebendo os movimentos possíveis a
				 * partir da posição de origem informada.
				 */
				UI.clearScreen(); // Limpa a tela...
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				/* Imprime novamente o tabuleiro, criando uma sobrecarga
				 * do 'printBoard()' passando os movimentos possíveis.
				 * Será responsável por imprimir o tabuleiro COLORINDO as
				 * posições possíveis para onde a peça pode ser movida!
				 */
				
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				/* Sempre que executar um movimento de xadrez e retornar 
				 * uma possível peça capturada, fará o teste se a peça 
				 * capturada for diferente de nulo, significa que uma 
				 * peça foi capturada!
				 */
				if (capturedPiece != null) {
					captured.add(capturedPiece);
					// Adiciona a peça capturada na lista de peças capturadas!
				}
				
				
			}
			catch (ChessException e){
				System.out.println(e.getMessage()); 
				// Tratamento básico p/imprimir a mensagem na tela!
				sc.nextLine();
				// O programa irá aguardar o usuário apertar Enter!
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage()); 
				// Tratamento básico p/imprimir a mensagem na tela!
				sc.nextLine();
				// O programa irá aguardar o usuário apertar Enter!
			}

		}
		
				
		
		
	}

}
