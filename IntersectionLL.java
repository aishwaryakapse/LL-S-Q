

public class IntersectionLL {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node getIntersectionNode(Node headA, Node headB){
		int len1 = 0;
		int len2 = 0;
		
		Node p1 = headA, p2 = headB;
		if(p1 == null || p2 == null){
			return null;
		}
		
		while( p1 != null){
			len1++;
			p1 = p1.next;
		}
		
		while(p2 != null){
			len2++;
			p2 = p2.next;
		}
		
		int diff = 0;
		p1 = headA;
		p2 = headB;
		
		if(len1 > len2){
			diff = len1-len2;
			int i=0;
			while(i < diff){
				p1 = p1.next;
				i++;
			}
		}else{
			diff = len2 - len2;
			int i = 0;
			while(i < diff){
				p2 = p2.next;
				i++;
			}
		}
		
		while(p1 != null && p2 != null){
			if(p1.data == p2.data){
				return p1;
			}else{
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return null;
	}
	
	public void displayList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		IntersectionLL ill = new IntersectionLL();
		Node conn = new Node(10);
		conn.next = new Node(15);
		conn.next.next = new Node(17);
		conn.next.next.next = new Node(18);
		
		Node headA = new Node(7);
		headA.next = new Node(36);
		headA.next.next = new Node(24);
		headA.next.next.next = conn;
		
		Node headB = new Node(14);
		headB.next = new Node(104);
		headB.next.next = conn;

		System.out.println(" 1st list: ");
		ill.displayList(headA);
		
		System.out.println(" 2nd list: ");
		ill.displayList(headB);
		
		System.out.println("The intersection is at: ");
		Node res = ill.getIntersectionNode(headA, headB);
		System.out.println(res.data);
	}

}
