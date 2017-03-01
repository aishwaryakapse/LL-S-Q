
public class MergeSortedLL {
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	public Node mergeTwoLists(Node l1, Node l2){
		Node p1 = l1;
		Node p2 = l2;
		
		Node fakeHead = new Node(0);
		Node p = fakeHead;
		while(p1 != null && p2 != null){
			if(p1.data <= p2.data){
				p.next = p1;
				p1 =p1.next;
			}else{
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		
		if(p1 != null){
			p.next = p1;
		}
		
		if(p2 != null){
			p.next = p2;
		}
		
		return fakeHead.next;
	}
	
	public void display(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MergeSortedLL msl = new MergeSortedLL();
		Node l1 = new Node(5);
		l1.next = new Node(17);
		l1.next.next = new Node(25);
		l1.next.next.next = new Node(34);
		l1.next.next.next.next = new Node(55);
		
		Node l2 = new Node(1);
		l2.next = new Node(14);
		l2.next.next = new Node(25);
		
		System.out.println("1st sorted Linked List is: ");
		msl.display(l1);
		
		System.out.println("2nd sorted linked list is: ");
		msl.display(l2);
		
		Node result = msl.mergeTwoLists(l1, l2);
		System.out.println(" The Merged Linked List is: ");
		msl.display(result);
		
	}

}
