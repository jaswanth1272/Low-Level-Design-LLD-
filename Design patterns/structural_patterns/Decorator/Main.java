// Base Interface
interface Pizza {
    String getDescription();
    int getCost();
}

// Concrete Class
class Margherita implements Pizza {
    public String getDescription() {
        return "Margherita";
    }
    public int getCost() {
        return 100;
    }
}

// Decorator
class ExtraCheese implements Pizza {
    private Pizza pizza;

    public ExtraCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    public int getCost() {
        return pizza.getCost() + 20;
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Margherita();
        pizza = new ExtraCheese(pizza);
        
        System.out.println(pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());
    }
}
