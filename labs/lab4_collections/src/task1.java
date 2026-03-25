import java.util.List;
import java.util.Optional;

public class task1 {

    public static Optional<String> findXElement(List<String> list) {
        return list.stream()
                .filter(item -> item.startsWith("X") && item.length() > 5)
                .findFirst()
                .or(() -> Optional.of("Default"));
    }

    public static void main(String[] args) {

        List<String> list1 = List.of("Hello", "Xaviex", "Kateryna");
        System.out.println("List 1: " + list1);
        System.out.println("Found: " + findXElement(list1).get());

        List<String> list2 = List.of("Hello", "World", "Java");
        System.out.println("\nList 2: " + list2);
        System.out.println("Found: " + findXElement(list2).get());
    }
}