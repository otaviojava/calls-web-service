package my.compary.service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    @Column
    public LocalDateTime start;
    @Column
    public LocalDateTime end;
    @Column
    public BigDecimal cost;

    /**
     * Framework Only
     */
    @Deprecated
    public Period() {
    }

    private Period(LocalDateTime start, LocalDateTime end, BigDecimal cost) {
        this.start = start;
        this.end = end;
    }

    public static Period of(LocalDateTime start, LocalDateTime end) {
        return new Period(start, end, BigDecimal.ZERO);
    }
}
