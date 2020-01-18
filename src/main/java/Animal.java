import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Animal {
    protected int weight;

    public void eat(){
        throw new NotImplementedException();
    }

    public boolean isAlive(){
        throw new NotImplementedException();
    }

    public int getWeight(){
        return weight;
    }
}
