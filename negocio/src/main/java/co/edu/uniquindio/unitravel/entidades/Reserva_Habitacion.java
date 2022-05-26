package co.edu.uniquindio.unitravel.entidades;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.function.DoubleBinaryOperator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva_Habitacion {

    @Id
    @ToString.Include
    @GeneratedValue
    private int codigo;

    @ToString.Include
    private Double precio;

    public Reserva_Habitacion(int codigo, Double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private Reserva reserva;
}
