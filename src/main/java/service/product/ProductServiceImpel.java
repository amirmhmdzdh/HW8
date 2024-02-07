package service.product;

import base.service.BaseServiceImpel;
import model.Product;
import repository.product.ProductRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductServiceImpel extends BaseServiceImpel<Integer, Product, ProductRepository> implements ProductService {

    private final Scanner scanner = new Scanner(System.in);

    public ProductServiceImpel(ProductRepository repository) {
        super(repository);
    }

    @Override
    public void saveProduct() {

        String name;
        while (true) {
            System.out.print("Please enter the name of the Product you want: ");
            name = scanner.next();
            if (Validation.isValidName(name))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        String description;
        while (true) {
            System.out.println("Please enter a description of your Product: ");
            description = scanner.next();
            if (Validation.isValidName(description))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        String gender;
        while (true) {
            System.out.println("Please enter a Gender of your Product: ");
            gender = scanner.next();
            if (Validation.isValidName(gender))
                break;
            else
                System.out.println("Invalid input! Please enter a Gender .");
        }
        String color;
        while (true) {
            System.out.print("Please enter the color of the Product you want: ");
            color = scanner.next();
            if (Validation.isValidName(color))
                break;
            else
                System.out.println("Invalid input! Please enter a Color .");
        }
        System.out.println("Please enter the product size: ");
        int size = scanner.nextInt();

        System.out.println("Please enter the product price: ");
        int price = scanner.nextInt();

        System.out.println("Please enter the category ID: ");
        int categoryId = scanner.nextInt();

        Product product = new Product(name, description, gender, color, size, price, categoryId);

        int result = 0;
        try {
            result = repository.save(product);
            result++;

        } catch (SQLException e) {
            System.out.println("An error occurred while saving the product : " + e.getMessage());
        }
        if (result > 0) {
            System.out.println(name + "you successfully added :)");
        } else {
            System.out.println("something is wrong :/");
        }

    }

    @Override
    public void findAllProduct() {

        try {
            Product[] products = repository.findAllProduct();

            for (Product product : products) {
                System.out.println(product);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving the products: " + e.getMessage());
        }
    }
}
