package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private String direccion;

    private String telefono;

    private int numEstrellas;
}
