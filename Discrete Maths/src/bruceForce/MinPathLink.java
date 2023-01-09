package bruceForce;

import java.util.ArrayList;

class Node {
	String location;
	ArrayList<Node> next = new ArrayList<>();
	ArrayList<Double> distance = new ArrayList<>();
	ArrayList<String> path = new ArrayList<>();
	ArrayList<Double> total = new ArrayList<>();
	ArrayList<Double> price = new ArrayList<>();
	ArrayList<Double> ticket = new ArrayList<>();
	
	Node(String location) {
		this.location = location;
	}
	
	public void addNode(Node node, double distance, double ticket) {
		this.next.add(node);
		this.distance.add(distance);
		this.ticket.add(ticket);
	}
	
	public void findPath(Node head, String lastPath, double lastDistance, double lastticket) {
		Node temp = head;
		
		if(lastPath.equalsIgnoreCase("")) {
			lastPath += temp.location;
		}else {
			lastPath += " -> " + temp.location;
		}
		if(temp.next.size() == 0) {
			path.add(lastPath);
			total.add(lastDistance);
			price.add(lastticket);
			return;
		}else {
			for(int i=0 ; i<temp.next.size() ; i++) {
				lastDistance += temp.distance.get(i);
				lastticket += temp.ticket.get(i);
				
				if(i>= 1) {
					lastDistance -= temp.distance.get(i-1);
					lastticket -= temp.ticket.get(i-1);
				}
				findPath(temp.next.get(i), lastPath, lastDistance, lastticket);
				
			}
		}
	}
}

class Graph {
	Node head;
	Graph(Node node){
		this.head = node; 
	}	
	
	public int minDistance(Node head) {
		int min = 0;
		double minDis = head.total.get(0);
		for(int i=0 ; i<head.total.size() ; i++) {
			if(minDis > head.total.get(i)) {
				minDis = head.total.get(i);
				min = i;
			}
		}
		return min;
	}
}

public class MinPathLink {

	public static void main(String[] args) {
		Node kl = new Node("Kuala Lumpur");
		Node nl = new Node("Nilai");
		Node sa = new Node("Shah Alam");
		Node srb = new Node("Seremban");
		Node rb = new Node("Rembau");
		Node sg = new Node("Segamat");
		Node ak = new Node("Ayer Keroh");
		Node mr = new Node("Muar");
		Node kg = new Node("Kluang");
		Node bp = new Node("Batu Pahat");
		Node ku = new Node("Kulai");
		Node jbs = new Node("Johor Bahru Sentral");
		Node nj = new Node("Nusa Jaya");
		Node je = new Node("Jurong East, Singapore");
		Node wl = new Node("Woodland, Singapore");
		
		Graph graph = new Graph(kl);
		
		kl.addNode(sa,24,40);
		kl.addNode(nl,40,15);
		kl.addNode(srb,55,50);
		sa.addNode(rb,80,32);
		sa.addNode(srb,60,70);
		nl.addNode(srb,19,25);
		srb.addNode(sg,93,62);
		sg.addNode(kg,70,35);
		rb.addNode(ak,40,40);
		ak.addNode(kg,120,58);
		ak.addNode(mr,43,33);
		mr.addNode(bp,42,42);
		bp.addNode(nj,87,61);
		nj.addNode(je,30,10);
		srb.addNode(rb,25,6);
		kg.addNode(ku,56,17);
		kg.addNode(nj,80,20);
		ku.addNode(jbs,19,20);
		jbs.addNode(wl,19,20);
		wl.addNode(je,20,42);
		bp.addNode(ku,76,65);
		
		long startTime = System.nanoTime();
		
		graph.head.findPath(graph.head,"",0,0);
		
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Execution:" + Float.valueOf(elapsedTime)/1000000000 + "sec" );
	
        System.out.println("Distance(Km) \tPrice(RM) \tPath");
        System.out.println("-------------------------------------------------------------");
        
		for(int i=0 ; i<graph.head.path.size() ; i++) {
				System.out.println( graph.head.total.get(i) + "\t\t" + graph.head.price.get(i) + "\t\t" + graph.head.path.get(i) );
		}
		
		int a = graph.minDistance(graph.head);
		System.out.println("\n\nThe minimun path is :" + graph.head.path.get(a));
		System.out.println("Distance:" + graph.head.total.get(a) + "km\n" + "Price\t:RM" + graph.head.price.get(a));
	}
}
