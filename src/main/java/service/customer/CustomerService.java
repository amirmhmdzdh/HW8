package service.customer;

import base.service.BaseService;
import model.Customer;

public interface CustomerService extends BaseService<Integer , Customer> {

 void signUp();

 void signIn();

 void editeProfile();

 void deleteAccount();


}
