package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchServiceProviderTest {
    private LaunchServiceProvider target;
    private LaunchServiceProvider target2;

    @BeforeEach
    public void setUp() {
        target = new LaunchServiceProvider();
        target2 = new LaunchServiceProvider("ProviderName", 2000, "Australia");
    }

    @DisplayName("should throw exception when setName given null")
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSetNameGivenNull() {
        assertThrows(IllegalArgumentException.class, () ->  target.setName(null));
    }

    @DisplayName("should throw exception when setCountry given null")
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSetCountryGivenNull() {
        assertThrows(IllegalArgumentException.class, () ->  target.setCountry(null));
    }

    @DisplayName("should throw exception when setHeadquaters given null")
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSetHeadquatersGivenNull() {
        assertThrows(IllegalArgumentException.class, () ->  target.setHeadquarters(null));
    }

    @DisplayName("should throw exception when setRockets given null")
    @Test
    public void shouldThrowNullPointerExceptionWhenSetRocketsGivenNull() {
        assertThrows(NullPointerException.class, () ->  target.setRockets(null));
    }

    @DisplayName("should throw exception when setYearFounded given negative or zero input")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void shouldThrowIllegalArgumentExceptionWhenSetYearFoundedGivenNegativeOrZeroInput(int arg) {
        assertThrows(IllegalArgumentException.class, ()-> target.setYearFounded(arg));
    }

    @DisplayName("should throw exception when setYearFounded given out of range input")
    @ParameterizedTest
    @ValueSource(ints = {1700, 2500, 150, 1800, 2020})
    public void shouldThrowIllegalArgumentExceptionWhenSetYearFoundedGivenOutOfRangeInput(int arg) {
        assertThrows(IllegalArgumentException.class, ()-> target.setYearFounded(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowIllegalArgumentExceptionIfSetNameGivenEmptyInput(String arg) {
        assertThrows(IllegalArgumentException.class, () -> target.setName(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowIllegalArgumentExceptionIfSetCountryGivenEmptyInput(String arg) {
        assertThrows(IllegalArgumentException.class, () -> target.setCountry(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowIllegalArgumentExceptionIfSetHeadquatersGivenEmptyInput(String arg) {
        assertThrows(IllegalArgumentException.class, () -> target.setHeadquarters(arg));
    }

    @DisplayName("should return true when two launch service provider have same name yearFounded country")
    @Test
    public void shouldReturnTrueWhenProvidersHaveSameNameYearFoundedCountry() {
        LaunchServiceProvider anotherProvider = new LaunchServiceProvider("ProviderName", 2000, "Australia");
        assertTrue(target2.equals(anotherProvider));
    }

    @DisplayName("should return false when two launch service provider have different name yearFounded country")
    @Test
    public void shouldReturnTrueWhenProvidersHaveDifferentNameYearFoundedCountry() {
        LaunchServiceProvider anotherProvider = new LaunchServiceProvider("NameProvider", 1995, "Singapore");
        assertFalse(target2.equals(anotherProvider));
    }

}
