package bankingsystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount a1 = new BankAccount("A1", 100);
        BankAccount a2 = new BankAccount("A2", 200);

        Thread t1 = new ClientThread("Client-one", a1, a2);
        Thread t2 = new ClientThread("Client-two", a2, a1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Усі операції завершено");
        System.out.println("Кінцевий баланс A1: " + a1.getBalance());
        System.out.println("Кінцевий баланс A2: " + a2.getBalance());
    }
}