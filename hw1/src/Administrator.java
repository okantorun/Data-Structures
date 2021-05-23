
public class Administrator extends UserData {

	
	//public final static AdministratorManagement aManage = new AdministratorManagement();
	
	private AdministratorManagement aManage;
	private Database dataBaseAdmin;
	public Administrator(String username,String password,AdministratorManagement aManage,Database dataBaseAdmin) {
	   	 super(username,password);
	   	 this.aManage = aManage;
	   	 this.dataBaseAdmin = dataBaseAdmin;
	    
   	
   }
	/**
	 * 
	 * @return Common object for users to link
	 */
	public AdministratorManagement getAdminManage() {
		return aManage;
	}
	
	/**
	 * 
	 * @param admin object to register
	 */
	public void createAdmin(Administrator admin) {
		if(dataBaseAdmin.getAdminSize()<5) {
			dataBaseAdmin.setDatabase(admin);
			System.out.println("Admin registration successful.");
		}
		else {
			System.out.println("There are enough admins in the system.");
		}
	} 
	
	/**
	 * 
	 * @return For common access to information in dataBase
	 */
	public Database adminAccsessDatabase()
	{
		return dataBaseAdmin;
	}
	
	/**
	 * @param userName  Setter of username
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	 }
	
	/**
	 * @return Getter of username
	 */
	 public String getUsername() {
	    return userName;
	 }
	 /**
	  * 
	  * @param admin this obejct for login info
	  */
	 public void adminLogin(Administrator admin)
	 {
		 boolean control = true;
		 for(int i=0;i<adminAccsessDatabase().getAdminSize();i++)
		 {
			 if(adminAccsessDatabase().dataAdministrator[i].getUsername().equals(admin.getUsername()) &&
					 adminAccsessDatabase().dataAdministrator[i].getPassword().equals(admin.getPassword()))
			 {
				 System.out.println("Admin Login successful.");
				 control=false;
			 }
			 
		 }
		 if(control)
			 System.out.println("Username or password is wrong.");
		 
	 }
	 public String toString(){
		    return "UserName : " + this.getUsername();
	}
	
 
}
