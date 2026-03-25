import java.util.ArrayList;
import java.util.Optional;

public class task5 {

    public static void printList(ArrayList<Integer> list) {
        System.out.println("Items in the list:");
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    public static Optional<Integer> findProductOfOdd(ArrayList<Integer> list) {
        int product = 1;
        boolean found = false;

        for (Integer item : list) {
            if (item % 2 != 0) {
                product *= item;
                found = true;
            }
        }

        if (!found) {
            return Optional.empty();
        } else {
            return Optional.of(product);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        printList(list);

        Optional<Integer> result = findProductOfOdd(list);

        if (result.isPresent()) {
            System.out.println("Product of odd numbers: " + result.get());
        } else {
            System.out.println("No odd numbers found.");
        }
    }
}