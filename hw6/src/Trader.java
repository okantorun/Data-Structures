import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Trader extends User {
	protected static String id="10000000";
	private ArrayList<Product>listProduct=new ArrayList<>();
	private ArrayList<Orders>statusOrders=new ArrayList<>();
	DataFiles dataFiles=new DataFiles();
	private String name;
	/**
	 * 
	 * @param userId User Id
	 * @param password User Password
	 * @param name User Name
	 * @param csvWriter User.csv
	 * @throws Exception
	 */
	public Trader(String userId, String password,String name,FileWriter csvWriter) throws Exception {
		super(userId, password);
		this.name=name;
		dataFiles.writeUserFile("Trader",userId, password,name, csvWriter);
		setId();
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Static Id value increased one by one
	 */
	public void setId() {
		int updateId=Integer.parseInt(id)+1;
		this.id = String.valueOf(updateId);
	}
	/**
	 * 
	 * @param csvReader Order.csv
	 * @param traderName Trader Name for seraching
	 * @throws IOException
	 */
	public void listOfOrders(FileReader csvReader,String traderName) throws IOException {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		statusOrders=new ArrayList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(values[5].equals(traderName)) {
	        	statusOrders.add(new Orders(values[0],values[1],values[2],
	        								values[3],values[4],values[5],values[6]));
	        }	       
	    }
	    for(int i=0;i<statusOrders.size();i++) {
	    	System.out.println(statusOrders.get(i).getCustomerId()+"--"+statusOrders.get(i).getProductId()+"--"+statusOrders.get(i).getProductName()+
	    											"--"+statusOrders.get(i).getDiscPrice()+" "+statusOrders.get(i).getTraderName());
	    }
	    br.close();
	}
	/**
	 * 
	 * @param productId for comparison
	 * @param customerId for comparison
	 * @param csvReader order.csv
	 * @param filePath	order.csv
	 * @throws Exception
	 */
	public void meetOrders(String productId,String customerId,FileReader csvReader,String filePath) throws Exception {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		boolean control=true;
		statusOrders=new ArrayList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(values[0].equals(customerId) && values[1].equals(productId)
	        								&& values[5].equals(getName())) {
	        	control=false;
	        	statusOrders.add(new Orders(values[0], values[1], values[2], 
						values[3], values[4], values[5], "Meeted"));
	        }
	        else {
		        statusOrders.add(new Orders(values[0], values[1], values[2], 
		        						values[3], values[4], values[5], values[6]));
	        }
	    }	
	    if(control)
	    	throw new Exception("There are no orders that match the criteria you are looking for!");
	    dataFiles.writeOrderFileUpdate(new FileWriter(filePath),statusOrders);
	    System.out.println("Meeted is successfully");
	    
	}
	/**
	 * 
	 * @param productId for comparison
	 * @param customerId for comparison
	 * @param csvReader	order.csv
	 * @param filePath	order.csv
	 * @throws Exception
	 */
	public void cancelOrders(String productId,String customerId,FileReader csvReader,String filePath) throws Exception {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		boolean control=true;
		statusOrders=new ArrayList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(values[0].equals(customerId) && values[1].equals(productId)
	        								&& values[5].equals(getName())) {
	        	control=false;
	        	statusOrders.add(new Orders(values[0], values[1], values[2], 
						values[3], values[4], values[5], "Canceled"));
	        }
	        else {
		        statusOrders.add(new Orders(values[0], values[1], values[2], 
		        						values[3], values[4], values[5], values[6]));
	        }
	    }	
	    if(control)
	    	throw new Exception("There are no orders that match the criteria you are looking for!");
	    dataFiles.writeOrderFileUpdate(new FileWriter(filePath),statusOrders);
	    System.out.println("Cancelled is successfully");
	    
	}
	/**
	 * 
	 * @param csvWriter new.csv
	 * @param csvReader	new.csv
	 * @param productObj features of the new product to be added
	 * @throws Exception
	 */
	public void addProduct(FileWriter csvWriter,FileReader csvReader,Product productObj) throws Exception {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(values[0].equals(productObj.getId())) {
	        	throw new Exception("Another product found at the same id !");
	        }	       
	    }	   	   
	    csvWriter.append(productObj.getId());
	    csvWriter.append(";");
	    csvWriter.append(productObj.getName());
	    csvWriter.append(";");
	    csvWriter.append(productObj.getCatagory());
	    csvWriter.append(";");
	    csvWriter.append(String.valueOf(productObj.getPrice()));
	    csvWriter.append(";");
	    csvWriter.append(String.valueOf(productObj.getDiscountedPrice()));
	    csvWriter.append(";");
	    csvWriter.append(productObj.getDescription());
	    csvWriter.append(";");
	    csvWriter.append(productObj.getTrader());
	    csvWriter.append("\n");
	    csvWriter.close();
	    System.out.println("Added is successfully");
	    csvWriter.close();
	    br.close();
	}
	/**
	 * 
	 * @param productId id of the product to be deleted
	 * @param csvReader new.csv
	 * @param csvWriter	new.csv
	 * @throws Exception If product not found
	 */
	public void removeProduct(String productId,FileReader csvReader,FileWriter csvWriter) throws Exception {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		boolean control =true;
		listProduct=new ArrayList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(!values[0].equals(productId)) {	    
	        	listProduct.add(new Product(values[0], values[1], values[2], values[3], 
	        													values[4], values[5],values[6]));	 
	        	
	        }
	        else if(!values[6].equals(this.getName()))
	        	throw new Exception("You do not have any product with this id!");
	        else         	 
	        	control=false;        	        
	    }    
	   
	    if(control)
	    	throw new Exception("You do not have any product with this id!");
	    dataFiles.writeProductFile(new FileWriter("new.csv"),listProduct);	
	    System.out.println("Removed is successfully");
	    br.close();
	    csvReader.close();
	}
	/**
	 * 
	 * @param productId id of the product to be editted
	 * @param newProduct new product features
	 * @param csvReader	new.csv
	 * @param csvWriter	new.csv
	 * @throws Exception If product not found
	 */
	public void editProduct(String productId,Product newProduct,FileReader csvReader,FileWriter csvWriter) throws Exception {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		boolean control =true;
		listProduct=new ArrayList<>();
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";");   
	        if(values[0].equals(newProduct.getId()) && values[6].equals(this.getName())) {	    
	        	listProduct.add(newProduct);	
	        	control=false;
	        }
	        else         	 
	        	listProduct.add(new Product(values[0], values[1], values[2], values[3], 
															values[4], values[5],values[6]));	  	        
	    }    
	   
	    if(control)
	    	throw new Exception("You do not have any product with this id!");
	    dataFiles.writeProductFile(new FileWriter("new.csv"),listProduct);	
	    br.close();
	}
}
