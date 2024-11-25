package TemplateMethod;

public class JamAndPeanutButterSandwich extends Sandwich{

    @Override
    public void addFilling() {
        System.out.println("Adding jerry jam and peanut butter to the sandwich.");
    }
}
