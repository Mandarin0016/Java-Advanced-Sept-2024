package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CakeFactory {

    private static final String CAKE_PACKAGE_NAME = "factory.";

    private CakeFactory() {

    }

    // BiscuitCake, ChocolateCake, SpinachCake, and WhiteCake
    // Chocolate, White, Spinach, Biscuit
    public static Cake createCake(String type,
                                  double diameter,
                                  double price,
                                  int pieces) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // factory.ChocolateCake
        String className = CAKE_PACKAGE_NAME + type + "Cake";
        Class<Cake> cakeClass = (Class<Cake>) Class.forName(className);

        Constructor<Cake> declaredConstructor = cakeClass
        .getDeclaredConstructor(double.class,
                                double.class,
                                int.class);

        return declaredConstructor.newInstance(diameter, price, pieces);
    }
}
