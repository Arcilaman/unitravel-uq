package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

//    @Query("select r.usuario.nombre, r.fechaReserva, r.habitaciones from Reserva r join r.habitaciones h where h.hotel.codigo = :codigoHotel and r.fechaInicio < :fecha")
//    List<Object[]> obtenerReservas(int codigoHotel, LocalDate fecha);

    /**
     * retorna los vuelos
     * @return
     */
    @Query("select v from Reserva r join r.reserva_sillas s join s.silla.vuelo v where r.codigo= :codReserva")
    List<Vuelo> obtenerReservaVuelos(int codReserva);

    @Query("select new co.edu.uniquindio.unitravel.dto.ReservaDto(u, h) from Reserva  r join r.reserva_habitaciones rh join rh.habitacion.hotel h join r.usuario u where r.codigo = :codReserva")
    List<ReservaDto> obtenerHotelUsuario(int codReserva);
}

