package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    @Query("select  h from Hotel h where h.numEstrellas = :estrellas")
    List<Hotel> obtenerHoteles(int estrellas);

    List<Hotel> findAllByNumEstrellas(int estrellas);

//    List<Hotel> findAllByTelefono(String telefono);

    Page<Hotel> findAll(Pageable pageable);

//    @Query("select  h from Hotel h where h.numEstrellas >= :estrellas")
//    List<Hotel> obtenerHoteles(int estrellas);
}
