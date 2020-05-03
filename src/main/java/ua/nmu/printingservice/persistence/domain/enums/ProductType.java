package ua.nmu.printingservice.persistence.domain.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public enum ProductType {
    POSTER(Constants.POSTER_VALUE),
    STICKER(Constants.STICKER_VALUE);

    @Getter
    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    @NoArgsConstructor(access = AccessLevel.NONE)
    public static class Constants {
        public static final String POSTER_VALUE = "POSTER";
        public static final String STICKER_VALUE = "STICKER";
    }
}
