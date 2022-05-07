package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private int codigo;

    @ToString.Include
    @Column(length = 50, nullable = false)
    private String nombre;

    @ToString.Include
    private String direccion;

    @ToString.Include
    private String telefono;

    @ToString.Include
    private int numEstrellas;

    @ManyToOne
    private AdministradorHotel administrador_hotel;

    @OneToMany(mappedBy = "hotel")
    private List<Comentario> comentarios;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    private List <Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel")
    private List <Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    private List <Foto> fotos;



}
