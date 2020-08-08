package Java;

public class SimpleLinkedListTest {
	
	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		
		list.addFirstNode("피자");
		list.printList();
		list.addFirstNode("치킨");
		list.printList();
		list.addFirstNode("삼겹살");
		list.printList();
		System.out.println("======Stack.push======");
		
		list.popFirstNode();
		list.printList();
		list.popFirstNode();
		list.printList();
		list.popFirstNode();
		list.printList();
		System.out.println("======Stack.pop======");
	}
}
