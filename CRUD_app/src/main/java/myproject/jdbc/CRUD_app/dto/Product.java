package myproject.jdbc.CRUD_app.dto;

public class Product {
private int productid;
private String productname;
private double price;
private String productDescription;

public Product() {
	
}
public int getProductid() {
	return productid;
}
public Product(int productid, String productname, double price, String productDescription) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.price = price;
	this.productDescription = productDescription;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

}