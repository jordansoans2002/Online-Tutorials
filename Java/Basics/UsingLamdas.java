import java.util.List;
import java.util.Arrays;

import java.util.LinkedList;

import java.util.function.Predicate;

import java.util.stream.Collectors;

import java.text.DecimalFormat;


public class Main {

    
    public static void main(String[] args) throws Exception {


        List<Product> store = new LinkedList<Product>(

            Arrays.asList(

                //ID  Name    Department     Price

                new Product(0,"Laptop","Electronics", 1099.99f),

                new Product(1,"Hat","Clothes", 5f),

                new Product(2,"Stove","Kitchen", 800.70f),

                new Product(3,"Camara","Electronics", 50.50f),

                new Product(4,"Fridge","Kitchen", 960.25f),

                new Product(5,"Sweater","Clothes", 25f),

                new Product(6,"Scanner","Electronics", 346.60f),

                new Product(7,"Microwave","Kitchen", 490.10f),

                new Product(8,"Pants","Clothes", 10.30f)

            )

        );


        //Print each of the products

            System.out.println("Original List:");

        



        //Filter and print the Products which belongs to the Electronics department

		List <Product>= new LinkerList<>().stream().filter(
			Product p -> p.department().equalsIgnoreCase("Electronics"))
			collect(Collecters.toList());
            System.out.println("Only Electronics:");

        


        //Remove Products which belongs to the Kitchen department

        
        //Print each of the products

            System.out.println("\n\nWithout Kitchen department, list:");




        //Print products that are chepear than $800.00

            System.out.println("\n\nCheap products:");

        

        //Remove Products that more expensive than $700.00

        
        //Print each of the products

            System.out.println("\n\nWithout Expensive products, list:");


    }

}



class Product {

    public int id;

    public String name, department;

    public float price;

    
    public Product(int id, String name, String department, float price) {

        this.id = id;

        this.name = name;

        this.department = department;

        this.price = price;

    }
    
    

    public String toString(){

        return ( this.name + (new DecimalFormat(" $0.00")).format(this.price) );

    }

}