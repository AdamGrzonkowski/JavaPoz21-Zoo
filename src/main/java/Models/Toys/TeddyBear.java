package Models.Toys;

public class TeddyBear extends ToyBear {
    public String display(){
        String msg = "I am Teddy Models.Animals.Bear!";
        return msg;
    }

    protected int weight;

    public int getWeight(){
        return weight;
    }
}
