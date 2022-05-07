package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepo extends JpaRepository<Vehiculo, String> {
    @Query("select  h from Hotel h where h.numEstrellas = :estrellas")
    List<Hotel> obtenerHoteles(int estrellas);



}
