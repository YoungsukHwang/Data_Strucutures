
public class MinHeap {
        private Node[] heap;
        private int size = 0;
        
        public int getSize() {
                return size;
        }

        public MinHeap(int i){
                 heap = new Node[i];
        }
                
        public void insert(Node k) {
                size++;
                int i = size; //Virtually Insert Node k to heap[size] first and then
                while(i > 1 &&  heap[parent(i)].getDval() > k.getDval()) { //Compare with it's parent until it finds its position.
                        heap[i] = heap[parent(i)]; //This is a swap with parent. 
                        i = parent(i); // again and again until parent is smaller than k.(k is larger than it's parent)
                }
                heap[i] = k; //Real insertion.
        }

        public Node getMin(){
                if(size != 0)
                        return heap[1];
                return null;
        }
        
        public Node delMin() {
                if(size != 0) {
                        Node min = heap[1]; //This is the min.
                        heap[1] = heap[size]; //Move heap[size](The last position) to heap[1](root). 
                        size--; // Shrink the size.
                        heapify(1); //From heap[1], find it's position
                        return min; // give min.
                }
                return null;
        }
        
        public int hasNode(Node n){
        	for(int i=1; i <= getSize(); i++)
        		if(heap[i].equals(n))
        			return i;
        	return -1;
        }
        
        public void changeKey(Node n, double d){
        	int target=0;
        	for(int i=1; i <= getSize(); i++)
        		if(heap[i].equals(n))
        			target =i;
        	heap[target].dval = d;
        	upheapify(target);		
        }

        private void upheapify(int target) {
			int parent = parent(target);
			int current = target;
			
			while( parent>=1 && heap[parent].dval > heap[current].dval){
				swap(parent, current);
				current = parent;
				parent = parent(current);
			}	
		}

		public void heapify(int i) { // three cases - degree of node : 0, 1, 2. 0-leaf node : no need to rearrange, 1-only has left tree(node) - only check if the left child has to be swapped with the node(parent), 2- has the both children-full heapify.
                int l = left(i);
                int r = right(i);
                int smallest;
                if(r <= size) {// degree of node is 2
                        if(heap[l].getDval() < heap[r].getDval())
                                smallest = l;
                        else
                                smallest = r;

                        if(heap[i].getDval() > heap[smallest].getDval()) {
                                swap(i, smallest); //node swap
                                heapify(smallest); //heapify again from the index smallest, where the node we are dealing with is now at.
                        }
                }
                else if(l == size && heap[i].getDval() > heap[l].getDval()) { // Cases when the degree of node is 1.(This is the only case when l==size)
                        swap(i, l);
                }//do nothing if the degree of node is 0               

        }

        private void swap(int i, int l) {
                Node tmp = heap[i];
                heap[i] = heap[l];
                heap[l] = tmp;
        }
        
        public int parent(int i) {
                return i/2;
        }
        
        public int left(int i) {
                return 2*i;
        }
        
        public int right(int i) {
                return 2*i+1;
        }
}