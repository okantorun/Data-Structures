
public class Product {
	private String id;
	private String name;
	private String catogory;
	private int price ;
	private int discountedPrice;
	private String description;
	private String trader;
	
	public Product(String id,String name,String catogory,
				String price, String discountedPrice,String description,String trader) 
	{
		this.id=id;
		this.name=name;
		this.catogory=catogory;
		this.price=Integer.parseInt(price);
		this.discountedPrice=Integer.parseInt(discountedPrice);
		this.description=description;
		this.trader=trader;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCatagory() {
		return catogory;
	}
	public int getPrice() {
		return price;
	}
	public int getDiscountedPrice() {
		return discountedPrice;
	}
	public String getDescription() {
		return description;
	}
	public String getTrader() {
		return trader;
	}
	
	
	
}
