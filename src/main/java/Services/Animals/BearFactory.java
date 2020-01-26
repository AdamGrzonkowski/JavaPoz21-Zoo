package Services.Animals;

import Constants.BearSpecies;
import Dtos.BearDto;
import Models.Animals.*;

public class BearFactory {
    public Bear Create(BearDto dto){
           if (dto.type.equalsIgnoreCase(BearSpecies.BlackBear)){
               return new BlackBear.BlackBearBuilder()
                       .setName(dto.name)
                       .setLastEatTime(dto.lastEatTime)
                       .build();
           }
           else if (dto.type.equalsIgnoreCase(BearSpecies.BrownBear)){
               return new BrownBear().toBuilder()
                       .name(dto.name)
                       .lastEatTime(dto.lastEatTime)
                       .build();
           }
           else if (dto.type.equalsIgnoreCase(BearSpecies.PolarBear)){
               return new PolarBear().toBuilder()
                       .name(dto.name)
                       .lastEatTime(dto.lastEatTime)
                       .build();
           }

           throw new RuntimeException("Wrong parameter - no class to create found!");
    }
}
