package ru.stqa.pft.sandbox;

public class Hi {
    public static void main(String[] args) {
        Square s = new Square(5);
        Rectangle r = new Rectangle();
        r.setA(4);
        r.setB(5);

        System.out.println("Sqare " + area(s));
        System.out.println("Rectangle " + area(r));

    }
    public static double area(Square s){
        return s.a * s.a;
    }
    public static double area(Rectangle r){
        return r.getA() * r.getB();
    }
}
