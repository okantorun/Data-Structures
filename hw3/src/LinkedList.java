

import java.util.*;

public class LinkedList<E> {

	private Node <E> head = null;
	private Node <E> tail = null;
	private int size = 0;
	
	private static class Node<E>  {
	      private  E data;
	      private  Node<E> prev;
	      private  Node<E> next;
	 
	        @SuppressWarnings("unused")
			// Constructor to create a new node
	        // next and prev is by default initialized as null
	        Node(E d) { data = d; }
	}
	/**
	 * 
	 * @param index index at which the specified element is to be inserted
	 * @param item element to be inserted
	 */
	public void add(int index, E item) //Inserts itemect item into the list at position index
	{
		 if (index < 0 || index > size) {
			 throw new IndexOutOfBoundsException(Integer.toString(index));
		 }
		 if (index == 0) {addFirst(item);} 
		 else if(index == size) {addLast(item);}
		 else {
			 Node<E> current =getNode(index-1);
			 Node<E> newNode = new Node<>(item);
			 newNode.next=current.next;
			 current.next=newNode;
			 newNode.prev=current;
			 if(newNode.next!=null)
				 newNode.next.prev=newNode;	  
	         size++;
		 }
	}
	/**
	 * 
	 * @param item  the element to add
	 */
	public void addFirst(E item) //Inserts itemect item as the first element of the list
	{
		Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
           addInitial(newNode);
        } else {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
            
            size++;
        }
	}
	/**
	 * 
	 * @param item  the element to add
	 */
	public void addLast(E item) //Adds itemect item to the end of the list
	{
		
		Node<E> newNode = new Node<>(item);
		 if (isEmpty()) {
            addInitial(newNode);
		 }else {
		    tail.next = newNode;
		    newNode.prev = tail;
		    tail = newNode;
		    size++;
		 }
		

	}
	/**
	 * 
	 * @param newNode node of the first added element
	 */
	private void addInitial(Node<E> newNode)
	{
		  newNode.next = null;
          newNode.prev = null;
          head = newNode;
          tail = newNode;
          size++;
	}
	/**
	 * 
	 * @param index the index of the node where the object is located
	 * @return node where the object is located
	 */
	private Node<E> getNode(int index) {
		 Node<E> node = head;
		 for (int i = 0; i < index && node != null; i++) {
			 node = node.next;
		 }
		 return node;
	}
	/**
	 * 
	 * @param index	location of object
	 * @return object
	 */
	public E get(int index) //Returns the item at position index
	{
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		
		if(index==0) getFirst();
		if(index==size-1) getLast();
		
	   Node<E> node = getNode(index);
	   return node.data;
	}
	/**
	 * 
	 * @return the first element in this list
	 */
	public E getFirst() //Gets the first element in the list. Throws NoSuchElementException if the list is empty
	{
		return head.data;
	}
	/**
	 * 
	 * @return the last element in this list
	 */
	public E getLast()// Gets the last element in the list. Throws NoSuchElementException if the list is empty
	{
		return tail.data;
	}
	/**
	 * 
	 * @param item the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	public boolean remove(E item) //Removes the first occurrence of itemect item from the list. Returns true if the list contained itemect item; otherwise, returns false
	{
		 Node<E> current = head;

		 if(isEmpty())
				return false;
		 
		 if (head.data.equals(item) && tail.data.equals(item))
	    {			 
	        head=null;
	        tail=null;
	        size--;
	        return true;
	    }
		
		else if(head.data.equals(item))
		{
			removeFirst();
		}
		
		else if(tail.data.equals(item))
		{
			
			removeLast();
		}
		else {
			 for(int i=0;i<size;i++) {
				 if(current.data.equals(item))
					 break;
				 current = current.next;
			 }
			   
	        current.prev.next = current.next;
	        if (current.next != null)
	        {
	            current.next.prev = current.prev;
	        }        
	        current = null;   
	        size--;
		}
		return true;
		
	}
	/**
	 * 
	 * @return the last element from this list
	 */
	private boolean removeLast()
	{
		 tail = tail.prev;
	     tail.next = null;
	     size--;
	     return true;
	}
	/**
	 * 
	 * @return the first element from this list
	 */
	private boolean removeFirst()
	{
		
		head = head.next;
        head.prev = null;
        size--;
        return true;
	}
	public boolean isEmpty() { return (head == null);}
	public int getSize()
	{
		return size;
	}
	/**
	 * 
	 * @return a list iterator over the elements in this list (in proper sequence)
	 */
	public Iterator<E> iterator() { return new KWListIter(0);  }
    /**
     * 
     * @return a list iterator over the elements in this list (in proper sequence)
     */
	public ListIterator<E> listIterator() { return new KWListIter(0);  }
    /**
     * 
     * @param index  index of the first element to be returned from the list-iterator (by a call to next)
     * @return a  ListIterator of the elements in this list (in proper sequence), starting at the specified position in the list
     */
    public ListIterator<E> listIterator(int index){return new KWListIter(index);}
    public ListIterator<E> listIterator(ListIterator iter)
     {     return new KWListIter( (KWListIter) iter);  }
	
	public class KWListIter implements ListIterator<E> 
	  {
	        private Node<E> nextItem;      
	        private Node<E> lastItemReturned;   
	        private int index = 0;   // 

	    public KWListIter(int i) 
	    {   if (i < 0 || i > size)
	        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
	        lastItemReturned = null;
	 
	        if (i == size)     
	        {     index = size;     nextItem = null;      }
	        else         
	        {   nextItem = head;
	            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
	        }
	    } 

	    public KWListIter(KWListIter other)
	    {   
	    	nextItem = other.nextItem;
	        index = other.index;    
	    }
	    /**
	     *@return true if the list iterator has more elements when traversing the list in the forward direction
	     */
	    public boolean hasNext() {   return nextItem != null;    }
	    public boolean hasPrevious()
	    {  
	    	return (nextItem == null && size != 0) || nextItem.prev != null;  
	    }
	    /**
	     * @return index of the element that would be returned by a subsequent call to previous, or -1 if the list iterator is at the beginning of the list
	     */
	    public int previousIndex() {  return index - 1;    }
	    /**
	     * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
	     */
	    public int nextIndex() {  return index;    }
	    
	    /**
	     * @return the next element in the list
	     * @throws if the iteration has no next element
	     */
	    public E next()
	    {   if (!hasNext()) {  throw new NoSuchElementException();   }
	        lastItemReturned = nextItem;
	        nextItem = nextItem.next;
	        index++;
	        return lastItemReturned.data;
	    }
	    /**
	     * @return the previous element in the list
	     * @throws if the iteration has no previous element
	     */
	    public E previous() 
	    {   if (!hasPrevious()) {   throw new NoSuchElementException();   }
	        if (nextItem == null) { nextItem = tail;  }
	        else {  nextItem = nextItem.prev;  }
	        lastItemReturned = nextItem;
	        index--;
	        return lastItemReturned.data;
	    }

	    public void add(E obj) { throw new UnsupportedOperationException(); } 
	    public void set(E o)  { throw new UnsupportedOperationException(); }  
	    public void remove(){ throw new UnsupportedOperationException();}      
	    
	    
	  }// end of inner class KWListIter
	
	
	
	
}
