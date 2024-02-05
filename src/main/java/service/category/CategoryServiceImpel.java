package service.category;

import base.service.BaseServiceImpel;
import model.Category;
import repository.category.CategoryRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryServiceImpel extends BaseServiceImpel<Integer, Category, CategoryRepository> implements CategoryService {

    private final Scanner scanner = new Scanner(System.in);

    public CategoryServiceImpel(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public void saveCategory() {

        String name;
        while (true) {
            System.out.print("Please enter the name of the category you want: ");
            name = scanner.next();
            if (Validation.isValidName(name))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        String description;
        while (true) {
            System.out.println("Please enter a description of your Category: ");
            description = scanner.next();
            if (Validation.isValidName(description))
                break;
            else
                System.out.println("Invalid input! Please enter a name containing only letters.");
        }

        Category category = new Category(name, description);


        int result = 0;
        try {
            result = repository.save(category);
            result++;

        } catch (SQLException e) {
            System.out.println("An error occurred while saving the category: " + e.getMessage());
        }

        if (result > 0) {
            System.out.println(name + "you successfully added :)");
        } else {
            System.out.println("something is wrong :/");
        }
    }
}