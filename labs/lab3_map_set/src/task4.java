public class task4 {

    public <T extends Comparable<T>> void findMax(T[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        T max = array[0];

        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        System.out.println("Max element: " + max);
    }

    public static void main(String[] args) {

        task4 task = new task4();

        Integer[] intArray = {3, 1, 4, 1, 5, 9};
        System.out.println("Finding max in Integer array:");
        task.findMax(intArray);

        String[] stringArray = {"apple", "cherry", "banana"};
        System.out.println("\nFinding max in String array:");
        task.findMax(stringArray);

        Double[] doubleArray = {3.14, 2.71, 1.41};
        System.out.println("\nFinding max in Double array:");
        task.findMax(doubleArray);

        Character[] charArray = {'a', 'z', 'm'};
        System.out.println("\nFinding max in Character array:");
        task.findMax(charArray);
    }
}