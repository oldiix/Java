import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class task5 {
    static public class Pair<T, U> {

        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst()  { return first; }
        public U getSecond() { return second; }

        public void setFirst(T first)   { this.first = first; }
        public void setSecond(U second) { this.second = second; }

        public boolean equals(Pair<T, U> other) {
            return Objects.equals(this.first, other.first) &&
                    Objects.equals(this.second, other.second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(1, "one");
        Pair<Integer, String> pair3 = new Pair<>(2, "two");

        System.out.println("=== Pair<Integer, String> ===");
        System.out.println("Pair 1: " + pair1);
        System.out.println("Pair 2: " + pair2);
        System.out.println("Pair 3: " + pair3);
        System.out.println("Pair 1 equals Pair 2: " + pair1.equals(pair2));
        System.out.println("Pair 1 equals Pair 3: " + pair1.equals(pair3));


        Pair<String, List<Integer>> pair4 = new Pair<>("Anna",  Arrays.asList(90, 85, 92));
        Pair<String, List<Integer>> pair5 = new Pair<>("Anna",  Arrays.asList(90, 85, 92));
        Pair<String, List<Integer>> pair6 = new Pair<>("Maria", Arrays.asList(70, 80, 60));

        System.out.println("\n=== Pair<String, List<Integer>> ===");
        System.out.println("Pair 4: " + pair4);
        System.out.println("Pair 5: " + pair5);
        System.out.println("Pair 6: " + pair6);
        System.out.println("Pair 4 equals Pair 5: " + pair4.equals(pair5));
        System.out.println("Pair 4 equals Pair 6: " + pair4.equals(pair6));
    }
}