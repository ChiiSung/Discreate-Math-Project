package ds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		// create a graph that consists all the distance between two stations
		int graph[][] = new int [][]{{ 0, 24, 40, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						 			 {24, 0, 0, 60, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						 			 {40, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						 			 {55, 60, 19,0, 25, 93, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						 			 {0, 80, 0, 25, 0 ,0, 40, 0, 0, 0, 0, 0, 0, 0, 0},
						 			 {0,  0, 0, 93, 0, 0, 0, 70, 0, 0, 0, 0, 0, 0, 0},
						 			 {0,  0, 0, 0, 40, 0, 0, 120, 43, 0, 0, 0, 0, 0, 0},
						 			 {0,  0, 0, 0, 0, 70, 120, 0, 0, 0, 56, 0, 80, 0, 0},
						 			 {0,  0, 0, 0, 0, 0, 43, 0, 0, 42, 0, 0, 0, 0, 0},
						 			 {0,  0, 0, 0, 0, 0, 0, 0, 42, 0, 76, 0, 87, 0, 0},
						 			 {0,  0, 0, 0, 0, 0, 0, 56, 0, 76, 0, 19, 0, 0, 0},
						 			 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 19, 0},
						 			 {0,  0, 0, 0, 0, 0, 0, 80, 0, 87, 0, 0, 0, 0, 30},
						 			 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 20},
						 			 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
									};
		
		String stations[] = {"Kuala Lumpur", "Shah Alam", "Nilai", "Seremban", "Rembau", "Segamat", "Ayer Keroh", "Kluang", "Muar", "Batu Pahat",
								"Kulai", "Johor Bahru Sentral", "Nusa Jaya", "Woolands, Singapore", "Jurong East, Singapore"};
		
		double price[][] = new double [][]{{ 0, 40, 15, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
											 {40, 0, 0, 70, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											 {15, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											 {50, 70, 25,0, 6, 62, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 32, 0, 6, 0 ,0, 40, 0, 0, 0, 0, 0, 0, 0, 0},
											 {0,  0, 0, 62, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0},
											 {0,  0, 0, 0, 40, 0, 0, 58, 33, 0, 0, 0, 0, 0, 0},
											 {0,  0, 0, 0, 0, 35, 58, 0, 0, 0, 17, 0, 32, 0, 0},
											 {0,  0, 0, 0, 0, 0, 33, 0, 0, 42, 0, 0, 0, 0, 0},
											 {0,  0, 0, 0, 0, 0, 0, 0, 42, 0, 65, 0, 61, 0, 0},
											 {0,  0, 0, 0, 0, 0, 0, 17, 0, 65, 0, 5, 0, 0, 0},
											 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 20, 0},
											 {0,  0, 0, 0, 0, 0, 0, 20, 0, 61, 0, 0, 0, 0, 10},
											 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 42},
											 {0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
											};
										  
		// create a 2d AraryList to store the min path
		ArrayList<List<String>> path = new ArrayList<List<String>>(stations.length);
		
		// create ArrayList for each element in the 2d ArrayList
		for(int i = 0; i <  stations.length; i++) {
			path.add(new ArrayList<String>());
		}
		// Add reference station for each ArrayList
		for(int i = 0; i < stations.length; i++) {
			path.get(i).add(stations[i]);
		}
		Dijkstra g = new Dijkstra();
		g.dijkstraAlgorithm(graph, path, 0, price);
	}

}
