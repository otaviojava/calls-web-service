package my.compary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CallDTOTest {

    @Test
    public void shouldConvertTo() {
        Call call = new Call();
        call.setCalle("123");
        call.setCalle("321");
        call.setType(TypeCall.INBOUND);
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(4);
        call.setPeriod(Period.of(start, end));
        call.setCost(BigDecimal.ZERO);

        CallDTO dto = CallDTO.of(call);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(call.getCalle(), dto.getCalle());
        Assertions.assertEquals(call.getCaller(), dto.getCaller());
        Assertions.assertEquals(start, dto.getStart());
        Assertions.assertEquals(end, dto.getEnd());
        Assertions.assertEquals(call.getType(), dto.getType());
        Assertions.assertEquals(call.getId(), dto.getId());
        Assertions.assertEquals(call.getCost(), dto.getCost());
    }

    @Test
    public void shouldConvertFrom() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(4);
        CallDTO dto = new CallDTO();
        dto.setCaller("123");
        dto.setCalle("321");
        dto.setType(TypeCall.INBOUND);
        dto.setStart(start);
        dto.setEnd(end);

        Call call = dto.toEntity();
        Assertions.assertNotNull(call);
        Assertions.assertEquals(dto.getCalle(), call.getCalle());
        Assertions.assertEquals(dto.getCaller(), call.getCaller());
        Assertions.assertEquals(dto.getStart(), start);
        Assertions.assertEquals(dto.getEnd(), end);
        Assertions.assertEquals(dto.getType(), call.getType());
        Assertions.assertNotEquals(dto.getCost(), call.getCost());
    }

    @Test
    public void shouldIgnoreId() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(4);
        CallDTO dto = new CallDTO();
        dto.setCaller("123");
        dto.setCalle("321");
        dto.setType(TypeCall.INBOUND);
        dto.setStart(start);
        dto.setEnd(end);

        Call call = dto.toEntity();
        Assertions.assertNull(call.getId());
    }
}