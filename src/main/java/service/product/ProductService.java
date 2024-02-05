package service.product;

import base.service.BaseService;
import model.Product;

public interface ProductService extends BaseService<Integer , Product> {

 void saveProduct();

}
