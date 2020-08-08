package Java;

public class Node {
	 String data;
	 Node link;
	 
	 public Node(String data, Node link) {
		 super();
//		 this(data);
		 this.data = data;
		 this.link = link;
	 }
	 
	 public Node(String data) {
//		 super();
		 this.data = data;
	 }
}
