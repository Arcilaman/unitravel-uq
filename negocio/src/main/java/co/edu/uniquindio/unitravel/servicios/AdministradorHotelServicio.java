package co.edu.uniquindio.unitravel.servicios;

import ch.qos.logback.core.encoder.EchoEncoder;
import co.edu.uniquindio.unitravel.entidades.Hotel;

public interface AdministradorHotelServicio {

    Hotel crearHotel(Hotel hotel) throws Exception;
    void eliminarHotel(int codigo) throws Exception;
}
