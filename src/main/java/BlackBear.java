import java.time.LocalDateTime;

public class BlackBear extends Bear  { // BlackBear -> Bear -> Animal -> RealObject
    public BlackBear(){
        weight = 50;
    }

    public BlackBear(LocalDateTime eatTime){
        super(eatTime);
    }

    public String display(){
        String msg = "I am Black Bear!";
        return msg;
    }

    @Override
    public String attack(){
        return "Zadaj ranę!";
    }
}
