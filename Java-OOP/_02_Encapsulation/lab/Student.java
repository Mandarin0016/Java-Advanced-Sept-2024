public final class Student {

    private final String name;
    private int age;
    private double[] grades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grades = new double[]{2, 3};
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // this - реферира към конкретният/сегашният обект
    // Field hiding
    public void setName(String name) {

//        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double[] getGrades() {

        double[] temp = new double[grades.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = grades[i];
        }
        return temp;
    }
}
