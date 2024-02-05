package menu;

import service.admin.AdminService;
import service.category.CategoryService;
import service.customer.CustomerService;
import utility.ApplicationContex;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService = ApplicationContex.getCustomerService();
    private final AdminService adminService = ApplicationContex.getAdminService();
    private final CategoryService categoryService = ApplicationContex.getCategoryService();

    public Menu() {
    }

    public void publicMenu() throws SQLException {

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
            System.out.println(" 2-Sign In ");
            System.out.println(" 3-Edite profile ");
            System.out.println(" 4-delete Account ");


            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> signup();
                    case 2 -> signin();
                    case 3 -> update();
                    case 4 -> delete();
                    default -> throw new
                            InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER NUMBER!!!");
            }

        }
    }


    public void adminMenu() throws SQLException {

        boolean back = false;

        while (!back) {
            System.out.println(" Admin Menu ");
            System.out.println();
            System.out.println(" 1- Login to own Account");
            System.out.println(" 2- Add category ");


            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> signIN();
                    case 2 -> addCategory();
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


}