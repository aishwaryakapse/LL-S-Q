class Node {
	int data;
	Node next;
	Node(int d) {
		data = d;
		next = null;
	}
}
public class ReverseBetween {
	public Node reverseBetween(Node head, int m, int n) {
		if(m == n) {
			return head;
		}
		
		Node prev = null;
		Node first = new Node(0);
		Node second = new Node(0);
		
		int i = 0;
		Node p = head;
		while(p != null) {
			System.out.println("Inside while :");
			i++;
			if(i == m-1) {
				prev = p;
			}
			
			if(i == m) {
				first.next = p;
			}
			
			if(i == n) {
				second.next = p.next;
			}
			
			p = p.next;
		}
		//check if for nodes
		if(first.next == null) {
			return head;
		}
		
		Node p1 = first.next;
		Node p2 = p1.next;
		p1.next = second.next;
		
		while(p1 != null && p2 != null) {
			Node t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}
		
		//connect to previous part
		if(prev != null) {	
			prev.next = p1;
		}else{
			return p1;
		}
		return head;
	}
	
	public void display(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	public static void main(String[] args) {
		ReverseBetween rb = new ReverseBetween();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		System.out.println("The list is: ");
		rb.display(head);
		rb.reverseBetween(head, 1, 3);
		System.out.println("The list after reverse between : ");
		rb.display(head);

	}

}
