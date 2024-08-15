public class Pen {
String clr;
int price;
String type;

public void write(){
    System.out.println("pen wirtes");
}
public void mark(){
    System.out.println("marks the highlights");
}
    public static void main(String[] args) {

        Pen p =new Pen();
        p.clr="red";
        p.price=100;
        p.type= "Marker";
        p.write();
        p.mark();

        Pen p2= new Pen();
            p2.clr="blue";
            p2.price=1000;
            p2.type="Ball_pen";
            p2.write();
            p2.mark();

    }
}
