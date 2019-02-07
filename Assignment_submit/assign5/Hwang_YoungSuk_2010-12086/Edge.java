
public class Edge {
	public Node dest;
	public double weight;
	
	public Node edgeFrom;
	
	public Edge(Node destination, double d) {
		this.dest = destination;
		this.weight = d;
	}

	public double getWeight() {
		return weight;
	}

	public void setEdgeFrom(Node from) {
		this.edgeFrom = from;
	}
	

}
