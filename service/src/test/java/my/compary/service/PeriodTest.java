package my.compary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

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
        Assertions.assertEquals(start, period.getStart());
        Assertions.assertEquals(end, period.getEnd());
    }

    @Test
    public void shouldReturnTheDifferenceMinutes() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(3);
        Period period = Period.of(start, end);
        Assertions.assertNotNull(period);
        Duration duration = period.getCallDuration();
        Assertions.assertNotNull(duration);
        Assertions.assertEquals(3L, duration.toMinutes());
    }

}