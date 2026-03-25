import java.util.ArrayList;
import java.util.List;

public class task7 {

    public static void addToList(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        addToList(intList);
        System.out.println("Integer list: " + intList);

        List<Number> numberList = new ArrayList<>();
        addToList(numberList);
        System.out.println("Number list:  " + numberList);

        List<Object> objectList = new ArrayList<>();
        addToList(objectList);
        System.out.println("Object list:  " + objectList);

    }
}