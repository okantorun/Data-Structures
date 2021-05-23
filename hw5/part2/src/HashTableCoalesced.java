
public class HashTableCoalesced<K,V> implements KWHashMap<K, V> {

	 	private Entry<K, V>[] table;
	    private static final int START_CAPACITY = 10;
	    private double LOAD_THRESHOLD = 0.75;
	    private int numKeys;
	    private int numDeletes;
	    private int tempIndex=-1;
	    private final Entry<K, V> DELETED = new Entry<K, V>(null, null);
	
	    public HashTableCoalesced() {
	        table = new Entry[START_CAPACITY];
	        numKeys = 0;
	    }
	    
	    /** Contains key‐value pairs for a hash table. */
	    private static class Entry<K, V> {
	
	        private K key;
	        private V value;
	        private int next = -1;
	        
	        
	        /** Creates a new key‐value pair.
	        @param key The key
	        @param value The value
	        */
	        public Entry(K key, V value) {
	            this.key = key;
	            this.value = value;
	        }
	        /** Retrieves the key.
	        @return The key
	        */
	        public K getKey() {
	            return key;
	        }
	        /** Retrieves the value.
	        @return The value
	        */
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
	        public String toString() {
	            return "Entry(%s, %s)"+ key + value +"->>>" +next;//String.format("Entry(%s, %s)", key, value,"->>>",next );
	        }
	
	    }
	    /** Finds either the target key or the first empty slot in the
	    search chain using linear probing.
	    @pre The table is not full.
	    @param key The key of the target object
	    @return The position of the target or the first empty slot if
	    the target is not in the table.
	   */
	    private int find(Object key) {
	        int index = key.hashCode() % table.length;
	        if (index < 0) {
	            index += table.length;
	        }
	        int k=1;
	        
	        while (table[index] != null && !key.equals(table[index].key)) {
	        	 
	        	if(table[index].next == -1) {
	        		tempIndex=index;
	        	}		        	
	            index += k;
	            k+=2;
	                   	
	            if (index >= table.length)
	                index = 0;            
	        }
	        if(tempIndex!=-1) {
	        	table[tempIndex].next=index;
	        	tempIndex=-1;
	        }
	        return index;
	    }
	    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
	    @post The size of the table is doubled and is an odd integer.
	    Each nondeleted entry from the original table is
	    reinserted into the expanded table.
	    The value of numKeys is reset to the number of items
	    actually inserted; numDeletes is reset to 0.
	   */
	    private void rehash() {
	        Entry<K, V>[] oldTable = table;
	        
	        table = new Entry[2 * oldTable.length + 1];

	        numKeys = 0;
	        numDeletes = 0;
	        for (int i = 0; i < oldTable.length; i++) {
	            if (oldTable[i] != null && oldTable[i] != DELETED) {
	                put(oldTable[i].key, oldTable[i].value);
	            }
	        }
	    }
	    /** Method get for class HashtableOpen.
	    @param key The key being sought
	    @return the value associated with this key if found;
	    otherwise, null
	   */
	    @Override
	    public V get(Object key) {
	        int index = find(key);

	        if (table[index] != null)
	            return table[index].value;
	        else
	            return null;
	    }

	    @Override
	    public boolean isEmpty() {
	        return (numKeys > 0) ? false : true;
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
	        int index = find(key);

	        if (table[index] == null) {
	            table[index] = new Entry<K, V>(key, value);
	            numKeys++;

	            double loadFactor = (double) (numKeys + numDeletes) / table.length;
	            if (loadFactor > LOAD_THRESHOLD)
	                rehash();
	            return null;
	        }
	        V oldVal = table[index].value;
	        table[index].value = value;
	        return oldVal;
	    }

	    @Override
	    public V remove(Object key) {
	        int index = find(key);
	        V value = get(key);

	        if (value == null)
	            return null;
	        
	        int collidingIndex = 0;
	        while(table[index].next != -1) {
	            collidingIndex=table[index].next;
	        	table[index].key = table[collidingIndex].key;
	        	table[index].value = table[collidingIndex].value;
	        	
	        	if(table[collidingIndex].next != -1) 
	        		table[index].next = collidingIndex;	        		       
	        	else  table[index].next = -1;
	        	
	        	index = collidingIndex;
	        	
	        }
	        table[collidingIndex] = DELETED;
	        numDeletes++;
	        numKeys++;
	        return value;
	    }
	    /**
	     * @return size;
	     */
	    @Override
	    public int size() {
	        return numKeys;
	    }
	    public void print() {
	    	int i=0;
	        for (Entry entry : table) {
	            if (entry != null) {
	                if (entry != DELETED) {
	                    System.out.println(i+"- "+entry);	                  
	                }
	            }
	            i++;
	        }
	    }
		
}
