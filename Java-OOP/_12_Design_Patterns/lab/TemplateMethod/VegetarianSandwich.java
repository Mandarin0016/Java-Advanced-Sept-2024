package TemplateMethod;

public class VegetarianSandwich extends Sandwich {

    @Override
    public void addFilling() {
        System.out.println("Adding tomato and cucumber to the sandwich.");
    }
}
