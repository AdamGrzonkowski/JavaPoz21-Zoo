package Animals;

import java.time.LocalDateTime;

public interface IAnimal {
    LocalDateTime getLastEatTime();
    void eat();
    boolean isAlive();
    int getWeight();
}
