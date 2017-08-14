package Domain_Package;

public class Product {
	int productId, noOfProducts;
	String productName;
	String manufacturingUnit, manufacturingUnitLocation;
	float cost;


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturingUnit() {
		return manufacturingUnit;
	}
	public void setManufacturingUnit(String manufacturingUnit) {
		this.manufacturingUnit = manufacturingUnit;
	}
	public String getManufacturingUnitLocation() {
		return manufacturingUnitLocation;
	}
	public void setManufacturingUnitLocation(String manufacturingUnitLocation) {
		this.manufacturingUnitLocation = manufacturingUnitLocation;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
