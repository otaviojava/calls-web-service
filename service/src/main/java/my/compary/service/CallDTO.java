package my.compary.service;

import java.time.LocalDateTime;
import java.util.Objects;

public class CallDTO {

    private String caller;

    private String calle;

    private LocalDateTime start;

    private LocalDateTime end;

    private TypeCall type;

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
        return Objects.equals(caller, callDTO.caller)
                && Objects.equals(calle, callDTO.calle)
                && Objects.equals(start, callDTO.start)
                && Objects.equals(end, callDTO.end)
                && type == callDTO.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caller, calle, start, end, type);
    }

    @Override
    public String toString() {
        return "CallDTO{" +
                "caller='" + caller + '\'' +
                ", calle='" + calle + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", type=" + type +
                '}';
    }
}
