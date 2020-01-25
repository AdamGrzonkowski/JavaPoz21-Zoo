package Models.Shared;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
public class RealObject {
    protected int weight;

    protected RealObject(){}

    public int getWeight(){
        return weight;
    }
}
