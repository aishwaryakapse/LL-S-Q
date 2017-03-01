/*Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...

For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this 
in-place without altering the nodes' values
*/

public class ReorderList {
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void reorderList(Node head){
		if(head != null & head.next != null){
		
			
			Node slow = head;
			Node fast = head;
			
			while(fast != null && fast.next != null && fast.next.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			
			Node second = slow.next;
			slow.next = null;
			
			second = reverseOrder(second);
			
			Node p1 = head;
			Node p2 = second;
			//Merge two lists
			while(p2 != null){
				Node temp1 = p1.next;
				Node temp2 = p2.next;
				
				p1.next = p2;
				p2.next = temp1;
				p1 = temp1;
				p2 = temp2;
			}	
		}
	}
	
	public Node reverseOrder(Node head){
		Node prev = null;
		Node curr = head;
		while(curr != null){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head.next = null;
		return prev; //since prev is pointing to the head node
	}
	
	public void displayList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		rl.displayList(head);
		rl.reorderList(head);
		rl.displayList(head);
		
	}

}
