
import java.util.Iterator;

public class AdministratorManagement {
	
	private Database dataBase;
	//@SuppressWarnings({ "unchecked", "unused" })
	//private OLinkedList<Branch>tempListIterator;
	
	/**k
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
	 * @param newEmployee new employee object
	 */
	public void setBranchEmployee(BranchEmployee newEmployee){
		dataBase.branchEmpList.add(newEmployee);
        dataBase.setbranchEmployeeSize(getbranchEmployeeSize()+1);
        
    }
	/**
	 * 
	 * @param newEmployee new employee object
	 */
	 public void addBranchEmployee(BranchEmployee newEmployee){ 
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
            if(dataBase.branchEmpList.get(i).getUsername().equals(deleteBranchEmployee.getUsername())){
                delete = i;
                control = true;
            }
        }
        if(control){           
            dataBase.setbranchEmployeeSize(getbranchEmployeeSize()-1);
            dataBase.branchEmpList.remove(delete);
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
        return dataBase.branchEmpList.get(num);
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
     * @param newBranch setter of new branch
     */
	public void setBranch(Branch newBranch){
		dataBase.branchList.addLast(newBranch);
		dataBase.setbranchSize(getbranchSize()+1);
    }
	
	/**
	 * 
	 * @param num the index number to be returned
	 * @return Branch 
	 */
    public Branch getBranch(int num){
        return dataBase.branchList.get(num);
    }
    
    /**
     * 
     * @param newBranch new Baranch for adding
     * @throws IllegalArgumentException re-adding the existing branch
     */
    public void addBranch(Branch newBranch) throws IllegalArgumentException{
    	    	
		 boolean control = true;
	     
        for(int i=0;i<getbranchSize();i++){    
        	if(dataBase.branchList.get(i).getName().equals(newBranch.getName()))
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
        	if(dataBase.branchList.get(i).getName().equals(deleteBranch.getName())) {
                delete = i;
                control = true;
            }
        }
        if(control){          
            dataBase.branchList.remove(deleteBranch);
            dataBase.setbranchSize(getbranchSize()-1);
            System.out.println("Branch successfully removed. ");
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
    		if(dataBase.branchList.get(i).getBranchManagement().getwarningStock())
    		{
    			for(int j=0;j<dataBase.branchList.get(i).getBranchManagement().getProductTypeSize();j++)
    			{	
    				if(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getcolor() !=null) {
	    				if(dataBase.branchList.get(i).getBranchManagement().products.get(j).getmodel().equals(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getmodel()) &&
	    						dataBase.branchList.get(i).getBranchManagement().products.get(j).getcolor().equals(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getcolor()) &&
	    								dataBase.branchList.get(i).getBranchManagement().products.get(j).getProductType().equals(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getProductType()))
	    				{
	    					dataBase.branchList.get(i).getBranchManagement().products.get(j).setstock(5);
	    					dataBase.branchList.get(i).getBranchManagement().setwarningStock(false);
	    					System.out.println("The product has been successfully supplied.");
	    					break;
	    				}
    				}
    				else {
    					if(dataBase.branchList.get(i).getBranchManagement().products.get(j).getmodel().equals(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getmodel()) &&
    							dataBase.branchList.get(i).getBranchManagement().products.get(j).getProductType().equals(dataBase.branchList.get(i).getBranchManagement().requiredProduct.getProductType()))
    					{
    						dataBase.branchList.get(i).getBranchManagement().products.get(j).setstock(5);
    						dataBase.branchList.get(i).getBranchManagement().setwarningStock(false);
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
    	int i=0;
    	 @SuppressWarnings({ "unchecked", "unused" })
		Iterator<Branch> iterator =dataBase.branchList.listIterator();
    	while(iterator.hasNext())
    	{
    		System.out.printf("%d. Branch) %s\n",i+1,iterator.next().getName());
    		i++;
    	}
    }
    public void listBranchEmployee(){
        for(int i=0;i<getbranchEmployeeSize();i++)
            System.out.printf("%d. Branch Employee) %s - %s branch\n",i+1,dataBase.branchEmpList.get(i).getUsername(),dataBase.branchEmpList.get(i).getBranchName());
    }
	
    
   
	
}
