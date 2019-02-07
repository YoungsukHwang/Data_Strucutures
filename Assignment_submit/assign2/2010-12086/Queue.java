
public interface Queue {
	public boolean isEmpty();
	public Object getFront();
	public Object getRear();
	public void put(Object obj);
	public Object remove();
}
