import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class DataFiles {
	
	private ArrayList<Product>listProduct=new ArrayList<>();
	
	/**
	 * 
	 * @param csvReader "e-commerce-samples.csv"
	 * @param traderList List of traders
	 * @param csvWriter new.csv
	 * @throws IOException 
	 */
	public void readProductFile(FileReader csvReader,TreeSet<String>traderList,FileWriter csvWriter) throws IOException {
		BufferedReader br = new BufferedReader(csvReader);
		String line;
		listProduct=new ArrayList<>();
		int i=0;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(";"); 
	        if(i!=0) {
		        listProduct.add(new Product(values[0], values[1], values[2], values[3], 
														values[4], values[5],values[6]));	
		        traderList.add(values[6]);      	    	       
	        }
	        i++;
	    }
	    QuickSort.sort(listProduct);
		System.out.println(listProduct.size());
		br.close();
		writeProductFile(csvWriter,listProduct);
		
	}
	/**
	 * 
	 * @param csvWriter new.csv 
	 * @param tempListProduct List of Product
	 * @throws IOException
	 */
	public void writeProductFile(FileWriter csvWriter,ArrayList<Product> tempListProduct) throws IOException {		
	   for(int i=0;i<tempListProduct.size();i++) {
		   csvWriter.append(tempListProduct.get(i).getId());
		   csvWriter.append(";");
		   csvWriter.append(tempListProduct.get(i).getName());
		   csvWriter.append(";");
		   csvWriter.append(tempListProduct.get(i).getCatagory());
		   csvWriter.append(";");
		   csvWriter.append(String.valueOf(tempListProduct.get(i).getPrice()));
		   csvWriter.append(";");
		   csvWriter.append(String.valueOf(tempListProduct.get(i).getDiscountedPrice()));
		   csvWriter.append(";");
		   csvWriter.append(tempListProduct.get(i).getDescription());
		   csvWriter.append(";");
		   csvWriter.append(tempListProduct.get(i).getTrader());
		   csvWriter.append("\n");
	   }
	   csvWriter.close();
	}
	/**
	 * 
	 * @param userType Trader or Customer
	 * @param userId	User Id
	 * @param password  User Password
	 * @param name  	User Name
	 * @param csvWriter
	 * @throws IOException
	 */
	public void writeUserFile(String userType,String userId,String password,String name,FileWriter csvWriter) throws IOException {
		csvWriter.append(userType);
		csvWriter.append(";");
		csvWriter.append(userId);
		csvWriter.append(";");
		csvWriter.append(password);
		csvWriter.append(";");
		csvWriter.append(name);
		csvWriter.append("\n");
	}
	/**
	 * 
	 * @param order Added Order
	 * @param csvWriter Order.csv
	 * @throws IOException
	 */
	public void writeOrderFile(Orders order,FileWriter csvWriter) throws IOException {
		csvWriter.append(order.getCustomerId());
		csvWriter.append(";");
		csvWriter.append(order.getProductId());
		csvWriter.append(";");
		csvWriter.append(order.getProductName());
		csvWriter.append(";");
		csvWriter.append(String.valueOf(order.getPrice()));
		csvWriter.append(";");
		csvWriter.append(String.valueOf(order.getDiscPrice()));
		csvWriter.append(";");
		csvWriter.append(order.getTraderName());
		csvWriter.append(";");
		csvWriter.append(null);
		csvWriter.append("\n");
		csvWriter.close();
	}
	/**
	 * For Meeted or cancelled
	 * @param csvWriter Order.csv
	 * @param updateOrders Updated Order List
	 * @throws IOException
	 */
	public void writeOrderFileUpdate(FileWriter csvWriter,ArrayList<Orders>updateOrders) throws IOException {
		for(int i=0;i<updateOrders.size();i++) {
			csvWriter.append(updateOrders.get(i).getCustomerId());
			csvWriter.append(";");
			csvWriter.append(updateOrders.get(i).getProductId());
			csvWriter.append(";");
			csvWriter.append(updateOrders.get(i).getProductName());
			csvWriter.append(";");
			csvWriter.append(String.valueOf(updateOrders.get(i).getPrice()));
			csvWriter.append(";");
			csvWriter.append(String.valueOf(updateOrders.get(i).getDiscPrice()));
			csvWriter.append(";");
			csvWriter.append(updateOrders.get(i).getTraderName());
			csvWriter.append(";");
			csvWriter.append(updateOrders.get(i).getStatus());
			csvWriter.append("\n");			
		}
		csvWriter.close();
	}
}
