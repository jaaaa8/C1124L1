package lesson_7_asbtract_and_interface.thuc_hanh.b1;

import lesson_7_asbtract_and_interface.thuc_hanh.b1.animal.Animal;
import lesson_7_asbtract_and_interface.thuc_hanh.b1.animal.Chicken;
import lesson_7_asbtract_and_interface.thuc_hanh.b1.animal.Tiger;
import lesson_7_asbtract_and_interface.thuc_hanh.b1.fruit.Apple;
import lesson_7_asbtract_and_interface.thuc_hanh.b1.fruit.Fruit;
import lesson_7_asbtract_and_interface.thuc_hanh.b1.fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Chicken();
        animals[1] = new Tiger();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
        Chicken chicken = (Chicken) animals[0];
        Tiger tiger = (Tiger) animals[1];
        System.out.println(chicken.howToEat());
        System.out.println(tiger.howToEat());

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
