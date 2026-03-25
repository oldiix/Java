import java.util.List;
import java.util.ArrayList;

public class task3 {
    static class Box<T> {

        private List<T> items;

        public Box() {
            items = new ArrayList<>();
        }

        public void addItem(T item) {
            items.add(item);
        }

        public void removeItem(T item) {
            items.remove(item);
        }

        public void showAllItems() {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {

        Box<String> cityBox = new Box<>();
        cityBox.addItem("Kyiv");
        cityBox.addItem("Lviv");
        cityBox.addItem("Odesa");
        System.out.println("City Box:");
        cityBox.showAllItems();

        Box<Integer> yearBox = new Box<>();
        yearBox.addItem(2021);
        yearBox.addItem(2022);
        yearBox.addItem(2023);
        System.out.println("\nYear Box:");
        yearBox.showAllItems();

        Box<Object> mixedBox = new Box<>();
        mixedBox.addItem("Chernivtsi");
        mixedBox.addItem(3.14);
        mixedBox.addItem(100);
        System.out.println("\nMixed Box:");
        mixedBox.showAllItems();

        cityBox.removeItem("Lviv");
        System.out.println("\nCity Box after removal:");
        cityBox.showAllItems();
    }
}
