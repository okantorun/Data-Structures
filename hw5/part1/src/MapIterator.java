import java.util.Map.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@SuppressWarnings("serial")
public class MapIterator<K , V>{
	private K key;
	private HashMapIter<K, V> tempHashMapIter;
	private int size;
	private int currIndex;
	private int traverseIndex;
	private Object arr[];
	
	
	/**
	 * 
	 * @param hashMapIter default constructor
	 */
	@SuppressWarnings("unchecked")
	public MapIterator(HashMapIter<K, V> hashMapIter) {
		tempHashMapIter=hashMapIter;
		size = hashMapIter.size();
		currIndex=0;
		traverseIndex=0;
		arr=(K[])hashMapIter.keySet().toArray();
	}
	
	/**
	 * 
	 * @param hashMapIter  hashmapiter sent from the hashmap class
	 * @param key key of the starting index
	 */
	public MapIterator(HashMapIter<K, V> hashMapIter, K key) {
		
		tempHashMapIter=hashMapIter;
		size = hashMapIter.size();
		currIndex=0;
		traverseIndex=0;
		arr=(K[])hashMapIter.keySet().toArray();
		for(Entry<K, V> tempSet:tempHashMapIter.entrySet()) {
			if(tempSet.getKey().equals(key)) {
				break;
			}
			currIndex++;
		}
		
	}
	/**
	 * 
	 * @return next element
	 */
	public K next() {
		int i=0;
		if(currIndex>=size && traverseIndex<size) 
			currIndex=0;
		
		if(traverseIndex==size) {
			return (K) arr[currIndex-1];
			
		}
		for(Entry<K, V> tempSet:tempHashMapIter.entrySet()) {
			if(i==currIndex) {
				currIndex++;
				traverseIndex++;		
				return tempSet.getKey();
			}				
			i++;
		}	
		
		throw new NoSuchElementException("Error : Out of range");
		
	}
	/**
	 * 
	 * @return previous element
	 * @throws NoSuchElementException
	 */
	public K prev() throws NoSuchElementException{
		int i=0;
		if(traverseIndex==0) 
			return (K) arr[currIndex];
		if(currIndex==0 && traverseIndex<size)
			currIndex=size;
		for(Entry<K, V> tempSet:tempHashMapIter.entrySet()) {
			if(i==currIndex-1) {
				currIndex--;
				traverseIndex--;
				return tempSet.getKey();
			}				
			i++;
		}		
		throw new NoSuchElementException("Error : Out of range");
		
	}
	/**
	 * 
	 * @return do you have the next element true or false
	 */
	public boolean hasNext() {
		if(traverseIndex < size)return true;
		return false;
	}
	
	
}
