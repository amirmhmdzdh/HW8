package service.category;

import base.service.BaseServiceImpel;
import model.Category;
import repository.category.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryServiceImpel extends BaseServiceImpel<Integer , Category , CategoryRepository> implements CategoryService {

    private final Scanner scanner = new Scanner(System.in);
    public CategoryServiceImpel(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public void saveCategory() {

        System.out.print("Please enter the name of the category you want: ");
        String name = scanner.next();

        System.out.println("Please enter a description of your Category: ");
        String description = scanner.next();

        Category category = new Category(name, description);

        int result = 0;
        try {
            result = repository.save(category);
        } catch (SQLException e) {
            System.out.println("An error occurred while saving the category: " + e.getMessage());
        }

        if (result == 1)
            System.out.println(name + "you successfully added :)");
        else
            System.out.println("something is wrong :/");
    }
}
