package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio{

    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Override
    public AdministradorHotel validarLogin(String email, String password) throws Exception {
        return null;
    }

    @Override
    public void recuperarPassword(String email) throws Exception {

    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {
        return null;
    }

    @Override
    public void eliminarHotel(int codigo) throws Exception {

    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) {
        return null;
    }

    @Override
    public Hotel modificarHotel(Hotel hotel) throws Exception {
        return null;
    }

    @Override
    public Hotel obtenerHotel(Integer codigoHotel) throws Exception {
        return null;
    }

    @Override
    public Ciudad obtenerCiudad(int codCiudad) throws Exception {
        return ciudadRepo.findById(codCiudad).orElse(null);
    }

    @Override
    public AdministradorHotel obtenerAdminHotel(String cedulaAdmin) throws Exception {
        return  administradorHotelRepo.findById(cedulaAdmin).orElse(null);
    }
}
