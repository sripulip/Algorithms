package dataStructures;

public class HashMap<K, V> {

	private final int mapSize = 100;
	@SuppressWarnings("unchecked")
	HashMapEntry<K, V>[] hashMap = new HashMapEntry[mapSize];

	@SuppressWarnings("hiding")
	private class HashMapEntry<K, V> {
		@SuppressWarnings("unused")
		private final K key;
		private V value;

		private HashMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		private V getValue() {
			return value;
		}
	}

	public V get(K key) {
		int hash = key.hashCode();
		int hashValue = hash % mapSize;
		return hashMap[hashValue].getValue();
	}

	public boolean put(K key, V value) {
		int hash = key.hashCode();
		int hashValue = hash % mapSize;
		hashMap[hashValue] = new HashMapEntry<K, V>(key, value);
		return true;
	}

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Sri");
		map.put(2, "Ram");
		map.put(3, "Kashyap");
		map.put(2, "Kashyap");
		map.put(4, "Kashyap");

		String name = map.get(1);
		System.out.println(name);
	}
}
