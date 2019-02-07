import java.util.NoSuchElementException;

public class myLinkedList implements LinkedList {

	Node head;
	int size;
	Node iter;

	public myLinkedList() {
		head = null;
		size = 0;
	}

	public void resetIter() {
		this.iter = head;
	}

	@Override
	public Object next() {
		if (iter.next == null)
			throw new NoSuchElementException();

		iter = iter.next;
		return iter.str;
	}

	@Override
	public boolean hasNext() {
		return iter.next != null;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

	public void checkIndex(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("index=" + index + " size=" + size);
	}

	@Override
	public Object get(int index) { //Object return type <- String instance. Upcasting.
		checkIndex(index);

		resetIter();
		for (int i = 0; i < index; i++)
			iter = iter.next;
		return iter.str;
	}

	@Override
	public int indexOf(Object elem) { //Object type elem comes, but can be instances of Node.
		resetIter();
		int index = 0;
		while (iter != null && !iter.equals(elem)) {
			iter = iter.next;
			index++;
		}
		if (iter == null)
			return -1;
		else
			return index;
	}

	@Override
	public Object remove(int index) {
		checkIndex(index);

		resetIter();
		Object obj;
		if (index == 0) {
			obj = head.str;
			head = head.next;
		} else {
			for (int i = 0; i < index - 1; i++) {
				iter = iter.next;
			}
			obj = iter.next.str;
			iter.next = iter.next.next;
		}
		size--;
		return obj;
	}

	@Override
	public void add(int index, Object obj) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index=" + index + " size=" + size);

		if (index == 0) {
			head = new Node(obj.toString(), head);
		} else {
			resetIter();
			for (int i = 0; i < index - 1; i++) {
				iter = iter.next;
			}
			iter.next = new Node(obj.toString(), iter.next);
		}
		size++;
	}

	public String toString() {
		String rtn = new String();
		rtn = "{ ";
		if (size == 0) {

		} else {
			resetIter();
			for (int i = 0; i < size; i++) {
				rtn += iter.str+" ";
				iter = iter.next;
			}
		}
		rtn+="}";
		return rtn;
	}

}
