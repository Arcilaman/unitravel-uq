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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @ToString.Include
    private String nombre;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Habitacion habitacion;

}
