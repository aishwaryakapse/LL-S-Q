

/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.

*/
public class PartitionList {
	static Node head;
	
 	static class Node {
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	public Node partition(Node head, int x){
		
		
		Node fakeNode1 = new Node(0);
		Node fakeNode2 = new Node(0);
		
		Node p = head;
		Node prev = fakeNode1;
		Node p2 = fakeNode2;
		fakeNode1.next = head;
		
		while(p != null){
			if(p.data < x){
				p = p.next;
				prev = prev.next;
			}else{
				p2.next = p;
				prev.next = p.next;
				
				p = prev.next;
				p2 = p2.next;
			}
		}
		
		//close the list
		p2.next = null;
		prev.next = fakeNode2.next;
		
		return fakeNode1.next;
	}
	
	public void displayList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PartitionList pl = new PartitionList();
		head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		pl.displayList(head);
		pl.partition(head, 3);
		pl.displayList(head);

	}

}
