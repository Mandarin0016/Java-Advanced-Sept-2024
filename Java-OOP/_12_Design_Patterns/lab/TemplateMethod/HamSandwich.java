package TemplateMethod;

public class HamSandwich extends Sandwich {

    @Override
    public void addFilling() {
        System.out.println("Adding ham and mozzarella to the sandwich.");
    }
}
