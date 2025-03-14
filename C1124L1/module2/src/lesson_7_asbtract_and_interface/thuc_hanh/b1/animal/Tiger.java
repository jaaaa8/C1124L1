package lesson_7_asbtract_and_interface.thuc_hanh.b1.animal;

import lesson_7_asbtract_and_interface.thuc_hanh.b1.Edible;

public class Tiger extends Animal implements Edible {

    public Tiger() {}

    @Override
    public String makeSound() {
        return "Tiger: Roarrrr!";
    }

    @Override
    public String howToEat() {
        return "Tiger: Ngoàm ngoàm";
    }
}
