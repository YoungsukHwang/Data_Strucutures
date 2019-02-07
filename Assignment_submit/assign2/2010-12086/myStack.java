import java.util.EmptyStackException;

public class myStack implements Stack {
	
	int top;
	Object[] stack;
	
	public myStack(int initalSize){
		if(initalSize<1)
			throw new IllegalArgumentException();
		
		top=-1;
		stack = new Object[initalSize];
	}
	public myStack(){
		this(10);
	}

	@Override
	public boolean empty() {
		return top==-1;
	}

	@Override
	public Object peek() {
		return stack[top];
	}

	@Override
	public void push(Object obj) {
		if(top == stack.length-1){
			Object[] newStack = new Object[stack.length*2];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			stack = newStack;
		}
		stack[++top]=obj;
	}

	@Override
	public Object pop() {
		if(empty())
			throw new EmptyStackException();
		Object topElem = stack[top];
		stack[top--]=null;
		return topElem;
	}
	
	public String toString(){
		String str = new String("This is a path.\n");
		
		while(!this.empty())
			str += this.pop().toString();
		return str;
	}
	
}
