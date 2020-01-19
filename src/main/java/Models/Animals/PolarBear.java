package Models.Animals;

import Constants.AttackType;

import java.time.LocalDateTime;

public class PolarBear extends Bear {
    public PolarBear(){
        assignConsts();

    }

    public PolarBear(LocalDateTime eatTime){
        super(eatTime);
        assignConsts();
    }

    private void assignConsts(){
        weight = 200;
        attackType = AttackType.KILL;
        info = "I am Polar Bear!";
    }
}
