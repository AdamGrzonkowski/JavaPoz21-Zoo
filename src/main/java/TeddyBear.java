public class TeddyBear extends Bear {
    @Override
    public void eat(){
        throw new RuntimeException("Teddy bears do not eat!");
    }

    @Override
    public boolean isAlive(){
        return false;
    }

    public String display(){
        String msg = "I am Teddy Bear!";
        return msg;
    }

    @Override
    public String attack() {
        throw new RuntimeException("Teddy Bears do not attack!");
    }
}
