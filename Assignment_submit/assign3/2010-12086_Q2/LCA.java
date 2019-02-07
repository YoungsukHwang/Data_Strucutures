// 2010-12086 Hwang, Youngsuk
import java.util.ArrayList;

public class LCA {
	// A binary tree with every node containing a distinct number. (No two nodes
	// have the same data values.)

	public static void PrintCommonPath(Node root, int n1, int n2) {
		// Find the path common to the two paths from the root. If no common
		// path, then print "No Common Path"

		// Find paths
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> p2 = new ArrayList<>();

		findPath(root, n1, p1);
		findPath(root, n2, p2);

		System.out.println("Path from root to n1: " + p1.toString());
		System.out.println("Path from root to n2: " + p2.toString());
		// Compare paths and print the output.

		String str = new String("1");

		for (int i = 1; i < p1.size(); i++)
			if (p1.get(i).equals(p2.get(i)))
				str += "->" + p1.get(i);

		if (str.equals("1"))
			System.out.println("No Common Path");
		else
			System.out.println("Coomn Path:\n"+str);

	}

	public static boolean findPath(Node root, int n, ArrayList<Integer> arr) {

		if (root == null)
			return false;

		arr.add(new Integer(root.data));

		if (root.data == n)
			return true;

		if (findPath(root.left, n, arr) || findPath(root.right, n, arr))
			return true;

		arr.remove(arr.size() - 1);
		return false;
	}

	public static void main(String[] args) {

		System.out.println("2010-12086 Hwang, Youngsuk");
		System.out.println("My LCA Tree");
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.right.left = new Node(8);
		root.right.left.right = new Node(9);
		int n1 = 4, n2 = 8;

		PrintCommonPath(root, n1, n2);

	}

}
