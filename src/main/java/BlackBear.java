public class BlackBear extends Bear { // BlackBear -> Bear -> Animal
    public BlackBear(){
        weight = 50;
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
