public class CoffeeDecoratorExample {

    // Base Component
    interface Coffee {
        double cost();
        String description();
    }

    // Concrete Component
    static class BasicCoffee implements Coffee {
        @Override
        public double cost() {
            return 5.0; // Base cost of coffee
        }

        @Override
        public String description() {
            return "Coffee";
        }
    }

    // Decorator Base Class
    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        @Override
        public double cost() {
            return coffee.cost();
        }

        @Override
        public String description() {
            return coffee.description();
        }
    }

    // Concrete Decorators
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return coffee.cost() + 1.0; // Add cost of milk
        }

        @Override
        public String description() {
            return coffee.description() + ", Milk";
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return coffee.cost() + 0.5; // Add cost of sugar
        }

        @Override
        public String description() {
            return coffee.description() + ", Sugar";
        }
    }

    // Main method to demonstrate the Decorator Pattern
    public static void main(String[] args) {
        // Create a basic coffee
        Coffee myCoffee = new BasicCoffee();
        System.out.println("Description: " + myCoffee.description() + ", Cost: $" + myCoffee.cost());

        // Add milk to the coffee
        Coffee myCoffeeWithMilk = new MilkDecorator(myCoffee);
        System.out.println("Description: " + myCoffeeWithMilk.description() + ", Cost: $" + myCoffeeWithMilk.cost());

        // Add sugar to the coffee with milk
        Coffee myCoffeeWithMilkAndSugar = new SugarDecorator(myCoffeeWithMilk);
        System.out.println("Description: " + myCoffeeWithMilkAndSugar.description() + ", Cost: $" + myCoffeeWithMilkAndSugar.cost());
    }
}