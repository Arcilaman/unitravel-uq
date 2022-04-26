package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
 @Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Vehiculo implements Serializable {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private String placa;

    @ToString.Include
    private String tipo;

    @ToString.Include
    private Double precio;

    @ManyToOne
    private Reserva reserva;
}
