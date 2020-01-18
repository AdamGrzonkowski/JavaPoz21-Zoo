import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AnimalTest {

    @Test(expected = NotImplementedException.class)
    public void eatThrowsNotImplementedException(){
        Animal animal = new Animal();
        animal.eat();
    }

    @Test(expected = NotImplementedException.class)
    public void isAliveThrowsNotImplementedException(){
        Animal animal = new Animal();
        animal.isAlive();
    }
}
