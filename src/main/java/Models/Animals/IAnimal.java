package Models.Animals;

import java.time.LocalDateTime;

public interface IAnimal { // Interfaces are used for Composition (we do not have to use Interfaces, during modeling phase, so when we define classes which describe real world)
    LocalDateTime getLastEatTime();
    void eat();
    boolean isAlive();
    int getWeight();
}
