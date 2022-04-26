package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;
    @ToString.Include
    private Date fechaReserva;
    @ToString.Include
    private Date fechaInicio;
    @ToString.Include
    private Date fechaFin;
    @ToString.Include
    private Double precioTotal;
    @ToString.Include
    private String estado;
    @ToString.Include
    private int cantidadPersona;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "reserva")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "reserva")
    private List<Actividad> actividades;

    @ManyToMany(mappedBy = "reservas")
    private List<Silla> sillas;


}
