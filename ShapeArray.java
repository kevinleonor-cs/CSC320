public class ShapeArray {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(5.0);
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        Cone cone = new Cone(4.0, 9.0);

        Shape[] shapeArray = {sphere, cylinder, cone};

        System.out.println("===== Shape Array Output =====\n");
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
