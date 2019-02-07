
public class coordinate {
	private int row;
	private int col;
	private int rank;
	
	public coordinate(int row, int col, int rank){
		this.setRow(row);
		this.setCol(col);
		this.setRank(rank);
	}
	
	public coordinate(int row, int col){
		this.setRow(row);
		this.setCol(col);
	}
	public coordinate(){
		
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public String toString(){
		return "<"+row+","+col+">";
	}
	
	public coordinate compare(coordinate o1, coordinate o2){
		int row_dis = o2.getRow() - o1.getRow();
		int col_dis = o2.getCol() - o1.getCol();
		coordinate comp = new coordinate(row_dis, col_dis);
		return comp;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
