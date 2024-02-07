package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpel extends BaseRepositoryImpel<Integer, Admin> implements AdminRepository {

    public AdminRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " admin ";
    }

    @Override
    public String getColumnsName() {
        return " user_name , password ";
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return " ( ? , ? ) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Admin entity, boolean isCountOnly) throws SQLException {

        preparedStatement.setString(1, entity.getUserName());
        preparedStatement.setString(2, entity.getPassword());

    }

    @Override
    public Admin mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Admin admin = new Admin();
        admin.setId(resultSet.getInt("id"));
        admin.setUserName(resultSet.getString("user_name"));
        admin.setPassword(resultSet.getString("password"));


        return admin;
    }

    @Override
    public String getUpdateQueryParams() {
        return" user_name = ? , password = ? ";
    }

}
