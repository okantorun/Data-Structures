

public class BranchEmployee extends UserData {
	
	private BranchEmployeeManagement empManage;
	String branchName;
	
	/**
	 * 
	 * @param username setter of username
	 * @param password setter of password
	 * @param branchName setter of branchname
	 * @param empManage	setter of BranchEmployeeManagement
	 */
	public BranchEmployee(String username,String password,String branchName,BranchEmployeeManagement empManage) {
    	 super(username,password);
    	 this.empManage=empManage;
    	 this.branchName = branchName;
    }
	/**
	 * 
	 * @return getter of BranchEmployeeManagement
	 */
	public BranchEmployeeManagement getBranchEmployeeManage() {
		return empManage;
	}
	/**
	 *  @param userName setter of employee username
	 */
	@Override
	public void setUsername(String userName)
	{
		this.userName=userName;
		
	}
	/**
	 * @return getter of  employee username
	 */
	@Override
	public String getUsername()
	{
		return userName;
	}
	/**
	 * 
	 * @return getter of employee branch name
	 */
	public String getBranchName()
	{
		return branchName;
	}
	 public String toString(){
		    return "UserName: " + this.getUsername() +"BranchName"+ this.getBranchName();
	}
	
}
