/* Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list 
should become 1 -> 2 -> 4 after calling your function.

*/
public class DeleteNode {
	
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int val){
			data = val;
			next = null;
		}
	}
	
	public void deleteNode(Node curr){
		curr.data = curr.next.data;
		curr.next = curr.next.next;
	}
	
	public void display(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
	}
	
	
	public static void main(String[] args) {
		DeleteNode dn = new DeleteNode();
		head = new Node(10);
		head.next = new Node(15);
		head.next.next = new Node(20);
		head.next.next.next = new Node(25);
		dn.display(head);
		
		dn.deleteNode(head.next.next);
		System.out.println();
		dn.display(head);
		
	}

}
