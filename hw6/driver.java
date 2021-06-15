import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class driver {
	
	public static void createDefaultTrader(HashMap<String, Trader>traderRecords,
								TreeSet<String>traderList,FileWriter csvWriterUser) throws Exception {
		for(String temp:traderList) {
			traderRecords.put(Trader.id,new Trader(Trader.id, "123456", temp, csvWriterUser));
		}
	}
	public static void main(String[] args) throws Exception  
	{  
		
		HashMap<String, Customer> customerRecords = new HashMap<>();
		HashMap<String, Trader> traderRecords = new HashMap<>();
		TreeSet<String>defaultTraderList=new TreeSet<>();

		DataFiles pr=new DataFiles();
		
		FileWriter csvWriterProduct = new FileWriter("new.csv");
		FileWriter csvWriterUser=new FileWriter("User.csv");
		FileWriter csvWriterOrder=new FileWriter("Order.csv");
				
		FileReader csvReader=new FileReader("Database/e-commerce-samples.csv");
		FileReader csvReaderOrder=new FileReader("Order.csv");
		FileReader csvReaderProduct=new FileReader("new.csv");
		
		pr.readProductFile(csvReader,defaultTraderList,csvWriterProduct);
		
	
		createDefaultTrader(traderRecords, defaultTraderList, csvWriterUser);
		
		customerRecords.put("11111111", new Customer("11111111", "123456",csvWriterUser));
		customerRecords.put("22222222", new Customer("22222222", "123456",csvWriterUser));
		
		System.out.println("---------Buy Product------------\n");
		customerRecords.get("11111111").buyProduct("SHTEHUY4DGTGAYBS", new FileWriter("Order.csv",true));
		customerRecords.get("22222222").buyProduct("SHTEHUY55ARGYFJS", new FileWriter("Order.csv",true));
		customerRecords.get("11111111").buyProduct("CRTE4DY4YV6KZCSK",new FileWriter("Order.csv",true));
		
		System.out.println("---------Search All products with \"shorts\" in their name or description------------\n");
		customerRecords.get("11111111").searchProduct("shorts");
		
		System.out.println("\n----------Sort By Name----------\n");
		customerRecords.get("11111111").sortByName();
		
		System.out.println("\n----------Sort By Disc. Price----------\n");
		customerRecords.get("11111111").sortByDiscPrice();
		
		System.out.println("\n----------Sort By Disc. Amount----------\n");
		customerRecords.get("11111111").sortByDiscAmount();
		
		System.out.println("\n----------Filter Disc. price range 400 and 600----------\n");
		customerRecords.get("11111111").filterPrice(400, 600);
		
		System.out.println("\n----------Filter by \"Kids' Clothing\" category----------\n");
		customerRecords.get("11111111").filterCategory("Kids' Clothing");
		
		System.out.println("\n----------All products of the trader Alisha----------\n");
		customerRecords.get("11111111").displayProductsOfTrader("Alisha");
		
		
		System.out.println("\n--------List of orders for Trader 1OAK--------");
		traderRecords.get("10000000").listOfOrders(csvReaderOrder,traderRecords.get("10000000").getName());		
		System.out.println("\n--------List of orders for Trader 5 FEELINGS---------");
		traderRecords.get("10000007").listOfOrders(new FileReader("Order.csv"),traderRecords.get("10000007").getName());
		
		//Add Product to "new.csv"
		traderRecords.get("10000000").addProduct(new FileWriter("new.csv",true),csvReaderProduct,
				new Product("aaaaaaaa", "Man->shooes", "sport shoes", "1000", "700", "New product", traderRecords.get("10000000").getName()));
		traderRecords.get("10000007").addProduct(new FileWriter("new.csv",true),new FileReader("new.csv"),
				new Product("bbbbbbbb", "Woman->shooes", "sport shoes", "1000", "700", "New product", traderRecords.get("10000007").getName()));
		
		//Remove Product from "new.csv"
		traderRecords.get("10000000").removeProduct("SHTEHUY55ARGYFJS", new FileReader("new.csv"), new FileWriter("new.csv",true));
		
		//Edit Product
		traderRecords.get("10000000").editProduct("SHTEHUY4DGTGAYBS",new Product("SHTEHUY4DGTGAYBS","1OAK Women's Floral Print Casual Shirt", "abc", "1000", "480", "abc","1OAK" ),
																													new FileReader("new.csv"), new FileWriter("new.csv",true));
		
		//Meeted orders "Order.csv"
		traderRecords.get("10000000").meetOrders("SHTEHUY4DGTGAYBS","11111111" , new FileReader("Order.csv"), "Order.csv");
		//Canceled order
		traderRecords.get("10000000").cancelOrders("SHTEHUY55ARGYFJS","22222222" , new FileReader("Order.csv"), "Order.csv");
		
		
		int chosen =1;
        int chosen2 =1;
        String keyword;
        String id = null;
        String password = null;      
        String productId = null;
        String customerId = null;
        String lastProductId = null;
        String traderName = null;
        String category = null;
        String prdName = null;
        String prdDescr = null;
        int price;
        int discPrice;
        int lowestPrice;
        int highestPrice;
        Customer tempCustomer3 = null;
        Scanner sc= new Scanner(System.in);	     
        while(chosen!=0) {
        	System.out.println("----------------------------------------------------");
	        System.out.println("1- Login as Trader ");
            System.out.println("2- Login as Customer");
            System.out.println("3- Register as Trader");
            System.out.println("4- Register as Customer");
            System.out.println("0- EXIT ");
            System.out.println("Please enter your choice:");
            chosen = sc.nextInt();
            while(chosen>4 || chosen<0) {
                System.out.println("Try a valid choice!!!");
                System.out.println("Please enter your choice:");
                chosen = sc.nextInt();
            }
            boolean control=true;
            switch (chosen) {
            	case 1:
            		control=true;
            		System.out.println("REGISTERED TRADER Ex: Id-Password-----10000000,123456");
            		System.out.println("REGISTERED TRADER Ex: Id-Password-----10000007,123456");
            		System.out.print("Id: ");
		        	id =  sc.next();
		        	System.out.print("Password: ");
		        	password =  sc.next();
					 for(int i=0;i<traderRecords.size();i++)
		           	 {						 
		           		if(traderRecords.get(id) !=null) {   	    
		           			if(traderRecords.get(id).getPassword().equals(password)) {
			           			 control=false;
			           			 chosen=1;
			           			 break;
		           			}
		           		}
		           	 }   
					 System.out.print(control);
					 if(control)
						 throw new Exception("Error : This customer is not registered in the system.");
					 break;
            	case 2:
	            	control=true;
		            System.out.println("REGISTERED CUSTOMER Id-Password-----11111111,123456");
		            System.out.println("REGISTERED CUSTOMER Id-Password-----22222222,123456");
		        	System.out.print("Id: ");
		        	id =  sc.next();
		        	System.out.print("Password: ");
		        	password =  sc.next();
					 for(int i=0;i<customerRecords.size();i++)
		           	 {
						 
		           		if(customerRecords.get(id) !=null) {   	    
		           			if(customerRecords.get(id).getPassword().equals(password)) {
			           			 control=false;
			           			 chosen=2;
			           			 break;
		           			}
		           		}
		           	 }   
					 System.out.print(control);
					 if(control)
						 throw new Exception("Error : This customer is not registered in the system.");
					 break;
					
            	case 3:
            		System.out.print("Id (8 digits): ");
		        	id =  sc.next();
		        	System.out.print("Password (6 digits): ");
		        	password =  sc.next();
		        	System.out.print("Name : ");
		        	traderName =  sc.next();
		        	if(traderRecords.containsKey(id) || customerRecords.containsKey(id))
		        		throw new Exception("There is a user on this id");
		        	traderRecords.put(id,new Trader(id, password, traderName, new FileWriter("User.csv",true)));
            		break;
            	case 4:
            		System.out.print("Id (8 digits): ");
		        	id =  sc.next();
		        	System.out.print("Password (6 digits): ");
		        	password =  sc.next();
		        	if(traderRecords.containsKey(id) || customerRecords.containsKey(id))
		        		throw new Exception("There is a user on this id");
		        	customerRecords.put(id, new Customer(id,password, csvWriterUser));
            		break;
            	case 0:
            		break;
	        }
            chosen2=chosen;
            switch(chosen2) {
            	case 1:
            		while(chosen2!=0) {
            			System.out.println("----------------------------------------------------");
	        	        System.out.println("1- Add Product ");
	        	        System.out.println("2- Remove Product ");
	                    System.out.println("3- Edit Product ");
	                    System.out.println("4- List of Orders ");
	                    System.out.println("5- Meet Order ");
	                    System.out.println("6- Cancel Order ");
	                    System.out.println("0- Exit ");
	                    System.out.println("Select :");
	                    chosen2 = sc.nextInt();
	                    switch(chosen2) {
		                    case 1:
		                    	System.out.print("Prd Id: ");
		    		        	productId =  sc.next();
		    		        	System.out.print("Prd Name: ");
		    		        	prdName =  sc.next();
		    		        	System.out.print("Prd Category: ");
		    		        	category =  sc.next();
		    		        	System.out.print("Price: ");
		    		        	price =  sc.nextInt();
		    		        	System.out.print("Disc. Price: ");
		    		        	discPrice =  sc.nextInt();
		    		        	System.out.print("Prd Descr.: ");
		    		        	prdDescr =  sc.next();
		                    	traderRecords.get(id).addProduct(new FileWriter("new.csv",true),new FileReader("new.csv"),
		                				new Product(productId,prdName,category,String.valueOf(price),String.valueOf(discPrice),prdDescr,traderRecords.get(id).getName()));
		                    	break;
		                    case 2:
		                    	System.out.print("The product id you want to delete: ");
		    		        	productId =  sc.next();
		                    	traderRecords.get(id).removeProduct(productId, new FileReader("new.csv"), new FileWriter("new.csv",true));
		                    	break;
		                    case 3:
		                    	System.out.print("Last Prd. Id: ");
		    		        	lastProductId =  sc.next();
		    		        	System.out.print("New Prd Id: ");
		    		        	productId =  sc.next();
		    		        	System.out.print("New Prd Name: ");
		    		        	prdName =  sc.next();
		    		        	System.out.print("New Prd Category: ");
		    		        	category =  sc.next();
		    		        	System.out.print("New Price: ");
		    		        	price =  sc.nextInt();
		    		        	System.out.print("New Disc. Price: ");
		    		        	discPrice =  sc.nextInt();
		    		        	System.out.print("New Prd Descr.: ");
		    		        	prdDescr =  sc.next();
		                    	traderRecords.get(id).editProduct(lastProductId,new Product(productId,prdName, category, String.valueOf(price),
		                    									String.valueOf(discPrice),prdDescr,traderRecords.get(id).getName()),new FileReader("new.csv"), new FileWriter("new.csv",true));
		                    	break;	
		                    case 4:		                    	
		                    	traderRecords.get(id).listOfOrders(new FileReader("Order.csv"),traderRecords.get(id).getName());
		                    	break;
		                    case 5:
		                    	System.out.print("Product Id: ");
		    		        	productId =  sc.next();
		    		        	System.out.print("Customer Id: ");
		    		        	customerId =  sc.next();
		                    	traderRecords.get(id).meetOrders(productId,customerId , new FileReader("Order.csv"), "Order.csv");
		                    	break;
		                    case 6:
		                    	System.out.print("Product Id: ");
		    		        	productId =  sc.next();
		    		        	System.out.print("Customer Id: ");
		    		        	customerId =  sc.next();
		                    	traderRecords.get(id).cancelOrders(productId,customerId , new FileReader("Order.csv"), "Order.csv");
		                    	break;
	                    }
            		}
            	case 2:            		
            		while(chosen2!=0) {
	            		System.out.println("----------------------------------------------------");
	        	        System.out.println("1- Search Product ");
	        	        System.out.println("2- List all Products of Trader ");
	                    System.out.println("3- Buy Product ");
	                    System.out.println("0- Exit ");
	                    System.out.println("Select :");
	                    chosen2 = sc.nextInt();
	                    switch(chosen2) {
	                    	case 1:
	                    		System.out.println("Enter the keyword you want to search :");
	                    		keyword =  sc.next();
	                    		customerRecords.get(id).searchProduct(keyword);
	                    		System.out.println("----------------------------------------------------");
	                	        System.out.println("1- Sort by Name ");
	                	        System.out.println("2- Sort by Discounted Price ");
	                            System.out.println("3- Sort by Discount Amount ");
	                            System.out.println("4- Filter Price ");
	                            System.out.println("5- Filter Catagory ");
	                            System.out.println("Select :");
	                            chosen2 = sc.nextInt();   
	                            switch(chosen2) {
	                            	case 1:
	                            		customerRecords.get(id).sortByName();
	                            		break;
	                            	case 2:
	                            		customerRecords.get(id).sortByDiscPrice();
	                            		break;
	                            	case 3:
	                            		customerRecords.get(id).sortByDiscAmount();
	                            		break;
	                            	case 4:
	                            		System.out.println("Enter lowest price:");
	                            		lowestPrice = sc.nextInt();
	                            		System.out.println("Enter highest price:");
	                            		highestPrice = sc.nextInt();
	                            		customerRecords.get(id).filterPrice(lowestPrice, highestPrice);
	                            		break;
	                            	case 5:
	                            		System.out.println("Which category of products are you looking for?");
	                            		System.out.println("Enter :");
	                            		category =  sc.next();
	                            		customerRecords.get(id).filterCategory(category);
	                            		break;
	                            		
	                            }
	                    		break;
	                    	case 2:
	                    		System.out.println("Enter The Trader Name  :");
	                    		traderName =  sc.next();
	                    		customerRecords.get(id).displayProductsOfTrader(traderName);
	                    		break;
	                    	case 3:
	                    		System.out.println("Enter The Id of The Product You Want To Buy :");
	                    		productId =  sc.next();
	                    		customerRecords.get(id).buyProduct(productId,new FileWriter("Order.csv",true));
	                    		break;
	                    	case 0:	            
	                    		break;
	                    }
            	}
            
            }       

        }
		csvWriterUser.close();		
		csvWriterProduct.close();
		
	}
	

}
