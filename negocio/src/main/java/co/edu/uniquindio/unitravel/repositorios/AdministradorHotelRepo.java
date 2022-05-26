package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel, String> {

    Optional<AdministradorHotel> findAllByCorreo(String correo);

    /**
     * retorna el administrador de un hotel dado el código del hotel
     * @param codigoHotel
     * @return
     */
    @Query("select ah from AdministradorHotel ah join ah.hoteles h where h.codigo = :codigoHotel")
    List<AdministradorHotel> obtenerAdministradorHotel(int codigoHotel);

    /**
     * retorna hoteles de un administrador
     * @param codigoAdminHotel
     * @return
     */
    @Query("select h from AdministradorHotel ah join ah.hoteles h where h.codigo= :codigoAdminHotel")
    List<Hotel> obtenerHotelesAdmin(String codigoAdminHotel);

    /**
     * retorna lista de fotos dado un código de hotel
     * @param codHotel
     * @return
     */
    @Query("select f from AdministradorHotel  ah join ah.hoteles h join h.fotos f where h.codigo = :codHotel")
    List<Foto> obtenerFotosHotel(int codHotel);
}
