

public abstract class UserData implements UserDataInterface {
	
	 protected String userName;
	 protected int customerNumber = 100;
	 protected static int customerNumberCount=0; 
	 protected String firstName;
	 protected String lastName;
	 protected String password;
	 protected String emailAddress;
	
	 /**
	  * 
	  * @param userName for setusername
	  * @param password for setpassword
	  */
	public UserData(String userName,String password) {
	    this.userName = userName;
	    this.password = password;
	}
	/**
	 * 
	 * @param firstName for setfirstname
	 * @param lastName	for setlastname
	 * @param password	for setpassword	
	 * @param emailAddress	for setemailaddress
	 */
	public UserData(String firstName,String lastName,String password,String emailAddress)
	{	
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.emailAddress=emailAddress;
		this.customerNumber+= customerNumberCount;
		customerNumberCount++;
	}
	/**
	 * 
	 * @param userName setter of username 
	 */
	public abstract void setUsername(String userName);
	/**
	 * 
	 * @return UserName for admin and branchemployee
	 */
	public abstract String getUsername();
	/**
	 * @param name setter of name
	 */
	public void setName(String name)
	{
		this.firstName=name;
	}
	/**
	 *  @return first name
	 */
	public String getName()
	{
		return firstName;
	}
	/**
	 *  @param lastName setter of last name
	 */
	public void setlastName(String lastName)
	{
		this.lastName=lastName;
	}
	/**
	 *  @return last name
	 */
	public String getlastName() 
	{
		return lastName;
	}
	/**
	 *  @param email setter of email
	 */
	public void setemail(String email)
	{
		this.emailAddress=email;
	}
	/**
	 *  @return email
	 */
	public String getemail()
	{
		return emailAddress;
	}
	/**
	 *  @param password setter of password
	 */
	public void setPassword(String password)
	{
		this.password=password;
		
	}
	/**
	 *  @return password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 *  @return customer number
	 */
	public int getCustomerNumber()
	{
		return customerNumber;
	}
	public String toString(){
	    return "Name : " + this.getName() + "Surname :" +this.getlastName()+ "Email :"+ this.getemail();
	}
	
}
