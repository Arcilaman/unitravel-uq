package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @ToString.Include
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List <Hotel> hoteles;

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "ciudades")
    private List<Vuelo> vuelos;

}
