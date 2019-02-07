public class myArraylist implements ArrayList{
	
	public Object[] ary;
	public int size;
	
	public myArraylist(int initial) {
		if(initial<1)
			throw new IllegalArgumentException("Initial value must be >= 1");
		
		ary = new String[initial];
		size = 0;
	}
	
	public myArraylist() {
		this(10);
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) {
		if(index<0 || index >= size)
			throw new IndexOutOfBoundsException("index:"+index+" size:"+size+" IndexOutOfBounds");
		return ary[index];
	}

	@Override
	public int indexOf(Object elem) {
		
		for(int i=0;i<size;i++)
			if(ary[i].equals(elem)){
				return i;
			}
		return -1;
	}

	@Override
	public Object remove(int index) {
		if(index<0 || index >=size)
			throw new IndexOutOfBoundsException("Index:"+index+" size:"+size+" IndexOutofBounds");
		
		Object obj = ary[index];
		for(int i=index+1; i < size; i++)
			ary[i-1]=ary[i];
		
		ary[size-1]=null;		
		size--;
		return obj;
	}

	@Override
	public void add(int index, Object obj) {
		if(index<0 || index > size)
			throw new IndexOutOfBoundsException("Index:"+index+" size:"+size+" IndexOutofBounds");
		
		if(size==ary.length)
			ary = this.arrayResize(ary, 2*size);
		
		for(int i=size-1; i >= index; i--)
			ary[i+1]=ary[i];
		ary[index]=obj;
		size++;
	}

	private Object[] arrayResize(Object[] ary, int new_size) {
		// TODO Auto-generated method stub
		if(new_size <= ary.length)
			throw new IllegalArgumentException("Original size:"+ary.length+" New size:"+ new_size+"  Wrong size input");
		
		Object[] new_ary= new Object[new_size];
		System.arraycopy(ary, 0, new_ary, 0, ary.length);
		
		return new_ary;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer("{ ");
		for(int i=0; i<size; i++)
			s.append(ary[i]+" ");
		s.append("}");
		
		return new String(s);
	}

}
