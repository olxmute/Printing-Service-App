package ua.nmu.printingservice.persistence.domain.enums;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.apache.commons.text.WordUtils.capitalizeFully;

public enum Orientation {
    PORTRAIT,
    LANDSCAPE;

    public static Map<String, String> getOrientationMap() {
        return Arrays.stream(Orientation.values())
                .collect(toMap(Enum::name, orientation -> capitalizeFully(orientation.name())));
    }
}
