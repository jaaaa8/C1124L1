package lesson_7_asbtract_and_interface.bai_tap.b1_2;

public class Main {
    public static void main(String[] args) {
        Shape[] geometric = new Shape[3];
        geometric[0] = new Circle(35);
        geometric[1] = new Rectangle(50.0,50);
        geometric[2] = new Square(50.0);

        for (Shape shape : geometric) {
            System.out.println(shape);
        }

        for(int i=0;i<geometric.length;i++) {
            if(geometric[i] instanceof Circle) {
                ((Circle)geometric[i]).resize(1.5);
            }else if(geometric[i] instanceof Square) {
                ((Square)geometric[i]).resize(1.5);
                ((Square)geometric[i]).howToColor();
            }
            else {
                ((Rectangle)geometric[i]).resize(1.5);
            }
        }

        for(int i=0;i<geometric.length;i++) {
            System.out.println(geometric[i]);
            if(geometric[i] instanceof Square) {
                ((Square)geometric[i]).resize(1.5);
                ((Square)geometric[i]).howToColor();
            }
        }

    }
}
