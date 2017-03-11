public class Engine2 {

    public static void main(String[] args) {

        Point2 p1 = new Point2(2,-5,-4 ,3);
        Point2 p2 = new Point2(10,20,30 ,40);


        System.out.println("Расстояние между");
        System.out.println("Точкой 1 с координатами " + p1.x1 + " и " + p1.y1);
        System.out.println("и");
        System.out.println("Точкой 2 с координатами " + p1.x2 + " и " + p1.y2);
        System.out.println("Равно: " + p1.distance());
        System.out.println();
        System.out.println("Расстояние между");
        System.out.println("Точкой 1 с координатами " + p2.x1 + " и " + p2.y1);
        System.out.println("и");
        System.out.println("Точкой 2 с координатами " + p2.x2 + " и " + p2.y2);
        System.out.println("Равно: " + p2.distance());
    }



}
