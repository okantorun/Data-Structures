
import java.util.*; 

public class Driver {
	
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws Exception {
		{
			try {
				
				LinkedList<Branch>tempBranchArr=new LinkedList<Branch>();
				ArrayList<BranchEmployee>tempBranchEmpArr=new ArrayList<>();
				ArrayList<Customer>tempcustomerArr=new ArrayList<>();
				
				Database objDatabase = new Database();
				AdministratorManagement objAdminManagment = new AdministratorManagement(objDatabase);
				BranchEmployeeManagement objBranchEmployeeManagment = new BranchEmployeeManagement(objDatabase);
				BranchManagement objBranchManagement = new BranchManagement();
				
				
		        Administrator admin = new Administrator("Alex","123",objAdminManagment,objDatabase);
		        Administrator admin2 = new Administrator("Pablo","321",objAdminManagment,objDatabase);
		        
		        System.out.println("*****TWO ADMIN REGISTRATION HAS BEEN COMPLETED*****");
		        admin.createAdmin(admin);
		        admin2.createAdmin(admin2);
		        
		      
		        Branch newBranch  = new Branch("Ankara",objBranchManagement,objDatabase);
		        Branch newBranch2  = new Branch("Bursa",objBranchManagement,objDatabase);
		        Branch newBranch3  = new Branch("Istanbul",objBranchManagement,objDatabase);
		        Branch newBranch4  = new Branch("Izmır",objBranchManagement,objDatabase);
		        Branch tempBranch;
		        
		        BranchEmployee newBranchEmp  = new BranchEmployee("Ahmet","123","Ankara",objBranchEmployeeManagment);
		        BranchEmployee newBranchEmp2 = new BranchEmployee("Mehmet","321","Bursa",objBranchEmployeeManagment);
		        BranchEmployee newBranchEmp3  = new BranchEmployee("Melike","123","Izmýr",objBranchEmployeeManagment);
		        
		        BranchEmployee tempBranchEmp;
		   
		        
		        Customer newCustomer = new Customer("Okan","Torun","1234","torun.okn@gmail.com",objDatabase);
		        Customer newCustomer2 = new Customer("Peter","Bishop","1475","p.bishop@gmail.com",objDatabase);
		        Customer newCustomer3 = new Customer("Micheal","Scofield","4321","micheal@gmail.com",objDatabase);
		        Customer tempCustomer;
		        
		        System.out.println("\n\n<<<<<<<TEST FOR ADMINISTRATORS>>>>>>>\n\n");
		        admin.adminLogin(admin);
		        
		        System.out.println("\n*****TEST FOR ADD TWO BRANCHES******");
		        admin.getAdminManage().addBranch(newBranch);
		        admin.getAdminManage().addBranch(newBranch2);
		        admin.getAdminManage().listBranch();
		        
		        tempBranchArr.addLast(newBranch);
		        tempBranchArr.addLast(newBranch2);
		        
		        System.out.println("\n*****TEST FOR ADD TWO BRANCHES******");
		        admin.getAdminManage().addBranch(newBranch3);
		        admin.getAdminManage().addBranch(newBranch4);
		        admin2.getAdminManage().listBranch();
		        tempBranchArr.addLast(newBranch3);
		        tempBranchArr.addLast(newBranch4);
		        		   
		        
		        System.out.println("\n*****TEST FOR REMOVE ONE BRANCH******");
		        admin.getAdminManage().removeBranch(newBranch3);
		        admin2.getAdminManage().listBranch();
		        tempBranchArr.remove(newBranch3);
		        
		        System.out.println("\n*****TEST FOR ADD THREE BRANCH EMPLOYEE AND LIST******");
		        admin.getAdminManage().addBranchEmployee(newBranchEmp);
		        admin.getAdminManage().addBranchEmployee(newBranchEmp2);
		        admin.getAdminManage().addBranchEmployee(newBranchEmp3);
		        admin.getAdminManage().listBranchEmployee();
		        tempBranchEmpArr.add(newBranchEmp);
		        tempBranchEmpArr.add(newBranchEmp2);
		        tempBranchEmpArr.add(newBranchEmp3);
		        
		        System.out.println("\n*****TEST FOR REMOVE ONE BRANCH EMPLOYEE AND LIST******");
		        admin.getAdminManage().removeBranchEmployee(newBranchEmp);
		        admin.getAdminManage().listBranchEmployee();
		        tempBranchEmpArr.remove(newBranchEmp);
		        
		        System.out.println("\n*****TEST FOR SUPPLIED PRODUCT******");
		        admin.getAdminManage().productSupplied();
		        
		        System.out.println("\n\n<<<<<<<TEST FOR BRANCH EMPLOYEE>>>>>>>\n");
		        System.out.println("\n*****TEST FOR SEARCH PRODUCT******");
		        Product tempProduct;
		        tempProduct = new Product("Chair","m1","c1");
		        newBranchEmp.getBranchEmployeeManage().listProduct(tempProduct, newBranch2);
		        
		        System.out.println("\n*****TEST FOR STORE SALE TWO PRODUCT NON-MEMEBER CUSTOMER ******");
		        newBranchEmp.getBranchEmployeeManage().saleProduct(newCustomer, tempProduct, newBranch2);
		        tempProduct = new Product("BookCases","m1");		 
		        newBranchEmp.getBranchEmployeeManage().saleProduct(newCustomer, tempProduct, newBranch2);
		        tempcustomerArr.add(newCustomer);
		        
		        
		        System.out.println("\n*****TEST FOR SEARCH PRODUCT AGAIN******");
		        tempProduct = new Product("Chair","m1","c1");
		        newBranchEmp.getBranchEmployeeManage().listProduct(tempProduct, newBranch2);
		        tempProduct = new Product("BookCases","m1");
		        newBranchEmp.getBranchEmployeeManage().listProduct(tempProduct, newBranch2);
		        
		        System.out.println("\n*****TEST FOR BEFORE REMOVE PRODUCT******");
		        tempProduct = new Product("OfficeDesk","m3","c2");
		        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, newBranch3);
		        
		        System.out.println("\n*****TEST FOR REMOVE PRODUCT******");
		        newBranchEmp3.getBranchEmployeeManage().removeProduct(tempProduct, newBranch3, 3);
		        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, newBranch3);
		        
		        System.out.println("\n*****TEST FOR ADD PRODUCT******");
		        newBranchEmp3.getBranchEmployeeManage().addProduct(tempProduct, newBranch3, 1);
		        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, newBranch3);
		        
