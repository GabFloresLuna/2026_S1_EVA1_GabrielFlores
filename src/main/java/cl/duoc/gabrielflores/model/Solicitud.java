package cl.duoc.gabrielflores.model;


import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud 
{
    @NotNull(message= "El id no puede ser nulo")
    @Min(value= 1, message= "El id debe ser mínimo 1")
    private Long id;
    @Pattern(regexp = "^(\\d{1,2}(?:\\.?\\d{3}){2}-?[\\dkK])$", message = "Formato de RUT erróneo")
    @NotBlank(message = "El rut no puede ser blanco")
    private String rut;
    @NotBlank(message= "el nombre no puede ser blanco")
    private String nombreString;
    @NotBlank(message= "la especialidad no puede ser blanco")
    private String especialidadString;
    @NotNull (message= "El estado no puede ser blanco")
    private String estadoString;
    @PastOrPresent (message= "La fecha no puede ser futura")
    private LocalDateTime fechaRegistro;
    @Min(value= 1, message= "El nivel debe ser mínimo 1")
    @Max(value= 5, message= "El nivel debe ser máximo 5")
    private int nivelPrioridad;
}
