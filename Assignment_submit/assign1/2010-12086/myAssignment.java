//Youngsuk Hwang 2010-12086
import java.util.*;

public class myAssignment {

	public static void main(String[] args) {

		Interact inter = new Interact();
		String action = new String();
		
		long curTime = System.currentTimeMillis();

		boolean quitMark = false;
		inter.menu();
		do {
			System.out.println("What action would you like to perform?");
			Scanner input = new Scanner(System.in);
			action = input.nextLine();

			if (action.equals("a") || action.equals("A")) { // Add String
				System.out.println("Please enter a string to add:");
				String adding = new String();
				adding = input.nextLine();
				System.out.println("Please enter an index to add:");
				int index = input.nextInt();
				while (index < 0 || index > inter.myl.size) {
					System.out.println("The last index is " + (inter.myl.size) ); ///-1?
					System.out.println("Please enter an index to add:");
					index = input.nextInt();
				}
				inter.myl.add(index, adding);

			} else if (action.equals("c") || action.equals("C")) { // Check if Empty
				inter.checkIfEmpty();
			} else if (action.equals("e") || action.equals("E")) { // Search for String
																	
				System.out.println("Please enter an index to search:");
				int index = input.nextInt();
				while (index < 0 || index > inter.myl.size - 1) {
					System.out.println("The index you want is not in the list");
					System.out.println("Please enter an index to search:");
					index = input.nextInt();
				}
				System.out.println("string at the given index is " + inter.myl.get(index));

			} else if (action.equals("l") || action.equals("L")) { // List String
				inter.listStrings();
			} else if (action.equals("o") || action.equals("O")) { //List CurrentSize
				inter.listCurrentSize();
			} else if (action.equals("q") || action.equals("Q")) { // Quit
				quitMark = true; // quit
			} else if (action.equals("r") || action.equals("R")) { // Remove
				
				System.out.println("Please enter an index to remove:");
				int index = input.nextInt();
				while (index < 0 || index > inter.myl.size - 1) {
					System.out.println("It does not exist");
					System.out.println("Please enter the index of a string to remove:");
					index = input.nextInt();
				}
				Object obj =inter.myl.remove(index);
				System.out.println( obj+" was removed");
			} else if (action.equals("t") || action.equals("T")) {
				inter.reverse();
			} else if (action.equals("u") || action.equals("U")) {
				inter.removeDuplicates();
			} else if (action.equals("?")) {
					inter.menu();
			} 

		} while (quitMark == false);

		//System.out.println("This is the end of the program");
		long elapsedTime= System.currentTimeMillis();
		//System.out.println(elapsedTime - curTime);
	}

}
