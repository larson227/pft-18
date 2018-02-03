package Task2;

public class Point {
    public static void main(String[] args) {
        PointTest pt = new PointTest(4,4,2,4,2,4);
        MainLogic ml = new MainLogic();
        double a = ml.distance(pt.getP1(),pt.getP2());
        System.out.println(a);
        System.out.println(ml.superDistance(pt.getX1(),pt.getX2(),pt.getY1(),pt.getY2()));

    }

}
