package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @ToString.Include
    private String comentario;

    @ToString.Include
    @PositiveOrZero
    @Max(5)
    private int calificacion;

    @ToString.Include
    private LocalDateTime fechaCalificacion;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Usuario usuario;

    public Comentario(String comentario, int calificacion, Hotel hotel, Usuario usuario) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fechaCalificacion = LocalDateTime.now();
        this.hotel = hotel;
        this.usuario = usuario;
    }
}
