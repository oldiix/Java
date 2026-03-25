import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class task3 {
    public static Optional<String> findLonger(List<String> list) {
        return list.stream()
                .max(Comparator.comparingInt(String::length));
    }
    public static void main(String[] args) {

        List<String> list = List.of("Andriy", "Stepan", "Katya", "Xenia", "Mykhailo");
        System.out.println("List: " + list);
        System.out.println("Longest name: " + findLonger(list).get());

        List<String> emptyList = List.of();
        System.out.println("\nEmpty list: " + emptyList);
        System.out.println("Longest name: " + findLonger(emptyList));
    }
}