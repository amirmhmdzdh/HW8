package repository.product;

import base.repository.BaseRepositoryImpel;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductRepositoryImpel extends BaseRepositoryImpel<Integer, Product> implements ProductRepository {
    public ProductRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " product ";
    }

    @Override
    public String getColumnsName() {
        return " ( name , description , gender , color , size , price , category_id ) ";
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return " ( ? , ? , ? , ? , ? , ? , ? ) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Product entity, boolean isCountOnly) throws SQLException {

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setString(3, entity.getGender());
        preparedStatement.setString(4, entity.getColor());
        preparedStatement.setInt(5, entity.getSiza());
        preparedStatement.setInt(6, entity.getPrice());
        preparedStatement.setInt(7, entity.getCategoryId());

    }

    @Override
    public Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Product product = new Product();

        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setGender(resultSet.getString("gender"));
        product.setColor(resultSet.getString("color"));
        product.setSiza(resultSet.getInt("size"));
        product.setPrice(resultSet.getInt("price"));
        product.setCategoryId(resultSet.getInt("category_id"));

        return product;
    }

    @Override
    public String getUpdateQueryParams() {
        return " name = ? , description = ? , gender = ? , color = ? , size = ? , price = ? , category_id = ? ";
    }

    @Override
    public Product[] findAllProduct() throws SQLException {

        String query = " SELECT * FROM product ";
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();

        Product[] products = new Product[rowCount];

        int i = 0;
        while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String categoryName = resultSet.getString("name");
            String description = resultSet.getString("description");
            String gender = resultSet.getString("gender");
            String color = resultSet.getString("color");
            int size = resultSet.getInt("size");
            int price = resultSet.getInt("price");
            int categoryId = resultSet.getInt("category_id");

            Product product = new Product(productId, categoryName, description, gender, color, size, price, categoryId);

            products[i] = product;
            i++;
        }


        return products;
    }
}
