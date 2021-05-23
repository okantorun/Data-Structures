

public class BranchManagement {
	
	
	private String name;
	@SuppressWarnings("unused")
	private int productTypeSize;
	@SuppressWarnings("unused")
	private int productTypeCap;
	protected HybridList<Product>products;
	protected Product requiredProduct ;
	private boolean warningStock;
	 public BranchManagement() {
		warningStock = false;
		requiredProduct = new Product("null","null","null",0);
        productTypeSize=0;
        productTypeCap=120;
        products=new HybridList<>();
        addProduct();
     }
	 /**
	  * 
	  * @param productType setter of product type
	  * @param model	setter of product model
	  * @param color	setter of product color
	  * @param stock	setter of product stock
	  */
	 public void setProduct(String productType,String model,String color,int stock)
   	{
    	Product temp;
    	temp = new Product(productType,model,color,stock);
    	products.add(temp);
   		productTypeSize++;
   	}
	 /**
	  * 
	  * @param productType setter of product type
	  * @param model  setter of product model
	  * @param stock  setter of product stock
	  */
    public void setProduct(String productType,String model,int stock)
   	{
    	Product temp;
    	temp = new Product(productType,model,stock);
    	products.add(temp);
   		productTypeSize++;
   	}
    /**
     * Each product is placed in a certain number when the branch is opened
     */
    public void addProduct() {
		for(int i=0;i<7;i++)
			for(int j=0;j<4;j++)
				setProduct("Chair","m"+i,"c"+j,5);
		for(int i=0;i<5;i++)
			for(int j=0;j<4;j++)
				setProduct("OfficeDesk","m"+i,"c"+j,5);
		for(int i=0;i<10;i++)
			for(int j=0;j<4;j++)
				setProduct("MeetingTable","m"+i,"c"+j,5);
		for(int i=0;i<12;i++)
			setProduct("BookCases","m"+i,5);
		for(int i=0;i<12;i++)
			setProduct("OfficeCabinets","m"+i,5);
	
	}
    /**
     * 
     * @param warningStock The admin understands the products that need to be supplied from this warning
     */
    public void setwarningStock(boolean warningStock)
    {
    	this.warningStock= warningStock;
    }
    /**
     * 
     * @param warningStock The admin is checking the warning
     * @param productObj The manager checks the required product
     */
    public void setwarning(boolean warningStock,Product productObj)
    {
    	this.warningStock=warningStock;
    	requiredProduct  =productObj;
    }
    /**
     * 
     * @return getter of warning
     */
    public boolean getwarningStock()
    {
    	return warningStock;
    }
    /**
     * 
     * @return getter of product type size
     */
    public int getProductTypeSize()
    {
    	return productTypeSize;
    }
    
    
}
