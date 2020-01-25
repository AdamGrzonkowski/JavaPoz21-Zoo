package Models.Animals;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

@SuperBuilder(toBuilder = true)
@Getter
public abstract class Bear extends Animal {

    public Bear(){}

    protected Bear(LocalDateTime eatTime){
        lastEatTime = eatTime;
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
