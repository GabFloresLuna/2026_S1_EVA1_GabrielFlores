package cl.duoc.gabrielflores.model;


import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud 
{
    @NotNull
    private Long id;
    @NotBlank
    private String pacienteString;
    @NotBlank
    private String especialidadString;
    @NotNull
    private String estadoString;
    @FutureOrPresent
    private LocalDateTime fechaRegistro;
    @Min(value= 1, message= "El nivel debe ser mínimo 1")
    @Max(value= 5, message= "El nivel debe ser máximo 5")
    private int nivelPrioridad;
}
