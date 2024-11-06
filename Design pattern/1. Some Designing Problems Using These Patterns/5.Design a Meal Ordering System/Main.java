// Interface for meal components
interface Course {
    String getName();
}

// Main Course options
class MainCourse implements Course {
    private String name;

    public MainCourse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Side Dish options
class SideDish implements Course {
    private String name;

    public SideDish(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Drink options
class Drink implements Course {
    private String name;

    public Drink(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Dessert options
class Dessert implements Course {
    private String name;

    public Dessert(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Meal {
    private MainCourse mainCourse;
    private SideDish sideDish;
    private Drink drink;
    private Dessert dessert;

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setSideDish(SideDish sideDish) {
        this.sideDish = sideDish;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Meal:\n" +
                "- Main Course: " + (mainCourse != null ? mainCourse.getName() : "None") + "\n" +
                "- Side Dish: " + (sideDish != null ? sideDish.getName() : "None") + "\n" +
                "- Drink: " + (drink != null ? drink.getName() : "None") + "\n" +
                "- Dessert: " + (dessert != null ? dessert.getName() : "None");
    }
}


class MealBuilder {
    private Meal meal;

    public MealBuilder() {
        this.meal = new Meal();
    }

    public MealBuilder addMainCourse(String name) {
        meal.setMainCourse(new MainCourse(name));
        return this;
    }

    public MealBuilder addSideDish(String name) {
        meal.setSideDish(new SideDish(name));
        return this;
    }

    public MealBuilder addDrink(String name) {
        meal.setDrink(new Drink(name));
        return this;
    }

    public MealBuilder addDessert(String name) {
        meal.setDessert(new Dessert(name));
        return this;
    }

    public Meal build() {
        return meal;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a custom meal
        Meal customMeal = new MealBuilder()
                .addMainCourse("Burger")
                .addSideDish("Fries")
                .addDrink("Soda")
                .addDessert("Ice Cream")
                .build();

        System.out.println(customMeal);

        // Create a Vegetarian Combo
        Meal vegetarianCombo = new MealBuilder()
                .addMainCourse("Veggie Burger")
                .addSideDish("Salad")
                .addDrink("Juice")
                .build();

        System.out.println("\n" + vegetarianCombo);

        // Create a Kids Meal
        Meal kidsMeal = new MealBuilder()
                .addMainCourse("Chicken Nuggets")
                .addDrink("Milkshake")
                .build();

        System.out.println("\n" + kidsMeal);
    }
}
