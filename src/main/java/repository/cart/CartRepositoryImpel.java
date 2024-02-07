package repository.cart;

import base.repository.BaseRepositoryImpel;
import model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepositoryImpel extends BaseRepositoryImpel<Integer, Cart> implements CartRepository {


    public CartRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " cart ";
    }

    @Override
    public String getColumnsName() {
        return " ( customer_id , product_id , number , price ) ";
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return " ( ? , ? , ? , ? ) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Cart entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setInt(1, entity.getCustomerId());
        preparedStatement.setInt(2, entity.getProductId());
        preparedStatement.setInt(3, entity.getNumber());
        preparedStatement.setInt(4, entity.getProductPrice());

    }

    @Override
    public Cart mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Cart cart = new Cart();

        cart.setId(resultSet.getInt("id"));
        cart.setCustomerId(resultSet.getInt("customer_id"));
        cart.setProductId(resultSet.getInt("product_id"));
        cart.setNumber(resultSet.getInt("number"));
        cart.setProductPrice(resultSet.getInt("price"));


        return cart;
    }

    @Override
    public String getUpdateQueryParams() {
        return " customer_id = ? , product_id = ? , number = ? , price = ? ";
    }

    @Override
    public int calculateTotalPrice(int customerId) {

        int total = 0;
        try {
            String query = " SELECT SUM(price) AS total FROM cart WHERE customer_id = ? ;";
            PreparedStatement preparedStatement = super.getConnection().prepareStatement(query);

            preparedStatement.setInt(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while calculating the total price: " + e.getMessage());
        }
        return total;
    }

    @Override
    public void showCartById(int customerId) throws SQLException {

        String query = "SELECT * FROM cart WHERE customer_id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int productId = resultSet.getInt("product_id");
                int number = resultSet.getInt("number");
                int Price = resultSet.getInt("price");


                System.out.println("Product ID : " + productId);
                System.out.println("Quantity :  " + number);
                System.out.println("Price : " + Price);
                System.out.println("----------------------");


            }
        }
    }

    @Override
    public void deleteCart(Cart cart) throws SQLException {

        String query = "DELETE FROM cart WHERE id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, cart.getId());
        preparedStatement.setInt(2, cart.getCustomerId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteCustomerById(int customerId) throws SQLException {

        String query = " DELETE FROM cart WHERE customer_id = ? ";
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, customerId);
        preparedStatement.executeUpdate();

    }
}
