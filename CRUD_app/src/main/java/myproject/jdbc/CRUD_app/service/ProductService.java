package myproject.jdbc.CRUD_app.service;

import java.util.List;
import java.util.Scanner;

import myproject.jdbc.CRUD_app.dao.ProductDAOImpl;
import myproject.jdbc.CRUD_app.dto.Product;

public class ProductService {
	private Scanner sc;
	ProductDAOImpl daoimpl;
	public ProductService()
	{
		daoimpl=new ProductDAOImpl();
		sc=new Scanner(System.in);
		
	}
	public void insert()
	{
		System.out.println("Enter no of product u want to enter ");
		int noofproducts=sc.nextInt();
		for(int x=1;x<=noofproducts;x++)
		{
			Product p1=new Product();
			System.out.println("Enter product id ");
			p1.setProductid(sc.nextInt());
			System.out.println("Enter product name ");
			p1.setProductname(sc.next());
			System.out.println("Enter price ");
			p1.setPrice(sc.nextDouble());
			System.out.println("Enter description ");
			p1.setProductDescription(sc.next());
			daoimpl.insertDetails(p1);
			
		}
		
	}
	public void delete()
	{
		System.out.println("Enter the id of product you want to delete");
		int val = sc.nextInt();
		daoimpl.deleteDetails(val);
		
	}
	public void updateDetails()
	{
		System.out.println("Enter the id of product you want to update");
		int val = sc.nextInt();
		daoimpl.updateDetails(val);
		
	}
	public List<Product> getList()
	{	
		List<Product> obj1 = daoimpl.getDetails();
		return obj1;
		
	}

}