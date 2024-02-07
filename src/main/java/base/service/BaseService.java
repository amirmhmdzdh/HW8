package base.service;

import base.model.BaseEntity;
import java.io.Serializable;
import java.sql.SQLException;

public interface BaseService<ID extends Serializable, TYPE extends BaseEntity<ID>> {

    void save(TYPE entity) throws SQLException;

    TYPE findById(ID id) throws SQLException;

    TYPE findByUser(String entity) throws SQLException;

    void update(TYPE entity) throws SQLException;

    void delete(ID id) throws SQLException;


}
