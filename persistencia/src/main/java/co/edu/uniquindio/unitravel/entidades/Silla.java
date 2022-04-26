package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private String codigo;

    @ToString.Include
    private String posición;
    @ToString.Include
    private Double precio;

    @ManyToMany
    private List<Reserva> reservas;

    @ManyToOne
    private Vuelo vuelo;

}
