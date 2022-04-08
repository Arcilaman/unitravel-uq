package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private Date fechaReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private Double precioTotal;
    private String estado;
    private int cantidadPersona;


}
