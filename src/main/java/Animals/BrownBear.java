package Animals;

import java.time.LocalDateTime;

public class BrownBear extends Bear {
    public BrownBear(){
        weight = 100;
    }

    public BrownBear(LocalDateTime eatTime){
        super(eatTime);
    }

    public String display(){
        String msg = "I am Brown Animals.Bear!";
        return msg;
    }

    @Override
    public String attack(){
        return "Zadaj ranę!";
    }
}
