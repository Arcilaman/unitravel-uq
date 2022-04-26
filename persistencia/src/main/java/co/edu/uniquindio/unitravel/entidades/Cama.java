package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Cama {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private int codigo;

    @ToString.Include
    private String tipo;

    @ManyToMany
    private List<Habitacion> habitaciones;

}
