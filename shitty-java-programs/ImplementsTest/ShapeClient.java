public class ShapeClient {
    // individual shape classes:
    static class Circle implements Shape {
        private double radius;
        public Circle(double r) {
            radius = r;
        }
        public double getPerimeter() {
            return 2 * radius * 3.1416;
        }
        public double getArea() {
            return 3.1416 * radius * radius;
        }
    }
    static class Triangle implements Shape { //isosceles, lol 
        private double base;
        public double height;
        public Triangle(double b, double h) {
            base = b;
            height = h;
        }
        public double getPerimeter() {
            return base + Math.sqrt(Math.pow((base/2), 2.0) + Math.pow(height, 2.0)) * 2;
        }
        public double getArea() {
            return (base * height) / 2;
        }
    }
    static class Rectangle implements Shape {
        private double base;
        public double height;
        public Rectangle(double b, double h) {
            base = b;
            height = h;
        }
        public double getPerimeter() {
            return 2 * base + 2 * height;
        }
        public double getArea() {
            return base * height;
        }

    }

    public static void main(String[] args) {
        Shape[] listOfShapes = new Shape[3];
        listOfShapes[0] = new Circle(3);
        listOfShapes[1] = new Triangle(4, 8);
        listOfShapes[2] = new Rectangle(3,2);
        for (Shape shape : listOfShapes) {
            System.out.println(shape.getClass().getName());
            System.out.println(shape.getArea());
            System.out.println(shape.getPerimeter());
            System.out.println();
        }
    }

}