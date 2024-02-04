package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpel extends BaseRepositoryImpel<Integer , Admin > implements AdminRepository {
    protected CustomerRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getColumnsName() {
        return null;
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Admin entity, boolean isCountOnly) throws SQLException {

    }

    @Override
    public Admin mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public Admin findById(Integer integer) throws SQLException {
        return null;
    }
}
