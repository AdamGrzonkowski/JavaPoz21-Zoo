package Models.Animals;

import Constants.AttackType;

import java.time.LocalDateTime;

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
