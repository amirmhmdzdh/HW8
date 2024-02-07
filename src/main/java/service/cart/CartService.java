package service.cart;

import base.service.BaseService;
import model.Cart;

import java.sql.SQLException;

public interface CartService extends BaseService<Integer , Cart> {

    void saveCart() throws SQLException;
    void deleteCart();

}
