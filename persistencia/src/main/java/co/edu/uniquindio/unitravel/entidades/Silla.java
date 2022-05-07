package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
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
    @Column(length = 10)
    private String codigo;

    @ToString.Include
    private String posición;
    @ToString.Include
    private Double precio;

    @OneToMany(mappedBy = "silla")
    private List<Reserva_Silla> reserva_sillas;

    @ManyToOne
    private Vuelo vuelo;

}
