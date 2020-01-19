package Animals;

import java.time.LocalDateTime;

public class BlackBear extends Bear  { // Animals.BlackBear -> Animals.Bear -> Animals.Animal -> Shared.RealObject
    public BlackBear(){
        weight = 50;
    }

    public BlackBear(LocalDateTime eatTime){
        super(eatTime);
    }

    public String display(){
        String msg = "I am Black Animals.Bear!";
        return msg;
    }

    @Override
    public String attack(){
        return "Zadaj ranę!";
    }
}
