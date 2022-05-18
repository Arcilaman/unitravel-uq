package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;

public interface AdministradorServicio {

    AdministradorHotel registrarAdminHotel(AdministradorHotel adminHotel) throws Exception;

    Vuelo crearVuelo(Vuelo vuelo) throws Exception;

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;
}
