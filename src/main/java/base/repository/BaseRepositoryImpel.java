package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>> implements BaseRepository<ID, TYPE> {

    private final Connection connection;


    protected BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(TYPE entity) throws SQLException {

        String sql = " INSER INTO " + getTableName() + " " + getColumnsName() + " VALUES " + getCountOfQestionMarkParams();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, entity, false);
            preparedStatement.executeUpdate();

        }

    }

    @Override
    public TYPE findById(ID id) {
        return null;
    }

    @Override
    public void update(TYPE entity) {

    }

    @Override
    public void delete(ID id) {

    }


    public abstract String getTableName();

    public abstract String getColumnsName();

    public abstract String getCountOfQestionMarkParams();

    public abstract void fillParamForStatement(PreparedStatement preparedStatement, TYPE entity, boolean isCountOnly) throws SQLException;

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract String getUpdateQueryParams();


}
