public class HashTable {
	private LinkedList[] table = new LinkedList[10];
	
	public HashTable() {
		for(int i = 0; i < table.length; i++) {
			table[i] = new LinkedList();
		}
	}

	public void add(int key) {
		int hash = hashFunction(key);
		System.out.println("Hash: " + hash);
		table[hash].append(new Node(key));
	}

	public String view() {	
		String str = "";
		for (int i = 0; i < table.length; i++) {
			str += i + (table[i].isEmpty() == false ? " -> " : "")+table[i].displayInfo()+"\n";
		}
		return str;
	}

	public int search(int key) {
		int hash = hashFunction(key);
		if(table[hash].find(key)) {
			return hash;
		}else {
			return 0;
		}
	}

	public boolean delete(int key) {
		int hash = hashFunction(key);
		return table[hash].remove(key);
	}

	private static int hashFunction(int key) {
		int hash = key % 10;
		return hash;
	}

}