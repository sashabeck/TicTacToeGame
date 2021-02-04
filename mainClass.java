import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		System.out.println("Welcome to Sasha's Tic-Tac-Toe game.");
	
		TicTacToeGame game1 = new TicTacToeGame();
		
		while(true) {
		System.out.println("It's your turn, player " + game1.player);
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		
		game1.makeMove(input);
		game1.printBoard();
		}
	}

}
	
	
	

