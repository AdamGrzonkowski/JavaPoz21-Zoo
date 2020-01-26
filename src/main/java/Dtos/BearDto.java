package Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO = Data Transfer Object
 * Container class, used to transfer data around the program without the need to specify methods with a large number of parameters.
 * DTOs should be preferred over Model classes when programming service classes / GUI. Models should only be used in Data Layer (integrating with database, saving to it - in our app, saving / reading to / from Lists).
 */
@Setter
@Getter
public class BearDto {
    public String name;
    public LocalDateTime lastEatTime;
    public String type;
}
