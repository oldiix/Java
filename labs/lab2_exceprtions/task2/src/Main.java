import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    private final Queue<String> orders = new LinkedList<>();

    public void addOrder(String order) {
        orders.add(order);
        System.out.println("Додано замовлення: " + order);
    }

    public void processOrder() {
        if (orders.isEmpty()) {
            throw new NoSuchElementException("Черга порожня! Немає замовлень для обробки.");
        }

        String processedOrder = orders.remove();
        System.out.println("Оброблено замовлення: " + processedOrder);
    }

    public static void main(String[] args) {

        Main queue = new Main();

        queue.addOrder("Замовлення №1");
        queue.addOrder("Замовлення №2");
        queue.addOrder("Замовлення №3");

        queue.processOrder();
        queue.processOrder();
        queue.processOrder();

        try {
            queue.processOrder();
        } catch (NoSuchElementException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}