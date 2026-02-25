public class Main {
    public static void main(String[] args) {

        int x = 526;
        switch (x % 2) {
            case 0:
            System.out.println("Парне");
            break;
            case 1:
                System.out.println("Непарне");
                break;
            default:
                System.out.println("Невідомо");
        }
    }
}