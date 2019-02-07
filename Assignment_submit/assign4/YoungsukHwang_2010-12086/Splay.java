import java.util.ArrayList;

public class Splay {
	
	public Node root;

	public int[] sort(int[] arr, int numOfInts) {
		// TODO Auto-generated method stub
		// When using a splay tree as the binary search tree,
		// the resulting algorithm (called splaysort) has the additional property that it is an adaptive sort,
		// meaning that its running time is faster than O(n log n) for inputs that are nearly sorted.
		System.out.println("---Splaysort Starts---");
		
		for(int i=0; i<numOfInts; i++)
			put(new Node(arr[i]));
		
		ArrayList<Node> list = new ArrayList<>();
		inorder(list);
		
		int[] result = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			result[i]= list.get(i).data;
		
		return result; 
	}
	
	private void inorder(ArrayList<Node> list) {
		Splay left = new Splay();
		Splay right = new Splay();
		left.root = this.root.left;
		right.root = this.root.right;

		if (left.root != null)
			left.inorder(list);
		list.add(root);
		if (right.root != null)
			right.inorder(list);
		
	}

	public void put(Node n){
		if(root==null){
			root = n;
			return;
		}
		
		root = splay(root, n);
		
		if(root.getData() > n.getData()){
			n.left = root.left;
			n.right = root;
			root.left=null;
			root=n;
		}
		else if(root.getData() < n.getData()){
			n.right = root.right;
			n.left = root;
			root.right = null;
			root=n;
		}
		else{
			root.data = n.data;
		}
	}

	private Node splay(Node root, Node n) {
		if(root==null) return null;
		
		if( root.getData() > n.getData() ){ // n < rt
			if(root.left ==null) return root;
			
			if(root.left.getData() > n.getData()){
				root.left.left = splay(root.left.left, n);
				root = rotateRight(root);
			}
			else if(root.left.getData() < n.getData()){
				root.left.right = splay(root.left.right, n);
				if(root.left.right!=null)
					root.left = rotateLeft(root.left);
			}
			if(root.left==null) return root;
			else				return rotateRight(root);
		}
		
		else if (root.getData() < n.getData() ){ // rt < n
			if(root.right==null) return root;
			
			if( root.right.getData() > n.getData() ){
				root.right.left = splay(root.right.left, n);
				if( root.right.left != null)
					root.right = rotateRight(root.right);
			}
			else if( root.right.getData() < n.getData() ){
				root.right.right = splay(root.right.right, n);
				root = rotateLeft(root);
			}
			if(root.right == null) return root;
			else					return rotateLeft(root);
		}
		else return root;
	}
	
	private Node rotateRight(Node h) { //Zig
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
	}

	private Node rotateLeft(Node h) { //Zag
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}



}
