public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}

	private void setHead(Node head) {
		this.head = head;
	}

	public void append(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}

	public boolean find(int key) {
		Node currentNode = head;
		
		while (currentNode != null) {
			if (currentNode.getData() == key)
				return true;
			currentNode = currentNode.getNext();
		}
		return false;
	}
	

	public boolean remove(int key) {
		if(this.head == null) {
			return false;
		}
		if(this.head.getData() == key) {
			this.head = this.head.getNext();
			return true;
		}
		Node currentNode = head;
		while(currentNode.getNext() != null) {
			if(currentNode.getNext().getData() == key) {
				currentNode.setNext(currentNode.getNext().getNext());
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	

	public String displayInfo() {
		Node currentNode = head;
		String str = "";
		while (currentNode != null) {
			str += String.valueOf(currentNode.getData()) + " -> ";
			currentNode = currentNode.getNext();
		}
		if (str != "") {
			str = str.substring(0, str.length() - 4);
		}
		return str;
	}
	
	public boolean isEmpty() {
		boolean isEmpty = true;
		if(this.head == null) {
			isEmpty = true;
		}else {
			isEmpty = false;
		}
		return isEmpty;
	}

}