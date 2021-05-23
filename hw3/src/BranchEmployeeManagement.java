
public class BranchEmployeeManagement implements CustomerController {
	
	
	private Database dataBase;
	
	
	/**
	 * 
	 * @param dataBaseCustomer To establish a common connection with the database
	 */
	public BranchEmployeeManagement(Database dataBaseCustomer)
	{
		
   	 	this.dataBase=dataBaseCustomer;
	}
	
	/**
	 *  @param newCustomer new customer object
	 */
	 public void setCustomers(Customer newCustomer){
		 dataBase.customerList.add(newCustomer);
        dataBase.setcusotomerSize
        	(dataBase.getcusotomerSize()+1);
    }
	 /**
	  *  @param newCustomer new customer for store sale
	  *  @throws Exception Tries to re-add an existing customer
	  */
	public void addCustomer(Customer newCustomer) throws Exception{
		int i;
		
        boolean control = true;
     
        for(i=0;i<dataBase.getcusotomerSize();i++){
            if(dataBase.customerList.get(i).getName().equals(newCustomer.getName()) &&
            		dataBase.customerList.get(i).getlastName().equals(newCustomer.getlastName()))
                control = false;
        }
        if(control) {
            setCustomers(newCustomer);
            System.out.println("You have successfully registered, your customer number is "+dataBase.customerList.get(i).getCustomerNumber());
        }
        else
        	throw new Exception("Error : This customer is available");
        
    }
	/**
	 * @param deleteCustomer Customer object to be deleted
	 */
	 public void removeCustomer(Customer deleteCustomer) throws Exception{
	        int delete = 0;
	        boolean control = false;
	        for(int i=0;i<dataBase.getcusotomerSize();i++){
	            if(dataBase.customerList.get(i).getName().equals(deleteCustomer.getName()) &&
	            		dataBase.customerList.get(i).getlastName().equals(deleteCustomer.getlastName()))
	            {
	                delete = i;
	                control = true;
	            }
	        }
	        if(control){	            
	        	dataBase.customerList.remove(delete);
	            dataBase.setcusotomerSize(dataBase.getcusotomerSize()-1);
	            System.out.println("Customer has been successfully deleted from the system.");
	        
	        }
	        else {
	        	throw new Exception("Error : This customer is not registered in the system.");
			}
	 }
	 /**
	  * 
	  * @param customerObj the Purchaser
	  * @param newProduct Product to sale
	  * @param brancjObj Branch to sell
	  * @throws Exception Tries to re-add an existing customer
	  */
	 public void saleProduct(Customer customerObj,Product newProduct,Branch brancjObj)throws Exception
	 {	
		 
		 int i,temp = 0;
		 boolean control = true;
		 for(i=0;i<dataBase.getcusotomerSize();i++){
            if(dataBase.customerList.get(i).getName().equals(customerObj.getName()) &&
            		dataBase.customerList.get(i).getlastName().equals(customerObj.getlastName())) 
            {
                control = false;
                temp=i;
            }
         }
		
        if(control) {
            addCustomer(customerObj);
            temp=dataBase.getcusotomerSize()-1;
            
        }
       
        if(( brancjObj.getBranchManagement().products.get(getIndexbyProduct(newProduct, brancjObj)).getstock())>0) {
        	
        	dataBase.customerList.get(temp).newOrder(newProduct);
        	//dataBase.customer[temp].newOrder(newProduct);
        	removeProduct(newProduct, brancjObj, 1);
        	System.out.println("The product has been successfully sold.");
        }
        else {
			System.out.println("not stock enough");
		}
	            
		 
	 }
	 /**
	  * 
	  * @param productObj product to be added to stock
	  * @param brancjObj branch to add 
	  * @param stockSize amount to add 
	  */
	 public void addProduct(Product productObj,Branch brancjObj,int stockSize)
	 {
		 brancjObj.getBranchManagement().products.get(getIndexbyProduct(productObj, brancjObj)).
			setstock(brancjObj.getBranchManagement().products.get(getIndexbyProduct(productObj, brancjObj)).getstock()+stockSize) ;
		 System.out.println("PRODUCT ADD SUCCESSFUL");
	 }
	 		 
	 
	 /**
	  * 
	  * @param newProduct product to be reduced
	  * @param brancjObj branch to decrease
	  * @param stockSize amount to be reduced
	  */
	 public void removeProduct(Product newProduct,Branch brancjObj,int stockSize) 
	 {
		 brancjObj.getBranchManagement().products.get(getIndexbyProduct(newProduct, brancjObj)).
			setstock(brancjObj.getBranchManagement().products.get(getIndexbyProduct(newProduct, brancjObj)).getstock()-stockSize) ;
		 System.out.println("PRODUCT REMOVE SUCCESSFUL");
	 }
	 
