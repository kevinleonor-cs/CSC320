public class ShapeArrayTest {
    public static void main(String[] args) {
        System.out.println("===== Test Case 1: Small Values =====\n");
        Shape[] test1 = {
            new Sphere(1.0),
            new Cylinder(1.0, 1.0),
            new Cone(1.0, 1.0)
        };
        for (Shape shape : test1) {
            System.out.println(shape.toString());
            System.out.println();
        }

        System.out.println("===== Test Case 2: Large Values =====\n");
        Shape[] test2 = {
            new Sphere(10.5),
            new Cylinder(6.2, 15.8),
            new Cone(8.0, 12.0)
        };
        for (Shape shape : test2) {
            System.out.println(shape.toString());
            System.out.println();
        }

        System.out.println("===== Test Case 3: Decimal Values =====\n");
        Shape[] test3 = {
            new Sphere(2.75),
            new Cylinder(4.5, 3.25),
            new Cone(5.5, 7.75)
        };
        for (Shape shape : test3) {
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
