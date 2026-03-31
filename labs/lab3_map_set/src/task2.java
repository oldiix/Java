import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class task2 {
    public static <T> Set<T> getUniqueElements(List<T> list) {

        return new HashSet<>(list);
    }

    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {

        List<String> movies = Arrays.asList(
                "Inception",
                "Interstellar",
                "The Dark Knight",
                "Inception",
                "Interstellar",
                "Inception",
                "Avatar",
                "The Dark Knight"
        );

        System.out.println("Original list:");
        System.out.println(movies);

        Set<String> uniqueMovies = getUniqueElements(movies);
        System.out.println("\nUnique movies:");
        System.out.println(uniqueMovies);

        Map<String, Integer> occurrences = countOccurrences(movies);
        System.out.println("\nOccurrences:");
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
