package my.compary.service;

import java.time.LocalDateTime;
import java.util.Objects;

public class CallDTO {

    private Long id;

    private String caller;

    private String calle;

    private LocalDateTime start;

    private LocalDateTime end;

    private TypeCall type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CallDTO callDTO = (CallDTO) o;
        return Objects.equals(id, callDTO.id)
                && Objects.equals(caller, callDTO.caller)
                && Objects.equals(calle, callDTO.calle)
                && Objects.equals(start, callDTO.start)
                && Objects.equals(end, callDTO.end)
                && type == callDTO.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caller, calle, start, end, type);
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
