import java.util.ArrayList;

public class myQueue extends ArrayList<Object> implements Queue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public myQueue() {
		super();
	} 

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public Object getFront() {
		return get(0);
	}

	@Override
	public Object getRear() {
		return get(size()-1);
	}

	@Override
	public void put(Object obj) {
		add(size(), obj);
	}

	@Override
	public Object remove() {
		return remove(0);
	}
	
}