	 /**
	  * 
	  * @param productObj searched product index number
	  * @param brancjObj branch of the product
	  * @return index of product
	  */
	 public int getIndexbyProduct(Product productObj,Branch brancjObj)
	 {
		 int IndexbyProduct;
		 if(productObj.getProductType() == "Chair" || productObj.getProductType() == "OfficeDesk" ||
				 productObj.getProductType() == "MeetingTable" )
		 {
			 
			 for(int i=0;i<brancjObj.getBranchManagement().getProductTypeSize();i++) {				
				if( brancjObj.getBranchManagement().products.get(i).getProductType().equals(productObj.getProductType()) &&
						brancjObj.getBranchManagement().products.get(i).getcolor().equals(productObj.getcolor()) &&
							brancjObj.getBranchManagement().products.get(i).getmodel().equals(productObj.getmodel()))
				{
					
					IndexbyProduct = i;
					return IndexbyProduct;
				}
						
			 }
			 
		 }
		 
		 else 
		 {
			 for(int i=0;i<brancjObj.getBranchManagement().getProductTypeSize();i++) {
				if( brancjObj.getBranchManagement().products.get(i).getProductType().equals(productObj.getProductType()) &&
						brancjObj.getBranchManagement().products.get(i).getmodel().equals(productObj.getmodel()))
				{
					IndexbyProduct = i;
					return IndexbyProduct;
				}
						
			 }
		 }
		return 0;
	 }
	 /**
	  *  @param productObj product to list
	  *  @param branchObj  branch of product
	  */
	 public void listProduct(Product productObj,Branch branchObj){
        
		 int index;
		
		 index = getIndexbyProduct(productObj, branchObj);
	
    	if(branchObj.getBranchManagement().products.get(index).getcolor() != null) {
    		System.out.printf("\nBranch : %s \nProduct Type : %s \nProduct Model : %s \nProduct Color: %s \nProduct Stock : %d\n",branchObj.getName(),
    				branchObj.getBranchManagement().products.get(index).getProductType(),branchObj.getBranchManagement().products.get(index).getmodel(),
    					branchObj.getBranchManagement().products.get(index).getcolor(),branchObj.getBranchManagement().products.get(index).getstock());
    	}
    	else {
    		System.out.printf("\nBranch : %s \nProduct Type : %s \nProduct Model : %s \nProduct Stock : %d\n",branchObj.getName(),branchObj.getBranchManagement().products.get(index).getProductType(),
    				branchObj.getBranchManagement().products.get(index).getmodel(),branchObj.getBranchManagement().products.get(index).getstock());
    	}
        
            
    }
	 /**
	  * 
	  * @param productObj product to be supplied
	  * @param branchObj branch of the product
	  */
	 public void productInquire(Product productObj,Branch branchObj)
	 {
		 branchObj.getBranchManagement().setwarning(true, productObj);
		 System.out.println("Admine alert has been sent successfully.");
		
	 }
	 /**
	  *  @param customerNumber the number of the customer whose orders are to be listed
	  */
	 public void orderList(int customerNumber)
	 {
		 for(int i=0; i<dataBase.getcusotomerSize(); i++)
		 {
			 if(dataBase.customerList.get(i).customerNumber == customerNumber)
				 dataBase.customerList.get(i).orderList(customerNumber);
		 }
	 }
	 public void listCustomers(){
        for(int i=0;i<dataBase.getcusotomerSize();i++)
            System.out.printf("%s %s , %s ,CustomerNumber : %d\n",dataBase.customerList.get(i).getName(),dataBase.customerList.get(i).getlastName(),dataBase.customerList.get(i).getemail(),dataBase.customerList.get(i).getCustomerNumber());
    }
	
}
