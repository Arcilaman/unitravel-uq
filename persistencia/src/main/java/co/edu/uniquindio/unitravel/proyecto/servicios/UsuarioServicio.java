package co.edu.uniquindio.unitravel.proyecto.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws  Exception;

    Usuario ObtenerUsuario(String codigo) ;

    void eliminarUsuario(String cedula) throws Exception;

    List<Usuario> listarUsuario()  ;

    Usuario validarLogin(String correo, String password) throws Exception;

    Comentario crearComentario(Comentario comentario) throws Exception;

    Reserva hacerReserva(Reserva reserva) throws  Exception;

    void eliminarResserva(Integer codigo) throws Exception;

    Reserva modificarReserva(Reserva reserva) throws Exception;

    List<Hotel> buscarHotelesCiudad(String nombreCiudad);

    List<Reserva> listarReservas(String emailUsuario);

   // void recuperarPassword(String email) throws Exception;




}
