package my.compary.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CallDTO {

    private Long id;

    @NotBlank(message = "caller may not be blank")
    private String caller;

    @NotBlank(message = "calle may not be blank")
    private String calle;

    @NotNull(message = "start may not be blank")
    private LocalDateTime start;

    @NotNull(message = "end may not be blank")
    private LocalDateTime end;

    @NotNull(message = "type may not be blank")
    private TypeCall type;

    private BigDecimal cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public TypeCall getType() {
        return type;
    }

    public void setType(TypeCall type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CallDTO{" +
                "id=" + id +
                ", caller='" + caller + '\'' +
                ", calle='" + calle + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }

    public static CallDTO of(Call call) {
        Period period = call.getPeriod();
        CallDTO dto = new CallDTO();
        dto.setId(call.getId());
        dto.setCalle(call.getCalle());
        dto.setCaller(call.getCaller());
        dto.setType(call.getType());
        dto.setStart(period.getStart());
        dto.setEnd(period.getEnd());
        dto.setCost(call.getCost());
        return dto;
    }

    public Call toEntity() {
        Call call = new Call();
        call.setCalle(this.calle);
        call.setCaller(this.caller);
        call.setType(this.type);
        call.setPeriod(Period.of(this.start, this.end));
        PulseDialing pulseDialing = new PulseDialing(call);
        pulseDialing.pulse();
        return call;
    }
}
