package repository;

import base.repository.BaseRepositoryImpel;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpel extends BaseRepositoryImpel<Integer, Customer> implements CustomerRepository {


    protected CustomerRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " Customer ";
    }

    @Override
    public String getColumnsName() {
        return " ( first_name , last_name , user_name , email , password , national_code ) ";
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return " ( ? , ? , ? , ? , ? , ? ) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Customer entity, boolean isCountOnly) throws SQLException {

        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getEmail());
        preparedStatement.setString(5, entity.getPassword());
        preparedStatement.setString(6, entity.getNationalCode());


    }

    @Override
    public Customer mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setUsername(resultSet.getString("user_name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPassword(resultSet.getString("password"));
        customer.setNationalCode(resultSet.getString("national_code"));

        return customer;
    }

    @Override
    public String getUpdateQueryParams() {
        return " first_name = ? , last_name = ? , user_name = ? , email = ? , password = ? , national_code = ? ";
    }
}
