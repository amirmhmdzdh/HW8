package service.customer;

import base.service.BaseServiceImpel;
import model.Customer;
import repository.customer.CustomerRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerServiceImpel extends BaseServiceImpel<Integer, Customer, CustomerRepository> implements CustomerService {

    private final Scanner scanner = new Scanner(System.in);

    public CustomerServiceImpel(CustomerRepository repository) {
        super(repository);

    }


    @Override
    public void signUp() {

        System.out.println("please enter your first Name:");
        String name = scanner.next();

        System.out.println("please enter your last Name:");
        String lastName = scanner.next();


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
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("An error occurred while saving the customer:" + e.getMessage());
        }

        if (result == 1) {
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

            //throw new RuntimeException(e);
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

        System.out.println("please enter your username : ");
        String userName = scanner.next();
        Customer customer = null;

        try {
            customer = findByUser(userName);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

        System.out.println("please enter your first Name:");
        String name = scanner.next();

        customer.setFirstName(name);

        System.out.println("please enter your last Name:");
        String lastName = scanner.next();

        customer.setLastName(lastName);

        System.out.println("please enter your username:");
        String username = scanner.next();

        customer.setUsername(username);

        System.out.println("please enter your Email:");
        String email = scanner.next();

        customer.setEmail(email);

        System.out.println("please enter your password:");
        String password = scanner.next();

        customer.setPassword(password);

        System.out.println("please enter your nationalCode :");
        String nationalCode = scanner.next();

        customer.setNationalCode(nationalCode);

        try {
            repository.update(customer);
        } catch (SQLException e) {
            //
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void deleteAccount() {

        System.out.println("enter id that you want delete :");
        int id = scanner.nextInt();


        try {
            Customer customer = repository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
