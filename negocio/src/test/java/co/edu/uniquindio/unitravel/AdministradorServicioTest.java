package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.EmailServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {
    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private EmailServicio emailServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudadDestino(){
        Ciudad ciudad = new Ciudad(4,"San Andrés");
        try {
            Ciudad guardado = administradorServicio.crearCiudad(ciudad);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudadDestino(){

        try {
            administradorServicio.eliminarCiudad(2);
            Ciudad eliminado = administradorServicio.obtenerCiduad(2);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades(){
        List<Ciudad> lista= administradorServicio.ListarCiudades();
        lista.forEach(System.out::println);

    }




    @Test
    @Sql("classpath:dataset.sql")
    public void registarAdminHotel(){
        AdministradorHotel administradorHotel= new AdministradorHotel();
        administradorHotel.setNombre("Felipe");
        administradorHotel.setCedula("1004");
        administradorHotel.setCorreo("Felipe@gmail.com");
        administradorHotel.setPassword("1234");

        try {
            AdministradorHotel guardado= administradorServicio.registrarAdminHotel(administradorHotel);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {

             e.printStackTrace();
//
            Assertions.assertTrue(false);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdminHotel(){
        AdministradorHotel administradorHotel = administradorServicio.ObtenerAdminHotel("1005");
        administradorHotel.setPassword("817abc");

        try {
            AdministradorHotel actualizado= administradorServicio.actualizarAdminHotel(administradorHotel);
            Assertions.assertEquals("817abc",actualizado.getPassword());
        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    @Test
    @Sql("classpath:dataset.sql")
    public void elimarAdminHotel(){
        try {
            administradorServicio.eliminarAdminHotel("1005");
            AdministradorHotel eliminado = administradorServicio.ObtenerAdminHotel("1005");
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     *
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdminHotel(){
        List<AdministradorHotel> lista= administradorServicio.listarAdminHotel();
        for (AdministradorHotel adminHotel: lista
             ) {
            System.out.println(adminHotel);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void loginAdminHotel(){
        try {
            Administrador administrador= administradorServicio.validarLogin("admin@gmail.com","00001");
            Assertions.assertNotNull(administrador);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
//    @Sql("classpath:dataset.sql")
//    public void enviarCorreoTest(){
//        boolean estado = emailServicio.enviarEmail("prueba","Este es un mensaje","juand.arcilae@uqvirtual.edu.co");
//    }
}
