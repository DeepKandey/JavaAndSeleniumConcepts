package dataStructuresAndAlgorithms;

public class HashTable {

	// Hash table
	// A hash table is a data structure that is used to store keys/value pairs. It
	// uses a hash function to compute an index into an array in which an element
	// will be inserted or searched. By using a good hash function, hashing can work
	// well. Under reasonable assumptions, the average time required to search for
	// an element in a hash table is O(1).

	private int INITIAL_SIZE = 16;
	private HashEntry[] data; // Linked List

	class HashEntry {
		String key;
		String value;
		HashEntry next;

		public HashEntry(String key, String value) { // creating hash entry as a linked list so that in case of
														// collision, it contains the reference of next key having same
														// index
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	HashTable() {
		data = new HashEntry[INITIAL_SIZE];
	}

	public int getIndex(String key) {

		// Get the hash code
		int hashCode = key.hashCode();
		System.out.println("HashCode corresponding key: " + key + " is " + hashCode);

		// Convert to index
		int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

		// Hack to force collision for testing
		if (key.equals("John Smith") || key.equals("Sandra Dee")) {
			index = 4;
		}

		System.out.println("index corresponding key: " + key + " is " + index);
		return index;
	}

	public void put(String key, String value) {

		// Get the index
		int index = getIndex(key);

		// Create the linked list entry
		HashEntry entry = new HashEntry(key, value);

		// if no entry there- add it
		if (data[index] == null) {
			data[index] = entry;
		}
		// Else handles collision by adding to end of Linked List
		else {
			HashEntry entries = data[index];

			// Walk the end
			while (entries.next != null) {
				entries = entries.next;
			}

			// Add our new entry there
			entries.next = entry;
		}
	}

	public String get(String key) {

		// Get the index
		int index = getIndex(key);

		// Get the current list of entries
		HashEntry entries = data[index];

		System.out.print("Value corresponding key: " + key + " is ");

		// if we have existing entries against the key...
		if (entries != null) {
			// else walk chain until find a match
			while (!entries.key.equals(key) && entries.next != null) {
				entries = entries.next;
			}

			// then return it
			return entries.value;
		}

		// if we have no entries against this key...
		return null;
	}

	@Override
	public String toString() {
		int bucket = 0;
		StringBuilder hashTableStr = new StringBuilder();
		for (HashEntry entry : data) {
			if (entry == null) {
				continue;
			}

			hashTableStr.append("\n bucket[").append(bucket).append("] = ").append(entry.toString());
			bucket++;

			HashEntry temp = entry.next;
			while (temp != null) {
				hashTableStr.append("--> ");
				hashTableStr.append(temp.toString());
				temp = temp.next;
			}
		}
		return hashTableStr.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable obj = new HashTable();
		obj.put("Deepak Rai", "1");
		obj.put("John Smith", "2");
		obj.put("Sandra Dee", "3");
		System.out.println(obj.get("Deepak Rai"));
		System.out.println(obj.get("John Smith"));
		System.out.println(obj.get("Sandra Dee"));
		System.out.println(obj.toString());
	}
}
