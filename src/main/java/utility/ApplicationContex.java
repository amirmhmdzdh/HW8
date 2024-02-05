package utility;

import connection.JDBCConnection;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.admin.AdminRepository;
import repository.admin.AdminRepositoryImpel;
import repository.category.CategoryRepository;
import repository.category.CategoryRepositoryImpel;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpel;
import repository.product.ProductRepository;
import repository.product.ProductRepositoryImpel;
import service.admin.AdminService;
import service.admin.AdminServiceImpel;
import service.category.CategoryService;
import service.category.CategoryServiceImpel;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpel;
import service.product.ProductService;
import service.product.ProductServiceImpel;

import java.sql.Connection;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationContex {

    static final Connection CONNECTION;
    static final CustomerRepository CUSTOMER_REPOSITORY;
    static final AdminRepository ADMIN_REPOSITORY;
    static final CategoryRepository CATEGORY_REPOSITORY;
    static final ProductRepository PRODUCT_REPOSITORY;


    static final CustomerService CUSTOMER_SERVICE;
    static final AdminService ADMIN_SERVICE;
    static final CategoryService CATEGORY_SERVICE;
    static final ProductService PRODUCT_SERVICE;

    static {

        CONNECTION = JDBCConnection.getConnection();
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpel(CONNECTION);
        CUSTOMER_SERVICE = new CustomerServiceImpel(CUSTOMER_REPOSITORY);


        ADMIN_REPOSITORY = new AdminRepositoryImpel(CONNECTION);
        ADMIN_SERVICE = new AdminServiceImpel(ADMIN_REPOSITORY);


        CATEGORY_REPOSITORY = new CategoryRepositoryImpel(CONNECTION);
        CATEGORY_SERVICE = new CategoryServiceImpel(CATEGORY_REPOSITORY);

        PRODUCT_REPOSITORY = new ProductRepositoryImpel(CONNECTION);
        PRODUCT_SERVICE = new ProductServiceImpel(PRODUCT_REPOSITORY);
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

    public static ProductService getProductService() {
        return PRODUCT_SERVICE;
    }

}