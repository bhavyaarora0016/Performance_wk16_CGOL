package perf_cgol;

public class Output extends Thread{
	private int r, c;
	private int[][] arr ;
	private int[][] futureLife = new int[100][100];

	public Output(int row, int column, int[][] arr) {
		this.r=row;
		this.c=column;
		this.arr = arr;
	}
	
	public void run() {
		//Calculating the time elapsed so far.
		long startTime = System.nanoTime();
		int i,j,k,l;

		// Loop through every cell of the every row and column
		for(i=1; i<r-1; i++){
			for(j=1; j<c-1; j++){

				// Finding how many cells are alive
				int aliveCell = 0;
				for(k=-1; k<=1; k++)
					for(l=-1; l<=1; l++)
						aliveCell = aliveCell + arr[i+k][j+l];

				aliveCell = aliveCell - arr[i][j];

				// If cell is lonely then it dies
				if((arr[i][j] == 1) && (aliveCell < 2)){
					futureLife[i][j] = 0;
				}

				// If cell is overpopulated it dies
				else if((arr[i][j] == 1) && (aliveCell > 3)){
					futureLife[i][j] = 0;
				}

				// A new cell is born as 3 adjacent cells are alive
				else if((arr[i][j] == 0) && (aliveCell ==3)){
					futureLife[i][j] = 1;
				}

				// Nothing happens so it remains same
				else{
					futureLife[i][j] = arr[i][j];
				}
			}
		}

		System.out.println();
		System.out.println("Next Life is:");

		// Printing the next life
		for(k=0; k<r; k++){
			for(l=0; l<c; l++){
				System.out.print(futureLife[k][l] + " ");
			}
			System.out.println();
		}
		
		//Assigning the next life to the main array to print further generation
		for (k = 0; k < r; k++) {
			for (l = 0; l < c; l++) {
				arr[k][l] = futureLife[k][l];
			}
		}
		//Calculating the time to execute the next generation of CGOL
		long time = System.nanoTime() - startTime;
        System.out.println("Time taken to generate the next Generation execution time: " + time + " ns");
        System.out.println("Enter the 's' key for continuing the game and any other character to end the game");
	}

}
