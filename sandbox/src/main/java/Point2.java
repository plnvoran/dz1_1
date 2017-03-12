/**
 * Created by Denis on 11.03.2017.
 */
public class Point2 {

    double x; double y;


    Point2(double x, double y) {
       this.x=x;
       this.y=y;



    }

    public double distance(Point2 P) {

        double Lsq;
        double L;

        Lsq = Math.pow(x - P.x, 2) + Math.pow(y - P.y, 2);
        L = Math.sqrt(Lsq);

        return L;
    }

}
