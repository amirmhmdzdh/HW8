package repository.cart;

import base.repository.BaseRepository;
import model.Cart;
import java.sql.SQLException;

public interface CartRepository extends BaseRepository<Integer , Cart> {

    int calculateTotalPrice(int customerId);

    void showCartById(int customerId) throws SQLException;

    void deleteCart(Cart cart) throws SQLException;

    void deleteCustomerById(int customerId) throws SQLException;
}


