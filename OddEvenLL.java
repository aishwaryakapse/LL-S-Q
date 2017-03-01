/* Given a singly linked list, group all odd nodes together followed by the even nodes.
 
Please note here we are talking about the node number and not the value in the nodes.

The program should run in O(1) space complexity and O(nodes) time complexity.

Example:

Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

*/
public class OddEvenLL {
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node oddEvenLL(Node head){
		Node result = head;
		Node p1 = head;
		Node p2 = head.next;
		Node connectNode = head.next;
		
		while(p1 != null && p2 != null){
			Node t = p2.next;
			if(t == null){
				break;
			}
			
			p1.next = p2.next;
			p1=p1.next;
			
			p2.next = p1.next;
			p2 = p2.next;
		}
		
		
		p1.next = connectNode;
		
		return result;
	}
	
	public void displayList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		OddEvenLL oell = new OddEvenLL();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		oell.displayList(head);
		
		Node result = oell.oddEvenLL(head);
		oell.displayList(result);

	}

}
