package service.cart;

import model.Product;
import base.service.BaseServiceImpel;
import model.Cart;
import repository.cart.CartRepository;
import service.product.ProductService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CartServiceImpel extends BaseServiceImpel<Integer, Cart, CartRepository> implements CartService {

    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService;

    public CartServiceImpel(CartRepository repository, ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    public void saveCart() {
        try {

            System.out.println("Please enter your ID");
            int customerId = scanner.nextInt();

            System.out.println("Please enter your desired product ID: ");
            int productId = scanner.nextInt();

            System.out.println("Please enter the quantity: ");
            int quantity = scanner.nextInt();

            Product product = productService.findById(productId);
            if (product != null) {
                int productPrice = product.getPrice();
                int totalPrice = productPrice * quantity;

                Cart cart = new Cart(customerId, productId, quantity, totalPrice);

                int result = repository.save(cart);
                ;
                result++;

                if (result > 0) {
                    System.out.println("Your cart was successfully added :)");

                    repository.showCartById(customerId);

                    System.out.println(" Total Price : " + repository.calculateTotalPrice(customerId));

                    System.out.println(" *Thank you for your purchase* ");

                } else {
                    System.out.println("Something went wrong :/");
                }
            } else {
                System.out.println("Product not found!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        } catch (SQLException e) {
            System.out.println("An error occurred while saving the cart: " + e.getMessage());
        }
    }


    @Override
    public void deleteCart() {

        System.out.println("Enter the Customer ID : ");
        int customerId = scanner.nextInt();

        System.out.println("Enter the CartID that you want delete: ");
        int cartId = scanner.nextInt();

        try {
            repository.findById(customerId);
            Cart cart = repository.findById(cartId);
            if (cart != null ) {
                repository.delete(cartId);
                System.out.println("Cart with ID " + cartId + " has been successfully deleted.");
            } else {
                System.out.println("Cart with ID " + cartId + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while deleting the Cart: " + e.getMessage());
        }
    }
}
