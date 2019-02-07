import java.util.LinkedList;

public class Node {
	private int x;
	private int y;
	private double height;
	public LinkedList<Edge> links;
	double dval;
	
	public Node(int x, int y, double height){
		this.x =x;
		this.y =y;
		this.height = height;
		this.links = new LinkedList<>();
	}
	
	public double getHeight(){
		return height;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getCoordinate(){
		String str = new String();
		str+="("+x+","+y+")";
		return str;
	}

	public double getDval(){
		return dval;
	}
}
