package Animals;

import Shared.RealObject;

import java.time.LocalDateTime;

public abstract class Animal extends RealObject implements IAnimal{
    protected LocalDateTime lastEatTime;

    public LocalDateTime getLastEatTime(){
        return lastEatTime;
    }

    public void eat(){
        this.lastEatTime = LocalDateTime.now();
    }

    public abstract boolean isAlive();
}
