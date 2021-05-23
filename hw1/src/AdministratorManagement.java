

public class AdministratorManagement {
	
	private Database dataBase;
	
	/**
	 * 
	 * @param dataBaseAdmin To establish a common connection with the database
	 */
	public AdministratorManagement(Database dataBaseAdmin) {
	   	
		this.dataBase=dataBaseAdmin;
   }
	
	 /**
	  * 
	  * @return Employee number
	  */
	public int getbranchEmployeeSize()
	{
		return dataBase.getbranchEmployeeSize();
		
	}
	/**
	 * 
	 * @return Employee capacity
	 */
	public int getbranchEmployeeCap()
	{
		return dataBase.getbranchEmployeeCap();
		
	}
	/**
	 * 
	 * @param newEmployee new employee object
	 */
	public void setBranchEmployee(BranchEmployee newEmployee){
        dataBase.branchEmployees[getbranchEmployeeSize()] = newEmployee;
        dataBase.setbranchEmployeeSize(getbranchEmployeeSize()+1);
    }
	/**
	 * 
	 * @param newEmployee new employee object
	 */
	 public void addBranchEmployee(BranchEmployee newEmployee){
		 if(getbranchEmployeeSize()==getbranchEmployeeCap()) {
			BranchEmployee[] temp = new BranchEmployee[getbranchEmployeeCap()*2];
			for(int i = 0; i  <getbranchEmployeeSize(); i++) {
				temp[i]=dataBase.branchEmployees[i];
			}
			dataBase.branchEmployees = temp;
			dataBase.setbranchEmployeeCap(getbranchEmployeeCap()*2);
		}
	
        setBranchEmployee(newEmployee);
        System.out.println("Branch Employee successfully added. ");
       
    }
	 /**
	  * 
	  * @param deleteBranchEmployee Employee to be deleted
	  * @throws Exception If there is no employee requested to be deleted 
	  */
	 public void removeBranchEmployee(BranchEmployee deleteBranchEmployee) throws Exception{
        int delete = 0;
        boolean control = false;
        for(int i=0;i<getbranchEmployeeSize();i++){
            if(dataBase.branchEmployees[i].getUsername().equals(deleteBranchEmployee.getUsername())){
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<getbranchEmployeeSize()-1;i++)
                dataBase.branchEmployees[i] = dataBase.branchEmployees[i+1];
            dataBase.setbranchEmployeeSize(getbranchEmployeeSize()-1);
            System.out.println("Branch Employee successfully removed. ");
        }
        else
        	throw new Exception("Error : This branch employee does not exist !!!");
    }
	 /**
	  * 
	  * @param num the index number to be returned
	  * @return Branch Employee
	  */
    public BranchEmployee getBrancEmployee(int num)
    {
        return dataBase.branchEmployees[num];
    }
    /**
     * 
     * @return Branch number
     */
    public int getbranchSize()
	{
		return dataBase.getbranchSize();
	}
    /**
     * 
     * @return Branch Capacity
     */
    public int getbranchCap()
	{
		return dataBase.getbranchCap();
	}
    /**
     * 
     * @param newBranch setter of new branch
     */
	public void setBranch(Branch newBranch){
        dataBase.branch[getbranchSize()] = newBranch;
        dataBase.setbranchSize(getbranchSize()+1);
    }
	
	/**
	 * 
	 * @param num the index number to be returned
	 * @return Branch 
	 */
    public Branch getBranch(int num){
        return dataBase.branch[num];
    }
    
    /**
     * 
     * @param newBranch new Baranch for adding
     * @throws IllegalArgumentException re-adding the existing branch
     */
    public void addBranch(Branch newBranch) throws IllegalArgumentException{
    	
    	if(getbranchSize()==getbranchCap()) {
			Branch[] temp = new Branch[getbranchCap()*2];
			for(int i = 0; i  <getbranchCap(); i++) {
				temp[i]=dataBase.branch[i];
			}
			dataBase.branch = temp;
			dataBase.setbranchCap(getbranchCap()*2);
		}
		 boolean control = true;
	     
        for(int i=0;i<getbranchSize();i++){
            if(dataBase.branch[i].getName().equals(newBranch.getName()))
                control = false;
        }
        if(control) {
            setBranch(newBranch);
            System.out.println("Branch successfully added. ");
        }
        else
        	throw new IllegalArgumentException("Already existing " + newBranch.getName() +" in the set object cannot be added.");
    	
    	
    }
    /**
     * 
     * @param deleteBranch branch to be deleted
     * @throws Exception There is no branch to be deleted.
     */
    public void removeBranch(Branch deleteBranch)throws Exception{
        int delete = 0;
        boolean control = false;
        for(int i=0;i<getbranchSize();i++){
            if(dataBase.branch[i].getName().equals(deleteBranch.getName())){
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<getbranchSize()-1;i++)
                dataBase.branch[i] = dataBase.branch[i+1];
            dataBase.setbranchSize(getbranchSize()-1);
        }
        else
        	throw new Exception("Error : There is no " + deleteBranch.getName() +" so it cannot be deleted");
    }
    
    @SuppressWarnings("static-access")
	public void productSupplied()
    {
    	boolean control = true;
    	for(int i=0; i<getbranchSize();i++)
    	{	
    		if(dataBase.branch[i].getBranchManagement().getwarningStock())
    		{
    			for(int j=0;j<dataBase.branch[i].getBranchManagement().getProductTypeSize();j++)
    			{	
    				if(dataBase.branch[i].getBranchManagement().requiredProduct.getcolor() !=null) {
	    				if(dataBase.branch[i].getBranchManagement().products[j].getmodel().equals(dataBase.branch[i].getBranchManagement().requiredProduct.getmodel()) &&
	    						dataBase.branch[i].getBranchManagement().products[j].getcolor().equals(dataBase.branch[i].getBranchManagement().requiredProduct.getcolor()) &&
	    								dataBase.branch[i].getBranchManagement().products[j].getProductType().equals(dataBase.branch[i].getBranchManagement().requiredProduct.getProductType()))
	    				{
	    					dataBase.branch[i].getBranchManagement().products[j].setstock(5);
	    					dataBase.branch[i].getBranchManagement().setwarningStock(false);
	    					System.out.println("The product has been successfully supplied.");
	    					break;
	    				}
    				}
    				else {
    					if(dataBase.branch[i].getBranchManagement().products[j].getmodel().equals(dataBase.branch[i].getBranchManagement().requiredProduct.getmodel()) &&
    							dataBase.branch[i].getBranchManagement().products[j].getProductType().equals(dataBase.branch[i].getBranchManagement().requiredProduct.getProductType()))
    					{
    						dataBase.branch[i].getBranchManagement().products[j].setstock(5);
    						dataBase.branch[i].getBranchManagement().setwarningStock(false);
    						System.out.println("The product has been successfully supplied.");
    						break;
    					}
    					
					}
    				control =false;
    			}
    		}
    	}
    	if(control) 
			System.out.println("There is no product to be supplied.");
		
    }
    public void listBranch(){
        for(int i=0;i<getbranchSize();i++)
            System.out.printf("%d. Branch) %s\n",i+1,dataBase.branch[i].getName());
    }
    public void listBranchEmployee(){
        for(int i=0;i<getbranchEmployeeSize();i++)
            System.out.printf("%d. Branch Employee) %s - %s branch\n",i+1,dataBase.branchEmployees[i].getUsername(),dataBase.branchEmployees[i].getBranchName());
    }
	
    
   
	
}
