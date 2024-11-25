package TemplateMethod;

public class Main {

    public static void main(String[] args) {

        HamSandwich hamSandwich = new HamSandwich();
        JamAndPeanutButterSandwich jamAndPeanutButterSandwich = new JamAndPeanutButterSandwich();
        VegetarianSandwich vegetarianSandwich = new VegetarianSandwich();

        hamSandwich.makeSandwich();
        jamAndPeanutButterSandwich.makeSandwich();
        vegetarianSandwich.makeSandwich();
    }
}
