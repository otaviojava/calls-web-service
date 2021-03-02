package my.compary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        CallDTO dto = CallDTO.of(call);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(call.getCalle(), dto.getCalle());
        Assertions.assertEquals(call.getCaller(), dto.getCaller());
        Assertions.assertEquals(start, dto.getStart());
        Assertions.assertEquals(end, dto.getEnd());
        Assertions.assertEquals(call.getType(), dto.getType());
    }

    @Test
    public void shouldConvertFrom() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(4);
        CallDTO dto = new CallDTO();
        dto.setCalle("123");
        dto.setCalle("321");
        dto.setType(TypeCall.INBOUND);
        dto.setStart(start);
        dto.setEnd(end);

        dto.toEntity();

    }
}