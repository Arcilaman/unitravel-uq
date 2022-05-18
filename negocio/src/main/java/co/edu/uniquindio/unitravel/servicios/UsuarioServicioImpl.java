package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {


    private UsuarioRepo usuarioRepo;

    private ComentarioRepo comentarioRepo;

    private ReservaRepo reservaRepo;

    private HotelRepo hotelRepo;

    //private EmailServicio emailServicio;


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, ComentarioRepo comentarioRepo, ReservaRepo reservaRepo, HotelRepo hotelRepo){

        this.usuarioRepo= usuarioRepo;
        this.comentarioRepo=comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.hotelRepo = hotelRepo;
        //this.emailServicio=emailServicio;
    }


    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        Usuario buscado = ObtenerUsuario(usuario.getCedula());

        if(buscado!= null){
            throw new Exception("El codigo del usuario ya esta registrado");
        }

        Usuario usuarioEmail = buscarPorEmail(usuario.getCorreo());

        if(usuarioEmail!= null){
            throw new Exception("El correo del usuario ya esta registrado");
        }

        return usuarioRepo.save(usuario);
    }


    public  Usuario buscarPorEmail(String email)
    {
        return usuarioRepo.findAllByCorreo(email).orElse(null);

    }
    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception{
        Usuario buscado= ObtenerUsuario(usuario.getCedula());
        if(usuario==null){
            throw new Exception(" el usuario no esxiste");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario ObtenerUsuario(String codigo) {

        return usuarioRepo.findById(codigo).orElse(null);
    }




    @Override
    public void eliminarUsuario(String cedula) throws  Exception{
        Usuario usuario= ObtenerUsuario(cedula);
        if(usuario==null){
            throw new Exception(" el usuario no esxiste");
        }
        usuarioRepo.delete(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario validarLogin(String correo, String password) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findByCorreoAndPassword(correo,password);

        if (usuario.isEmpty()){
            throw new Exception("los datos de autenticacion son incorrectos");
        }

        return usuario.get();
    }





    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {
        return comentarioRepo.save(comentario);


    }

    @Override
    public Reserva hacerReserva(Reserva reserva) throws Exception {
        List<Reserva_Habitacion> reserva_habitaciones= reserva.getReserva_habitaciones();

        for (int i=0; i < reserva_habitaciones.size() ; i++){
            //validar que las habitaciones esten disponibles
            if(reserva_habitaciones.get(i) == null){

            }
        }

        //validar disponiblidad de los vuelos,asignar sillas aleatoriamente

        return reservaRepo.save(reserva);
    }

    @Override
    public void eliminarResserva(Integer codigo) throws Exception {
        Optional<Reserva> reserva= reservaRepo.findById(codigo);
        if(reserva.isEmpty()){
            throw new Exception("la reserva no existe");
        }
        reservaRepo.delete(reserva.get());

    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {
        return null;
    }

    @Override
    public List<Hotel> buscarHotelesCiudad(String nombreCiudad) {
        return hotelRepo.obtenerHoteles(nombreCiudad);
    }

    @Override
    public List<Reserva> listarReservas(String emailUsuario) {
        return usuarioRepo.obtenerListaReservas(emailUsuario);
    }

//    @Override
//    public void recuperarPassword(String email) throws Exception {
//        Optional<Usuario> usuario= usuarioRepo.findByCorreo(email);
//        if(usuario.isEmpty()){
//            throw new Exception("el correo no pertenece a ningun usuario ");
//        }
//        String password = usuario.get().getPassword();
//        emailServicio.enviarEmail("recuperacion de la contraseña ", " hola su contraseña  es"+password,email );
//
//    }
}
