import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Customer extends User {
	
	private final static int idColumn = 0;
	private final static int nameColumn = 1;
	private final static int descriptionColumn = 5;
	private final static int traderColumn = 6;
	private LinkedList<Product>searchResult=new LinkedList<>();
	private LinkedList<Product>filterResult = new LinkedList<>();
	private Deque<Orders>orderProducts=new ArrayDeque<>();
	private DataFiles dataFiles=new DataFiles();
	
	/**
	 * 
	 * @param userId User Id
	 * @param password User Password
	 * @param csvWriter User record file
	 * @throws Exception Stream Closed
	 */
	public Customer(String userId, String password,FileWriter csvWriter) throws Exception {
		super(userId, password);
		dataFiles.writeUserFile("Customer",userId, password, null, csvWriter);
	}
	
	/**
	 * 
	 * @param keyword Searched keyword
	 * @throws Exception If product not found
	 */
	public void searchProduct(String keyword) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("new.csv"));
		String line;
		boolean control=true;
		searchResult=new LinkedList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   	     
	        if(values[nameColumn].contains(keyword) || values[descriptionColumn].contains(keyword)) {
	        	searchResult.add(new Product(values[0], values[1], values[2],
	        						values[3], values[4], values[5], values[6]));
	        	control=false;
	        	
	        }       
	    }
	    if(control)
	    	throw new Exception("Product Not Found");
	   	 	    
	    listProduct();		    
	    br.close();
	}
	
	/**
	 *  Sort by Name
	 */
	public void sortByName() {
		bubbleSort(searchResult);	    	
 	    listProduct();
	}
	/**
	 * Sort by Discounted Price
	 */
	public void sortByDiscPrice() {
		ShellSort.sort(searchResult);	    	    
    	listProduct();
	}
	/**
	 * Sort by Discount Amount
	 */
	public void sortByDiscAmount() {
		InsertionSort.sort(searchResult);
    	listProduct();
	}
	/**
	 * 
	 * @param lowestPrice lowest price for filter
	 * @param highestPrice highest price for filter
	 */
	public void filterPrice(int lowestPrice,int highestPrice) {
		LinkedList<Product>entitiesToRemove=new LinkedList<>();
		
		for(Product temp:searchResult) {
			if(temp.getDiscountedPrice()<lowestPrice || 
						temp.getDiscountedPrice()>highestPrice)	{
				entitiesToRemove.add(temp);		
			}
		}
		searchResult.removeAll(entitiesToRemove);
		listProduct();
		
	}
	/**
	 * Products that do not have preferred categories 
	 * in the file are not added to the array.
	 * @param category Desired category
	 */
	public void filterCategory(String category) {
		LinkedList<Product>entitiesToRemove=new LinkedList<>();
		
		for(Product temp:searchResult) {
			if(temp.getCatagory().indexOf(category) == -1)
			{
				entitiesToRemove.add(temp);		
			}
		}
		searchResult.removeAll(entitiesToRemove);
		listProduct();
		
	}
	/**
	 * 
	 * @param records Sort for product
	 */
	public void  bubbleSort(LinkedList<Product> records) {
		 int n = records.size();
		 for (int i = 0; i < n-1; i++){
		     for (int j = 0; j < n-i-1; j++){
		          if ((records.get(j).getName()).compareTo(records.get(j+1).getName())> 0) {
		               Product temp = records.get(j);
		               records.set(j, records.get(j+1));
		               records.set(j+1, temp);
		          }
		      }
		 }
	 }
	/**
	 * List Product
	 */
	public void listProduct() {
		 for(Product temp:searchResult) 
		    	System.out.println(temp.getName()+"--"+temp.getPrice()+"--"+
		    					temp.getDiscountedPrice()+"--"+temp.getTrader());
	}
	/**
	 * 
	 * @param traderName Desired trader
	 * @throws Exception If trader has not product
	 */
	public void displayProductsOfTrader(String traderName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("new.csv"));
		String line;
		boolean control =true;
		searchResult=new LinkedList<>();
	    while ((line = br.readLine()) != null) {
	    	String[] values = line.split(";");   
	        if(values[traderColumn].equals(traderName)) {
	        	searchResult.add(new Product(values[0], values[1], values[2],
	        						values[3], values[4], values[5], values[6]));
	        	control=false;
	        	
	        }       	       
	    }
	    if(control)
	    	throw new Exception("The trader you want has no product");
	    
	    for(Product temp:searchResult) {
	    	System.out.println(temp.getName()+"--"+temp.getPrice()+"--"+temp.getDiscountedPrice()+"--"+temp.getTrader());
	    }
	    br.close();
	}
	/**
	 * 
	 * @param id
	 * @param csvWriter
	 * @throws Exception
	 */
	public void buyProduct(String id,FileWriter csvWriter) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("new.csv"));
		String line;
		boolean control=true;
	    while ((line = br.readLine()) != null) {
	    	String[] values = line.split(";"); 
	    	if(values[idColumn].equals(id)) {
	    		orderProducts.add(new Orders(this.getId(), values[0], values[1], values[3] ,values[4], values[6], null));
	    		dataFiles.writeOrderFile(orderProducts.getLast(), csvWriter);
	    		System.out.println("Product was bought successfully");
	    		control=false;
	    		break;
	    	}
	    }
	    if(control)
	    	throw new Exception("There is no product with this id");
	    br.close();
	}
}
