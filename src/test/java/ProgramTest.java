import Services.Animals.IAnimalService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class ProgramTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void ProcessCommand_OnGetCountOfAll_CallsCorrectAnimalServiceMethod(){
        IAnimalService animalServiceMock = mock(IAnimalService.class);
        Program.ProcessCommand("getCountOfAll", animalServiceMock);

        verify(animalServiceMock, times(1)).getNumberOfAllAnimals();
    }

    @Test
    public void ProcessCommand_OnGetCountOfPolarBear_CallsCorrectAnimalServiceMethod(){
        IAnimalService animalServiceMock = mock(IAnimalService.class);
        Program.ProcessCommand("getCountOf Polar Bears", animalServiceMock);

        verify(animalServiceMock, times(1)).getAnimalsCount();
    }

    @Test
    public void ProcessCommand_Quit_ExitsProgramWithStatus0(){
        exit.expectSystemExitWithStatus(0);
        Program.ProcessCommand("quit", null);
    }
}
