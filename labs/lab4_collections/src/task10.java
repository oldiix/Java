import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;

public class task10 {

    public static Optional<String> cityWithHighestAverage(Map<String, List<Integer>> temperature) {
        return temperature.entrySet().stream()
                .max(Comparator.comparingDouble(entry ->
                        entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(Double.NEGATIVE_INFINITY)
                ))
                .map(Map.Entry::getKey);
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> temperature = Map.of(
                "Chernivtsy", List.of(10, 12, 13),
                "Ternopil", List.of(11, 15, 14),
                "Lviv", List.of(9, 7, 8)
        );

        Optional<String> hottestCity = cityWithHighestAverage(temperature);

        hottestCity.ifPresentOrElse(
                city -> System.out.println("City with Maximum Average Temperature: " + city),
                () -> System.out.println("No cities found.")
        );
    }
}