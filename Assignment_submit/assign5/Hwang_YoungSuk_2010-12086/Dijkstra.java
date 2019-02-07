import java.text.DecimalFormat;

public class Dijkstra {
	Node[][] mat;

	public Dijkstra() {

	}
	public Dijkstra(Node[][] nodeMat) {
		this.mat = nodeMat;
	}
	
	public void SSSP(){
		Node start = mat[2][2];
		MinHeap heap = new MinHeap(400);
		
		start.dval = 0;
		heap.insert(start);
		for(int i=0; i<mat.length;i++)
			for(int j=0; j<mat[0].length;j++)
				if(mat[i][j]!=null && !(i==2&&j==2) ){
					mat[i][j].dval = Double.MAX_VALUE;
					heap.insert(mat[i][j]);
				}
		
		Coordinate[][] pre = new Coordinate[20][20];
		while(heap.getSize()>0){
			Node current = heap.delMin();
			for(Edge e: current.links)
				if(heap.hasNode(e.dest)!=-1 &&  current.dval+e.weight<e.dest.dval){
					heap.changeKey(e.dest, current.dval+e.weight);
					pre[e.dest.getX()][e.dest.getY()] = new Coordinate(current.getX(), current.getY());
				}
		}
		
//		for(int i=0; i<mat.length;i++)
//			for(int j=0; j<mat[0].length;j++)
//				if(mat[i][j]!=null)
//					heap.insert(mat[i][j]);
//		
//		for(int i=1; i<= 360; i++){
//			Node n = heap.delMin();
//			System.out.println("(0-0) "+"to "+n.getCoordinate()+" dval:"+new DecimalFormat("##.##").format(n.dval)+" Path:"+findPath(new Coordinate(n.getX(), n.getY()), pre, new String()));
//		}
//		System.out.println("SSSP done");
	
		for(int i=0; i<mat.length;i++)
			for(int j=0; j<mat[0].length;j++)
				if(mat[i][j]!=null){
					Node n = mat[i][j];
					System.out.println("(0-0) "+"- "+n.getCoordinate()+": "+new DecimalFormat("##.##").format(n.dval)+" "+findPath(new Coordinate(n.getX(), n.getY()), pre, new String()));
				}
		System.out.println("SSSP done");
		
	}
	
	public String findPath(Coordinate n, Coordinate[][] pre, String str){
		if(n==null)
			return "";
		str= findPath(pre[n.x][n.y], pre, str)+" ("+n.x+","+n.y+")";
		return str;
	}
	

}
