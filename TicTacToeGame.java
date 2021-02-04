
public class TicTacToeGame {

	char[][] board;
	int player = 0;
	int numMoves;
	char[] symbol = 
		{ ' ', 'X','O'};
	
	public void initializeBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public TicTacToeGame() {
		board = new char[3][3];
		initializeBoard();
		numMoves = 0;
		player = 1;
	}
	
	public void printBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public boolean isValidMove(char letter, int position) {
		if(position < 1 || position > 9) {
			return false;
		}
		position--;
		
		if(letter != 'X' && letter != 'O') {
			return false;
		}
		
		int row = position/3;
		int column = position%3;
		if(board[row][column] != '-') {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isWinner(char letter) {
		
		//rows
		if(board[0][0] == letter && board[0][1] == letter && board[0][2] == letter) 
			return true;
		if(board[1][0] == letter && board[1][1] == letter && board[1][2] == letter) 
			return true;
		if(board[2][0] == letter && board[2][1] == letter && board[2][2] == letter) 
			return true;
		
		//columns
		if(board[0][0] == letter && board[1][0] == letter && board[2][0] == letter) 
			return true;
		if(board[0][1] == letter && board[1][1] == letter && board[2][1] == letter) 
			return true;
		if(board[0][2] == letter && board[1][2] == letter && board[2][2] == letter) 
			return true;
		
		//diagonal
		if(board[0][0] == letter && board[1][1] == letter && board[2][2] == letter)
			return true;
		if(board[2][0] == letter && board[1][1] == letter && board[0][2] == letter) 
			return true;
		
		return false;

	}
	
	public void makeMove(int position) {
		if(!isValidMove(symbol[player], position)){
			System.out.println("Not a valid move.");
			return;
		}
		
		position--;
		int row = position/3;
		int column = position%3;
		board[row][column] = symbol[player];
		++numMoves;
		
		if(isWinner(symbol[player])) {
			System.out.println(symbol[player] + " wins.");
			System.exit(0);
		}
		
		if(numMoves > 8) {
			System.out.print("Draw.");
			System.exit(0);
		}
		
		player = player==1? 2:1;
		
	}
	
	
}