		        System.out.println("\n*****TEST FOR PREVIOUS ORDERS OF THE CUSTOMER WITH THE CUSTOMER NUMBER ENTERED******");
		        newBranchEmp3.getBranchEmployeeManage().orderList(newCustomer.getCustomerNumber());
		        
		        System.out.println("\n*****STOCK OF ITEMS BEFORE ADMIN IS ALERTED******");
		        tempProduct = new Product("OfficeDesk","m3","c2");
		        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, newBranch3);
		        newBranchEmp3.getBranchEmployeeManage().productInquire(tempProduct, newBranch3);
		        
		        System.out.println("\n*****STOCK INCREASED BY ADMIN.******");
		        admin.getAdminManage().productSupplied();
		        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, newBranch3);
		        
		        
		        System.out.println("\n\n<<<<<<<TEST FOR CUSTOMERS>>>>>>>\n");
		        newCustomer2.customerLogin(newCustomer2);
		        
		        System.out.println("\n******TEST FOR CUSTOMER REGISTERED******\n");
		        newCustomer2.addCustomer(newCustomer2);
		        newCustomer2.customerLogin(newCustomer2);
		        tempcustomerArr.add(newCustomer2);
		        
		        
		        System.out.println("\n******TEST FOR LIST REGISTERED CUSTOMERS******\n");
		        newBranchEmp2.getBranchEmployeeManage().listCustomers();
		        
		        System.out.println("\n******TEST FOR BRANCH EMPLOYEES DELETING ONE CUSTOMER FROM THE SYSTEM AND LIST******\n");
		        newBranchEmp2.getBranchEmployeeManage().removeCustomer(newCustomer2);
		        newBranchEmp2.getBranchEmployeeManage().listCustomers();
		        tempcustomerArr.remove(newCustomer2);
		        
		        System.out.println("\n******TEST FOR CUSTOMER SEARCH PRODUCT******\n");
		        tempProduct = new Product("OfficeDesk","m3","c2");
		        newCustomer3.listProduct(tempProduct, newBranch);
		       		       		     		    
		        System.out.println("\n******CUSTOMER REGISTERS TO THE SYSTEM******\n");
		        newCustomer3.addCustomer(newCustomer3);
		        tempcustomerArr.add(newCustomer3);
		        
		        
		        System.out.println("\n******CUSTOMER BUYS ONLINE PRODUCTS.******\n");
		        tempProduct = new Product("MeetingTable","m3","c2");
		        newCustomer3.saleOnlineProduct(newCustomer3, tempProduct, newBranch);
		        
		        System.out.println("\n******TEST FOR SEARCH THE PREVIOUS ORDERS.******\n");
		        newCustomer3.orderList(newCustomer3.getCustomerNumber());
		        
		        System.out.println("\n******TEST FOR SALE PRODUCT AGAIN AND SEARCH PREVIOUS ORDERS SAME CUSTOMER******\n");
		        tempProduct = new Product("BookCases","m3","c2");
		        newCustomer3.saleOnlineProduct(newCustomer3, tempProduct, newBranch);		   
		        newCustomer3.orderList(newCustomer3.getCustomerNumber());
		       
		        System.out.println("\n******TEST FOR SEARCH PREVIOUS ORDERS ANOTHER CUSTOMER******\n");
		        newCustomer.orderList(newCustomer.getCustomerNumber());
		        
		        int chosen =1;
		        int chosen2 =1;
		        int delete_stock=0;
		        int add_stock=0;
		        int custnumber=0;
		        String username = null;
		        String lastname = null;
		        String password = null;
		        String email = null;
		        String name1 = null;
		        String name2 = null;
		        String name3 = null;
		        String name4 = null;
		        String type = null;
		        String model = null;
		        String color = null;
		        Customer tempCustomer3 = null;
		        Scanner sc= new Scanner(System.in);	     
		       
		     while(chosen!=0) {
		    	 System.out.println("----------------------------------------------------");
		        System.out.println("1- Login as Admin ");
	            System.out.println("2- Login as Branch Employee");
	            System.out.println("3- Login as Customer");
	            System.out.println("0- EXIT ");
	            System.out.println("Please enter your choice:");
	            chosen = sc.nextInt();
	            while(chosen>3 || chosen<0) {
	                System.out.println("Try a valid choice!!!");
	                System.out.println("Please enter your choice:");
	                chosen = sc.nextInt();
	            }
	            switch (chosen) {
	                case 1:
	                	chosen=0;
	                	System.out.println("REGISTERED ADMIN NAMES-----Alex,Pablo");
	                	System.out.print("Username: ");
	                    username =  sc.next();
	                    if(username.equals(admin.getUsername()) || username.equals(admin2.getUsername()))
	                    	chosen=1;
	                    else
	                    	throw new Exception("Error : This admin is not registered in the system.");
	                    break;
	                case 2:
	                	chosen=0;
	                	System.out.println("REGISTERED EMPLOYEE NAMES-----Mehmet,Melike");
	                	System.out.print("Username: ");
	                    username =  sc.next();
	                    boolean control=true;
						 for(int i=0;i<objDatabase.getbranchEmployeeSize();i++)
                        	{	
													 
                        		if(tempBranchEmpArr.get(i).getUsername().equals(username)) { 

                        			 newCustomer2.customerLogin(tempcustomerArr.get(i));
                        			tempCustomer3 =tempcustomerArr.get(i);
                        			 control=false;
                        			 chosen=2;
                        			 break;
                        		}
                        	}   
						 if(control)
							 throw new Exception("Error : This EMPLOYEE is not registered in the system.");
                		break;
	                case 3:
	                	chosen=0;
	                	 System.out.println("1- Login");
	                     System.out.println("2- Register");
	                     System.out.println("Please enter your choice:");
	                     chosen = sc.nextInt();
	                     switch (chosen) {
	                     	case 1:
	                     		System.out.println("REGISTERED CUSTOMER NAMES-----Okan,Micheal");
	    	                	System.out.print("Username: ");
	    	                	username =  sc.next();
	    	                	control=true;
								 for(int i=0;i<objDatabase.getcusotomerSize();i++)
	                            	{
									 
	                            		if(tempcustomerArr.get(i).getName().equals(username)) {   	                            			
	                            			 newCustomer2.customerLogin(tempcustomerArr.get(i));
	                            			tempCustomer3 =tempcustomerArr.get(i);
	                            			 control=false;
	                            			 chosen=3;
	                            			 break;
	                            		}
	                            	}   
								 if(control)
									 throw new Exception("Error : This customer is not registered in the system.");
	                     		break;
	                     	case 2:
	                     		System.out.println("Enter Name:");
	                            username = sc.next();
	                            System.out.println("Enter Lastname:");
	                            lastname = sc.next();
								System.out.println("Enter Password");
								 password= sc.next();
								System.out.println("Enter Email");
								 email = sc.next();								
								
	                     		 tempCustomer3 = new Customer(username,lastname,password,email,objDatabase);
	                     		newCustomer2.addCustomer(tempCustomer3);
	                     		tempcustomerArr.add(tempCustomer3);
	                     		chosen=3;
	                     		break;
						}
	                	
	                    
	                    break;
	                    
	             	              
	              }
	            switch (chosen) {
              		case 1:
              		 System.out.println("Welcome "+username);
                     System.out.println("1- Add a branch");
                     System.out.println("2- Remove a branch");
                     System.out.println("3- List a branch");
                     System.out.println("4- Add a branchemployee");
                     System.out.println("5- Remove a branch employee");
                     System.out.println("6- List branch employee");
                     System.out.println("7- Supplied Product");	                 
                     System.out.println("Enter your choice:");
                     chosen = sc.nextInt();
                     switch(chosen){
                     	case 1:
	                         System.out.println("Enter Branch Name that you want to add");
	                         name1 = sc.next();
	                         Branch newBranch5 = new Branch(name1,objBranchManagement,objDatabase);
	                         admin.getAdminManage().addBranch(newBranch5);
	                         tempBranchArr.addLast(newBranch5);
	                         break;
                     	case 2:

                            System.out.println("Enter Branch Name that you want to remove");
                            name1 = sc.next();
                            if(admin.getAdminManage().getbranchSize() != 0) {
                            	for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
                            	{
                            		if(tempBranchArr.get(i).getName().equals(name1)) {                          			
                            			admin.getAdminManage().removeBranch(tempBranchArr.get(i));
                            			tempBranchArr.remove(tempBranchArr.get(i));
                            		}
                            	}                           
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");                     
                            break;
                            
                     	case 3:
                     		 admin.getAdminManage().listBranch();
                     		 break;
                     	case 4:
	                         System.out.println("Enter the name of the branch employee you want to add");
	                         name1 = sc.next();
	                         System.out.println("Assign a password to the branch employee");
	                         name2 = sc.next();
	                         System.out.println("Which branch do you want to assign?");
	                         name3 = sc.next();
	                        
	                         BranchEmployee newBranchEmployee5 = new BranchEmployee(name1,name2,name3,objBranchEmployeeManagment);
	                         admin.getAdminManage().addBranchEmployee(newBranchEmployee5);
	                         tempBranchEmpArr.add(newBranchEmployee5);
	                         break;
                    	case 5:

                           System.out.println("Enter Branch Employee Name that you want to remove");
                           name1 = sc.next();
                           boolean control=true;
                           if(admin.getAdminManage().getbranchEmployeeSize() != 0) {
                           	for(int i=0;i<admin.getAdminManage().getbranchEmployeeSize();i++)
                           	{
                           		if(tempBranchEmpArr.get(i).getUsername().equals(name1)) {    
                           			System.out.println(tempBranchEmpArr.get(i).getUsername());
                           			admin.getAdminManage().removeBranchEmployee(tempBranchEmpArr.get(i));
                           			tempBranchEmpArr.remove(tempBranchEmpArr.get(i));
                           			control=false;
                           		}
                           	}                           
                           }                       
                           if(control)
									 throw new Exception("Error : This customer is not registered in the system.");                    
                           break;
                           
                    	case 6:
                    		 admin.getAdminManage().listBranchEmployee();
                    		 break;
                    	case 7:
                    		System.out.println("Supply the product that needs to be procured at any branch.");
                    		 admin.getAdminManage().productSupplied();
                     }
                     break;
                     
              		case 2:
              			System.out.println("Welcome ");
                        System.out.println("1- Search Product");
                        System.out.println("2- Remove Product and List");
                        System.out.println("3- Add Product and List");
                        System.out.println("4- STORE SALE");                        
                        System.out.println("5- PREVIOUS ORDERS OF THE CUSTOMER WITH THE CUSTOMER NUMBER ENTERED");
                        System.out.println("6- Alert admin for product stock");          
                        System.out.println("7- Delete Customer from system and List customers");   
                        System.out.println("Enter your choice:");
                        chosen = sc.nextInt();
              			switch (chosen) {
							case 1:
								System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 tempProduct = new Product(type,model,color);
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									 System.out.println(tempBranchArr.get(i).getName());
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   
	                            			
	                            			 newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
							    
								break;
							case 2:
								System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 System.out.println("Enter Delete Stock(ex:2):");
								 delete_stock = sc.nextInt();
								 tempProduct = new Product(type,model,color);
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									 System.out.println(tempBranchArr.get(i).getName());
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   
	                            			
	                            			newBranchEmp3.getBranchEmployeeManage().removeProduct(tempProduct, tempBranchArr.get(i), delete_stock);
	                            			 newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
								 
							    
								break;
							case 3:
								System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 System.out.println("Enter Add Stock(ex:2):");
								 add_stock = sc.nextInt();
								 tempProduct = new Product(type,model,color);
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									 System.out.println(tempBranchArr.get(i).getName());
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   	                            			
	                            			newBranchEmp3.getBranchEmployeeManage().addProduct(tempProduct, tempBranchArr.get(i), add_stock);
	        						        newBranchEmp3.getBranchEmployeeManage().listProduct(tempProduct, tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
								
							case 4:
								System.out.println("Enter the name of customer:");
		                         name1 = sc.next();
		                         System.out.println("Enter the surname of customer:");
		                         name2 = sc.next();
		                         System.out.println("Assign password:");
		                         name3 = sc.next();
		                         System.out.println("Enter e-mail:");
		                         name4 = sc.next();
								Customer tempCustomer2 = new Customer(name1,name2,name3,name4,objDatabase);
								System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();								 
								 tempProduct = new Product(type,model,color);
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   	                            			
	                            			 newBranchEmp3.getBranchEmployeeManage().saleProduct(tempCustomer2, tempProduct, newBranch2);
	                            			 break;
	                            		}
	                            	}   
								
								break;
							case 5:
								System.out.println("Enter of customer number(Ex:100 or 102 available)");
								 custnumber = sc.nextInt();
								 boolean control=true;
								 for(int i=0;i<objDatabase.getcusotomerSize();i++)
	                            	{
									 
	                            		if(tempcustomerArr.get(i).getCustomerNumber()==custnumber) {   	                            			
	                            			newBranchEmp3.getBranchEmployeeManage().orderList(tempcustomerArr.get(i).getCustomerNumber());
	                            			control=false;
	                            			 break;
	                            		}
	                            	}   
								 if(control)
									 throw new Exception("Error : This customer is not registered in the system.");
								
								break;
							case 6:
								System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 tempProduct = new Product(type,model,color);
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   	                            			
	                            			newBranchEmp3.getBranchEmployeeManage().productInquire(tempProduct,tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
								 
								break;	
							case 7:
								System.out.println("Enter the customer number you want to delete(Ex:100 or 102 available):");
								 custnumber = sc.nextInt();
								 control=true;
								 for(int i=0;i<objDatabase.getcusotomerSize();i++)
	                            	{
									 
	                            		if(tempcustomerArr.get(i).getCustomerNumber()==custnumber) {   	                            			
	                            			newBranchEmp3.getBranchEmployeeManage().removeCustomer(tempcustomerArr.get(i));
	                            			newBranchEmp3.getBranchEmployeeManage().listCustomers();
	                            			tempcustomerArr.remove(tempcustomerArr.get(i));
	                            			control=false;
	                            			 break;
	                            		}
	                            	}   
								 if(control)
									 throw new Exception("Error : This customer is not registered in the system.");
								 break;
								
							
              			}
              			break;
              			
					case 3:
						System.out.println("Welcome ");                    
                        System.out.println("1- SearchProduct");
                        System.out.println("2- Online Buy Product");                        
                        System.out.println("3- Previous Orders");                                  
                        System.out.println("Enter your choice:");
                        chosen = sc.nextInt();
                        switch(chosen) {
                        	case 1:
                        		System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 tempProduct = new Product(type,model,color);    
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									 System.out.println(tempBranchArr.get(i).getName());
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   
	                            			
	                            			newCustomer3.listProduct(tempProduct, tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
                		        
                		        break;
                        	case 2:
                        		System.out.println("Enter Branch name(Ex:Bursa):");
		                           name1 = sc.next();
								System.out.println("Enter Type(ex:Chair):");
								 type = sc.next();
								System.out.println("Enter Model(ex:m1):");
								 model = sc.next();
								System.out.println("Enter Color(ex:c1):");
								 color = sc.next();
								 tempProduct = new Product(type,model,color);  
								 for(int i=0;i<admin.getAdminManage().getbranchSize();i++)
	                            	{
									 System.out.println(tempBranchArr.get(i).getName());
	                            		if(tempBranchArr.get(i).getName().equals(name1)) {   
	                            			
	                            			newCustomer3.saleOnlineProduct(tempCustomer3, tempProduct, tempBranchArr.get(i));
	                            			 break;
	                            		}
	                            	}   
                 		        
                        		break;
                        	case 3:
                        		newCustomer3.orderList(tempCustomer3.getCustomerNumber());
                        		break;
                        		
                        }
							
              			
	              	
	            }
			  }
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	      
	  }
	}

}
