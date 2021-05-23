

public interface CustomerController {
	/**
	 * 
	 *  @param newCustomer new customer for store sale
	  *  @throws Exception Tries to re-add an existing customer
	 */
	public void addCustomer(Customer newCustomer) throws Exception;
	/**
	 * 
	*  @param newCustomer new customer object
	 */
	public void setCustomers(Customer newCustomer);
	/**
	 * 
	 * @param deleteCustomer Customer object to be deleted
	 * @throws Exception 
	 */
	public void removeCustomer(Customer deleteCustomer) throws Exception;
	/**
	 * 
	 * @param customerNumber the number of the customer whose orders are to be listed
	 */
	public void orderList(int customerNumber);
	/**
	 * 
	  *  @param productObj product to list
	  *  @param branchObj  branch of product
	 */
	public void listProduct(Product productObj,Branch branchObj);
}
