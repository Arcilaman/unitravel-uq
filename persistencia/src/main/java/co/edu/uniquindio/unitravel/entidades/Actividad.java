package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Actividad implements Serializable {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private int codigo;

    @ToString.Include
    private String nombre;

    @ToString.Include
    private Double precio;

    @ManyToOne
    private Reserva reserva;
}
