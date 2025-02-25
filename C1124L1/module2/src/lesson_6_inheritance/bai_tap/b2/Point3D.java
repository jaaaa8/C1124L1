package lesson_6_inheritance.bai_tap.b2;

public class Point3D extends Point2D {
    private double z = 1.0;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    public Point3D() {
        super();
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double[] getXYZ() {
        return new double[]{getX(), getY(),z};
    }
    public void setXYZ(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "Point3D [x="+getX()+", y="+getY()+", z=" + z + "]";
    }
}
