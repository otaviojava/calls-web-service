package my.compary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class PulseDialingTest {

    @Test
    public void shouldReturnZeroIfIsInBound() {
        Call call = new Call();
        call.setCalle("123");
        call.setCalle("321");
        call.setType(TypeCall.INBOUND);
        call.setPeriod(Period.of(LocalDateTime.now(), LocalDateTime.now().plusMinutes(4)));

        PulseDialing pulseDialing = new PulseDialing(call);
        BigDecimal pulse = pulseDialing.pulse();
        Assertions.assertEquals(0, pulse.compareTo(BigDecimal.ZERO));
    }

    @Test
    public void shouldCreatePulseLessFiveMinutes() {
        Call call = new Call();
        call.setCalle("123");
        call.setCalle("321");
        call.setType(TypeCall.OUTBOUND);
        call.setPeriod(Period.of(LocalDateTime.now(), LocalDateTime.now().plusMinutes(4)));

        PulseDialing pulseDialing = new PulseDialing(call);
        BigDecimal pulse = pulseDialing.pulse();
        BigDecimal expectedValue = BigDecimal.valueOf(0.2D);
        Assertions.assertEquals(0, pulse.compareTo(expectedValue));
        Assertions.assertEquals(0, call.getCost().compareTo(expectedValue));
    }

    @Test
    public void shouldCreatePulseEqualsFiveMinutes() {
        Call call = new Call();
        call.setCalle("123");
        call.setCalle("321");
        call.setType(TypeCall.OUTBOUND);
        call.setPeriod(Period.of(LocalDateTime.now(), LocalDateTime.now().plusMinutes(5)));

        PulseDialing pulseDialing = new PulseDialing(call);
        BigDecimal pulse = pulseDialing.pulse();
        BigDecimal expectedValue = BigDecimal.valueOf(0.3D);
        Assertions.assertEquals(0, pulse.compareTo(expectedValue));
        Assertions.assertEquals(0, call.getCost().compareTo(expectedValue));
    }

    @Test
    public void shouldCreatePulseHigherThanFiveMinutes() {
        Call call = new Call();
        call.setCalle("123");
        call.setCalle("321");
        call.setType(TypeCall.OUTBOUND);
        call.setPeriod(Period.of(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10)));

        PulseDialing pulseDialing = new PulseDialing(call);
        BigDecimal pulse = pulseDialing.pulse();
        BigDecimal expectedValue = BigDecimal.valueOf(0.8D);
        Assertions.assertEquals(0, pulse.compareTo(expectedValue));
        Assertions.assertEquals(0, call.getCost().compareTo(expectedValue));
    }
}