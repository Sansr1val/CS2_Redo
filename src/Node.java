public class Node {
	
	/*Declaration of fields that would serve
	 * as a storage of a nodes' data which is 
	 * a integer type and pointer which is a Node type.
	 */
	private int data;
	private Node next;

	/*Node constructor which does not take
	 * any parameters and also assigning default
	 * values to its' data and pointer.
	 */
	public Node() {
		data = 0;
		next = null;
	}

	/*Nodes getters and setters methods
	 * to able to access its data and 
	 * pointer fields.
	 */
	public Node(int data) {
		this.data = data;
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
