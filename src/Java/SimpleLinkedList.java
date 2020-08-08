package Java;

public class SimpleLinkedList {
	
	private Node head;
	
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	public void popFirstNode() {
		Node secondNode = head.link;
		head.link = null;
		head = secondNode;
	}
	
	public void printList() {
		
		for (Node currNode=head; currNode!=null; currNode=currNode.link) {
			System.out.print(currNode.data + " ");
		}
		System.out.println();
	}
	
}
