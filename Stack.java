
public class Stack<E> {

	private E[] arr = null;
	private int CAP;
	private int top = -1;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int cap){
		this.CAP = cap;
		this.arr = (E[]) new Object[cap];
	}
	
	public E pop(){
		if(this.size == 0){
			return null;
		}
		this.size--;
		E result = this.arr[top];
		this.top--;
		
		return result;
	}
	
	public boolean push(E e){
		//if stack is full ie; capacity reached
		if(isFull()){
			return false;
		}
		this.size++;
		this.arr[++top] = e;
		return true;
	}
	
	public boolean isFull(){
		if(this.size == this.CAP){
			return true;
		}
		return false;
	}
	
	public String toString(){
		if(this.size == 0){
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<this.size; i++){
			sb.append(this.arr[i]+", ");
		}
		
		sb.setLength(sb.length()-2);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>(2);
		System.out.println(stack.push("hello"));
		System.out.println(stack.push("world"));
		System.out.println(stack.push("Aishwarya"));
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
}
