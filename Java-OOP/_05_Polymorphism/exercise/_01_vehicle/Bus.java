package _01_vehicle;

public class Bus extends VehicleImpl {

    private static final boolean DEFAULT_IS_EMPTY = true;
    private static final boolean DEFAULT_IS_AC_ON = false;

    private boolean isEmpty;
    private boolean isAcON;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = DEFAULT_IS_EMPTY;
        this.isAcON = DEFAULT_IS_AC_ON;
    }

    @Override
    public String drive(double distance) {

        // Проверка дали от предишен курс климатика не е останал включен
        // Ако е бил включен го изключваме
        if (isAcON) {
            super.setFuelConsumption(getFuelConsumption() - 1.4);
            isAcON = false;
        }

        // Тук винаги сме с изключен климатик
        // Правим проверка дали ще караме автобуса празен пропускаме проверката
        // и климатика остава изключен
        // ако ще го караме пълен включваме климатика
        if (!isEmpty) {
            super.setFuelConsumption(getFuelConsumption() + 1.4);
            isAcON = true;
        }

        return super.drive(distance);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
