
public class Database {	
	protected ArrayList<Administrator>administratorList;	
	protected ArrayList<Customer>customerList;
	private int customerSize;	
	private int adminSize;
	protected ArrayList<BranchEmployee>branchEmpList;
	protected LinkedList<Branch>branchList;		
	private int branchEmployeeSize;	
	private int branchSize;	
	public Database()
	{	
		administratorList=new ArrayList<>();
		customerList=new ArrayList<>();
		branchEmpList=new ArrayList<>();
		branchList=new LinkedList<>();
		adminSize =0;   	 
   	 	customerSize=0;	  	   	
	   	branchSize=0;
	   	branchEmployeeSize=0;
	}
	/**
	 * 
	 * @param temp new admin object
	 */
	 public void setDatabase(Administrator temp)
	 {
		 administratorList.add(temp);		 
		 adminSize++;
	 }
	 /**
	  * 
	  * @return Admin count
	  */
	 public int getAdminSize()
	 {
		 return adminSize;
	 }
	
	 /**
	  * 
	  * @return customer size
	  */
	 public int getcusotomerSize()
	 {
		 return customerSize;
	 }
	 /**
	  * 
	  * @param customerSize new customer size
	  */
	 public void setcusotomerSize(int customerSize)
	 {
		this.customerSize =customerSize;
	 }
	 /**
	  * 
	  * @return Branch employee size
	  */
	 public int getbranchEmployeeSize()
	{
		return branchEmployeeSize;
	}
	 /**
	  * 
	  * @param employeeSize new employee size
	  */
	 public void setbranchEmployeeSize(int employeeSize)
	 {
		this.branchEmployeeSize = employeeSize;
	 }
	 
	 /**
	  * 
	  * @return branch size
	  */
	 public int getbranchSize()
	{
		return branchSize;
	}
	 /**
	  * 
	  * @param branchsize new branch size
	  */
	 public void setbranchSize(int branchsize)
	 {
		this.branchSize = branchsize;
	 }
	 

}
