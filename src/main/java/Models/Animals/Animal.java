package Models.Animals;

import Constants.AttackType;
import Models.Shared.RealObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@Getter
public abstract class Animal extends RealObject implements IAnimal{ // We do not have to inherit from IAnimal at this point, it's just for example purposes
    protected LocalDateTime lastEatTime;
    protected AttackType attackType;
    protected String info;
    protected String name;

    protected Animal(){}

    public LocalDateTime getLastEatTime(){
        return lastEatTime;
    }

    public void eat(){
        this.lastEatTime = LocalDateTime.now();
    }

    public abstract boolean isAlive();

    public String getInfo(){
        return info;
    }

    public AttackType getAttackType(){
        return attackType;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
