
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;


@SuppressWarnings("rawtypes")
public class MaxHeap<E> {
	
	private E mode;
	private int modeFrequency;
	private ArrayList<MaxHeapData> theData;

	/**
     * Creates empty heap
     */
	public MaxHeap()
	{
		mode = null;
		modeFrequency =0;
		theData = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return mode
	 */
	public E getMode() {
		return mode;
	}
	/**
	 * 
	 * @return mode frequency
	 */
	public int getModeFrequency() {
		return modeFrequency;
	}
	/**
	 * 
	 * @return first element of heap
	 */
	@SuppressWarnings("unchecked")
	public E getFirst() {

		return (E) theData.get(0).getData();
	}
	/**
	 * 
	 * @return last element of heap
	 */
	@SuppressWarnings("unchecked")
	public E getLast() {
		return (E) theData.get(getSize()-1).getData();
	}
	/**
	 * 
	 * @param item searched element
	 * @return node in which the searched element is located
	 */
	@SuppressWarnings("unchecked")
	public MaxHeapData<E> search(E item) {
        for (MaxHeapData element : theData) {
            if (element.getData().equals(item)) {
                return  element;
            }
        }
        return null;
    }
	/**
	 * 
	 * @param item searched element 
	 * @return	index of searched element
	 */
	public int getByIndex(E item) {
        for (int i=0; i<theData.size();i++) {
            if (theData.get(i).getData().equals(item)) {
                return  i;
            }
        }
        return -1;
    }
	/**
	 * 
	 * @param parent index to swap
	 * @param child index to swap 
	 */
	 @SuppressWarnings("unused")
	private void swap(int parent, int child) {
        @SuppressWarnings("unchecked")
		MaxHeapData<E> tmp = theData.get(parent);
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
		 MaxHeapData<E> found = search(item);
		 if(found != null)
			 theData.get(getByIndex(item)).increment();
		 else {
			 theData.add(new MaxHeapData<E>(item));
			 
			 int child = theData.size()-1;
		     int parent = (child-1) / 2;
	         
	         while (parent>=0 && ((Comparable) theData.get(parent).getData()).compareTo(theData.get(child).getData()) < 0) {
	        	
	        	 swap(parent,child);
	             child = parent;
	             parent = (child - 1) / 2;
	         }
		 }
         
         
	 }
	 /**
	  * 
	  * @return heap size
	  */
	 public int getSize()
	 {
		 return theData.size();
	 }
	

	 /**
	  *  Delete the desired element and fix the heap
	  * @param index indexth largest element from the Heap
	  * @throws ArrayIndexOutOfBoundsException is greater than the index heap size you want to delete
	  */
	 @SuppressWarnings("unchecked")
	public void remove(E item) throws Exception
	 {
		@SuppressWarnings("unused")
		E found = null;
		int findIndex = -1;
        for (int i = 0; i < theData.size(); i++) {
            E curr = (E) theData.get(i).getData();
            if (((Comparable) curr).compareTo(item) == 0) {
                found = curr;
                findIndex = i;
                break;
            }
        }
        if (findIndex == -1) {
        	throw new  Exception("Error : There is no " + item +" so it cannot be deleted");
        }
		 
        if (theData.get(findIndex).getdataFrequency() > 1) {
        	theData.get(findIndex).decrement();
        } else {
        	 while(findIndex < theData.size()-1){
                 swap(findIndex,findIndex+1);
                 findIndex++;
             }
             theData.remove(theData.size()-1);       
        }
	 }
	/**
	 * 
	 * @return Returns the frequency of the mode in heap
	 */
	 @SuppressWarnings("unchecked")
	public int findMode()
	 {
		 for (int i=0; i<theData.size();i++) {
            if (theData.get(i).getdataFrequency() > modeFrequency) {
                mode = (E) theData.get(i).getData();
                modeFrequency = theData.get(i).getdataFrequency();
            }
         }
	     return modeFrequency;
	 }
	 
	 /**
		 * @return Heap structure as string
	 */
	 public String toString() {
        StringBuilder sb = new StringBuilder();
        for(MaxHeapData element : theData) {
            sb.append(element.getData().toString() + "\n");
        }
        return sb.toString();
	   }
	
}
