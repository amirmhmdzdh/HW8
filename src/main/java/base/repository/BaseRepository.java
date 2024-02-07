package base.repository;

import base.model.BaseEntity;
import java.io.Serializable;
import java.sql.SQLException;

public interface BaseRepository<ID extends Serializable, TYPE extends BaseEntity<ID>> {

    int save(TYPE entity) throws SQLException;

    TYPE findUser(String username) throws SQLException;

    void update(TYPE entity) throws SQLException;

    void delete(ID id) throws SQLException;

    TYPE findById(ID id) throws SQLException;
}
