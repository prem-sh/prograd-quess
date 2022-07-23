import java.util.ResourceBundle;
import java.util.Scanner;

public class FindArea {
    private static final double PI = 3.14;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.print("What do you have ? \n1. Circle \n2. Square \n3. Rectangle \n4. Triangle \n..any number to EXIT\n>>--> ");
        int opt = sc.nextInt();
            switch(opt){
                case 1:
                    System.out.print("\nEnter Radius of Circle > ");
                    int radius = sc.nextInt();
                    Circle c = new Circle(radius);
                    System.out.println("Area of given Circle is : "+getArea(c));
                    break;
                case 2:
                    System.out.print("\nEnter Side of the Square  > ");
                    int side = sc.nextInt();
                    Squre s = new Squre(side);
                    System.out.println("Area of given Squre is : "+getArea(s));
                    break;
                case 3:
                    System.out.print("\nEnter Length of the Rectangle  > ");
                    int length = sc.nextInt();
                    System.out.print("\nEnter Breadth of the Rectangle > ");
                    int breadth = sc.nextInt();
                    Rectangle r = new Rectangle(length,breadth);
                    System.out.println("Area of given Rectangle is : "+getArea(r));
                    break;
                case 4:
                    System.out.print("\nEnter Height of the Triangle  > ");
                    int height = sc.nextInt();
                    System.out.print("\nEnter Width of the Triangle   > ");
                    int width = sc.nextInt();
                    Triangle t = new Triangle(height,width);
                    System.out.println("Area of given Triangle is : "+getArea(t));
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static double getArea(Circle c){
        return (2*PI*c.getRadius());
    }
    private static double getArea(Squre s){
        return (s.getSide()*s.getSide());
    }
    private static double getArea(Rectangle r){
        return (r.getLength()*r.getBreadth());
    }
    private static double getArea(Triangle t){
        return (1/2*(t.getHeight()*t.getWidth()));
    }
}

class Circle{
    private int radius;
    Circle(int radius){this.radius = radius;}
    public int getRadius() {
        return radius;
    }
}
class Squre{
    private int side;
    Squre(int side){this.side = side;}
    public int getSide() {
        return side;
    }
}
class Rectangle{
    private int length;
    private int breadth;
    Rectangle(int length, int breadth){this.length = length;this.breadth=breadth;}
    public int getLength() {
        return length;
    }
    public int getBreadth() {
        return breadth;
    }
}
class Triangle{
    private int height;
    private int width;
    Triangle(int height, int width){this.height = height;this.width=width;}
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}