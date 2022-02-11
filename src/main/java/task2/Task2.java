package task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        initHumanList(humans);
        String output = performNecessaryActions(humans);
        System.out.println(output);
    }

    private static String performNecessaryActions(List<Human> humans) {
        return humans.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .filter(human -> human.getAge() < 20)
                .filter(human -> human.getFirstName().contains("e"))
                .map(human -> "" + human.getFirstName().charAt(0) + human.getLastName().charAt(0))
                .collect(Collectors.toList()).get(0);
    }

    private static void initHumanList(List<Human> humans) {
        humans.add(new Human(18, "Jame", "Kony", LocalDate.of(2000, 11, 5), 55));
        humans.add(new Human(25, "Keny", "Finy", LocalDate.of(1998, 11, 5), 55));
        humans.add(new Human(54, "Jonathon", "Ari", LocalDate.of(1968, 11, 5), 55));
        humans.add(new Human(40, "Kristie", "Merso", LocalDate.of(1978, 11, 5), 55));
        humans.add(new Human(16, "Oly", "Perdy", LocalDate.of(2002, 11, 5), 55));
        humans.add(new Human(30, "Chimmy", "Lis", LocalDate.of(1985, 11, 5), 55));
    }
}
