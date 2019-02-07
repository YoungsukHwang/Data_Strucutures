
public class Coordinate {
	public int x;
	public int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	

}


//int gridX=7, gridY=10;
//Node test = mat[gridX+2][gridY+2];
//System.out.println("Test node:"+ test.getCoordinate()+" H:"+test.getHeight()+" #ofLinks:"+test.links.size());
//Iterator<Edge> iter = test.links.iterator();
//while(iter.hasNext()){
//	Edge e = iter.next();
//	System.out.println("Dest:" + e.dest.getCoordinate()+" H:"+e.dest.getHeight()+" Weight:"+e.weight);