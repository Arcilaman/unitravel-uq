package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Foto;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {
    /**
     * retorna los hoteles
     * @return
     */
    @Query("select h from Foto  f  left join f.hotel h")
    List<Hotel> obtenerHoteles();


    /**
     * retorna las habitaciones
     * @return
     */
    @Query("select h from Foto  f  left join f.habitacion h")
    List<Hotel> obtenerHabitaciones();

    /**
     * Retorna los hoteles dado el codigo de la foto
     * @param codFoto
     * @return
     */
    @Query("select h from Foto f join f.hotel h where f.codigo= :codFoto")
    List<Hotel> obtenerHoteles(int codFoto);

    /**
     * Retorna las habitaciones dado el codigo de la foto
     * @param codFoto
     * @return
     */
    @Query("select h from Foto f join f.habitacion h where f.codigo= :codFoto")
    List<Hotel> obtenerHabitaciones(int codFoto);

    /**
     * retorna las fotos dado el código del hotel
     * @param codHotel
     * @return
     */
    @Query("select f from Foto f join f.hotel h where h.codigo = :codHotel" )
    List<Caracteristica> obtenerFotosHotel(int codHotel);

    /**
     * retorna las fotos dado un código de habitación
     * @param numHabitacion
     * @return
     */
    @Query("select f from Foto f join f.habitacion h where h.numero = :numHabitacion" )
    List<Caracteristica> obtenerFotosHabitacion(int numHabitacion);
}
