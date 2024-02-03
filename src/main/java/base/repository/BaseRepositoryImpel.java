package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>> implements BaseRepository<ID, TYPE> {

 private final Connection connection;


    protected BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }














}
