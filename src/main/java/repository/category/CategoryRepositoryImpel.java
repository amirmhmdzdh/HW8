package repository.category;

import base.repository.BaseRepositoryImpel;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryRepositoryImpel extends BaseRepositoryImpel<Integer, Category> implements CategoryRepository {
    public CategoryRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public Category findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public String getTableName() {
        return " category ";
    }

    @Override
    public String getColumnsName() {
        return " ( name , description ) ";
    }

    @Override
    public String getCountOfQestionMarkParams() {
        return " ( ? , ? ) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Category entity, boolean isCountOnly) throws SQLException {

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
    }

    @Override
    public Category mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Category category = new Category();

        category.setId(resultSet.getInt("id"));
        category.setName(resultSet.getString("name"));
        category.setDescription(resultSet.getString("description"));


        return category;
    }

    @Override
    public String getUpdateQueryParams() {
        return " name = ? , description = ? ";
    }
}
