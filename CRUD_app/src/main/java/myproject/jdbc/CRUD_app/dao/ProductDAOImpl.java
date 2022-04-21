package myproject.jdbc.CRUD_app.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myproject.jdbc.CRUD_app.dto.Product;

	public class ProductDAOImpl implements ProductDAO {
		private Connection con;//Connection interface can be used to make connection with database
		private PreparedStatement stat;//can be used to write parameterized queries
		private Statement stmt;
		public ProductDAOImpl()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/java_map","root","password");
			System.out.println("Connection established");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver not found");
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}

			
			
		}
		
		@Override
		public void insertDetails(Product p1) {
			try
			{
			stat=con.prepareStatement("insert into product values(?,?,?,?)");
			stat.setInt(1,p1.getProductid());
			stat.setString(2, p1.getProductname());
			stat.setDouble(3, p1.getPrice());
			stat.setString(4, p1.getProductDescription());
			int result=stat.executeUpdate();
			if(result>0)
			{
				System.out.println("Inserted successfully");
			}
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}

			
		}
		@Override
		public void deleteDetails(int productid) {
			// TODO Auto-generated method stub
			
			
			try {
				stat = con.prepareStatement("Delete from product where product_id = (?);");
				stat.setInt(1, productid);
				int result = stat.executeUpdate();
				
				if(result>0) {
					System.out.println("Deleted Successfully");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		@Override
		public void updateDetails(int productid) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the new name");
			String newName = sc.next();
			System.out.println("Enter the new price");
			double value = sc.nextDouble();
			System.out.println("Enter the new description");
			String desc = sc.next();
			
			try {
				stat = con.prepareStatement("Update product set product_name = (?), product_price = (?), product_description = (?) where product_id = (?)");
				stat.setString(1, newName);
				stat.setDouble(2, value);
				stat.setString(3, desc);
				stat.setInt(4, productid);
				
				int result = stat.executeUpdate();
				
				if(result>0) {
					System.out.println("Updated Successfully");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		@Override
		public List<Product> getDetails() {
			
			List<Product> productlist = new ArrayList<>();
			// TODO Auto-generated method stub
			try {
				stmt = con.createStatement();
				String sql = "Select product_id, product_name, product_price, product_description from product;";
				ResultSet result = stmt.executeQuery(sql);
				while (result.next()) {
					int i = result.getInt("product_id");
					String name = result.getString("product_name");
					double price = result.getDouble("product_price");
					String desc = result.getString("product_description");				
					Product obj = new Product(i, name, price, desc);
					productlist.add(obj);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return productlist;
		}
		
		



}
