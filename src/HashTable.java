public class HashTable {
	private LinkedList[] table = new LinkedList[10];
	
	public HashTable() {
		for(int i = 0; i < table.length; i++) {
			table[i] = new LinkedList();
		}
	}
	/*
	 * Adds a new integer in the list, accepts int key as its parameter.
	 * The key is Hashed and inserted into list at the hash using the 
	 * LinkedList class' append function.
	 */
	public void add(int key) {
		int hash = hashFunction(key);
		table[hash].append(new Node(key));
	}
	
	/*
	 * Shows the contents of the HashTable using the LinkedList class' displayInfo function.
	 * Starts the display with the index and an arrow "->" if the list is not empty,
	 * otherwise only the index is shown.
	 * Then returns String str.
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
	 * The hash is first computed by the hash function, then the key is searched 
	 * in the list found at the hash using the LinkedList class' find function.
	 * Returns true if the key is found in the list, else it returns false.
	 */
	public boolean search(int key) {
		int hash = hashFunction(key);
		return table[hash].find(key);
	}
	
	/*
	 * Deletes a key in the Hash Table using the LinkedList class' remove function.
	 * The hash is computed by the hash function and the linked list at the hash is searched
	 * for the key and deletes it.
	 * Returns true if the key is found and it will be deleted using remove() function,else
	 * it return false if it does not exist.
	 */
	public boolean delete(int key) {
		int hash = hashFunction(key);
		return table[hash].remove(key);
	}
	
	/*
	 * Used to compute the hash. Utilizes the modulo division method to create hash values.
	 * Returns the hash.
	 */
	public static int hashFunction(int key) {
		int hash = key % 10;
		return hash;
	}

}
