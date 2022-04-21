package myproject.jdbc.CRUD_app;

import java.util.List;
import java.util.Scanner;

import myproject.jdbc.CRUD_app.dto.Product;
import myproject.jdbc.CRUD_app.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	int c;
    	ProductService pservice=new ProductService();
    	while(true) {
    		
    		System.out.println("Press 1 to insert the details");
    		System.out.println("Press 2 to delete the record");
    		System.out.println("Press 3 to update the record");
    		System.out.println("Press 4 to display the record");
    		System.out.println("Press 5 to exit");
    		Scanner sc = new Scanner(System.in);
    		c = sc.nextInt();
    		
    		if(c == 1) {
    			pservice.insert();
    			
    		}
    		else if(c == 2) {
    			pservice.delete();
    		}
    		else if(c == 3) {
    			pservice.updateDetails();
    		}
    		else if(c == 4) {
    			List<Product> p = pservice.getList();
    			for(Product ele: p) {
    				
    				System.out.println("Product Id: " +ele.getProductid());
    				System.out.println("Product name: "+ ele.getProductname());
    				System.out.println("Product Price: "+ ele.getPrice());
    				System.out.println("Product Description: "+ ele.getProductDescription());
    				
    			}
    			
    		}
    		else if(c == 5) {
    			break;
    		}
    		
    		
    	}
    	
    }
}
