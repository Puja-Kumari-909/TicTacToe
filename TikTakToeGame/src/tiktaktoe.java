
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tiktaktoe {
	
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
	
	public static String checkWinner() {
		
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> midCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> lDigonal = Arrays.asList(1, 5, 9);
		List<Integer> rDigonal = Arrays.asList(3, 5, 7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(lDigonal);
		winning.add(rDigonal);
		
		for(List l : winning) {
			if(playerPosition.containsAll(l)) {
				return "YOU WIN!!";
			}else if(cpuPosition.containsAll(l)) {
				return "CPU WINS!! SORRY";
			}else if(( playerPosition.size()+cpuPosition.size()) == 9) {
				return "TIE! PLAY AGAIN";
			}
		}
		return "";
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row:gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char[][]gameBoard, int pos,String user) {
		
		 char symbol = ' ';
		if(user.equals("player")) {
			symbol = 'X';
			playerPosition.add(pos);
			
		}else if(user.equals("cpu")) {
			symbol = 'O';
			cpuPosition.add(pos);
		}
		
		switch(pos) {
		  case 1:
			  gameBoard[0][0]= symbol;
			  break;
		  case 2:
			  gameBoard[0][2]= symbol;
			  break;
		  case 3:
			  gameBoard[0][4]= symbol;
			  break;
		  case 4:
			  gameBoard[2][0]= symbol;
			  break;
		  case 5:
			  gameBoard[2][2]= symbol;
			  break;
		  case 6:
			  gameBoard[2][4]= symbol;
			  break;
		  case 7:
			  gameBoard[4][0]= symbol;
			  break;
		  case 8:
			  gameBoard[4][2]= symbol;
			  break;
		  case 9:
			  gameBoard[4][4]= symbol;
			  break;
		default :
			break;
			  
		}
		
		
	}

	
	public static void main(String[] args) {
		   
		char [][] gameBoard = { {' ', '|', ' ', '|', ' '},
				                {'-', '+', '-', '+', '-'}, 
				                {' ', '|', ' ', '|', ' '}, 
				                {'-', '+', '-', '+', '-'}, 
				                {' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard);
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter the position (1-9): ");
			int playerPos = scan.nextInt();
			while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)) {
				System.out.println("POSITON TAKEN!! Enter new position");
				playerPos = scan.nextInt();
			}
			
			
			placePiece(gameBoard, playerPos, "player");
			String result= checkWinner();
			
			if(result.length()>0) {
				System.out.println(result);
				break;
			  } 
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			
			while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
		
				cpuPos = rand.nextInt(9) + 1;
			} 
	
			placePiece(gameBoard, cpuPos, "cpu");
			
			printGameBoard(gameBoard);
			
			     result = checkWinner();
			     if(result.length() > 0) {
			    	 System.out.println(result);
			    	 break;
			     }
			System.out.println(result);
		}
		
	}

}

