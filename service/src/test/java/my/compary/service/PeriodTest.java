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

}