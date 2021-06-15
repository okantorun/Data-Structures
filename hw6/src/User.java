
public class User {
	
	private final static int userIdLength = 8;
	private final static int passwordLength = 6;
	private String userId;
	private String password;
	
	public User(String userId,String password) throws Exception {
		if(userId.length()!=userIdLength || password.length()!=passwordLength) {
			throw new Exception("Error:You have missed your id or password !");
		}
		this.userId = userId;
		this.password = password;
		
	}
	public String getId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
}
