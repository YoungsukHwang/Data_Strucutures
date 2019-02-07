import java.util.ArrayList;

public class Prime {
	Node[][] mat;
	
	public Prime(Node[][] nodeMat){
		this.mat = nodeMat;
	}
	
	public void MST(){
		Node start = mat[19+2][19+2];
		
		MinHeapPrime heap = new MinHeapPrime(4000);
		ArrayList<Node> chosenNodes= new ArrayList<>();
		ArrayList<Edge> chosenEdges= new ArrayList<>();
		
		chosenNodes.add(start);
		for(Edge e : start.links){
			e.setEdgeFrom(start);
			heap.insert(e);
		}
		
		while(chosenEdges.size()<359){
			Edge chosen = heap.delMin();
			//if chosen edge is toward inside of the tree, skip it and delMin another.
			boolean outside = true;
			for(Node n : chosenNodes)
				if( n.equals(chosen.dest))
					outside = false;
			//if it is towards outside. Add it to chosenEdges and it's destination into chosenNodes.
			if(outside){
				chosenEdges.add(chosen);
				chosenNodes.add(chosen.dest);
				for(Edge e: chosen.dest.links){
					e.setEdgeFrom(chosen.dest);
					heap.insert(e);
				}
			}
		}
		
		double totalWeight=0;
		for(int i=0; i<chosenEdges.size(); i++){
			System.out.println(chosenEdges.get(i).edgeFrom.getCoordinate()+" "+ chosenEdges.get(i).dest.getCoordinate());
			totalWeight+=chosenEdges.get(i).weight;
		}
		System.out.println("Weight: "+totalWeight);
		System.out.println("Total number of edges: "+chosenEdges.size());
		System.out.println("Prime Algorithm Ends");
	}
}
