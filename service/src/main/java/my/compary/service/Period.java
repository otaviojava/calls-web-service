package my.compary.service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class Period {

    @Column
    public LocalDateTime start;
    @Column
    public LocalDateTime end;

    /**
     * Framework Only
     */
    @Deprecated
    public Period() {
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
