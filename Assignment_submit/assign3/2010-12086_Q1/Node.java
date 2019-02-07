
public class Node { //Node for Question 1
	char data;
	Node left;
	Node right;

	public Node(String elem) {
		data = elem.charAt(0);
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node MakeBinaryTree(Expression exp) {
		String elem = exp.giveCurrent(exp.getCur());
		exp.increment();

		if (elem.matches("[0-9a-z]")) {
			return new Node(elem);
		} else { // operator input
			Node op = new Node(elem);
			op.left = MakeBinaryTree(exp);
			op.right = MakeBinaryTree(exp);
			return op;
		}

	}

}
