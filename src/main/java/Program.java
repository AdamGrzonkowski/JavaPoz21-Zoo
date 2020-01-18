import java.time.LocalDateTime;

public class Program {
    public static void main(String args[]){
        System.out.println("Hello!");

        Bear bear = new Bear((LocalDateTime.now().plusDays(-1)));
        bear.isAlive();

        System.out.println(bear.getWeight());

        BlackBear blb = new BlackBear();
        System.out.println(blb.display() + " " + blb.getWeight());

        BrownBear brb = new BrownBear();
        System.out.println(brb.display() + " " + blb.getWeight());

        PolarBear plb = new PolarBear();
        System.out.println(plb.display() + " " + blb.getWeight());
    }
}