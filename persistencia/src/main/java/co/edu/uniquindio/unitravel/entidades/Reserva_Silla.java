package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Reserva_Silla {
    @Id
    @ToString.Include
    private int codigo;

    @ToString.Include
    private Double precio;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Silla silla;

}
