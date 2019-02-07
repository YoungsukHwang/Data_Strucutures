//2010-12086 Hwang, Young Suk
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class init {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("The program starts");
		
		//READ file
//		File file = new File("src/height.txt");
		 File file = new File("height.txt"); //for run on terminal.
		Scanner sc = new Scanner(file);
		//READ file and store Nodes on Data Structures. 2D array.
		ArrayList<Node> nodes = new ArrayList<>();
		Node[][] mat = new Node[24][24];
		int x_cnt = 0, y_cnt = 0;
		while (sc.hasNext()) {
			double d = Double.parseDouble(sc.next());
			if (d != -1){
				Node n = new Node(x_cnt, y_cnt, d);
				mat[x_cnt+2][y_cnt+2] = n;
				nodes.add(n);
			}
			y_cnt++;
			if (y_cnt == 20) {
				y_cnt = 0;
				x_cnt++;
			}
		}

		// Link nodes together.
		for (x_cnt = 2; x_cnt < 22; x_cnt++)
			for (y_cnt = 2; y_cnt < 22; y_cnt++) {
				Node current = mat[x_cnt][y_cnt];
				if (current != null) {
					LinkedList<Edge> curLinks = current.links;
					
					Node r1 = mat[x_cnt][y_cnt+1];
					Node r2 = mat[x_cnt][y_cnt+2];
					Node d1 = mat[x_cnt+1][y_cnt];
					Node d2 = mat[x_cnt+2][y_cnt];
					Node u1r1 = mat[x_cnt-1][y_cnt+1];
					Node d1r1 = mat[x_cnt+1][y_cnt+1];					
					
					if(r1 != null){
						double wsq = (r1.getHeight()-current.getHeight())*(r1.getHeight() -current.getHeight()) + 1; //Math.pow(root,2)
						Edge e = new Edge(r1, Math.sqrt(wsq));
						curLinks.add(e); r1.links.add(new Edge(current, Math.sqrt(wsq)));
					}
					if(r2 != null){
						double wsq = (r2.getHeight()-current.getHeight())*(r2.getHeight() -current.getHeight()) + 4;
						Edge e = new Edge(r2, Math.sqrt(wsq));
						curLinks.add(e); r2.links.add(new Edge(current, Math.sqrt(wsq)));
					}
					if(d1 != null){
						double wsq = (d1.getHeight()-current.getHeight())*(d1.getHeight() -current.getHeight()) + 1;
						Edge e = new Edge(d1, Math.sqrt(wsq));
						curLinks.add(e); d1.links.add(new Edge(current, Math.sqrt(wsq)));
					}
					if(d2 != null){
						double wsq = (d2.getHeight()-current.getHeight())*(d2.getHeight() -current.getHeight()) + 4;
						Edge e = new Edge(d2, Math.sqrt(wsq));
						curLinks.add(e); d2.links.add(new Edge(current, Math.sqrt(wsq)));
					}
					if(u1r1 != null){
						double wsq = (u1r1.getHeight()-current.getHeight())*(u1r1.getHeight() -current.getHeight()) + 4;
						Edge e = new Edge(u1r1, Math.sqrt(wsq));
						curLinks.add(e); u1r1.links.add(new Edge(current, Math.sqrt(wsq)));
					}
					if(d1r1 != null){
						double wsq = (d1r1.getHeight()-current.getHeight())*(d1r1.getHeight() -current.getHeight()) + 4;
						Edge e = new Edge(d1r1, Math.sqrt(wsq));
						curLinks.add(e); d1r1.links.add(new Edge(current, Math.sqrt(wsq)));
					}
				}
			}
		
		System.out.println("---Dijkstra---");
		Dijkstra dij = new Dijkstra(mat);
		dij.SSSP();
		
		System.out.println("---Prime---");
		Prime prime = new Prime(mat);
		prime.MST();
		
		System.out.println("The program ends");
	}
	
}

