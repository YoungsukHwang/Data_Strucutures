public class Node {
	
	public Node next;
	public String str;
	
	public Node(){
		
	}
	
	public Node(String str){
		this.str = str; 
	}
	
	public Node(String str, Node next){
		this.str = str;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}
	public String getStr() {
		return str;
	}
}
