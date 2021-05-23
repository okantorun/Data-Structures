
public class ArrayList<E> {

	// Data fields
	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	
	private E[] theData;
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;
		
	@SuppressWarnings("unchecked")
	public ArrayList () {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}
	/**
	 * Making space in the array
	 */
	private void reallocate()
	{
		capacity*=2;
		@SuppressWarnings({ "unchecked", "unused" })
		E[] temp =(E[]) new Object[capacity];
		for(int i=0;i<size;i++)
			temp[i] = theData[i];
		theData = temp;
	}
	/**
	 * 
	 * @param anEntry object to add to the end of the array
	 */
	public void add(E anEntry)
	{
		if (size >= capacity) { 
			reallocate();
		}
		theData[size] = anEntry;
		size++;
	}
	/**
	 * 
	 * @param index the location of the object to be inserted
	 * @param anEntry new object to add
	 */
	public void add (int index, E anEntry) {
		// check bounds
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index); 
		}
		// Make sure there is room
		if (size >= capacity) { 
			reallocate();
		}
		// shift data
		for (int i = size; i > index; i--) {
			theData[i] = theData[i-1];
		}
		// insert item
		theData[index] = anEntry;
		size++;
	}
	/**
	 * 
	 * @param index location of object
	 * @return object
	 */
	public E get (int index) {
		
		return theData[index];
	}
	/**
	 * 
	 * @param index  location of object
	 * @param newValue object to be set
	 */
	public void set (int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		//E oldValue = theData[index];
		theData[index] = newValue;
		//return oldValue;
	}
	/**
	 * 
	 * @param index	the location of the object to be deleted
	 * @return deleted object
	 */
	public E remove (int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
				
		for (int i = index + 1; i < size; i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	/**
	 * 
	 * @param item object to be deleted
	 * @return deleted object
	 */
	public E remove(Object item)
	{
		int temp=0;
		for(int i=0;i<size;i++)
		{
			if(theData[i].equals(item))
				temp=i;
		}
		
		
		return remove(temp);
	}
}
