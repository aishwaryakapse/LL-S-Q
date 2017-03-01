
/* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
public class RemoveDuplicatesI {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}

	public Node deleteDuplicates1(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node prev = head;
		Node p = head.next;
		
		while(p != null){
			if(p.data == prev.data){
				prev.next = p.next;
				p = p.next;
				
			}else{
				prev = p;
				p = p.next;
			}
		}
		
		return head;
	}
	
	public Node deleteDuplicates2(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node p = head;
		while(p.next != null){
			if(p.data == p.next.data){
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}
		return head;
	}
	
	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesI rd1 = new RemoveDuplicatesI();
		Node head = new Node(10);
		head.next = new Node(15);
		head.next.next = new Node(15);
		head.next.next.next = new Node(25);
		head.next.next.next.next = new Node(25);
		head.next.next.next.next.next = new Node(30);
		rd1.display(head);
		Node result = rd1.deleteDuplicates1(head);
		System.out.println();
		rd1.display(result);
		System.out.println();
		result = new Node(30);
		result.next = new Node(35);
		result.next.next = new Node(35);
		result.next.next.next = new Node(40);
		result.next.next.next.next = new Node(45);
		result.next.next.next.next.next = new Node(50);
		rd1.display(result);
		System.out.println();
		Node result1 = rd1.deleteDuplicates2(result);
		rd1.display(result1);
	}

}
