package my.compary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {

    @Test
    public void shouldReturnNPE() {
        Assertions.assertThrows(NullPointerException.class, () -> Period.of(null, LocalDateTime.now()));
        Assertions.assertThrows(NullPointerException.class, () -> Period.of(LocalDateTime.now(), null));
    }

    @Test
    public void shouldReturnErrorWhenStartIsBiggerThanEnd() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Period.of(LocalDateTime.now().plusDays(2L), LocalDateTime.now()));
    }

    @Test
    public void shouldCreateAValidPeriod() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(3);
        Period period = Period.of(start, end);
        Assertions.assertNotNull(period);
        Assertions.assertEquals(start, period.start);
        Assertions.assertEquals(end, period.end);
    }
    @Test
    public void shouldReturnTheDifferenceMinutes() {


    }

}