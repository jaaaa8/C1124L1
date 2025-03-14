package lesson_7_asbtract_and_interface.thuc_hanh.b1.animal;

import lesson_7_asbtract_and_interface.thuc_hanh.b1.Edible;

public class Chicken extends Animal implements Edible {
    public Chicken() {}

    @Override
    public String makeSound() {
        return "Chicken: Cục cục cục cục tácccc";
    }

    @Override
    public String howToEat() {
        return "Chicken: cục cục cục";
    }
}
