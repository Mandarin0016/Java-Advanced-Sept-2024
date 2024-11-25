package TemplateMethod;

public abstract class Sandwich {

    // Template method design pattern:
    // 1. Concrete methods
    // 2. Abstract methods
    public void makeSandwich() {
        // Step 1:
        cutBread();
        // Step 2:
        addFilling();
        // Step 3:
        packTheSandwich();
    }

    public void cutBread() {
        System.out.println("Cutting the bread.");
    }

    public void packTheSandwich() {
        System.out.println("Packing the sandwich in a plastic bag.");
    }

    public abstract void addFilling();
}
