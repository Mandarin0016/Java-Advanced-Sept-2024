import java.util.ArrayList;

public class Main02 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

//        list.size = 5;

        //private method - encapsulated
//        list.grow();

        // Utility класове - класове, които не се инстанцират и извършват полезни действия посредством static методи
        //Math math = new Math();

        Student student = new Student("Vik", 23);
        student.setName("Ivo");
        System.out.println();

        student.getGrades()[0] = 6;
        student.getGrades()[1] = 6;


        String str = new String("old String");
        System.out.println(str);
        String result = str.replaceAll("old", "new");
        System.out.println(str);




    }
}
