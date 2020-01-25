package Models.Animals;

import Constants.AttackType;

import java.time.LocalDateTime;

public class BlackBear extends Bear  { // Models.Animals.BlackBear -> Models.Animals.Bear -> Models.Animals.Animal -> Models.Shared.RealObject
    private BlackBear(){
        assignConsts();
    }

    private BlackBear(LocalDateTime eatTime){
        super(eatTime);
        assignConsts();
    }

    private BlackBear(BlackBearBuilder builder){
        super(builder.lastEatTime);
        this.lastEatTime = builder.lastEatTime;
        this.name = builder.name;

        assignConsts();
    }

    private void assignConsts(){
        weight = 50;
        attackType = AttackType.HURT;
        info = "I am Black Bear!";
    }

    public static class BlackBearBuilder
    {
        private LocalDateTime lastEatTime;
        private String name;

        public BlackBearBuilder setName(String name){
            this.name = name;
            return this;
        }

        public BlackBearBuilder setLastEatTime(LocalDateTime lastEatTime){
            this.lastEatTime = lastEatTime;
            return this;
        }

        public BlackBear build(){
            return new BlackBear(this);
        }
    }
}
