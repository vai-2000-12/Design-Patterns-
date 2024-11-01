// SimUDuck.java

// FlyBehavior interface
interface FlyBehavior {
    void fly();
}

// QuackBehavior interface
interface QuackBehavior {
    void quack();
}

// Concrete FlyBehavior implementations
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly.");
    }
}

class FlyWithRocket implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}

// Concrete QuackBehavior implementations
class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack! Quack!");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak!");
    }
}

// Abstract Duck class
abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();
}

// Concrete Duck classes
class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    public void display() {
        System.out.println("I'm a real Mallard duck!");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    public void display() {
        System.out.println("I'm a rubber duckie!");
    }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }

    public void display() {
        System.out.println("I'm a decoy duck!");
    }
}

// SimUDuck test class
class SimUDuck {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println();

        Duck rubberDuckie = new RubberDuck();
        rubberDuckie.display();
        rubberDuckie.performFly();
        rubberDuckie.performQuack();

        System.out.println();

        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performFly();
        decoy.performQuack();

        System.out.println();

        // Dynamically change rubber duck behavior to fly with a rocket
        rubberDuckie.setFlyBehavior(new FlyWithRocket());
        rubberDuckie.performFly();
    }
}
