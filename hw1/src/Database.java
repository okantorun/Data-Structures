

public class Database {
	protected Administrator[] dataAdministrator;
	protected Customer[] customer;
	private int customerSize;
	private int customerCap;
	private int adminSize;
	protected BranchEmployee[] branchEmployees;
	@SuppressWarnings("unused")
	protected Branch[] branch;
	private int branchEmployeeSize;
	private int branchEmployeeCapacity;
	private int branchSize;
	private int branchCapacity;
	public Database()
	{	
		dataAdministrator =  new Administrator[5];
		adminSize =0;
		customer = new Customer[10];
   	 	customerCap=10;
   	 	customerSize=0;
	   	 branchEmployees = new BranchEmployee[10];
	   	 branch = new Branch[10];
	   	 branchCapacity=10;
	   	 branchSize=0;
	     branchEmployeeCapacity=10;
	   	 branchEmployeeSize=0;
	}
	/**
	 * 
	 * @param temp new admin object
	 */
	 public void setDatabase(Administrator temp)
	 {
		 dataAdministrator[adminSize] = temp;
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
	  * @return Customer capacity
	  */
	 public int getcusotomerCap()
	 {
		 return customerCap;
	 }
	 /**
	  * 
	  * @param customerCap new customer capacity
	  */
	 public void setcusotomerCap(int customerCap)
	 {
		this.customerCap =customerCap;
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
	  * @return Employee capacity
	  */
	 public int getbranchEmployeeCap()
	{
		return branchEmployeeCapacity;
	}
	 /**
	  * 
	  * @param employeeCap new employee capacity
	  */
	 public void setbranchEmployeeCap(int employeeCap)
	 {
		this.branchEmployeeCapacity = employeeCap;
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
	 /**
	  * 
	  * @return branch capacity
	  */
	 public int getbranchCap()
	{
		return branchCapacity;
	}
	 /**
	  * 
	  * @param branchcap new branch capacity
	  */
	 public void setbranchCap(int branchcap)
	 {
		this.branchCapacity = branchcap;
	 }

}
