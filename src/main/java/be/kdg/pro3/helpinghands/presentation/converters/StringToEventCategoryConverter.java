package be.kdg.pro3.helpinghands.presentation.converters;

import be.kdg.pro3.helpinghands.domain.EventCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEventCategoryConverter implements Converter<String, EventCategory> {

    @Override
    public EventCategory convert(String source) {
        // firstly, handles empty or null inputs safely
        if (source == null || source.isBlank()) {
            return null; // will trigger @NotNull on the ViewModel if required
        }

        try {
            // secondly,  clean the input and match against ENUM values
            return EventCategory.valueOf(source.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            // lastly, returns null if the string doesn't match any Enum value
            return null;
        }
    }
}