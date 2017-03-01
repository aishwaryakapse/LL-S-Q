/* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
public class CopyListRandomPointer {
	static Random head;
	static class Random{
		int data;
		Random next;
		Random random;
		
		Random(int d){
			data= d;
			next = null;
			random = null;
		}
	}

	public Random copyRandomList(Random head){
		if(head == null || head.next == null){
			return head;
		}
		
		Random p = head;
		
		//copy every node and insert to list
		while(p != null){
			Random copy = new Random(p.data);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		
		//Copy random pointer for each node
		p =head;
		while(p != null){
			if(p.random != null){
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}
		
		//break list to two
		p = head;
		Random newHead = head.next;
		while(p != null){
			Random temp = p.next;
			p.next = temp.next;
			if(temp.next != null){
				temp.next = temp.next.next;
			}
			p = p.next;
		}
		return newHead;
	}
	
	public void display(Random head){
		Random temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CopyListRandomPointer clrp = new CopyListRandomPointer();
		head = new Random(10);
		head.next = new Random(12);
		
		head.next.next = new Random(13);
		head.next.next.next = new Random(25);
		head.random = head.next.next;
		head.random.random = head.next;
		head.next.next.next.next = new Random(10);
				
		clrp.display(head);
		Random result = clrp.copyRandomList(head);
		clrp.display(result);	
	}
}
