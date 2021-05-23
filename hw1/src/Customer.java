



public class Customer extends UserData implements CustomerController  {

	private Product[] orderArr;
	private int orderCount;
	private Database dataBase;
	
	
	/**
	 * 
	 * @param Name setter of name
	 * @param lastName setter of last name
	 * @param password	setter of password
	 * @param emailAddress	setter of email address
	 * @param dataBase  To establish a common connection with the database
	 */
	Customer(String Name,String lastName,String password,String emailAddress,Database dataBase)
	{
		super(Name,lastName,password,emailAddress);
		orderArr = new Product[20];
		orderCount = 0;
		this.dataBase = dataBase;
	}
	/**
	 * @param userName setter of usurname
	 */
	public void setUsername(String userName)
	{
		this.userName = "No info";
	}
	/**
	 * @return getter of username
	 */
	public String getUsername()
	{
		return userName;
	}
	/**
	 * 
	 * @return Order count
	 */
	public int getOrderCount()
	{
		return orderCount;
	}
	/**
	 * 
	 * @param objProduct new order product
	 */
	public void newOrder(Product objProduct)
	{
		orderArr[orderCount] = objProduct;
		orderCount++;
	}
	/**
	 * 
	 * @param customer for customer login customer object
	 */
	public void customerLogin(Customer customer)
	 {
		 boolean control = true;
		 for(int i=0;i< dataBase.getcusotomerSize();i++)
		 {
			 if(dataBase.customer[i].getemail().equals(customer.getemail()) &&
					 dataBase.customer[i].getPassword().equals(customer.getPassword()))
			 {
				 System.out.println("Customer Login successful.");
				 control=false;
			 }
			 
		 }
		 if(control)
			 System.out.println("E-mail or password is wrong.");
		 
	 }
	/**
	 * 
	 * @param customerObj the Online Purchaser
	  * @param newProduct Product to sale
	  * @param brancjObj Branch to sell
	  * @throws Exception Tries to re-add an existing customer
	 */
	 public void saleOnlineProduct(Customer customerObj,Product newProduct,Branch brancjObj)throws Exception
	 {	
		 int i,temp = 0;
		
		 for(i=0;i<dataBase.getcusotomerSize();i++) {
            if(dataBase.customer[i].getName().equals(customerObj.getName()) &&
            		dataBase.customer[i].getlastName().equals(customerObj.getlastName())) 
            {
                temp=i;
            }
         }
		
       
       
        if(( brancjObj.getBranchManagement().products[getIndexbyProduct(newProduct, brancjObj)].getstock())>0) {
        	dataBase.customer[temp].newOrder(newProduct);
        	removeProduct(newProduct, brancjObj, 1);
        	System.out.println("The product has been successfully sold.");
        }
        else {
        	throw new Exception("Error : No stock enough");
			
		}
	            
		 
	 }
	 /**
	  * 
	 * @param newProduct product to be reduced
	  * @param brancjObj branch to decrease
	  * @param stockSize amount to be reduced
	  */
	 public void removeProduct(Product newProduct,Branch brancjObj,int stockSize) 
	 {
		 brancjObj.getBranchManagement().products[getIndexbyProduct(newProduct, brancjObj)].
			setstock(brancjObj.getBranchManagement().products[getIndexbyProduct(newProduct, brancjObj)].getstock()-stockSize) ;
		
	 }
	 /**
	  *  @param productObj product to list
	  *  @param branchObj  branch of product
	  */
	public void listProduct(Product productObj,Branch branchObj){
        
		 int index;
		 index = getIndexbyProduct(productObj, branchObj);
		 
	   	if(branchObj.getBranchManagement().products[index].getcolor() != null) {
	   		System.out.printf("\nBranch : %s \nProduct Type : %s \nProduct Model : %s \nProduct Color: %s \n",branchObj.getName(),
	   				branchObj.getBranchManagement().products[index].getProductType(),branchObj.getBranchManagement().products[index].getmodel(),
	   					branchObj.getBranchManagement().products[index].getcolor());
	   	}
	   	else {
	   		System.out.printf("\nBranch : %s \nProduct Type : %s \nProduct Model : %s \n",branchObj.getName(),branchObj.getBranchManagement().products[index].getProductType(),
	   				branchObj.getBranchManagement().products[index].getmodel());
	   	}
       
           
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
				if( brancjObj.getBranchManagement().products[i].getProductType().equals(productObj.getProductType()) &&
						brancjObj.getBranchManagement().products[i].getcolor().equals(productObj.getcolor()) &&
							brancjObj.getBranchManagement().products[i].getmodel().equals(productObj.getmodel()))
				{
					IndexbyProduct = i;
					return IndexbyProduct;
				}
						
			 }
		 }
		 else 
		 {
			 for(int i=0;i<brancjObj.getBranchManagement().getProductTypeSize();i++) {
				if( brancjObj.getBranchManagement().products[i].getProductType().equals(productObj.getProductType()) &&
						brancjObj.getBranchManagement().products[i].getmodel().equals(productObj.getmodel()))
				{
					IndexbyProduct = i;
					return IndexbyProduct;
				}
						
			 }
		 }
		return 0;
	 }
	 /**
	  *  @param customerNumber the number of the customer whose orders are to be listed
	  */
	public void orderList(int customerNumber)
	{
		
		 for(int i=0; i<dataBase.getcusotomerSize(); i++)
		 {
			 if(dataBase.customer[i].customerNumber == customerNumber)
			 {
				
			 System.out.println("Customer number "+dataBase.customer[i].getCustomerNumber());
				 for(int j=0;j<orderCount;j++)
				{
					if(dataBase.customer[i].orderArr[j].getcolor() != null) {
						System.out.printf("%s %s %s\n",dataBase.customer[i].orderArr[j].getProductType(),
								dataBase.customer[i].orderArr[j].getmodel(),dataBase.customer[i].orderArr[j].getcolor());
					}
					else {
						System.out.printf("%s %s\n",dataBase.customer[i].orderArr[j].getProductType(),
								dataBase.customer[i].orderArr[j].getmodel());
					}
				}
			 }
		 }
		
	}
	/**
	 *  @param newCustomer new customer object
	 */
	public void setCustomers(Customer newCustomer){
        dataBase.customer[dataBase.getcusotomerSize()] = newCustomer;
        dataBase.setcusotomerSize
        	(dataBase.getcusotomerSize()+1);
    }
	/**
	  *  @param newCustomer new customer for adding array
	 */
	public void addCustomer(Customer newCustomer){
		int i;
		if(dataBase.getcusotomerSize()==dataBase.getcusotomerCap()) {
			Customer[] temp = new Customer[dataBase.getcusotomerCap()*2];
			for(i=0;i<dataBase.getcusotomerCap();i++) {
				temp[i]=dataBase.customer[i];
			}
			dataBase.customer = temp;
			dataBase.setcusotomerCap(dataBase.getcusotomerCap()*2);
		}
        boolean control = true;
     
        for(i=0;i<dataBase.getcusotomerSize();i++){
            if(dataBase.customer[i].getName().equals(newCustomer.getName()) &&
            		dataBase.customer[i].getlastName().equals(newCustomer.getlastName()))
                control = false;
        }
        if(control) {
            setCustomers(newCustomer);
            System.out.println("You have successfully registered, your customer number is "+dataBase.customer[i].getCustomerNumber());
        }
        else
            System.out.println("This customer is available");
        
    }
	/**
	 * @param deleteCustomer Customer who wants to delete their membership
	 */
	 public void removeCustomer(Customer deleteCustomer){
        int delete = 0;
        boolean control = false;
        for(int i=0;i<dataBase.getcusotomerSize();i++){
            if(dataBase.customer[i].getName().equals(deleteCustomer.getName()) &&
            		dataBase.customer[i].getlastName().equals(deleteCustomer.getlastName()))
            {
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<dataBase.getcusotomerSize()-1;i++)
                dataBase.customer[i] = dataBase.customer[i+1];
            dataBase.setcusotomerSize(dataBase.getcusotomerSize()-1);
        
        }
	 }
	
}
