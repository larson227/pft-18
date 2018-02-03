package Task2;

public class MainLogic {
    public static double distance(double p1, double p2){
        return Math.sqrt(p1+p2);
    }
    public static double superDistance(double x1, double x2, double y1, double y2){
        double x = Math.pow((x2 - x1),2);
        double y = Math.pow((y2 - y1), 2);
        return Math.sqrt(x+y);
    }
}
