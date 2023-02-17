public class HashTable {
	private LinkedList[] table = new LinkedList[10];
	
	public HashTable() {
		for(int i = 0; i < table.length; i++) {
			table[i] = new LinkedList();
		}
	}
	
	/*
	 * add function accepts integer as key using the LinkedList class' append function.
	 * The keys are then hashed by the HashFunction method. Uses separate chaining as 
	 * solution for the collisions.  
	 */
	public void add(int key) {
		int hash = hashFunction(key);
		table[hash].append(new Node(key));
	}
	
	/*
	 * Shows the contents of the HashTable using the LinkedList class' displayInfo function.
	 * Starts the display with an arrow "->" if the list is not empty,
	 * otherwise it will display nothing.
	 */
	public String view() {	
		String str = "";
		for (int i = 0; i < table.length; i++) {
			str += i + (table[i].isEmpty() == false ? " -> " : "")+table[i].displayInfo()+"\n";
		}
		return str;
	}

	/*
	 * Searches for a key in the Hash Table using the LinkedList class' find function.
	 * THe hash is first computed by the hash function, the key is searched 
	 * in the list found at the hash.
	 */
	public int search(int key) {
		int hash = hashFunction(key);
		if(table[hash].find(key)) {
			return hash;
		}else {
			return 0;
		}
	}
	
	/*
	 * Deletes a key in the Hash Table using the LinkedList class' remove function.
	 * The hash is computed by the hash function and the linked list at the hash is searched
	 * for the key.
	 * It returns the boolean value of the 
	 */
	public boolean delete(int key) {
		int hash = hashFunction(key);
		return table[hash].remove(key);
	}

	public static int hashFunction(int key) {
		int hash = key % 10;
		return hash;
	}

}
