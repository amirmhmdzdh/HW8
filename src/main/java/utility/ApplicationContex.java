package utility;

import connection.JDBCConnection;
import repository.admin.AdminRepository;
import repository.admin.AdminRepositoryImpel;
import repository.category.CategoryRepository;
import repository.category.CategoryRepositoryImpel;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpel;
import service.admin.AdminService;
import service.admin.AdminServiceImpel;
import service.category.CategoryService;
import service.category.CategoryServiceImpel;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpel;

import java.sql.Connection;

public class ApplicationContex {

    private static final Connection CONNECTION;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final CategoryRepository CATEGORY_REPOSITORY;

    private static final CustomerService CUSTOMER_SERVICE;
    private static final AdminService ADMIN_SERVICE;
    private static final CategoryService CATEGORY_SERVICE;

    static {

        CONNECTION = JDBCConnection.getConnection();
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpel(CONNECTION);
        CUSTOMER_SERVICE = new CustomerServiceImpel(CUSTOMER_REPOSITORY);


        ADMIN_REPOSITORY = new AdminRepositoryImpel(CONNECTION);
        ADMIN_SERVICE = new AdminServiceImpel(ADMIN_REPOSITORY);


        CATEGORY_REPOSITORY = new CategoryRepositoryImpel(CONNECTION);
        CATEGORY_SERVICE = new CategoryServiceImpel(CATEGORY_REPOSITORY);

    }


    public static CustomerService getCustomerService() {
        return CUSTOMER_SERVICE;
    }

    public static AdminService getAdminService() {
        return ADMIN_SERVICE;
    }

    public static CategoryService getCategoryService() {
        return CATEGORY_SERVICE;
    }


}