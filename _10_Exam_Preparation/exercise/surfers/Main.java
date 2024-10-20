package surfers;

public class Main {
    public static void main(String[] args) {
////Initialize the repositories (Beach)
        Beach malibu = new Beach("Malibu", 3);
        Beach playaLaRopa = new Beach("Playa La Ropa", 2);
        Beach veleka = new Beach("Veleka", 0);
//Initialize entities (Surfer)
        Surfer john = new Surfer("John", 40, 10, true, 100);
        Surfer mike = new Surfer("Mike", 20, 1, false, 59);
        Surfer charlie = new Surfer("Charlie", 55, 19, true, 50);
        Surfer hulk = new Surfer("Hulk", 18, 0, true, 50);
        Surfer asen = new Surfer("Asen", 28, 10, false, 500);


        System.out.println(malibu.addSurfer(john));
        System.out.println(malibu.addSurfer(hulk));
        System.out.println(malibu.addSurfer(mike));
        System.out.println(malibu.getSurfersWithPersonalSurfboards());
        System.out.println(malibu.removeSurfer("Hulkhhhh"));
        System.out.println(veleka.addSurfer(charlie));

        System.out.println(veleka.addSurfer(asen));


        System.out.println(veleka.getMostExperiencedSurfer());

        System.out.println(malibu.getReport());
        System.out.println(playaLaRopa.getReport());
        System.out.println(veleka.getReport());



    }
}