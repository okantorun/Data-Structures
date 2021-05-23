

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;



@SuppressWarnings("unused")
public class HybridList<E> extends AbstractList<E>{
	
	/**
	 * maximum number of elements an arraylist will have in each node
	 */
    private final static int MAX_NUMBER = 10;  
    /**
     * total number of elements
     */
    private int currSize;
    private Node<E> head;
    private Node<E> tail;  
   

    public HybridList() {
        head = null;
        tail = null;
        currSize = 0;
    }

    private class Node<T> {
    	/**
    	 * arraylist in node
    	 */
    	public ArrayList<E>arr=new ArrayList<>();                
        public Node<T> next;      
        public Node<T> prev;

        
      
		public Node() {
            next = null;
            prev = null;          
        }

       /**
        * Is there any element in the array
        * @return true if completely empty
        */
        public boolean isEmpty() {
            int countNull = 0;
            for(int i = 0; i < 10; i++) {
                if(arr.get(i) == null) {
                    countNull++;
                }
            }

            return countNull == 10;
        }
        /**
         * Is there any free space in the array
         * @return true if there is free space
         */
        public boolean containsEmpty() {
            for(int i = 0; i < MAX_NUMBER; i++) {
                if(arr.get(i) == null) {
                    return true;
                }
            }

            return false;
        }
    }

    
  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public ListIterator<E> listIterator() {
        return new HybridListIterator();
    }
    /**
     * HybridListIterator is ListIterator implementation for list
     */
    public class HybridListIterator<E>  implements ListIterator<E> {
    	/**
    	 * the index followed by the iterator
    	 */
        private int itrIndex = 0;   
       
        /**
         * check next element
         */
		public boolean hasNext() {
			
    		return get(itrIndex+1) != null;
		}
		
		/**
		 * @return next element
		 */
		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if(!hasNext())
				return null;
			else {
				return (E) get(itrIndex++);
			}					
		}
       /**
        * check previous element
        */
        @Override
        public boolean hasPrevious() {
            return get(itrIndex - 1) != null;        
        }
        public int getindex()
        {
        	return itrIndex;
        }

       /**
        * @return previous element
        */
        @SuppressWarnings("unchecked")
		@Override
        public E previous() {
        	if(!hasPrevious())
        		return null;
			return (E) get(itrIndex--);
        }

        /**
         * @return next index
         */
        @Override
        public int nextIndex() {
            return itrIndex + 1;
        }

        /**
         * @return previous index
         */
        @Override
        public int previousIndex() {
            return itrIndex - 1;
        }

		@Override
		public void remove() {throw new UnsupportedOperationException();}
				
		@Override
		public void set(E e) {throw new UnsupportedOperationException();}

		@Override
		public void add(E e) {throw new UnsupportedOperationException();}		
                  
    }

   
    /**
     * @return array size
     */
    @Override
    public int size() {
        return currSize;
    }

   /**
    * @return checks if the list is empty
    */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @return creates new listiterator
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public Iterator<E> iterator() {
        return new HybridListIterator();
    }
    
    /**
     * @param index location of the element to be added
     * @param e new element to be added
     * @throws is not in the index range
     */
    @Override
    public void add(int index, E e) throws  IndexOutOfBoundsException {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        
        Node<E> currNode = head;
        if(currNode == null)
            throw new IndexOutOfBoundsException();

        int nodeIndex = index / MAX_NUMBER;				//The node where the array we will traverse is 
        int arrIndex = index % MAX_NUMBER;				//the position of the object we are looking for in the array

        for(int i = 0; i < nodeIndex; i++) {
            if(currNode.next == null)
                break;
            currNode = currNode.next;
        }

        if(currNode.containsEmpty()) {
            // current array has empty place          
        	currNode.arr.add(arrIndex, e);
       
        } else {
        						// If the current array is full, the new array is added to the next node.       	
            Node<E> tmpNode = new Node<E>();
            tmpNode.prev = currNode;
            tmpNode.next = currNode.next;
            currNode.next = tmpNode;
            tmpNode.arr.add(0,currNode.arr.get(MAX_NUMBER-1));        
            currNode.arr.add(index, e);
        }
    }

   /**
    * adds to the end of the list
    * @param new object to add
    * @return true if adding element is successful
    */
    @Override
    public boolean add(E e) {
        if(isEmpty()) {         
            head = new Node<E>();
            tail = head;
            head.arr.add(0, e);
            
        } else {           
            boolean placedControl = false;
            if(tail.containsEmpty()) {
            	 tail.arr.add(e);
                 placedControl = true;
            }               

            // if tail array was full, add new node after tail and place the element
            // point tail to new node
            if(!placedControl) {
                Node<E> tmpNode = new Node<E>();
                tmpNode.prev = tail;
                tail.next = tmpNode;
                tail = tail.next;
                tail.arr.add( e);
            }
        }

        currSize++;
        return true;
    }

    /**
     * Deletes the object to be deleted from the array in the current node
     * @param object to be deleted
     * @return true if deleting element is successful
     */
    @Override
    public boolean remove(Object obj) {
        if(isEmpty()) {
            return false;
        }

        Node<E> currNode = head;
        while (currNode != null) {
            for(int i = 0; i < MAX_NUMBER; i++) {
                if(currNode.arr.get(i).equals(obj)) {
                    currNode.arr.set(i, null); 
                    if(currNode.isEmpty()) {			//If the current array is empty, we delete the node.
                        if(currNode.prev == null) {
                            head = currNode.next;		//head
                            head.prev = null;
                        } else if(currNode.next == null) {
                            tail = currNode.prev;		//tail
                            tail.next = null;
                        } else {
                            currNode.prev.next = currNode.next;		//middle
                            currNode.next.prev = currNode.prev;
                        }
                        currSize--;
                        return true;
                    }
                    currNode.arr.remove(obj);                  
                    return true;

                }
            }

            currNode = currNode.next;
        }

        return false;
    }

    /**
     * @param location of object
     * @return object
     */
     
    @Override
    public E get(int index) {
        if(index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> currNode = head;
        if(currNode == null)
            return null;

        int nodeIndex = index / MAX_NUMBER;
        int arrIndex = index % MAX_NUMBER;


        for(int i = 0; i < nodeIndex; i++) {
            if(currNode.next == null)
                break;
            currNode = currNode.next;
        }
          
        return  currNode.arr.get(arrIndex);
        
    }
    
   /**
    * @param the index of the element to be deleted
    * @return deleted object
    */
    @Override
    public E remove(int index) {
        if(isEmpty()) {
            return null;
        }

        Node<E> currNode = head;
        if(currNode == null)
            return null;

        int nodeIndex = index / MAX_NUMBER;
        int arrIndex = index % MAX_NUMBER;

        for(int i = 0; i < nodeIndex; i++) {
            if(currNode.next == null)
                return null;
            currNode = currNode.next;
        }

      
        E oldValue = currNode.arr.get(arrIndex);
        currNode.arr.set(arrIndex, null);
        								
        					//If there are no elements left in the arraylist, it is removed from the linked list.
        if(currNode.isEmpty()) {        	
            if(currNode.prev == null) {             
                head = currNode.next;
                if(head == null)
                    return oldValue;
                head.prev = null;
            } else if(currNode.next == null) {               
                tail = currNode.prev;
                tail.next = null;
            } else {               
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }

            return oldValue;
        }
   
        currNode.arr.remove(arrIndex);
       

        return oldValue;
    }

}
