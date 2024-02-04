package service.admin;

import base.service.BaseServiceImpel;
import model.Admin;
import model.Customer;
import repository.admin.AdminRepository;
import repository.customer.CustomerRepository;
import service.customer.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminServiceImpel extends BaseServiceImpel<Integer, Admin, AdminRepository> implements AdminService {

    private final Scanner scanner = new Scanner(System.in);

    public AdminServiceImpel(AdminRepository repository) {
        super(repository);
    }

    @Override
    public void signIn() {

        System.out.println("please enter your username:");
        String userName = scanner.next();

        System.out.println("please enter your password:");
        String password = scanner.next();

        Admin admin = null;

        try {
            admin = repository.findUser(userName);
        } catch (SQLException e) {
            System.out.println("An error occurred while finding the user: " + e.getMessage());
        }

        if (admin == null) {
            System.out.println(" Sorry, you are not an admin ");
        } else if (!admin.getPassword().equals(password)) {
            System.out.println("Please enter the correct password");
        } else {
            System.out.println("WELCOME " + admin.getUserName());
        }


    }
}
