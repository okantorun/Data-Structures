

public class Orders {
	private String customerId;
	private String productId;
	private String productName;
	private int price;
	private int discPrice;
	private String traderName;
	private String status;
	public Orders(String customerId,String productId,String productName,
								String price,String discPrice,String traderName,String status)
	{
		this.customerId =customerId;
		this.productId =productId;
		this.productName = productName;
		this.price =Integer.parseInt(price);
		this.discPrice =Integer.parseInt(discPrice);
		this.traderName = traderName;
		this.status =status;
	}
	public String getCustomerId() {
		return customerId ;
	}
	public String getProductId() {
		return productId ;
	}
	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price ;
	}
	public int getDiscPrice() {
		return discPrice;
	}
	public String getTraderName() {
		return traderName;
	}
	public String getStatus() {
		return status;
	}
}
