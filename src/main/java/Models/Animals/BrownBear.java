package Models.Animals;

import Constants.AttackType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@Getter
public class BrownBear extends Bear {
    public BrownBear(){
        assignConsts();
    }

    public BrownBear(LocalDateTime eatTime){
        super(eatTime);
    }

    private void assignConsts(){
        weight = 100;
        attackType = AttackType.HURT;
        info = "I am Brown Bear!";
    }
}
