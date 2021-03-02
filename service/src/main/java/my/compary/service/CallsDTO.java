package my.compary.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CallsDTO {

    @NotNull(message = "calls may not be blank")
    @Min(value = 1, message = "The list cannot be empty")
    private List<CallDTO> dtos;

    public List<CallDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<CallDTO> dtos) {
        this.dtos = dtos;
    }
}
