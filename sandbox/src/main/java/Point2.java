/**
 * Created by Denis on 11.03.2017.
 */
public class Point2 {

    double x1;
    double y1;
    double x2;
    double y2;

    Point2(double x1, double y1, double x2, double y2) {
       this.x1=x1;
       this.y1=y1;
       this.x2=x2;
       this.y2=y2;


    }

    public double distance() {

        double Lsq;
        double L;

        Lsq = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        L = Math.sqrt(Lsq);

        return L;
    }

}
