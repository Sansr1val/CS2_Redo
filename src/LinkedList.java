public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}

	private void setHead(Node head) {
		this.head = head;
	}
	
        /*
	 * Method for adding a new node. If the linked list is empty, 
         * the new node will be the head of the list. 
         * If not, the new node will be added at the end of the list.
	 */ 
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

	/*
	 * Searches for a key in the List.
	 * Returns true if found, otherwise, it returns false.
	 */
	public boolean find(int key) {
		Node currentNode = head;
		
		while (currentNode != null) {
			if (currentNode.getData() == key)
				return true;
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	/*
	 * Deletes a key in the list.
	 * It first checks if the list is empty. 
	 * If the list is empty, it returns false, otherwise it checks if the head node contains the key.
	 * If found on the head node, the node is deleted and returns true, otherwise, the list is traversed.
	 * If it's found, the key is deleted and returns true, otherwise, returns false.
	 */
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
	
	/*
	 * Displays the contents of the list.
	 * Each key is segmented by the string " -> ".
	 * A substring is made to remove the last unnecessary " -> ".
	 */
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
	
	/*
	 * Returns true if the list is empty (head == null).
	 * Otherwise, it returns false.
	 */
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
