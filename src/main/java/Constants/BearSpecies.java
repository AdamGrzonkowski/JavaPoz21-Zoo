package Constants;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used to store strings used more than once throughout an application, in order
 * to avoid errors in case we have typo somewhere (by referencing values everywhere from this class, we won't get a typo).
 */
public final class BearSpecies {
    public static final String BlackBear = "Black Bear";
    public static final String BrownBear = "Brown Bear";
    public static final String PolarBear = "Polar Bear";


    public static final List<String> BearSpeciesList = Arrays.asList(new String[]{
            BlackBear,
            BrownBear,
            PolarBear});
}
