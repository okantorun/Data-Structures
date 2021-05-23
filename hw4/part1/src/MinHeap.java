


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;



@SuppressWarnings("rawtypes")
public class MinHeap<E> {

	private ArrayList<E> theData;

	/**
     * Creates empty heap
     */
	public MinHeap()
	{
		theData = new ArrayList<>();
	}
	
	
	
	/**
	 * 
	 * @param item item to search for
	 * @return found item or null
	 */
	public E search(E item) {
        for (E element : theData) {
            if (element.equals(item)) {
                return element;
            }
        }
        return null;
    }
	
	/**
	 * 
	 * @param parent index to swap
	 * @param child index to swap 
	 */
	 @SuppressWarnings("unused")
	private void swap(int parent, int child) {
        E tmp = theData.get(parent);
        theData.set(parent, theData.get(child));
        theData.set(child, tmp);
    }
	 
	 /**
	  * Adding and fixing 
	  * @param item item to add
	  */
	 @SuppressWarnings("unchecked")
	public void add(E item)
	 {
		 theData.add(item);
		 
		 int child = theData.size()-1;
	     int parent = (child-1) / 2;
         
         while (parent>=0 && ((Comparable) theData.get(parent)).compareTo(theData.get(child)) > 0) {
        	
        	 swap(parent,child);
             child = parent;
             parent = (child - 1) / 2;
         }
         
	 }
	 /**
	  * 
	  * @return theData size  
	  */
	 public int getSize()
	 {
		 return theData.size();
	 }
	 
	 /**
	  * 
	  * @param insertHeap new heap to be merged with heap
	  */
	 @SuppressWarnings("unchecked")
	public void merge(MinHeap<E> insertHeap)
	 {
		 
		 @SuppressWarnings("unused")
		Iterator<E>iterator = insertHeap.iterator();
		
		 while(iterator.hasNext()) {
			 this.add(iterator.next());
		 }
		
		 
	 }
	 /**
	  *  Delete the desired element and fix the heap
	  * @param index indexth largest element from the Heap
	  * @throws ArrayIndexOutOfBoundsException is greater than the index heap size you want to delete
	  */
	 @SuppressWarnings("unchecked")
	public void remove(int index)throws ArrayIndexOutOfBoundsException
	 {
		 
		 @SuppressWarnings("unchecked")
		 E[] arr=(E[]) new Comparable[theData.size()];
		 
		 if(index>theData.size())
			 throw new ArrayIndexOutOfBoundsException("Error : Array Index Out Of Bounds");
		
		 
		 for(int i=0;i<theData.size() ;i++)
		 {
			arr[i] = theData.get(i);
		 }
		 bubbleSort();
		 E element = search(theData.get(theData.size()-index));
		 
		 for(int i=0;i<theData.size() ;i++)
		 {
			theData.set(i,arr[i]);
		 }
		 
		 int findIndex=-1;
		 
		 for (int i = 0; i < theData.size(); i++) {
            E current = theData.get(i);
            if (((Comparable) current).compareTo(element) == 0) {
                findIndex = i;
                break;
            }
         }
		 
		 System.out.println("Removed->"+element);
		 while(findIndex < theData.size()-1){
             swap(findIndex,findIndex+1);
             findIndex++;
         }
         theData.remove(theData.size()-1);		 
		
	 }
	 /**
	  * sorting array 
	  */
	 @SuppressWarnings("unchecked")
	public void  bubbleSort() {
		 int n = theData.size();
		 for (int i = 0; i < n-1; i++){
		     for (int j = 0; j < n-i-1; j++){
		          if (((Comparable) theData.get(j)).compareTo(theData.get(j+1))> 0) {
		               E temp = theData.get(j);
		               theData.set(j, theData.get(j+1));
		               theData.set(j+1, temp);
		          }
		      }
		 }
	 }
	 /**
	  * 
	  * @return iterator to start of list
	  */
	 @SuppressWarnings("unchecked")
		public Iterator<E> iterator() {
			return new HeapIterator();
		}
		@SuppressWarnings("hiding")
		public class HeapIterator<E> implements Iterator<E> {

			   
	 	    @SuppressWarnings("unused")
			private E lastElement=null;
	        protected int currentIndex = 0;

	        /**
	         * @return has valid next element
	         */
	        @Override
	        public boolean hasNext() {
	        	if(currentIndex+1>theData.size())
					return false;
				else
					return true;
	        }

	        /**
	         * @return  current element
	         */
	        @SuppressWarnings("unchecked")
			@Override
	        public E next() {
	        	if(!hasNext()) {
					lastElement = null;
					return null;
				}
					
				else {
					lastElement = (E) theData.get(currentIndex);
					return (E) theData.get(currentIndex++);
				}	
	        }
	        public E setLast() {
	        	//add(lastElement);
	        	return lastElement;
	        }
	    }
		
	/**
	 * @return Heap structure as string
	 */
	 public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E element : theData) {
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
	   }
	
}
