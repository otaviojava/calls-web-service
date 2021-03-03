package my.compary.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@QuarkusTest
class CallServiceTest {

    @Inject
    private CallService callService;

    @Test
    public void shouldCreate() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(4);
        CallDTO dto = new CallDTO();
        dto.setCaller("123");
        dto.setCalle("321");
        dto.setType(TypeCall.INBOUND);
        dto.setStart(start);
        dto.setEnd(end);
        List<CallDTO> dtos = callService.save(new CallsDTO(List.of(dto)));
        Assertions.assertTrue(dtos.stream().map(CallDTO::getId).allMatch(Objects::nonNull));
        dto = dtos.get(0);
        Assertions.assertNotNull(dto.getCost());
    }
}