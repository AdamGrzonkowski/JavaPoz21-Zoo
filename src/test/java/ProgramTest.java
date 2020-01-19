import Services.Animals.IAnimalService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProgramTest {
    @Test
    public void ProcessCommand_OnGetCountOfAll_CallsCorrectAnimalServiceMethod(){
        IAnimalService animalServiceMock = mock(IAnimalService.class);
        Program.ProcessCommand("getCountOfAll", animalServiceMock);

        verify(animalServiceMock, times(1)).getNumberOfAllAnimals();
    }
}
