// Енумерация - дават възможност да дефинираме съвкупност от стойности
public enum Month {

    // Константни стойности // Обекти от класа Month
    JANUARY(5),
    FEBRUARY(7),
    MARCH(10),
    APRIL(15),
    MAY(25),
    JUNE(30),
    JULY(35),
    AUGUST(35),
    SEPTEMBER(25),
    OCTOBER(10),
    NOVEMBER(5),
    DECEMBER(1);

    // Field
    private int averageTemperature;
    private int daysCount;

    // Contructor
    Month(int averageTemperature) {
        this.averageTemperature = averageTemperature;
        this.daysCount = 30;
    }

    // Month
    public int getAverageTemperature() {
        return this.averageTemperature;
    }
}
