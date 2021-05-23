import java.util.HashMap;

public class HashMapIter <K,V> extends HashMap<K, V> {
	/**
	 * 
	 * @return Returns default iterator
	 */
	public MapIterator<K, V> iterator(){
		return new MapIterator<K,V>(this);
	}
	/**
	 * 
	 * @param key the index key to start
	 * @return The iterator starting from the index where the key is located
	 */
	public MapIterator<K, V> iterator(K key){
		return new MapIterator<K,V>(this,key);
	}
}
