

public class Product {
	
	@SuppressWarnings("unused")
	private String productType;
	@SuppressWarnings("unused")
	private String model;
	@SuppressWarnings("unused")
	private String color;
	@SuppressWarnings("unused")
	private int stock;
	/**
	 * 
	 * @param productType setter of product type
	 * @param model	setter of product model
	 * @param color	setter of prodcut color
	 * @param stock	setter of product stock
	 */
	Product(String productType,String model,String color,int stock)
	{
		this.productType=productType;
		this.model=model;
		this.color=color;
		this.stock=stock;
		
		//addProduct();
	}
	/**
	 * 
	 * @param productType setter of product type
	 * @param model setter of prodcut model
	 * @param color	setter of prodcut model
	 */
	Product(String productType,String model,String color)
	{
		this.productType=productType;
		this.model=model;
		this.color=color;
	}
	/**
	 * 
	 * @param productType  setter of product type
	 * @param model setter of prodcut model
	 * @param stock setter of product stock
	 */
	Product(String productType,String model,int stock)
	{
		this.productType=productType;
		this.model=model;
		this.stock=stock;
	}
	/**
	 * 
	 * @param productType setter of product type
	 * @param model setter of prodcut model
	 */
	Product(String productType,String model)
	{
		this.productType=productType;
		this.model=model;
	}
	/**
	 * 
	 * @return Product type
	 */
	public String getProductType()
	{
		return productType;
	}
	
	/**
	 * 
	 * @return product model
	 */
	public String getmodel()
	{
		return model;
	}
	/**
	 * 
	 * @return product color
	 */
	public String getcolor()
	{
		return color;
	}
	/**
	 * 
	 * @param stock prodcut stock
	 */
	public void setstock(int stock)
	{
		this.stock=stock;
	}
	/**
	 * 
	 * @return product stock
	 */
	public int getstock()
	{
		return stock;
	}
	
	
}
