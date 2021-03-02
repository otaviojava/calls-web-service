package my.compary.service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class Period {

    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;

    /**
     * Framework Only
     */
    @Deprecated
    public Period() {
    }

    LocalDateTime getStart() {
        return start;
    }

    void setStart(LocalDateTime start) {
        this.start = start;
    }

    LocalDateTime getEnd() {
        return end;
    }

    void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Duration getCallDuration() {
        return Duration.between(start, end);
    }

    private Period(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public static Period of(LocalDateTime start, LocalDateTime end) {
        Objects.requireNonNull(start, "start is required");
        Objects.requireNonNull(end, "end is required");
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("The start cannot be bigger than the end");
        }
        return new Period(start, end);
    }
}
