import java.util.ArrayList;

public class BST {
	Node root;

	public BST() {
	}

	public BST(int[] arr, int numOfInts) {
		for(int i=0; i< numOfInts; i++)
			insert(arr[i]);
	}

	public int[] sort(int[] arr, int numOfInts) {
		System.out.println("---Binary Tree sort Starts---");
		for(int i=0; i< numOfInts; i++)
			insert(arr[i]);
		
		ArrayList<Node> list = new ArrayList<>();
		inorder(list);
		
		int[] result=new int[list.size()];
		for(int i=0; i<list.size(); i++)
			result[i]= list.get(i).data;		
		return result;
	}
	
	public void inorder(ArrayList<Node> list){
		BST left = new BST();
		BST right = new BST();
		left.root = this.root.left;
		right.root = this.root.right;

		if (left.root != null)
			left.inorder(list);
		list.add(root);
		if (right.root != null)
			right.inorder(list);
	}

	public void insert(int i) { // Question: dealing with object thing.
								// reference of BST.
		if (root == null)
			root = new Node(i);

		if (i < root.data && root.left == null)
			root.left = new Node(i);

		if (i > root.data && root.right == null)
			root.right = new Node(i);

		if (i < root.data) {
			BST left = new BST();
			left.root = this.root.left;
			left.insert(i);
		} else if (i > root.data) {
			BST right = new BST();
			right.root = this.root.right;
			right.insert(i);
		}
	}
}
