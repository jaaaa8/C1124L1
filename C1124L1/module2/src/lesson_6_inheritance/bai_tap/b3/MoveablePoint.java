package lesson_6_inheritance.bai_tap.b3;

public class MoveablePoint extends Point {
    private float xSpeed = 0f;
    private float ySpeed = 0f;

    public MoveablePoint() {
        super();
    }
    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }
    public void move(){
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    @Override
    public String toString() {
        return "MoveablePoint [xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ",\n" +
                "x= "+super.getX()+", y= "+super.getY()+"]";
    }
}
