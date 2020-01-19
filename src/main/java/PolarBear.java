import java.time.LocalDateTime;

public class PolarBear extends Bear {
    public PolarBear(){
        weight = 200;
    }

    public PolarBear(LocalDateTime eatTime){
        super(eatTime);
    }

    public String display(){
        String msg = "I am Polar Bear!";
        return msg;
    }

    @Override
    public String attack(){
        return "Bij zabij!";
    }
}
