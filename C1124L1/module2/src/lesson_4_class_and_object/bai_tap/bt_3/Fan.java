package lesson_4_class_and_object.bai_tap.bt_3;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = SLOW;
    private boolean isActive = false;
    private double radius = 5;
    private String fanColor = "blue";

    public Fan() {
    }
    public Fan(int speed, boolean isActive, double radius, String fanColor) {
        setSpeed(speed);
        setActive(isActive);
        setRadius(radius);
        setFanColor(fanColor);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return this.speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }

    public void setFanColor(String fanColor) {
        this.fanColor = fanColor;
    }
    public String getFanColor() {
        return this.fanColor;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
    public boolean isActive() {
        return this.isActive;
    }
    public String isActiveFan(){
        if (this.isActive) {
            return "Quạt đang bật.";
        }
        return "Quạt đang tắt.";
    }

    public String toString() {
        return "Tốc độ: " + this.speed + ".\n" +
                "Màu: "+this.fanColor+".\n" +
                "Bán kính quạt: "+this.radius+".\n" +
                isActiveFan();
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setFanColor("yellow");
        fan1.setActive(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setFanColor("blue");
        fan2.setActive(false);
        System.out.println("Quạt 1: ");
        System.out.printf(fan1.toString());
        System.out.println();
        System.out.println("Quạt 2: ");
        System.out.printf(fan2.toString());
    }
}
