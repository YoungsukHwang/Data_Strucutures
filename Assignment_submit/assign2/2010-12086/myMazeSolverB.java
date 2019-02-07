import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myMazeSolverB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Read file
		System.out.println("The B program starts");
		File file = new File("./maze2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String rowcol = br.readLine();
		int rowNum = Integer.parseInt(rowcol.substring(0, 1));
		int colNum = Integer.parseInt(rowcol.substring(2, 3));
		int[][] maze = new int[rowNum][colNum];

		String st;
		for (int i = 0; i < rowNum; i++) {
			st = br.readLine();
			for (int j=0; j < colNum; j++)
				maze[i][j] = (int) new Integer(st.substring(2*j, 2*j+1));
		}
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++)
				System.out.print(maze[i][j]);
			System.out.print("\n");
		}
		String lastline = br.readLine();
		int sx = Integer.parseInt(lastline.substring(0, 1)), sy = Integer.parseInt(lastline.substring(2, 3));
		br.close();
		
		coordinate start = new coordinate(sx,sy);
		coordinate end = findEnd(maze, start);
		//System.out.println("Start " + start.toString() +" End "+ end.toString());
		
		List<coordinate> path = findLongestPath(maze, start, end);
		for(coordinate c : path)
			System.out.print(c.toString());	
		
		System.out.println("\nThe program ends");
	}

	private static coordinate findEnd(int[][] maze, coordinate start) {
		coordinate end = new coordinate();
		int m = maze.length, n = maze[0].length;
		
		for(int i=0; i< n; i++)
			if(maze[0][i]==1){
				if(start.getRow()==0 && start.getCol()==i){
					System.out.println("You found start");
				}else{
					end = new coordinate(0,i);
				}
			}
		for(int i=0; i< n; i++)
			if(maze[m-1][i]==1){
				if(start.getRow()==m-1 && start.getCol()==i){
					System.out.println("You found start");
				}else{
					end = new coordinate(m-1,i);
				}
			}
		for(int i=0; i< m; i++)
			if(maze[i][0]==1){
				if(start.getRow()==i&&start.getCol()==0){
					System.out.println("You found start");
				}else{
					end = new coordinate(i,0);
				}
			}
		for(int i=0; i< m; i++)
			if(maze[i][n-1]==1){
				if(start.getRow()==i && start.getCol()==n-1){
					System.out.println("You found start");
				}else{
					end = new coordinate(i,n-1);
				}
			}
		return end;
	}

	private static List<coordinate> findLongestPath(int[][] maze, coordinate start, coordinate end) {
		List<coordinate> result = null;
		int rows = maze.length;
		int cols = maze[0].length;
		if(start.getRow()<0 || start.getCol()<0)
			return null;
		if(start.getRow() == rows || start.getCol() == cols)
			return null;
		if(maze[start.getRow()][start.getCol()] == 0)
			return null;
		if(start.getRow()==end.getRow() && start.getCol()==end.getCol() ){
			List<coordinate> path = new ArrayList<coordinate>();
			path.add(start);
			return path;
		}
		
		maze[start.getRow()][start.getCol()] = 0;
		coordinate[] nextCoordinate = new coordinate[4];
		nextCoordinate[0]= new coordinate(start.getRow()-1, start.getCol()); //up
		nextCoordinate[1]= new coordinate(start.getRow(), start.getCol() +1); //right
		nextCoordinate[2]= new coordinate(start.getRow()+1, start.getCol()); //down
		nextCoordinate[3]= new coordinate(start.getRow(), start.getCol()-1); //left
		
		int maxLength = Integer.MIN_VALUE;
		for(coordinate nextCo : nextCoordinate){
			List<coordinate> path = findLongestPath(maze, nextCo, end);
			if(path !=null && path.size()> maxLength){
				maxLength = path.size();
				path.add(0, start);
				result = path;
			}
		}
		maze[start.getRow()][start.getCol()] = 1;
		if(result ==null||result.size()==0)
			return null;
		
		return result;
	}

}
