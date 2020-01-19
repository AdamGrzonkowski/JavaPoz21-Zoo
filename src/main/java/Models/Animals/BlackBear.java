package Models.Animals;

import Constants.AttackType;

import java.time.LocalDateTime;

public class BlackBear extends Bear  { // Models.Animals.BlackBear -> Models.Animals.Bear -> Models.Animals.Animal -> Models.Shared.RealObject
    public BlackBear(){
        assignConsts();
    }

    public BlackBear(LocalDateTime eatTime){
        super(eatTime);
        assignConsts();
    }

    private void assignConsts(){
        weight = 50;
        attackType = AttackType.HURT;
        info = "I am Black Bear!";
    }
}
