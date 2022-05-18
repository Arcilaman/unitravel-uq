package co.edu.uniquindio.unitravel.entidades;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.function.DoubleBinaryOperator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva_Habitacion {

    @Id
    @ToString.Include
    private int codigo;

    @ToString.Include
    private Double precio;

    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private Reserva reserva;
}
