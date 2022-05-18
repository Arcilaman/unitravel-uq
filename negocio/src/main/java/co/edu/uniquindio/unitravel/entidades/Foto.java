package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.validator.constraints.URL;

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
public class Foto implements Serializable {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private int codigo;

//    @URL
    @ToString.Include
    private String url;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Habitacion habitacion;
}
