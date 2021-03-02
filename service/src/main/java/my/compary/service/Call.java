package my.compary.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Call {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    @NotBlank
    private String caller;
    @Column
    @NotBlank
    private String calle;
    @Column
    private Period period;
    @Column
    @Enumerated
    @NotNull
    private TypeCall type;
    @Column
    @NotNull
    private BigDecimal cost;

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getCaller() {
        return caller;
    }

    void setCaller(String caller) {
        this.caller = caller;
    }

    String getCalle() {
        return calle;
    }

    void setCalle(String calle) {
        this.calle = calle;
    }

    Period getPeriod() {
        return period;
    }

    void setPeriod(Period period) {
        this.period = period;
    }

    TypeCall getType() {
        return type;
    }

    void setType(TypeCall type) {
        this.type = type;
    }

    BigDecimal getCost() {
        return cost;
    }

    void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Call call = (Call) o;
        return Objects.equals(id, call.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", caller='" + caller + '\'' +
                ", calle='" + calle + '\'' +
                ", period=" + period +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }
}
