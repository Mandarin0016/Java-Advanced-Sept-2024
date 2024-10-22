import java.util.Arrays;

public enum Calendar {
    JANUARY(31, 8, 23),
    FEBRUARY(27, 8, 19),
    MARCH(31, 8, 23),
    APRIL(30, 8, 22);

    private final int days;
    private final int nonWorkingDays;
    private final int workingDays;

    Calendar(int days, int nonWorkingDays, int workingDays) {
        this.days = days;
        this.nonWorkingDays = nonWorkingDays;
        this.workingDays = workingDays;
    }

    public int getDays() {
        return days;
    }

    public int getNonWorkingDays() {
        return nonWorkingDays;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public static void printMonths() {
        Arrays.stream(Calendar.values())
              .forEach(System.out::println);
    }

    public double calculateMonthSalary(double dailyWage) {
        return this.workingDays * dailyWage;
    }

    @Override
    public String toString() {
        return String.format("%s -> days = %d, nonWorkingDays = %d, workingDays = %d",
                             this.name(),
                             this.days,
                             this.nonWorkingDays,
                             this.workingDays);
    }
}
