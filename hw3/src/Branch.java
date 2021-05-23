
public class Branch {
	
	private BranchManagement bManage ;
	private Database databaseBranch;
	private String name;
	
	/**
	 * 
	 * @param name setter of name
	 * @param bManage link for shared use of branches
	 * @param databaseBranch For branches to have common access to data
	 */
    public Branch(String name,BranchManagement bManage,Database databaseBranch) {   	
        this.name = name;
        this.bManage = bManage;
        this.databaseBranch = databaseBranch;
    }
    /**
     * 
     * @return getter of branch management object
     */
    
    public BranchManagement getBranchManagement()
    {
    	return bManage;
    }
    /**
     * 
     * @return getter of branch name
     */
    public String getName() {
        return name;
    }
    
   
}
