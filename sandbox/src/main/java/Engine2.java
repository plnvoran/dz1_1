public class Engine2 {

    public static void main(String[] args) {

        Point2 p1 = new Point2(2,-5);
        Point2 p2 = new Point2(-4 ,3);
        Point2 p3 = new Point2(10,20);
        Point2 p4 = new Point2(30 ,40);


        System.out.println("Расстояние между");
        System.out.println("Точкой 1 с координатами " + p1.x + " и " + p1.y);
        System.out.println("и");
        System.out.println("Точкой 2 с координатами " + p2.x + " и " + p2.y);
        System.out.println("Равно: " + p1.distance(p2));
        System.out.println();
        System.out.println("Расстояние между");
        System.out.println("Точкой 1 с координатами " + p3.x + " и " + p3.y);
        System.out.println("и");
        System.out.println("Точкой 2 с координатами " + p4.x + " и " + p4.y);
        System.out.println("Равно: " + p3.distance(p4));
    }



}
