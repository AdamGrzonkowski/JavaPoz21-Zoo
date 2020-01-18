import java.time.LocalDateTime;

public class Program {
    public static void main(String args[]){
        System.out.println("Hello!");

        Bear bear = new BlackBear((LocalDateTime.now().plusDays(-1)));
        bear.isAlive();

        System.out.println(bear.getWeight());

        Bear blb = new BlackBear();
        System.out.println(blb.display() + " " + blb.getWeight() + " " + blb.attack());

        Bear brb = new BrownBear();
        System.out.println(brb.display() + " " + brb.getWeight()+ " " + brb.attack());

        Bear plb = new PolarBear();
        System.out.println(plb.display() + " " + plb.getWeight()+ " " + plb.attack());
    }
}