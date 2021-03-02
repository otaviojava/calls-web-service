package my.compary.service;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Call extends PanacheEntity {

    @Column
    @NotBlank
    public String caller;
    @Column
    @NotBlank
    public String calle;
    @Column
    public Period period;
    @Column
    @Enumerated
    @NotNull
    public TypeCall type;


}
