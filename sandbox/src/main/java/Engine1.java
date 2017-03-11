
public class Engine1 {

    public static void main(String[] args) {

        Point1 p1 = new Point1();
        p1.x = 2;
        p1.y = -5;

        Point1 p2 = new Point1();
        p2.x = -4;
        p2.y = 3;

        System.out.println("Расстояние между");
        System.out.println("Точкой 1 с координатами " + p1.x + " и " + p1.y);
        System.out.println("и");
        System.out.println("Точкой 2 с координатами " + p2.x + " и " + p2.y);
        System.out.println("Равно: " + distance(p1, p2));
    }

    public static double distance(Point1 p1, Point1 p2) {

        double Lsq;
        double L;

        Lsq = Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
        L = Math.sqrt(Lsq);

        return L;
    }

}
