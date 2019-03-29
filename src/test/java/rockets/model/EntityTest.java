package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntityTest {

    private Entity target;

    @BeforeEach
    public void setUp() {
        target = new Entity(){};

    }

    @DisplayName("should throw exception when pass null to setId function")
    @Test
    public void shouldThrowExceptionWhenSetIdToNull()
    {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setId(null));
        assertEquals("Id cannot be null", exception.getMessage());
    }

    @DisplayName("should throw exception when pass negative value to setId function")
    @ParameterizedTest
    @ValueSource(longs = {-1,-100})
    public void shouldThrowExceptionWhenSetIdToNegative(Long id)
    {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setId(id));
        assertEquals("id cannot be negative",exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setWikilink function")
    @Test
    public void shouldThrowExceptionWhenSetWikilinktoNull()
    {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setWikilink(null));
        assertEquals("wikilink cannot be null or empty",exception.getMessage());
    }

    @DisplayName("should throw exception when pass empty to setWikilink function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetWikilinktoEmpty(String wikilink)
    {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setWikilink(wikilink));
        assertEquals("wikilink cannot be null or empty",exception.getMessage());
    }









}
