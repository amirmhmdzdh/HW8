package service.customer;

import base.service.BaseServiceImpel;
import model.Customer;
import repository.cart.CartRepository;
import repository.customer.CustomerRepository;
import utility.Validation;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerServiceImpel extends BaseServiceImpel<Integer, Customer, CustomerRepository> implements CustomerService {

    private final Scanner scanner = new Scanner(System.in);
    private final CartRepository cartRepository;

    public CustomerServiceImpel(CustomerRepository repository, CartRepository cartRepository) {
        super(repository);
        this.cartRepository = cartRepository;

    }


    @Override
    public void signUp() {

        String name;
        while (true) {

            System.out.println("please enter your first Name:");
            name = scanner.next();
            if (Validation.isValidName(name))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        String lastName;
        while (true) {
            System.out.println("please enter your last Name:");
            lastName = scanner.next();
            if (Validation.isValidName(lastName))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        String userName;
        while (true) {

            System.out.println("please enter your username:");
            userName = scanner.next();
            if (Validation.isValidUsername(userName))
                break;
            else
                System.out.println("please enter correct username");
        }


        String email;
        while (true) {
            System.out.println("please enter your Email:");
            email = scanner.next();

            if (Validation.isValidEmail(email))
                break;
            else
                System.out.println("please enter a correct Email");
        }

        String password;
        while (true) {

            System.out.println("please enter your password:");
            password = scanner.next();
            if (Validation.isValidPassword(password))
                break;
            else
                System.out.println("please enter correct password");
        }


        String nationalCode;
        while (true) {

            System.out.println("please enter your nationalCode :");
            nationalCode = scanner.next();
            if (Validation.isValidnatioalCode(nationalCode))
                break;
            else
                System.out.println("please enter correct nationalCode");
        }

        Customer customer = new Customer(name, lastName, userName, email, password, nationalCode);
        int result = 0;
        try {
            result = repository.save(customer);
            result++;

        } catch (SQLException e) {
            System.out.println("An error occurred while saving the customer:" + e.getMessage());
        }

        if (result > 0) {
            System.out.println(name + "you successfully is signup :)");
        } else {
            System.out.println("something is wrong :/");
        }
    }


    @Override
    public void signIn() {

        System.out.println("please enter your username:");
        String userName = scanner.next();

        System.out.println("please enter your password:");
        String password = scanner.next();

        Customer customer = null;
        try {

            customer = repository.findUser(userName);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        if (customer == null)
            System.out.println("please register first");

        else if (!customer.getPassword().equals(password)) {
            System.out.println("please enter correct password");
        } else
            System.out.println("WELCOME " + customer.getUsername());
        System.out.println();

    }


    @Override
    public void editeProfile() {

        System.out.println("please enter your Customer Id : ");
        int id = scanner.nextInt();
        Customer customer = null;
        try {
            customer = findById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        boolean exit = false;
        while (!exit) {

            System.out.println("Please select an option:");
            System.out.println("1. Edit first name");
            System.out.println("2. Edit last name");
            System.out.println("3. Edit email");
            System.out.println("4. Edit password");
            System.out.println("5. Edit national code");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Please enter your first name:");
                    String firstName = scanner.next();
                    if (Validation.isValidName(firstName)) {
                        customer.setFirstName(firstName);
                        try {
                            repository.update(customer);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("First name updated successfully.");
                    } else {
                        System.out.println("Invalid first name. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Please enter your last name:");
                    String lastName = scanner.next();
                    if (Validation.isValidName(lastName)) {
                        customer.setLastName(lastName);
                        try {
                            repository.update(customer);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Last name updated successfully.");
                    } else {
                        System.out.println("Invalid last name. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter your email:");
                    String email = scanner.next();
                    if (Validation.isValidEmail(email)) {
                        customer.setEmail(email);
                        try {
                            repository.update(customer);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Email updated successfully.");
                    } else {
                        System.out.println("Invalid email. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("Please enter your password:");
                    String password = scanner.next();
                    if (Validation.isValidPassword(password)) {
                        customer.setPassword(password);
                        try {
                            repository.update(customer);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Password updated successfully.");
                    } else {
                        System.out.println("Invalid password. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Please enter your national code:");
                    String nationalCode = scanner.next();
                    if (Validation.isValidnatioalCode(nationalCode)) {
                        customer.setNationalCode(nationalCode);
                        try {
                            repository.update(customer);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("National code updated successfully.");
                    } else {
                        System.out.println("Invalid national code. Please try again.");
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting profile editor.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }


    @Override
    public void deleteAccount() {

        System.out.println("Enter the ID of the account you want to delete:");
        int id = scanner.nextInt();

        try {
            Customer customer = repository.findById(id);
            if (customer != null) {

                cartRepository.deleteCustomerById(id);
                repository.delete(id);
                System.out.println("Account with ID " + id + " has been successfully deleted.");
            } else {
                System.out.println("Account with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while deleting the account: " + e.getMessage());
        }
    }
}