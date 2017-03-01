
public class PalindromeLL {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public boolean isPalindrome1(Node head){
		if(head == null || head.next == null){
			return true;
		}
		
		Node p = head;
		Node prev = new Node(head.data);
		
		while(p.next != null){
			Node temp = new Node(p.next.data);
			temp.next = prev;
			prev = temp;
			p = p.next;
		}
		Node p1 = head;
		Node p2 = prev;
		
		while(p1 != null){
			if(p1.data != p2.data){
				return false;
			}
			
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
	}
	
	public boolean isPalindrome2(Node head){
		
		if(head == null || head.next == null){
			return true;
		}
		
		//find List center
		Node fast = head;
		Node slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node secondHead = slow.next;
		slow.next = null;
		
		//reverse second part
		Node p1 = secondHead;
		Node p2 = p1.next;
		while(p1 != null && p2 != null){
			Node temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		
		secondHead.next = null;
		
		//compare two sublists
		Node p = (p2 == null ? p1 : p2);
		Node q = head;
		
		while(p != null){
			if(p.data != q.data){
				return false;
			}
			p = p.next;
			q = q.next;
		}
		return true;
	}
	
	public void printList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		PalindromeLL pll = new PalindromeLL();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		
		pll.printList(head);
		//System.out.println(pll.isPalindrome2(head));
		System.out.println(pll.isPalindrome1(head));
		
		
		

	}

}
