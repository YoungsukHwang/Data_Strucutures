
public class Heap {
	private Node[] heap;
	private int size = 0;

	public Heap(int[] arr, int numOfInts) {
			heap = new Node[numOfInts*2];
	}

	public int[] sort1(int[] arr, int numOfInts) {
		// Heap Sort without initialization
		System.out.println("---Heap sort without initialization Starts---");
		for(int i=0; i<numOfInts; i++)
			insert( new Node(arr[i]) );
		
		int[] result=new int[numOfInts];
		for(int i=0; i<numOfInts;i++)
			result[i] = delMin().getData(); 
		return result;
	}

	public int[] sort2(int[] arr, int numOfInts) {
		// Heap Sort with initialization
		System.out.println("---Heap sort with initialization Starts---");
		for(int i=0; i<numOfInts; i++)
			insert( new Node(arr[i]) );
		//Now we have non-heapified compelete binary tree. Let's make it heapified.
		for(int root= size/2; root>=1; root--){
			Node rt = heap[root];
			int child = 2 * root;
			while(child<=size){ //when child is existing.
				if(child<size && heap[child].getData()>heap[child+1].getData()) child++; //pick up smaller sibling. 
				
				if(rt.getData() <= heap[child].getData()) //if min-heap property is valid, break;
					break;
				
				heap[child/2] = heap[child]; //if not, copy smaller sibling into the original root index.
				child*=2; //with the botton assignemnt(heap[child/2]=rt), copy the original root into where the original child was. 
			}
			heap[child/2] = rt;
		}
		// Remove-min one by one to execute sorting.
		int[] result=new int[numOfInts];
		for(int i=0; i<numOfInts;i++)
			result[i] = delMin().getData(); 
		return result;
	}

	public int getSize() {
		return size;
	}

	public void insert(Node k) {
		size++;
		int i = size;
		while (i > 1 && heap[parent(i)].getData() > k.getData()) {
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = k;
	}

	public Node getMin() {
		if (size != 0)
			return heap[1];
		return null;
	}

	public Node delMin() {
		if (size != 0) {
			Node min = heap[1];
			heap[1] = heap[size];
			size--;
			heapify(1);
			return min;
		}
		return null;
	}

	public void heapify(int i) { // three cases - degree of node : 0, 1, 2. 
									// 0-leaf node : no need to rearragne.
									// 1-only has left tree(node) - only check if the left child has to be swapped with the node(parent).
									// 2- has the both children-full heapify.
		int l = left(i);
		int r = right(i);
		int smallest;
		if (r <= size) {// degree of node is 2
			if (heap[l].getData() < heap[r].getData())
				smallest = l;
			else
				smallest = r;

			if (heap[i].getData() > heap[smallest].getData()) {
				swap(i, smallest); // node swap
				heapify(smallest); // heapify again from the index smallest, where the node we are dealing with is now at.
			}
		} else if (l == size && heap[i].getData() > heap[l].getData()) { // Cases When dgr is 1.
			swap(i, l);
		} // do nothing if the degree of node is 0

	}

	private void swap(int i, int l) {
		Node tmp = heap[i];
		heap[i] = heap[l];
		heap[l] = tmp;
	}

	public int parent(int i) {
		return i / 2;
	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

}
