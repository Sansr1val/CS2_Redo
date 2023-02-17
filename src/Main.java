import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static HashTable hashtable = new HashTable();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, InterruptedException {
		
		/*
		 * The main menu of the program. Calls the methods of the operations selected by
		 * the command input of the user. Each methods also performs input checking to
		 * ensure no errors would occur. If an error occurs, the user is returned into
		 * the main menu.
		 */	
		while (true) {
			try {
				System.out.println("---HASH TABLE---");
				System.out.println("\n1. Add New Key");
				System.out.println("2. Display Hash Table");
				System.out.println("3. Search");
				System.out.println("4. Delete");
				System.out.println("5. Exit");
				System.out.print("Enter Option Number: ");

				int option = Integer.parseInt(reader.readLine());

				if (option < 1 || option > 5) {
					throw new NumberFormatException();
				}

				switch (option) {

				case 1:
					addKey();
					break;

				case 2:
					view();
					break;

				case 3:
					search();
					break;

				case 4:
					deleteKey();
					break;
						
				// Exits the program.
				case 5:
					System.out.print("\n--Exit--" + "\nProgram will be terminated");

					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\nProgram terminated.");
					System.exit(0);
				}
			}

			catch (NumberFormatException e) {
				System.out.println("Option number must be selected from NUMBERS 1-5 only!\nPlease try again.");
			}
		}
	}
	
	/*
	 * Adds a key to the Hash Table.
	 * Only valid inputs are Positive Integers.
	 * The hash is displayed when adding new keys.
	 */
	public static void addKey() throws IOException {
		try {
			System.out.println("\n--Add New Key--");
			System.out.print("Enter New Key: ");
			int key = Integer.parseInt(reader.readLine());

			if (key <= 0) {
				System.out.println("Only Enter POSITIVE INTEGERS!\nPlease try again.");
			} else {
				int hash = HashTable.hashFunction(key);
				System.out.println("Hash: " + hash);
				hashtable.add(key);
				System.out.println("Key added successfully!");
			}
		} catch (NumberFormatException e) {
			System.out.println("The only allowed inputs are POSITIVE INTEGERS!\nPlease try again.");
		}
	}
	
        // Displays the contents of the Hash Table.	
	public static void view() {
		System.out.println("\n--Display Hash Table--");
		System.out.println(hashtable.view());

	}
	
	
	/*
	 * Searches for a key in the Hash Table. 
	 * Only valid inputs are Positive Integer
	 * Displays the key and its index if found, shows a prompt if not.
	 */
	public static void search() throws IOException {
		try {
			System.out.println("\n--Search Key--");
			System.out.print("Enter Key to Search: ");
			int key = Integer.parseInt(reader.readLine());
			
			if(key<=0) {
				System.out.println("Numbers <=0 does not exist in the Hash Table.\nPlease try again.");
			}else {
				if(hashtable.search(key) !=0) {
					System.out.println("Index : " + hashtable.search(key) + " Key : " + key);
				}else {
					System.out.println("Key does not exist in the hashtable.");
				}
			}
			
		} catch (NumberFormatException e) {
			System.out.println("The only allowed inputs are POSITIVE INTEGERS!\nPlease try again.");
		} 
	}
	
	
	/*
	 * Deletes a key in the Hash Table. 
	 * Only valid inputs are Positive Integer
	 * Deletes the key if found, shows a prompt if not.
	 */
	public static void deleteKey() throws IOException {
		try {
			System.out.println("\n--Delete Key--");
			System.out.print("Enter Key to Delete: ");
			int key = Integer.parseInt(reader.readLine());
			if(key<=0) {
				System.out.println("Numbers <=0 does not exist in the Hash Table.\nPlease try again.");
			}else {
				if(hashtable.delete(key)) {
					System.out.println("Key is deleted successfully!");
				}else {
					System.out.println("Key is not found in the Hash Table.");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("The only allowed inputs are POSITIVE INTEGERS!\nPlease try again.");
		} 

	}
}
