package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;
    @ToString.Include
    private LocalDate fechaReserva;
    @ToString.Include
    private LocalDate fechaInicio;
    @ToString.Include
    private LocalDate fechaFin;
    @ToString.Include
    private Double precioTotal;
    @ToString.Include
    @Column(length = 10, nullable = false)
    private String estado;
    @ToString.Include
    private int cantidadPersona;

    @ManyToOne
    private Usuario usuario;



    @OneToMany(mappedBy = "reserva")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "reserva")
    private List<Actividad> actividades;

    @OneToMany(mappedBy = "reserva")
    private List<Reserva_Silla> reserva_sillas;

    @OneToMany(mappedBy = "reserva")
    private List<Reserva_Habitacion> reserva_habitaciones;


}
