
public class SwapNodePairs {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node swapNode(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node h = new Node(0);
		h.next = head;
		Node p = h;
		while(p.next != null && p.next.next != null){
			Node t1 = p;
			p = p.next;
			t1.next = p.next;
			
			Node t2 = p.next.next;
			p.next.next = p;
			p.next = t2;
			
		}
		return h.next;
	}
	
	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		SwapNodePairs snp = new SwapNodePairs();
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		snp.display(head);
		Node res = snp.swapNode(head);
		snp.display(res);
	}
}
