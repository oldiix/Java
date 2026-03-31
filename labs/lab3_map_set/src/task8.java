import java.util.ArrayList;
import java.util.List;

public class task8 {

    static abstract class Animal {
        public abstract void makeSound();
    }

    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Dog: Gav!");
        }
    }

    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Cat: Meow!");
        }
    }

    static class Labrador extends Dog {
        @Override
        public void makeSound() {
            System.out.println("Labrador: Gav, Labrador!");
        }
    }

    static class AnimalShelter {

        private List<Dog>    dogs;
        private List<Animal> others;

        public AnimalShelter() {
            dogs   = new ArrayList<>();
            others = new ArrayList<>();
        }

        public void addAnimals(Dog dog) {
            dogs.add(dog);
        }

        public void addAnimalsOther(Animal animal) {
            if (!(animal instanceof Dog)) {
                others.add(animal);
            } else {
                System.out.println("Use addAnimals() for dogs!");
            }
        }

        public void printAnimalSounds() {
            System.out.println("Dogs:");
            for (int i = 0; i < dogs.size(); i++) {
                dogs.get(i).makeSound();
            }
            System.out.println("\nOther animals:");
            for (int i = 0; i < others.size(); i++) {
                others.get(i).makeSound();
            }
        }
    }

    public static void main(String[] args) {

        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Labrador lab1 = new Labrador();

        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimals(dog1);
        shelter.addAnimals(lab1);
        shelter.addAnimalsOther(cat1);

        shelter.printAnimalSounds();
    }
}