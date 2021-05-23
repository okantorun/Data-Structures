import java.util.LinkedList;

public class HashTableChainBook<K,V> implements KWHashMap<K, V> {
	
	    private LinkedList<Entry<K, V>>[] table;
	    private int numKeys;
	    private static final int CAPACITY = 10;
	    private static final double LOAD_THRESHOLD = 3.0;

	    @SuppressWarnings("unchecked")
		public HashTableChainBook() {
	        table = new LinkedList[CAPACITY];
	    }
	    /** Contains key‐value pairs for a hash table. */
	    private static class Entry<K, V> {
	    	
	        private K key;
	        private V value;
	        
	        /** Creates a new key‐value pair.
	        @param key The key
	        @param value The value
	        */
	        public Entry(K key, V value) {
	            this.key = key;
	            this.value = value;
	        }

	        public K getKey() {
	            return key;
	        }

	        public V getValue() {
	            return value;
	        }
	        /** Sets the value.
	        @param val The new value
	        @return The old value
	        */
	        public V setValue(V val) {
	            V oldVal = value;
	            value = val;
	            return oldVal;
	        }

	    }
	    /** Method get for class HashtableOpen.
	    @param key The key being sought
	    @return the value associated with this key if found;
	    otherwise, null
	   */
	    public V get(Object key) {
	        int index = key.hashCode() % table.length;
	        if (index < 0)
	            index += table.length;
	        if (table[index] == null)
	            return null;

	        for (Entry<K, V> nextItem : table[index]) {
	            if (nextItem.key.equals(key))
	                return nextItem.value;
	        }
	        return null;
	    }
	    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
	    @post The size of the table is doubled and is an odd integer.
	    Each nondeleted entry from the original table is
	    reinserted into the expanded table.
	    The value of numKeys is reset to the number of items
	    actually inserted; numDeletes is reset to 0.
	   */
	    @SuppressWarnings("unchecked")
		private void rehash() {
	        LinkedList<Entry<K, V>>[] oldTable = table;

	        table = new LinkedList[2 * oldTable.length + 1];

	        numKeys = 0;
	        for (int i = 0; i < oldTable.length; i++) {
	            if (oldTable[i] != null) {
	                for (int j = 0; j < oldTable[i].size(); j++) {
	                    Entry<K, V> e = oldTable[i].get(j);
	                    put(e.key, e.value);
	                }
	            }
	        }
	    }

	    @Override
	    public boolean isEmpty() {
	        return numKeys == 0 ;
	    }
	    /** Method put for class HashtableOpen.
	    @post This key‐value pair is inserted in the
	    table and numKeys is incremented. If the key is already
	    in the table, its value is changed to the argument
	    value and numKeys is not changed. If the LOAD_THRESHOLD
	    is exceeded, the table is expanded.
	    @param key The key of item being inserted
	    @param value The value for this key
	    @return Old value associated with this key if found;
	    otherwise, null
	   */
	    @Override
	    public V put(K key, V value) {
	        int index = key.hashCode() % table.length;
	        if (index < 0)
	            index += table.length;
	        if (table[index] == null)
	            table[index] = new LinkedList<Entry<K, V>>();

	        for (Entry<K, V> nextItem : table[index]) {
	            if (nextItem.key.equals(key)) {
	                V oldVal = nextItem.value;
	                nextItem.setValue(value);
	                return oldVal;
	            }
	        }

	        table[index].addFirst(new Entry<K, V>(key, value));
	        numKeys++;
	        if (numKeys > (LOAD_THRESHOLD * table.length))
	            rehash();
	        return null;
	    }
	    /**
	     * @param  object to be deleted
	     */
	    @Override
	    public V remove(Object key) {
	        int index = key.hashCode() % table.length;
	        if (index < 0)
	            index += table.length;
	        if (table[index] == null)
	            return null;

	        for (Entry<K, V> nextItem : table[index]) {
	            if (nextItem.key.equals(key)) {
	                V value = nextItem.value;
	                table[index].remove(nextItem);
	                --numKeys;
	                if (table[index].isEmpty()) {
	                    table[index] = null;
	                }
	                return value;
	            }
	        }
	        return null;
	    }
	    /**
	     * @return size;
	     */
	    @Override
	    public int size() {
	        return numKeys;
	    }

}
