import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Bear extends Animal {
    private LocalDateTime lastEatTime;

    public Bear(){}

    protected Bear(LocalDateTime eatTime){
        if (eatTime == null){
            throw new IllegalArgumentException("Eattime has illegal value: null");
        }
        lastEatTime = eatTime;
    }

    public LocalDateTime getLastEatTime(){
        return lastEatTime;
    }

    public abstract String display();

    @Override
    public void eat(){
        this.lastEatTime = LocalDateTime.now();
    }

    @Override
    public boolean isAlive(){

        /*
        // This is how you'd need to approach it, if you used Date type instead of LocalDateTime
                return lastEatTime == null
                ? false
                : TimeUnit.DAYS.convert(new Date().getTime() - lastEatTime.getTime()), TimeUnit.MILLISECONDS) < 10;
        */

        /*
        // This code is the same one as below, but written in simpler way
        if (lastEatTime == null){
            return false;
        }
        else {
            long daysDifference = DAYS.between(lastEatTime, LocalDateTime.now());
            if (daysDifference < 10){
                return true;
            }
            else{
                return false;
            }
        }
     */

        return lastEatTime == null
                ? false
                : DAYS.between(lastEatTime, LocalDateTime.now()) < 10;
    }
}
