/* Determine whether a linked list has a cycle*/
public class LLCycle {
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public boolean hasCycle(Node head){
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LLCycle llc = new LLCycle();
		head = new Node(10);
		head.next = new Node(13);
		head.next.next = new Node(23);
		head.next.next.next = new Node(33);
		head.next.next.next.next = head.next.next;
		
		System.out.println(llc.hasCycle(head));
	}

}
