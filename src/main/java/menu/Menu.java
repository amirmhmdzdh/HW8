package menu;

import service.admin.AdminService;
import service.cart.CartService;
import service.category.CategoryService;
import service.customer.CustomerService;
import service.product.ProductService;
import utility.ApplicationContex;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService = ApplicationContex.getCustomerService();
    private final AdminService adminService = ApplicationContex.getAdminService();
    private final CategoryService categoryService = ApplicationContex.getCategoryService();
    private final ProductService productService = ApplicationContex.getProductService();
    private final CartService cartService = ApplicationContex.getCartService();

    public Menu() {
    }

    public void publicMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("***  Welcome to our online store  *** ");
            System.out.println();
            System.out.println(" Please select the desired section :)  ");
            System.out.println("1- Customer ");
            System.out.println("2- Admin ");


            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> customerMenu();
                    case 2 -> adminMenu();
                    default -> throw new
                            InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER NUMBER!!!");
            }

        }
    }


    public void customerMenu() {

        boolean back = false;

        while (!back) {
            System.out.println(" CUSTOMER MENU ");
            System.out.println();
            System.out.println(" 1-Sign Up ");
            System.out.println(" 2-Entry and order registration ");
            System.out.println(" 3-delete Cart ");
            System.out.println(" 4-Edite profile ");
            System.out.println(" 5-delete Account ");


            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> signup();
                    case 2 -> signin();
                    case 3 -> deleteCart();
                    case 4 -> update();
                    case 5 -> delete();
                    default -> throw new
                            InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER NUMBER!!!");
            }

        }
    }


    public void adminMenu() {

        boolean back = false;

        while (!back) {
            System.out.println(" Admin Menu ");
            System.out.println();
            System.out.println(" 1- Login to own Account");
            System.out.println(" 2- Add category ");
            System.out.println(" 3- Add Product ");

            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> signIN();
                    case 2 -> addCategory();
                    case 3 -> addProduct();
                    default -> throw new
                            InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER NUMBER!!!");
            }

        }
    }


    private void signup() {

        customerService.signUp();


    }

    private void signin() {
        customerService.signIn();
        System.out.println(" WELCOME ");
        System.out.println(" **** CATEGORIES **** ");
        System.out.println();
        categoryService.findAllCategory();
        System.out.println();
        System.out.println(" **** PRODUCTS **** ");
        System.out.println();
        productService.findAllProduct();
        System.out.println();
        System.out.println(" **** Please complete your shopping cart ****");
        try {
            cartService.saveCart();
        } catch (SQLException e) {
            System.out.println("An error occurred while saving the cart: " + e.getMessage());
        }
    }

    private void update() {
        customerService.editeProfile();

    }

    private void delete() {
        customerService.deleteAccount();
    }

    private void signIN() {

        adminService.signIn();
    }

    private void addCategory() {
        categoryService.saveCategory();
    }

    private void addProduct() {
        productService.saveProduct();
    }

    private void deleteCart() {
        cartService.deleteCart();
    }

}