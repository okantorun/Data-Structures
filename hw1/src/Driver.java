

public class Driver {
	
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws Exception {
		{
			try {
				
				
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
		        Branch newBranch4  = new Branch("Izmir",objBranchManagement,objDatabase);
		        Branch tempBranch;
		        
		        BranchEmployee newBranchEmp  = new BranchEmployee("Ahmet","123","Ankara",objBranchEmployeeManagment);
		        BranchEmployee newBranchEmp2 = new BranchEmployee("Mehmet","321","Bursa",objBranchEmployeeManagment);
		        BranchEmployee newBranchEmp3  = new BranchEmployee("Melike","123","Izmir",objBranchEmployeeManagment);
		        
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
		        
		        System.out.println("\n*****TEST FOR ADD TWO BRANCHES******");
		        admin.getAdminManage().addBranch(newBranch3);
		        admin.getAdminManage().addBranch(newBranch4);
		        admin2.getAdminManage().listBranch();
		        
		       /* System.out.println("\n*****TEST FOR ADD AN EXISTING BRANCHES******");
		        admin.getAdminManage().addBranch(newBranch4);*/
		        
		        System.out.println("\n*****TEST FOR REMOVE ONE BRANCH******");
		        admin.getAdminManage().removeBranch(newBranch3);
		        admin2.getAdminManage().listBranch();
		        
		        System.out.println("\n*****TEST FOR ADD THREE BRANCH EMPLOYEE AND LIST******");
		        admin.getAdminManage().addBranchEmployee(newBranchEmp);
		        admin.getAdminManage().addBranchEmployee(newBranchEmp2);
		        admin.getAdminManage().addBranchEmployee(newBranchEmp3);
		        admin.getAdminManage().listBranchEmployee();
		        
		        System.out.println("\n*****TEST FOR REMOVE ONE BRANCH EMPLOYEE AND LIST******");
		        admin.getAdminManage().removeBranchEmployee(newBranchEmp);
		        admin.getAdminManage().listBranchEmployee();
		        
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
		        
		        /*System.out.println("\n*****ADD A REGISTERED CUSTOMER TO THE SYSTEM******");
		        newBranchEmp.getBranchEmployeeManage().addCustomer(newCustomer);*/
		        
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
		        
		        System.out.println("\n******TEST FOR LIST REGISTERED CUSTOMERS******\n");
		        newBranchEmp2.getBranchEmployeeManage().listCustomers();
		        
		        System.out.println("\n******TEST FOR BRANCH EMPLOYEES DELETING ONE CUSTOMER FROM THE SYSTEM AND LIST******\n");
		        newBranchEmp2.getBranchEmployeeManage().removeCustomer(newCustomer2);
		        newBranchEmp2.getBranchEmployeeManage().listCustomers();
		        
		        System.out.println("\n******TEST FOR CUSTOMER SEARCH PRODUCT******\n");
		        tempProduct = new Product("OfficeDesk","m3","c2");
		        newCustomer3.listProduct(tempProduct, newBranch);
		       		       		     		    
		        System.out.println("\n******CUSTOMER REGISTERS TO THE SYSTEM******\n");
		        newCustomer3.addCustomer(newCustomer3);
		        
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
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	      
	  }
	}

}
