import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> categoriesAndLists;
    ArrayList<String> categoryForCombo;
    Random randomGenerator;

    DinnerConstructor() {
        categoriesAndLists = new HashMap<>();
        randomGenerator = new Random();
        categoryForCombo = new ArrayList<>();
    }

    void addCategoryAndDish(String dishType, String dishName) {
        if (categoriesAndLists.containsKey(dishType)) {
            ArrayList<String> dishes = categoriesAndLists.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            categoriesAndLists.put(dishType, dishes);
        }
    }

    void addTypeForCombo(String nextItem) {
        if (checkType(nextItem)) {
            categoryForCombo.add(nextItem);
        } else {
            System.out.println("Такого типа блюд нет, попробуйте еще раз");
        }
    }

    void comboGenerator(int numberOfCombos) {
        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.printf("Комбо №%d%n", i);
            ArrayList<String> combo = new ArrayList<>();
            for (String current : categoryForCombo) {
                ArrayList<String> currentCategory = categoriesAndLists.get(current);
                combo.add(currentCategory.get(randomGenerator.nextInt(currentCategory.size())));
            }
            System.out.println(combo);
        }
        categoryForCombo.clear();
    }

    boolean checkType(String type) {
        return categoriesAndLists.containsKey(type);
    }
}