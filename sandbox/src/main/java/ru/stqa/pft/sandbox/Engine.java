package ru.stqa.pft.sandbox;

public class Engine {

    public static void main(String[] args) {

        Point p1 = new Point(2,-5);
        Point p2 = new Point(-4 ,3);
        Point p3 = new Point(10,20);
        Point p4 = new Point(30 ,40);


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
