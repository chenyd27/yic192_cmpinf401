package Task1;

public class Cylinder extends Circle{
    private double height = 1.0;
    public Cylinder(){}
    public Cylinder(double radius,double height){
        super(radius);
        this.height = height;
    }
    public Cylinder(double radius,double height,String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return super.getArea() * this.height;
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(10,5,"red");
        System.out.println(cylinder.getVolume());
    }
}
