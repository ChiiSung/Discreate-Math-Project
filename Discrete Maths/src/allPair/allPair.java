package allPair;


public class allPair {

	public static void main(String[] args) {
		final int INF = 100000;
		final int DIAGONAl = 0;
		int graph[][] = {{ DIAGONAl, 24, 40, 55, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, 
			 			 {24, DIAGONAl, INF, 60, 80, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
			 			 {40, INF, DIAGONAl, 19, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
			 			 {55, 60, 19, DIAGONAl, 25, 93, INF, INF, INF, INF, INF, INF, INF, INF, INF},
			 			 {INF, 80, INF, 25, DIAGONAl ,INF, 40, INF, INF, INF, INF, INF, INF, INF, INF},
			 			 {INF,  INF, INF, 93, INF, DIAGONAl, INF, 70, INF, INF, INF, INF, INF, INF, INF},
			 			 {INF,  INF, INF, INF, 40, INF, DIAGONAl, 120, 43, INF, INF, INF, INF, INF, INF},
			 			 {INF,  INF, INF, INF, INF, 70, 120, DIAGONAl, INF, INF, 56, INF, 80, INF, INF},
			 			 {INF,  INF, INF, INF, INF, INF, 43, INF, DIAGONAl, 42, INF, INF, INF, INF, INF},
			 			 {INF,  INF, INF, INF, INF, INF, INF, INF, 42, DIAGONAl, 76, INF, 87, INF, INF},
			 			 {INF,  INF, INF, INF, INF, INF, INF, 56, INF, 76, DIAGONAl, 19, INF, INF, INF},
			 			 {INF,  INF, INF, INF, INF, INF, INF, INF, INF, INF, 19, DIAGONAl, INF, 19, INF},
			 			 {INF,  INF, INF, INF, INF, INF, INF, 80, INF, 87, INF, INF, DIAGONAl, INF, 30},
			 			 {INF,  INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 19, INF, DIAGONAl, 20},
			 			 {INF,  INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 30, 20, DIAGONAl}
						};
				
		final int NUM_OF_NODE = 15;
		long startTime = System.nanoTime();
        
		for(int i = 0; i < NUM_OF_NODE; i++) { // to generate 15 matrix
			for(int j = 0; j < NUM_OF_NODE; j++) { // for the row
				for(int k = 0; k < NUM_OF_NODE; k++) { // for the column
					if(i != j && i != k && j != k) { // if take node 0, than column 0 and row 0 will not be considered, the diagonal will always be 0, so not considered
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]); // relaxation
					}
				}
			}
			// printing out result
			System.out.println("Matrix " + (i + 1));
			for(int count = 0; count < NUM_OF_NODE; count++) {
				for(int count2 = 0; count2 < NUM_OF_NODE; count2++) {
					System.out.print(graph[count][count2] + " ");
				}
				System.out.print("\n");
			}
			System.out.println("\n\n");
		}
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Time Execution:" + Float.valueOf(elapsedTime)/1000000000 + "sec" );
	}

}