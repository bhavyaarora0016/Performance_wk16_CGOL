package perf_cgol;

import java.util.Scanner;

public class TheMainline {
	public static void main(String[] args) {
		
		//Taking the input
		Scanner sc = new Scanner(System.in);
		
		//Variables: rows and columns
		int row, column;
		char run;
		
		System.out.println("Enter the number of rows:");
		
		//Taking the row from the user
		row = sc.nextInt();

		System.out.println("Enter the number of Columns:");
		
		//Taking the column from the user
		column = sc.nextInt();
		
		//Declaring the Arrays which will store the intial CGOL
		int[][] arr = new int[row][column];

		System.out.println("Enter the CGOL:");
		System.out.println("Entry must be in 0 and 1, 0 is for the dead cell and 1 is for the alive cell");
		
		//Taking the user input for the initial generation
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		
		//Calling the function and printing next life when user enter y
		do {
			//Making the object of Logic class
			Output op = new Output(row,column,arr);
			
			//Executing the thread
			op.start();
			
			//Setting the priority so that it always run after printing the generation
			op.setPriority(2);
			
			//Asking the User to continue the game
			run = sc.next().charAt(0);
			
		} while (run == 's');

		//When user enter any other character then y, loop stops and print below message
		System.out.println("Thank you for playing the game");
		sc.close();
	}

	
}
