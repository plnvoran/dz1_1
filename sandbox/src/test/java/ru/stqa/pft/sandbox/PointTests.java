package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {
    @Test
    /* Тест 1: точки в разных квадрантах */
    public void testDistance1() {

        Point p1 = new Point(2, -5);
        Point p2 = new Point(-4, 3);
        Assert.assertEquals(p1.distance(p2), 10.1);


    }

    @Test
    /* Тест 2: одна из точек 0, 0 */
    public void testDistance2() {


        Point p3 = new Point(10, 10);
        Point p4 = new Point(0, 0);
        Assert.assertEquals(p3.distance(p4), 14.142135623730951);


    }



    @Test
    /* Тест 3: точки имеют равные координаты */
    public void testDistance3() {

        Point p5 = new Point(-1, 3);
        Point p6 = new Point(-1, 3);
        Assert.assertEquals(p5.distance(p6), 0.0);


    }

}
