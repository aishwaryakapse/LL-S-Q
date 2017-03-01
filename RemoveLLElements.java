
public class RemoveLLElements {
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}

	public Node removeElements(Node head, int val){
		Node helper = new Node(0);
		helper.next = head;
		Node p = helper;
		
		while(p.next != null){
			if(p.next.data == val){
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}
		return helper.next;
	}
	
	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		RemoveLLElements rlle = new RemoveLLElements();
		Node head = new Node(10);
		head.next = new Node(6);
		head.next.next = new Node(6);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(16);
		
		int val = 6;
		
		rlle.display(head);
		
		Node res = rlle.removeElements(head, val);
		rlle.display(res);

	}
}
