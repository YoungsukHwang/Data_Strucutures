import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class myMazeSolver {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Read file
		System.out.println("The program starts");
		File file = new File("./maze1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String rowcol = br.readLine();
		int rowNum = Integer.parseInt(rowcol.substring(0, 1));
		int colNum = Integer.parseInt(rowcol.substring(2, 3));
		int[][] maze = new int[rowNum][colNum];

		String st;
		for (int i =0; i < rowNum; i++) {
			st = br.readLine();
			for (int j =0; j < colNum; j++)
				maze[i][j] = (int) new Integer(st.substring(2 * (j), 2 * (j) + 1));
		}
		System.out.println("The input maze");
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++)
				System.out.print(maze[i][j]);
			System.out.print("\n");
		}
		
		String lastline = br.readLine();
		int sx = Integer.parseInt(lastline.substring(0, 1)), sy = Integer.parseInt(lastline.substring(2, 3));
		br.close();

		// Solve maze
		myStack s = new myStack();
		myQueue q = new myQueue();
		
		coordinate current = new coordinate(sx, sy);
		current.setRank(0);
		System.out.println("The coordinate index of the starting point is " + current.toString());
		
		q.put(current);
		maze[sx][sy] = 10;
		//Lee's algorithm
		do{
			//Upward
			if( current.getRow() !=0 && maze[current.getRow()-1][current.getCol()]==1 ){
				q.put(new coordinate(current.getRow()-1, current.getCol(), current.getRank()+1));
				maze[current.getRow()-1][current.getCol()] = 10 + current.getRank() + 1;
			}
			//Rightward
			if( current.getCol() != colNum-1 && maze[current.getRow()][current.getCol()+1]==1 ){
				q.put(new coordinate(current.getRow(), current.getCol()+1, current.getRank()+1));
				maze[current.getRow()][current.getCol()+1] = 10 + current.getRank() + 1;
			}
			//Downward
			if( current.getRow() != rowNum-1 && maze[current.getRow()+1][current.getCol()]==1 ){
				q.put(new coordinate(current.getRow()+1, current.getCol(), current.getRank()+1));
				maze[current.getRow()+1][current.getCol()] = 10 + current.getRank() + 1;
			}
			//Leftward
			if( current.getCol() != 0 && maze[current.getRow()][current.getCol()-1]==1 ){
				q.put(new coordinate(current.getRow(), current.getCol()-1, current.getRank()+1));
				maze[current.getRow()][current.getCol()-1] = 10 + current.getRank() + 1;
			}
			q.remove();
			current = (coordinate) q.getFront();
		}while(current.getRow()!=0 && current.getCol()!=0 && current.getRow()!=rowNum-1 && current.getCol()!=colNum-1); //until hit a wall
		
		System.out.println("The maze after lee's algorithm");
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++)
				System.out.print(maze[i][j]+"\t");
			System.out.print("\n");
		}
		
		s.push(current);
		while( !(current.getRow()==sx && current.getCol()==sy) ){
			int currentRank = maze[current.getRow()][current.getCol()];
			
			if (current.getRow() !=0 &&  maze[current.getRow()-1][current.getCol()] == currentRank-1){ //UP
				s.push(new coordinate(current.getRow()-1, current.getCol()));
			}else if(current.getCol() !=colNum-1 && maze[current.getRow()][current.getCol()+1] == currentRank-1){ //Right
				s.push(new coordinate(current.getRow(), current.getCol()+1));
			}else if(current.getRow() != rowNum-1 && maze[current.getRow()+1][current.getCol()] == currentRank-1){ // Down
				s.push(new coordinate(current.getRow()+1, current.getCol()));
			}else if( current.getCol() !=0 && maze[current.getRow()][current.getCol()-1] == currentRank-1){ // Left
				s.push(new coordinate(current.getRow(), current.getCol()-1));
			}
			current = (coordinate) s.peek();
			;
		}

		System.out.println(s.toString());
		System.out.println("The program ends");
	}

}
