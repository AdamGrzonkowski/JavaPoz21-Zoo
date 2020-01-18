import java.time.LocalDateTime;

public class Program {
    public static void main(String args[]){
        System.out.println("Hello!");
        Bear bear = new Bear((LocalDateTime.now().plusDays(-1)));
        bear.isAlive();
    }
}