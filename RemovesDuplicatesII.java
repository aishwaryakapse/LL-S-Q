

/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example, given 1->1->1->2->3, return 2->3.

*/

public class RemovesDuplicatesII {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node deleteDuplicates(Node head){
		Node t = new Node(0);
		t.next = head;
		
		Node p = t;
		while(p.next != null && p.next.next != null){
			if(p.next.data == p.next.next.data){
				int dup = p.next.data;
				while(p.next != null && p.next.data == dup){
					p.next = p.next.next;
				}
			}else{
				p = p.next;
			}
		}
		return t.next;
	}
	
	
	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RemovesDuplicatesII rd2 = new RemovesDuplicatesII();
		Node head = new Node(10);
		head.next = new Node(15);
		head.next.next = new Node(15);
		head.next.next.next = new Node(25);
		head.next.next.next.next = new Node(25);
		head.next.next.next.next.next = new Node(30);
		rd2.display(head);
		
		
		Node res = rd2.deleteDuplicates(head);
		rd2.display(res);
	}

}
