
public class ReverseLL {

	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node reverse_iter(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node prev = null;
		Node next = null;
		Node curr = head;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public Node reverse_recur(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		//get a second node
		Node second = head.next;
		head.next = null;
		
		Node rest = reverse_recur(second);
		second.next = head;
		
		return rest;
	}

	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ReverseLL rll = new ReverseLL();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		rll.display(head);
		Node res = rll.reverse_iter(head);
		rll.display(res);
		Node res1 = rll.reverse_recur(res);
		rll.display(res1);
	}

}
