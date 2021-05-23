
public class MaxHeapData<E>  {

	@SuppressWarnings("unused")
	private int dataFrequency;
	@SuppressWarnings("unused")
	private E data;
	
	/**
	 * 
	 * @param data element added to node of heap 
	 */
	public MaxHeapData(E data) {
		 dataFrequency = 1;
		 this.data = data;
	}
	/**
	 * Adding same element increment frequency
	 */
	public void increment()
	{
		dataFrequency++;
	}
	public void decrement()
	{
		dataFrequency--;
	}
	/**
	 * 
	 * @return heap element
	 */
	public E getData()
	{
		return data;
	}
	/**
	 * 
	 * @return frequency of data
	 */
	public int getdataFrequency()
	{
		return dataFrequency;
	}
	

}
