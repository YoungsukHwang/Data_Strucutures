// 2010-12086 Hwang, Youngsuk
public class MyTree01 {

	Node root;

	public MyTree01(String preorder) {
		// For given string of preorder expression, construct a binary tree.
		root = new Node();
		Expression Exp = new Expression(preorder);

		root = root.MakeBinaryTree(Exp);
	}

	public MyTree01(Node n) {
		root = n;
	}

	public String postorder() {
		if (this.root.left == null && this.root.right == null)
			return Character.toString(this.root.getData());

		MyTree01 mtl = new MyTree01(this.root.left);
		MyTree01 mtr = new MyTree01(this.root.right);

		String str = new String();
		str += mtl.postorder();
		str += mtr.postorder();
		str += this.root.getData();

		return str;
	}

	public String inorder() {
		// Watch out inserting parenthesis.
		if (this.root.left == null && this.root.right == null)
			return Character.toString(this.root.getData());

		MyTree01 mtl = new MyTree01(this.root.left);
		MyTree01 mtr = new MyTree01(this.root.right);

		String str = new String();
		str += "(";
		str += mtl.inorder();
		str += this.root.getData();
		str += mtr.inorder();
		str += ")";

		return str;
	}

	public String levelorder() {
		String str = new String();
		myQueue q = new myQueue();
		
		Node temp = root;
		while (temp != null) {
			str += temp.getData();
			q.add(temp.left);
			q.add(temp.right);
			temp = (Node) q.remove();
			
			if(temp==null)
				while(temp==null && !q.isEmpty())
					temp = (Node) q.remove();
		}

		return str;
	}

	public static void main(String[] args) {
		
		System.out.println("2010-12086 Hwang, Youngsuk");
		System.out.println("Construction");
		String preorder = "--xy*+st/xs";
		MyTree01 mt = new MyTree01(preorder);

		System.out.println("Tree preorder Overview");
		System.out.print(mt.root.getData());
		System.out.print(mt.root.left.getData());
		System.out.print(mt.root.left.left.getData());
		System.out.print(mt.root.left.right.getData());
		System.out.print(mt.root.right.getData());
		System.out.print(mt.root.right.left.getData());
		System.out.print(mt.root.right.left.left.getData());
		System.out.print(mt.root.right.left.right.getData());
		System.out.print(mt.root.right.right.getData());
		System.out.print(mt.root.right.right.left.getData());
		System.out.print(mt.root.right.right.right.getData());

		System.out.println("\nPostorder, inorder, levelorder");
		System.out.println("Postorder: " + mt.postorder());
		System.out.println("Inorder: " + mt.inorder());
		System.out.println("Levelorder: "+ mt.levelorder());

	}

}
