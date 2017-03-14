/**
 * Created by Denis on 11.03.2017.
 */
public class Point {

    double x; double y;


    Point(double x, double y) {
       this.x=x;
       this.y=y;



    }

    public double distance(Point P) {

        double Lsq;
        double L;

        Lsq = Math.pow(x - P.x, 2) + Math.pow(y - P.y, 2);
        L = Math.sqrt(Lsq);

        return L;
    }

}
