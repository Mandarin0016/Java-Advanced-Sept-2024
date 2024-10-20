package surfers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {
        // if we not get 100 points check whether the Surfer already exists!!!

        Surfer surfer1 = this.surfers.stream()
                                     .filter(s -> s.getName().equals(surfer.getName()))
                                     .findFirst()
                                     .orElse(null);

        if (surfer1 != null) {
            throw new RuntimeException("This surfer already exists!");
        }

        if (!surfer.isOwnsASurfBoard()) {
            if (this.surfboardsForRent > 0) {
                if (surfer.getMoney() >= 50) {
                    this.surfboardsForRent--;
                } else {
                    return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
                }
            } else {
                return "There are no free surfboards.";
            }
        }

        surfers.add(surfer);
        return String.format("Surfer %s added.", surfer.getName());
    }

    // Method removeSurfer(String name) – removes a Surfer by given name,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeSurfer(String name) {

        Surfer surfer = this.surfers.stream()
                                    .filter(s -> s.getName().equals(name))
                                    .findFirst()
                                    .orElse(null);

        // surfers.removeIf(s -> name.equals(s.getName()));

        if (surfer != null) {
            return this.surfers.remove(surfer);
        }
        return false;
    }

    // Method getMostExperiencedSurfer()–
    // returns String - the most experienced Surfer by age of experience in the given beach return:
    public String getMostExperiencedSurfer() {
        Surfer surfer = this.surfers.stream()
                                    .max(Comparator.comparing(Surfer::getExperience))
                                    .orElse(null);

        if (surfer == null) {
            return "There are no surfers.";
        }

        return String.format("%s is most experienced surfer with %d years experience.",
                             surfer.getName(),
                             surfer.getExperience());
    }

    // Method getSurfer(String name) – returns the Surfer with the given name, otherwise – returns null
    public Surfer getSurfer(String name) {
        return this.surfers.stream()
                           .filter(s -> s.getName().equals(name))
                           .findFirst()
                           .orElse(null);
    }

    public int getCount() {
        return this.surfers.size();
    }

    public String getSurfersWithPersonalSurfboards() {

        List<Surfer> surfersWithBoards = this.surfers.stream()
                                                     .filter(Surfer::isOwnsASurfBoard)
                                                     .toList();
        String names = surfersWithBoards.stream()
                                        .map(Surfer::getName)
                                        .collect(Collectors.joining(", "));

        return surfersWithBoards.isEmpty() ?
               "There are no surfers." :
               "Surfers who have their own surfboards: " + names;
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();

        if (this.surfers.isEmpty()) {
            sb.append(String.format("There are no surfers on %s beach.", this.name));
        } else {
            sb.append(String.format("Beach %s was visited by the following surfers:", this.name));

            AtomicInteger surferNumber = new AtomicInteger();

            this.surfers.forEach(surfer -> {
                sb.append(System.lineSeparator());
                // Трябва да се добави номерация за сърфистите
                //1. Mike with 1 years experience.
                //2. John with 10 years experience.
                sb.append(surferNumber.getAndIncrement()).append(". ");

                if (surfer.getExperience() == 0) {
                    sb.append(String.format("%s with no experience.", surfer.getName()));
                } else {
                    sb.append(String.format("%s with %d years experience.",
                                            surfer.getName(),
                                            surfer.getExperience()));
                }
            });
        }

        return sb.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSurfboardsForRent() {
        return surfboardsForRent;
    }

    public void setSurfboardsForRent(int surfboardsForRent) {
        this.surfboardsForRent = surfboardsForRent;
    }

    public List<Surfer> getSurfers() {
        return surfers;
    }

    public void setSurfers(List<Surfer> surfers) {
        this.surfers = surfers;
    }
}
