package allPair;


public class allPair {

	public static void main(String[] args) {
		final int INF = 100000;
		int graph[][] = {{0, 20, 40, INF, INF, INF},
						 {20, 0, 100, INF, INF, 70},
						 {40, 100, 0, 30, INF, INF},
						 {INF, INF, 30, 0, 180, INF},
						 {INF, INF, INF, 180, 0, 100},
						 {INF, 70, INF, INF, 100, 0},
				 		};
		
		final int NUM_OF_NODE = 6;
		for(int i = 0; i < NUM_OF_NODE; i++) { // to generate 6 matrix
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
	}

}