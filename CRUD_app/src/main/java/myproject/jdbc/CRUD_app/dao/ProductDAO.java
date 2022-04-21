package myproject.jdbc.CRUD_app.dao;

import java.util.List;

import myproject.jdbc.CRUD_app.dto.Product;

public interface ProductDAO {
public void insertDetails(Product p1);
public void deleteDetails(int productid);
public void updateDetails(int productid);
public List<Product> getDetails();
}
