/*You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNos {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node addTwoNos(Node l1, Node l2){
		int carry = 0;
		Node newHead = new Node(0);
		Node p1=l1, p2=l2, p3=newHead;
		while(p1 != null || p2 != null){
			if(p1 != null){
				carry = carry+p1.data;
				p1 = p1.next;
			}
			
			if(p2 != null){
				carry = carry + p2.data;
				p2 = p2.next;
			}
			
			p3.next = new Node(carry % 10);
			p3 = p3.next;
			carry = carry / 10;
		}
		if(carry == 1){
			p3.next = new Node(1);
		}
		return newHead.next;
	}
	
	public void display(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;		
		}
	}

	public static void main(String[] args) {
		AddTwoNos atn = new AddTwoNos();
		Node l1 = new Node(2);
		l1.next = new Node(3);
		l1.next.next = new Node(7);
		atn.display(l1);
		System.out.println();
		
		Node l2 = new Node(0);
		l2.next = new Node(0);
		l2.next.next = new Node(1);
		atn.display(l2);
		System.out.println();
		
		Node head = atn.addTwoNos(l1, l2);
		atn.display(head);
	}
}
