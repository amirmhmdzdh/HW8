package repository.category;

import base.repository.BaseRepository;
import model.Category;

import java.sql.SQLException;

public interface CategoryRepository extends BaseRepository<Integer , Category> {

 Category[] findAllCategory() throws SQLException;

}
