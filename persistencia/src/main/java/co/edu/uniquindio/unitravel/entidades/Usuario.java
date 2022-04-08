package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Usuario extends  Persona implements Serializable {
    //@ToString.Include

    public Usuario(String cedula, String nombre, @Email String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
