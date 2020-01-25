package Models.Animals;

import Constants.AttackType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@Getter
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
