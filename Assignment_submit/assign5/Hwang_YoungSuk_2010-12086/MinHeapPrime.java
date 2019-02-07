
public class MinHeapPrime {
        private Edge[] heap;
        private int size = 0;
        
        public int getSize() {
                return size;
        }

        public MinHeapPrime(int i){
                 heap = new Edge[i];
        }
                
        public void insert(Edge k) {
                size++;
                int i = size;
                while(i > 1 && heap[parent(i)].getWeight() > k.getWeight()) {
                        heap[i] = heap[parent(i)];
                        i = parent(i);
                }
                heap[i] = k;
        }

        public Edge getMin(){
                if(size != 0)
                        return heap[1];
                return null;
        }
        
        public Edge delMin() {
                if(size != 0) {
                        Edge min = heap[1];
                        heap[1] = heap[size];
                        size--;
                        heapify(1);
                        return min;
                }
                return null;
        }
        
        public void heapify(int i) { // three cases - degree of node : 0, 1, 2. 0-leaf node : no need to rearrange, 1-only has left tree(node) - only check if the left child has to be swapped with the node(parent), 2- has the both children-full heapify.
                int l = left(i);
                int r = right(i);
                int smallest;
                if(r <= size) {// degree of node is 2
                        if(heap[l].getWeight() < heap[r].getWeight())
                                smallest = l;
                        else
                                smallest = r;

                        if(heap[i].getWeight() > heap[smallest].getWeight()) {
                                swap(i, smallest); //node swap
                                heapify(smallest); //heapify again from the index smallest, where the node we are dealing with is now at.
                        }
                }
                else if(l == size && heap[i].getWeight() > heap[l].getWeight()) { // Cases when the degree of node is 1
                        swap(i, l);
                }//do nothing if the degree of node is 0               

        }

        private void swap(int i, int l) {
                Edge tmp = heap[i];
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